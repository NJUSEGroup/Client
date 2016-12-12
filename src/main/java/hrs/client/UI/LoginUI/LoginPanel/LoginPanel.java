package hrs.client.UI.LoginUI.LoginPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import hrs.client.UI.LoginUI.LoginFrame;
import hrs.client.UI.LoginUI.LoginPanel.Listener.CancelJBListener;
import hrs.client.UI.LoginUI.LoginPanel.Listener.LoginJBListener;
import hrs.client.UI.UserUI.Components.CommonLabel;
import hrs.client.util.ControllerFactory;
import hrs.client.util.HMSBlueButton;
import hrs.client.util.HMSGrayButton;
import hrs.client.util.UIConstants;
import hrs.common.Controller.LoginController.ILoginController;
import hrs.common.Exception.StaffService.StaffNotFoundExceptioon;
import hrs.common.Exception.StaffService.StaffPasswordErrorException;
import hrs.common.Exception.UserService.UserNotFoundException;
import hrs.common.Exception.UserService.UserPasswordErrorException;
import hrs.common.VO.StaffVO;
import hrs.common.VO.UserVO;

public class LoginPanel extends JPanel {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 3290076244434286905L;

	Font font = UIConstants.JLABEL_FONT;
	private JComboBox<String> accountType;
	private JTextField accountField;
	private JPasswordField passwordField;

	private ILoginController controller;
	private int JL_WIDTH = 120;
	private int JL_HEIGHT = 50;
	private int TEXT_WIDTH = 200;
	private int TEXT_HEIGHT = 30;
	private int START_X = 0;
	private int START_Y = 30;
	private LoginFrame frame;

	/**
	 * Create the panel.
	 */
	public LoginPanel(LoginFrame frame) {
		this.frame = frame;
		setSize(508, 420);
		setLayout(null);
		setBackground(Color.white);
		init();
	}

	private void init() {
		controller = ControllerFactory.getLoginController();
		setLabel();
		setInputField();
		setButton();

	}

	private void setButton() {
		HMSGrayButton cancelJB = new HMSGrayButton("取消");
		cancelJB.setBounds(80, START_Y+JL_HEIGHT*4, 120, 50);
		cancelJB.addActionListener(new CancelJBListener(this));
		add(cancelJB);
		
		HMSBlueButton loginJB = new HMSBlueButton("确定");
		loginJB.setBounds(220, START_Y+JL_HEIGHT*4, 120, 50);
		loginJB.addActionListener(new LoginJBListener(this));
		add(loginJB);
		
		loginJB.registerKeyboardAction(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				login();
				
			}
			
		},KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0),JComponent.WHEN_IN_FOCUSED_WINDOW);
		
	}
	private void setInputField() {
		
		accountType = new JComboBox<>();
		accountType.setFont(font);
		accountType.addItem("用户");
		accountType.addItem("工作人员");
		accountType.setBounds(START_X + JL_WIDTH + 30, START_Y + (JL_HEIGHT - TEXT_HEIGHT) / 2, TEXT_WIDTH,
				TEXT_HEIGHT);
		accountType.setFocusable(false);;
		add(accountType);

		accountField = new JTextField();
		accountField.setFont(font);
		accountField.setBounds(START_X + JL_WIDTH + 30, START_Y + (JL_HEIGHT - TEXT_HEIGHT) / 2 + JL_HEIGHT, TEXT_WIDTH,
				TEXT_HEIGHT);
		add(accountField);
		accountField.requestFocus();
		accountField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e){
				if (e.getKeyCode() == KeyEvent.VK_DOWN){
					passwordField.requestFocus();
				}
			}
		});

		passwordField = new JPasswordField();
		passwordField.setFont(font);
		passwordField.setBounds(START_X + JL_WIDTH + 30, START_Y + (JL_HEIGHT - TEXT_HEIGHT) / 2 + JL_HEIGHT * 2,
				TEXT_WIDTH, TEXT_HEIGHT);
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e){
				if (e.getKeyCode() == KeyEvent.VK_UP){
					accountField.requestFocus();
				}
			}
		});
		add(passwordField);
	}

	private void setLabel() {
		CommonLabel accountTypeJL = new CommonLabel("用户类型");
		accountTypeJL.setBounds(START_X, START_Y, JL_WIDTH, JL_HEIGHT);
		add(accountTypeJL);

		CommonLabel accountJL = new CommonLabel("用户名");
		accountJL.setBounds(START_X, START_Y + JL_HEIGHT, JL_WIDTH, JL_HEIGHT);
		add(accountJL);

		CommonLabel passwordJL = new CommonLabel("密码");
		passwordJL.setBounds(START_X, START_Y + JL_HEIGHT * 2, JL_WIDTH, JL_HEIGHT);
		add(passwordJL);
	}

	public void cancel() {
		accountField.setText("");
		passwordField.setText("");
	}

	public void login() {
		String account = accountField.getText();
		String password = new String(passwordField.getPassword());
		if (accountType.getSelectedItem().equals("用户")) {
			UserVO userVO = new UserVO();
			try {
				userVO = controller.loginUser(account, password);
				frame.loginUser(userVO);
			} catch (UserNotFoundException e) {
				JOptionPane.showMessageDialog(null, "该用户不存在！", "登录错误", JOptionPane.INFORMATION_MESSAGE);

			} catch (UserPasswordErrorException e) {
				JOptionPane.showMessageDialog(null, "密码错误！", "登录错误", JOptionPane.INFORMATION_MESSAGE);

			}
		} else {
			StaffVO staffVO = new StaffVO();
			try {
				staffVO = controller.loginStaff(account, password);
				frame.loginStaff(staffVO);
			} catch (StaffNotFoundExceptioon e) {
				JOptionPane.showMessageDialog(null, "该工作人员不存在！", "登录错误", JOptionPane.INFORMATION_MESSAGE);

			} catch (StaffPasswordErrorException e) {
				JOptionPane.showMessageDialog(null, "密码错误！", "登录错误", JOptionPane.INFORMATION_MESSAGE);

			}
		}

	}

}
