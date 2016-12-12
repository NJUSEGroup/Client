package hrs.client.UI.UserUI.UserInfoUI;

import java.awt.Dimension;
import java.awt.Font;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import hrs.client.UI.UserUI.UserFrame;
import hrs.client.UI.UserUI.Components.CommonPanel;
import hrs.client.UI.UserUI.UserInfoUI.UserInfoListener.CancelListener;
import hrs.client.UI.UserUI.UserInfoUI.UserInfoListener.ConfirmListener;
import hrs.client.util.ControllerFactory;
import hrs.client.util.DateChoosePanel;
import hrs.client.util.HMSBlueButton;
import hrs.client.util.UIConstants;
import hrs.common.Controller.UserController.IUserController;
import hrs.common.Exception.UserService.UserNotFoundException;
import hrs.common.VO.UserVO;
import hrs.common.util.DateHelper;

public class UserInfoPanel extends CommonPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9086068773100889858L;
	private JLabel userLabel;
	private JLabel nameLabel;
	private JLabel birthLabel;
	private JLabel contactLabel;
	private JLabel enterpriseLabel;
	private JLabel creditLabel;

	private JTextField userTextField;// 用户名文本框
	private JTextField nameTextField;// 真实姓名
	private JTextField contactTextField;// 联系方式
	private JTextField enterpriseField;// 企业
	private JLabel vipLv;
	private JLabel creditJL;

	private JComboBox<String> yearBox;// 出生年份选框
	private JComboBox<String> monthBox;// 出生月份选框
	private JComboBox<String> dayBox;// 出生日期选框
	private DateChoosePanel dateChoosePanel;

	private static int COMP_HEIGHT = 60;// 标签宽度，也即每行高度
	private static int TEXT_HEIGHT = 40;// 文本框高度
	private static int GAP_WIDTH = 60;// 左边空隙宽度
	private static int TEXT_X = 130 + GAP_WIDTH;// 文本框起始x坐标
	private UserFrame frame;

	// private Date date;
	private IUserController controller = ControllerFactory.getUserController();

	private UserVO user;

	Font font = UIConstants.JLABEL_FONT;

	public UserInfoPanel(UserVO user) {
		// setFont(font);
		this.user = user;

		// 初始化
		init();

		// setLayout(null);
		// setBackground(new Color(211, 237, 249));
		// setSize(1043, 688);

	}

	public void setFrame(UserFrame frame) {
		this.frame = frame;
	}
	@Override
	public void init() {
		creditJL = new JLabel();
		vipLv = new JLabel();
		userLabel = new UserInfoLabel("用户名");
		nameLabel = new UserInfoLabel("真实姓名");
		birthLabel = new UserInfoLabel("生日");
		contactLabel = new UserInfoLabel("联系方式");
		enterpriseLabel = new UserInfoLabel("企业名称");
		creditLabel = new UserInfoLabel("信用值");

		userTextField = new UserInfoText();// 用户名文本框
		nameTextField = new UserInfoText();// 真实姓名
		contactTextField = new UserInfoText();// 联系方式
		enterpriseField = new UserInfoText();// 企业

		userTextField.setBounds(TEXT_X, COMP_HEIGHT + 10, 180, TEXT_HEIGHT);
		nameTextField.setBounds(TEXT_X, COMP_HEIGHT * 2 + 10, 180, TEXT_HEIGHT);
		contactTextField.setBounds(TEXT_X, COMP_HEIGHT * 4 + 10, 180, TEXT_HEIGHT);
		enterpriseField.setBounds(TEXT_X, COMP_HEIGHT * 5 + 10, 180, TEXT_HEIGHT);
		creditJL.setBounds(TEXT_X, COMP_HEIGHT * 6, 100, COMP_HEIGHT);
		vipLv.setBounds(TEXT_X, COMP_HEIGHT * 7, 100, COMP_HEIGHT);

		// yearBox = new JComboBox<>();
		// monthBox = new JComboBox<>();
		// dayBox = new JComboBox<>();
		dateChoosePanel = new DateChoosePanel();
		dateChoosePanel.changeTobirth();
		dateChoosePanel.setDate(user.birthDate);
		dateChoosePanel.setBounds(TEXT_X, COMP_HEIGHT * 3 + 10 + 5, 260, 30);

		add(dateChoosePanel);
		add(userTextField);
		add(nameTextField);
		add(contactTextField);
		add(enterpriseField);
		add(creditJL);
		add(vipLv);
		// 从数据库获得用户信息
		getInfo();

		// 设置信息标签
		setLabel();

		// 设置按钮
		setButton();
	}

	private void setButton() {
		HMSBlueButton cancelJB = new HMSBlueButton("取消");
		cancelJB.setBounds(560, 500, 150, 60);
		cancelJB.addActionListener(new CancelListener(this));
		this.add(cancelJB);

		HMSBlueButton confirmJB = new HMSBlueButton("确认");
		confirmJB.setBounds(800, 500, 150, 60);
		confirmJB.addActionListener(new ConfirmListener(this, user));
		this.add(confirmJB);
	}

	/*
	 * 从数据库获得真实姓名，生日，联系方式，企业，信用值
	 */
	public void getInfo() {

		userTextField.setText(user.username);
		userTextField.setEnabled(false);
		nameTextField.setText(user.name);
		contactTextField.setText(user.phone);
		enterpriseField.setText(user.enterprise);
		creditJL = new JLabel("" + user.credit);
		vipLv = new UserInfoLabel("" + user.credit);
		
		enterpriseField.setEnabled(false);
		creditJL.setFont(font);
		creditJL.setPreferredSize(new Dimension(100, 60));

		vipLv.setFont(font);
		vipLv.setPreferredSize(new Dimension(100, 60));

	}

	/**
	 * 设置信息标签 即： 用户名 真实姓名 生日 联系方式 企业名称 信用值
	 *
	 */
	private void setLabel() {
		userLabel.setBounds(GAP_WIDTH, COMP_HEIGHT, 100, 60);
		nameLabel.setBounds(GAP_WIDTH, COMP_HEIGHT * 2, 100, COMP_HEIGHT);
		birthLabel.setBounds(GAP_WIDTH, COMP_HEIGHT * 3, 100, COMP_HEIGHT);
		contactLabel.setBounds(GAP_WIDTH, COMP_HEIGHT * 4, 100, COMP_HEIGHT);
		enterpriseLabel.setBounds(GAP_WIDTH, COMP_HEIGHT * 5, 100, COMP_HEIGHT);
		creditLabel.setBounds(GAP_WIDTH, COMP_HEIGHT * 6, 100, COMP_HEIGHT);

		JLabel vipLvJL = new UserInfoLabel("会员等级");
		vipLvJL.setBounds(GAP_WIDTH, COMP_HEIGHT * 7, 100, COMP_HEIGHT);

		this.add(userLabel);
		this.add(nameLabel);
		this.add(birthLabel);
		this.add(contactLabel);
		this.add(enterpriseLabel);
		this.add(creditLabel);
		this.add(vipLvJL);
	}

	public String getUsername() {
		System.out.println(userTextField.getText());
		return userTextField.getText();
	}

	public String getEnterprise() {

		return enterpriseField.getText();
	}

	public String getPhone() {
		return contactTextField.getText();
	}

	public String getRealName() {
		return nameTextField.getText();
	}

	public void update() {
		user.birthDate = dateChoosePanel.getDate();
		System.out.println(dateChoosePanel.getDate());
		user.username = getUsername();
		user.enterprise = getEnterprise();
		user.name = getRealName();
		user.phone = getPhone();

		controller.updateUser(user);
	}

	public void refresh() {
		frame.showUserInfo();
	}
}
