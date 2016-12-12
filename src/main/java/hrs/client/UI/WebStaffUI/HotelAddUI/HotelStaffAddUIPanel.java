package hrs.client.UI.WebStaffUI.HotelAddUI;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import hrs.client.UI.WebStaffUI.WebStaffFrame;
import hrs.client.UI.WebStaffUI.HotelAddUI.HotelAddListener.ConfirmMouseListener;
import hrs.client.UI.WebStaffUI.HotelAddUI.HotelAddListener.LastStepMouseListener;
import hrs.client.util.ControllerFactory;
import hrs.client.util.HMSBlueButton;
import hrs.client.util.UIConstants;
import hrs.common.Controller.WebStaffController.IWebStaffController;
import hrs.common.Exception.HotelService.HotelNotFoundException;
import hrs.common.Exception.StaffService.StaffExistedException;
import hrs.common.VO.HotelVO;
import hrs.common.VO.StaffVO;
import hrs.common.util.type.StaffType;

import javax.swing.JTextField;

public class HotelStaffAddUIPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2255510894682597506L;
	private JTextField jtextHotelStaffUsrname;
	private JPanel jpHotelAdd;
	private JPanel jpHotelStaffAdd;
	private JLabel jlpanelIN;
	private JLabel lblNewLabel;
	private HMSBlueButton jbConfirm;
	private HMSBlueButton jbLastStep;
	private JLabel jlPassword;
	private JLabel jlPasswordConfirm;
	private JLabel jlHotelStaffRealName;
	private JTextField jtextPassword;
	private JTextField jtextPasswordConfirm;
	private JTextField jtextRealName;
	private LastStepMouseListener lastStepMouseListener;
	private WebStaffFrame webStaffFrame;
	private StaffVO staffVO;
	private HotelVO hotelVO;
	private HotelAddUIPanel hotelAddUIPanel;
	private IWebStaffController controller = ControllerFactory.getWebStaffController();
	private ConfirmMouseListener listener;
	private JLabel jlHotelStaffUsername;

	/**
	 * Create the panel.
	 */
	public HotelStaffAddUIPanel(WebStaffFrame webStaffFrame, HotelAddUIPanel hotelAddUIPanel) {
		this.webStaffFrame = webStaffFrame;
		this.hotelAddUIPanel = hotelAddUIPanel;
		init();
	}

	public void init() {
		this.setSize(1080, 722);
		this.setBackground(UIConstants.JFRAME);

		jpHotelAdd = new JPanel();
		jpHotelAdd.setBackground(new Color(176, 224, 230));

		jpHotelStaffAdd = new JPanel();
		jpHotelStaffAdd.setBackground(Color.WHITE);

		jlHotelStaffUsername = new JLabel("用户名");
		jlHotelStaffUsername.setHorizontalAlignment(SwingConstants.LEFT);
		jlHotelStaffUsername.setFont(UIConstants.FONT_19);

		jtextHotelStaffUsrname = new JTextField();
		jtextHotelStaffUsrname.setColumns(10);

		jbLastStep = new HMSBlueButton("上一步");
		jbLastStep.setFont(UIConstants.FONT_18);
		lastStepMouseListener = new LastStepMouseListener(this);
		jbLastStep.addMouseListener(lastStepMouseListener);

		jbConfirm = new HMSBlueButton("确认");
		jbConfirm.setFont(UIConstants.FONT_18);
		listener = new ConfirmMouseListener(this);
		jbConfirm.addMouseListener(listener);

		jlPassword = new JLabel("密码");
		jlPassword.setHorizontalAlignment(SwingConstants.LEFT);
		jlPassword.setFont(UIConstants.FONT_19);

		jlPasswordConfirm = new JLabel("确认密码");
		jlPasswordConfirm.setHorizontalAlignment(SwingConstants.LEFT);
		jlPasswordConfirm.setFont(UIConstants.FONT_19);

		jlHotelStaffRealName = new JLabel("真实姓名");
		jlHotelStaffRealName.setHorizontalAlignment(SwingConstants.LEFT);
		jlHotelStaffRealName.setFont(UIConstants.FONT_19);

		jtextPassword = new JTextField();
		jtextPassword.setColumns(10);

		jtextPasswordConfirm = new JTextField();
		jtextPasswordConfirm.setColumns(10);

		jtextRealName = new JTextField();
		jtextRealName.setColumns(10);

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addGap(60)
										.addComponent(jpHotelAdd, GroupLayout.PREFERRED_SIZE, 202,
												GroupLayout.PREFERRED_SIZE)
										.addGap(30).addComponent(jpHotelStaffAdd, GroupLayout.PREFERRED_SIZE, 243,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup().addGap(93)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup().addGap(12)
														.addComponent(jbLastStep, GroupLayout.PREFERRED_SIZE, 128,
																GroupLayout.PREFERRED_SIZE)
														.addGap(82)
														.addComponent(jbConfirm, GroupLayout.PREFERRED_SIZE, 128,
																GroupLayout.PREFERRED_SIZE))
												.addGroup(groupLayout.createSequentialGroup()
														.addGroup(groupLayout
																.createParallelGroup(Alignment.TRAILING, false)
																.addComponent(jlPassword, Alignment.LEADING,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(jlHotelStaffUsername, Alignment.LEADING,
																		GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
																.addComponent(jlPasswordConfirm, Alignment.LEADING)
																.addComponent(jlHotelStaffRealName, Alignment.LEADING))
														.addGap(39)
														.addGroup(groupLayout
																.createParallelGroup(Alignment.LEADING, false)
																.addComponent(jtextRealName)
																.addComponent(jtextPasswordConfirm)
																.addComponent(jtextPassword)
																.addComponent(jtextHotelStaffUsrname,
																		GroupLayout.DEFAULT_SIZE, 231,
																		Short.MAX_VALUE))))))
						.addContainerGap(545, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(47)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(jpHotelStaffAdd, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 47,
										Short.MAX_VALUE)
								.addComponent(jpHotelAdd, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 47,
										GroupLayout.PREFERRED_SIZE))
						.addGap(48)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(jlHotelStaffUsername, GroupLayout.PREFERRED_SIZE, 36,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(jtextHotelStaffUsrname, GroupLayout.PREFERRED_SIZE, 41,
										GroupLayout.PREFERRED_SIZE))
						.addGap(41)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(jlPassword)
								.addComponent(jtextPassword, GroupLayout.PREFERRED_SIZE, 41,
										GroupLayout.PREFERRED_SIZE))
						.addGap(41)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(jlPasswordConfirm)
								.addComponent(jtextPasswordConfirm, GroupLayout.PREFERRED_SIZE, 41,
										GroupLayout.PREFERRED_SIZE))
						.addGap(41)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(jlHotelStaffRealName)
								.addComponent(jtextRealName, GroupLayout.PREFERRED_SIZE, 41,
										GroupLayout.PREFERRED_SIZE))
						.addGap(77)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(jbLastStep, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
								.addComponent(jbConfirm, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
						.addGap(222)));

		jlpanelIN = new JLabel("添加酒店工作人员");
		jlpanelIN.setHorizontalAlignment(SwingConstants.CENTER);
		jlpanelIN.setFont(UIConstants.FONT_20);
		jlpanelIN.setForeground(new Color(128, 138, 235));

		GroupLayout gl_jpHotelStaffAdd = new GroupLayout(jpHotelStaffAdd);
		gl_jpHotelStaffAdd
				.setHorizontalGroup(gl_jpHotelStaffAdd.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jpHotelStaffAdd.createSequentialGroup().addContainerGap()
								.addComponent(jlpanelIN, GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
								.addContainerGap()));
		gl_jpHotelStaffAdd
				.setVerticalGroup(gl_jpHotelStaffAdd.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jpHotelStaffAdd.createSequentialGroup().addContainerGap()
								.addComponent(jlpanelIN, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
								.addContainerGap()));
		jpHotelStaffAdd.setLayout(gl_jpHotelStaffAdd);

		lblNewLabel = new JLabel("添加酒店");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(UIConstants.FONT_20);
		lblNewLabel.setForeground(new Color(128, 138, 235));

		GroupLayout gl_jpHotelAdd = new GroupLayout(jpHotelAdd);
		gl_jpHotelAdd
				.setHorizontalGroup(gl_jpHotelAdd.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
						gl_jpHotelAdd.createSequentialGroup().addContainerGap()
								.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
								.addContainerGap()));
		gl_jpHotelAdd
				.setVerticalGroup(gl_jpHotelAdd.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jpHotelAdd.createSequentialGroup().addContainerGap()
								.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
								.addContainerGap()));
		jpHotelAdd.setLayout(gl_jpHotelAdd);
		setLayout(groupLayout);
	}

	public void showHotelAddUIPanel() {
		webStaffFrame.showHotelAddUIPanel();
	}

	public int passwordValid() {
		if (jtextPassword.getText().equals(jtextPasswordConfirm.getText())) {
			return 1;
		} else
			return 0;
	}

	public void addHotel() {
		hotelVO = this.hotelAddUIPanel.getHotelVO();
		// System.out.println(hotelVO);
		controller.addHotel(hotelVO);
	}

	public void addHotelStaff() {
		String username = jtextHotelStaffUsrname.getText();
		String password = jtextPassword.getText();
		String doublePassword = jtextPasswordConfirm.getText();
		String realName = jtextRealName.getText();
		// HotelVO hotelVO=this.hotelAddUIPanel.getHotelVO();
		if (username.equals("") || password.equals("") || doublePassword.equals("") || realName.equals("")) {
			JOptionPane.showMessageDialog(null, "请完整填写信息!", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			addHotel();
			HotelVO newHotelVO = null;
			try {
				newHotelVO = controller.findHotelByHotelName(hotelAddUIPanel.getHotelName());
			} catch (HotelNotFoundException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Error!", "Error", JOptionPane.ERROR_MESSAGE);
			}
			staffVO = new StaffVO(username, password, realName, StaffType.HotelStaff, newHotelVO);
			// System.out.println(staffVO);
			int result = JOptionPane.showConfirmDialog(null, "是否确定添加酒店？", "提示", JOptionPane.YES_NO_OPTION,
					JOptionPane.INFORMATION_MESSAGE);
			if (result == 0) {
				try {
					controller.addStaff(staffVO);
					JOptionPane.showMessageDialog(null, "添加酒店成功！");
				} catch (StaffExistedException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(hotelAddUIPanel, "此酒店已存在！", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			refresh();
			webStaffFrame.showHotelAddUIPanel();
		}
	}

	public void refresh() {
		hotelAddUIPanel.refresh();
		jtextHotelStaffUsrname.setText("");
		jtextPassword.setText("");
		jtextPasswordConfirm.setText("");
		jtextRealName.setText("");
	}

	public String getUsername() {
		return jtextHotelStaffUsrname.getText();
	}

	public String getPassword() {
		return jtextPassword.getText();
	}
}
