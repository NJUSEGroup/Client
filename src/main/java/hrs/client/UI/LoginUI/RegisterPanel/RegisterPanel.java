package hrs.client.UI.LoginUI.RegisterPanel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import hrs.client.UI.LoginUI.LoginFrame;
import hrs.client.UI.LoginUI.RegisterPanel.Listener.CancelJBListener;
import hrs.client.UI.LoginUI.RegisterPanel.Listener.RegisterJBListener;
import hrs.client.UI.LoginUI.RegisterPanel.Listener.TypeItemListener;
import hrs.client.UI.UserUI.Components.CommonLabel;
import hrs.client.util.ControllerFactory;
import hrs.client.util.DateChoosePanel;
import hrs.client.util.HMSBlueButton;
import hrs.client.util.HMSGrayButton;
import hrs.client.util.UIConstants;
import hrs.common.Controller.LoginController.ILoginController;
import hrs.common.Exception.UserService.UserExistedException;
import hrs.common.VO.UserVO;
import hrs.common.util.type.UserType;

public class RegisterPanel extends JPanel {

	/**
	* @Fields serialVersionUID : TODO
	*/ 
	private static final long serialVersionUID = 6960447518091833432L;
	
	private int JL_WIDTH = 120;
	private int JL_HEIGHT = 30;
	private int TEXT_WIDTH = 250;
	private int TEXT_HEIGHT = 20;
	private int GAP = (JL_HEIGHT-TEXT_HEIGHT)/2;
	private int START_X = 0;
	private int START_Y = 0;
	
	private JComboBox<String> typeBox ;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JPasswordField confirmpassField;
	private JTextField nameField;
	private JTextField phoneField;
	private JTextField enterpriseField;
	
	private DateChoosePanel dateChoosePanel;
	Font font = UIConstants.JLABEL_FONT;
	Font smallF = UIConstants.FONT_16;
	private ILoginController controller;
	private LoginFrame frame;
	/**
	 * Create the panel.
	 */
	public RegisterPanel(LoginFrame frame) {
		this.frame = frame;
		setSize(508,420);
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
	private void setLabel() {
		CommonLabel accountTypeJL = new CommonLabel("用户类型");
		accountTypeJL.setFont(smallF);
		accountTypeJL.setBounds(START_X, START_Y, JL_WIDTH, JL_HEIGHT);
		add(accountTypeJL);
		
		CommonLabel accountJL = new CommonLabel("用户名*");
		accountJL.setFont(smallF);
		accountJL.setBounds(START_X, START_Y+JL_HEIGHT, JL_WIDTH, JL_HEIGHT);
		add(accountJL);
		
		CommonLabel passwordJL = new CommonLabel("密码*");
		passwordJL.setFont(smallF);
		passwordJL.setBounds(START_X, START_Y+JL_HEIGHT*2, JL_WIDTH, JL_HEIGHT);
		add(passwordJL);
		
		CommonLabel confirmpassJL = new CommonLabel("确认密码*");
		confirmpassJL.setFont(smallF);
		confirmpassJL.setBounds(START_X, START_Y+JL_HEIGHT*3, JL_WIDTH, JL_HEIGHT);
		add(confirmpassJL);
		
		CommonLabel nameJL = new CommonLabel("真实姓名*");
		nameJL.setFont(smallF);
		nameJL.setBounds(START_X, START_Y+JL_HEIGHT*4, JL_WIDTH, JL_HEIGHT);
		add(nameJL);
		
		CommonLabel birthdayJL = new CommonLabel("生日");
		birthdayJL.setFont(smallF);
		birthdayJL.setBounds(START_X, START_Y+JL_HEIGHT*5, JL_WIDTH, JL_HEIGHT+10);
		add(birthdayJL);
		
		CommonLabel phoneJL = new CommonLabel("联系方式*");
		phoneJL.setFont(smallF);
		phoneJL.setBounds(START_X, START_Y+JL_HEIGHT*6+10, JL_WIDTH, JL_HEIGHT);
		add(phoneJL);
		
		CommonLabel enterpriseJL = new CommonLabel("企业名称");
		enterpriseJL.setFont(smallF);
		enterpriseJL.setBounds(START_X, START_Y+JL_HEIGHT*7+10, JL_WIDTH, JL_HEIGHT);
		add(enterpriseJL);
	}
	private void setInputField() {
		typeBox = new JComboBox<>();
		typeBox.setFont(smallF);
		typeBox.addItem("普通用户");
		typeBox.addItem("企业用户");
		typeBox.setBounds(START_X+JL_WIDTH+30, START_Y+GAP, TEXT_WIDTH, TEXT_HEIGHT);
		typeBox.addItemListener(new TypeItemListener(this));
		add(typeBox);
		
		usernameField = new JTextField();
		usernameField.setFont(smallF);
		usernameField.setBounds(START_X+JL_WIDTH+30, START_Y+GAP+JL_HEIGHT, TEXT_WIDTH, TEXT_HEIGHT);
		add(usernameField);
		
		passwordField = new JPasswordField();
		passwordField.setFont(smallF);
		passwordField.setBounds(START_X+JL_WIDTH+30, START_Y+GAP+JL_HEIGHT*2, TEXT_WIDTH, TEXT_HEIGHT);
		add(passwordField);
		
		confirmpassField = new JPasswordField();
		confirmpassField.setFont(smallF);
		confirmpassField.setBounds(START_X+JL_WIDTH+30, START_Y+GAP+JL_HEIGHT*3, TEXT_WIDTH, TEXT_HEIGHT);
		add(confirmpassField);
		
		nameField = new JTextField();
		nameField.setFont(smallF);
		nameField.setBounds(START_X+JL_WIDTH+30, START_Y+GAP+JL_HEIGHT*4, TEXT_WIDTH, TEXT_HEIGHT);
		add(nameField);
		
		dateChoosePanel = new DateChoosePanel();
		dateChoosePanel.changeTobirth();
		dateChoosePanel.setBounds(START_X+JL_WIDTH+30, START_Y+GAP+JL_HEIGHT*5, dateChoosePanel.getWidth(), TEXT_HEIGHT+10);
		add(dateChoosePanel);
		dateChoosePanel.setBackground(this.getBackground());
		
		
		phoneField = new JTextField();
		phoneField.setFont(smallF);
		phoneField.setBounds(START_X+JL_WIDTH+30, START_Y+GAP+JL_HEIGHT*6+10, TEXT_WIDTH, TEXT_HEIGHT);
		add(phoneField);
		
		enterpriseField = new JTextField();
		enterpriseField.setFont(smallF);
		enterpriseField.setBounds(START_X+JL_WIDTH+30, START_Y+GAP+JL_HEIGHT*7+10, TEXT_WIDTH, TEXT_HEIGHT);
		add(enterpriseField);
		enterpriseField.setEnabled(false);
	}
	private void setButton() {
		HMSGrayButton cancelJB = new HMSGrayButton("取消");
		cancelJB.setBounds(80, START_Y+JL_HEIGHT*8+20, 120, 50);
		cancelJB.addActionListener(new CancelJBListener(this));
		add(cancelJB);
		
		HMSBlueButton loginJB = new HMSBlueButton("确定");
		loginJB.setBounds(220, START_Y+JL_HEIGHT*8+20, 120, 50);
		loginJB.addActionListener(new RegisterJBListener(this));
		add(loginJB);
		
	}
	public void cancel() {
		phoneField.setText("");
		usernameField.setText("");
		confirmpassField.setText("");
		passwordField.setText("");
		usernameField.setText("");
		nameField.setText("");
		enterpriseField.setText("");
	}
	
	public void register() {
		String password = new String(passwordField.getPassword());
		String confirmpass = new String(confirmpassField.getPassword());
		if(!password.equals(confirmpass)){
			JOptionPane.showMessageDialog(null, "两次密码输入不一致!", "提示", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		
		if(usernameField.getText().equals("")
				||passwordField.getPassword().length==0
				||nameField.getText().equals("")
				||phoneField.getText().equals("")){
			JOptionPane.showMessageDialog(null, "请输入所有必填信息!", "提示", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
	
		if(typeBox.getSelectedItem().equals("普通用户")){
			System.out.println("普通用户");
			UserVO userVO = new UserVO(usernameField.getText(), password, phoneField.getText(), nameField.getText());
			if(dateChoosePanel.getDate()!=null)
				userVO.birthDate = dateChoosePanel.getDate();
			userVO.type = UserType.Normal;
			try {
				controller.register(userVO);
				JOptionPane.showMessageDialog(null, "注册成功!", "成功", JOptionPane.INFORMATION_MESSAGE);
				cancel();
				frame.showLogin();
			} catch (UserExistedException e) {
				JOptionPane.showMessageDialog(null, "用户名已存在!", "提示", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else{
			UserVO userVO = new UserVO(usernameField.getText(), password, phoneField.getText(), nameField.getText());
			if(dateChoosePanel.getDate()!=null)
				userVO.birthDate = dateChoosePanel.getDate();
			userVO.type = UserType.Enterprise;
			if(enterpriseField.getText().equals("")){
				JOptionPane.showMessageDialog(null, "企业名称不得为空!", "提示", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			userVO.enterprise = enterpriseField.getText();
			try {
				controller.register(userVO);
				JOptionPane.showMessageDialog(null, "注册成功!", "成功", JOptionPane.INFORMATION_MESSAGE);
				cancel();
				frame.showLogin();
			} catch (UserExistedException e) {
				JOptionPane.showMessageDialog(null, "用户名已存在!", "提示", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
		
	}
	public void setEnterprise() {
		if((typeBox.getSelectedItem()).equals("普通用户")){
			enterpriseField.setEnabled(false);
		}
		else{
			enterpriseField.setEnabled(true);
		}
		
	}

}
