package hrs.client.UI.WebStaffUI.WebUserUI;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.util.Date;
import javax.swing.JTextField;

import hrs.client.util.DateChoosePanel;
import hrs.client.util.UIConstants;
import hrs.common.VO.UserVO;

public class ShowUserInfoPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5437312933054543396L;
	private JLabel jlUsername;
	private JLabel jlPassword;
	private JLabel jlRealName;
	private JLabel jlBirthday;
	private JLabel jlPhone;
	private JLabel jlEnterpriseName;
	private JLabel jlCredit;
	private JTextField jtextPassword;
	private JTextField jtextRealName;
	private DateChoosePanel jtextBirthdayShow;
	private JTextField jtextPhone;
	private JLabel jlCreditvalue;
	private JLabel jlUsernameShow;
	private JLabel jlEnterpriseShow;

	/**
	 * Create the panel.
	 */
	public ShowUserInfoPanel() {
		init();
	}

	public void init() {
		this.setSize(1068, 430);
		this.setBackground(new Color(211, 237, 249));

		jlUsername = new JLabel("用户名");
		jlUsername.setBounds(43, 36, 72, 35);
		jlUsername.setFont(UIConstants.FONT_18);

		jlPassword = new JLabel("密码");
		jlPassword.setBounds(43, 89, 72, 35);
		jlPassword.setFont(UIConstants.FONT_18);

		jlRealName = new JLabel("真实姓名");
		jlRealName.setBounds(43, 145, 72, 35);
		jlRealName.setFont(UIConstants.FONT_18);

		jlBirthday = new JLabel("生日");
		jlBirthday.setBounds(43, 201, 72, 35);
		jlBirthday.setFont(UIConstants.FONT_18);

		jlPhone = new JLabel("联系方式");
		jlPhone.setBounds(43, 257, 72, 35);
		jlPhone.setFont(UIConstants.FONT_18);

		jlEnterpriseName = new JLabel("企业名称");
		jlEnterpriseName.setBounds(43, 313, 72, 35);
		jlEnterpriseName.setFont(UIConstants.FONT_18);

		jlCredit = new JLabel("信用值");
		jlCredit.setBounds(43, 369, 72, 35);
		jlCredit.setFont(UIConstants.FONT_18);

		jtextPassword = new JTextField();
		jtextPassword.setFont(UIConstants.FONT_17);
		jtextPassword.setBounds(171, 89, 253, 38);
		jtextPassword.setColumns(10);

		jtextRealName = new JTextField();
		jtextRealName.setFont(UIConstants.FONT_17);
		jtextRealName.setBounds(171, 145, 253, 38);
		jtextRealName.setColumns(10);

		jtextBirthdayShow = new DateChoosePanel();
		jtextBirthdayShow.dayBox.setBounds(180, 5, 50, 30);
		jtextBirthdayShow.monthBox.setSize(50, 30);
		jtextBirthdayShow.yearBox.setBounds(0, 5, 70, 30);
		jtextBirthdayShow.monthBox.setLocation(99, 5);
		jtextBirthdayShow.changeTobirth();
		jtextBirthdayShow.setBounds(171, 201, 253, 35);

		jtextPhone = new JTextField();
		jtextPhone.setFont(UIConstants.FONT_17);
		jtextPhone.setBounds(171, 257, 253, 38);
		jtextPhone.setColumns(10);

		jlUsernameShow = new JLabel();
		jlUsernameShow.setFont(UIConstants.FONT_19);
		jlUsernameShow.setBounds(171, 36, 253, 38);

		jlEnterpriseShow = new JLabel();
		jlEnterpriseShow.setFont(UIConstants.FONT_19);
		jlEnterpriseShow.setBounds(171, 313, 253, 38);

		jlCreditvalue = new JLabel();
		jlCreditvalue.setFont(UIConstants.FONT_19);
		jlCreditvalue.setBounds(171, 369, 253, 38);

		setLayout(null);

		add(jlCredit);
		add(jlEnterpriseName);
		add(jlPhone);
		add(jlBirthday);
		add(jlRealName);
		add(jlPassword);
		add(jlUsername);
		add(jlUsernameShow);
		add(jlCreditvalue);
		add(jlEnterpriseShow);
		add(jtextRealName);
		add(jtextPassword);
		add(jtextBirthdayShow);
		add(jtextPhone);
	}

	// public String getUsername(){
	// return .getText();
	// }
	public String getPassword() {
		return jtextPassword.getText();
	}

	public String getRealName() {
		// System.out.println(jtextRealName.getText());
		return jtextRealName.getText();
	}

	public java.util.Date getBirthday() {
		Date date = jtextBirthdayShow.getDate();
		return date;
	}

	public String getPhone() {
		// System.out.println(jtextPhone.getText());
		return jtextPhone.getText();
	}

	public void clear() {
		jlUsernameShow.setText("");
		jtextPassword.setText("");
		jtextRealName.setText("");
		jtextPhone.setText("");
		jlEnterpriseShow.setText("");
		jlCreditvalue.setText("");
		jtextBirthdayShow.changeTobirth();
	}

	public void inputInfo(UserVO userVO) {
		jlUsernameShow.setText(userVO.username);
		jtextPassword.setText(userVO.password);
		jtextRealName.setText(userVO.name);	
		jtextPhone.setText(userVO.phone);
		jlEnterpriseShow.setText(userVO.enterprise);
		jlCreditvalue.setText(userVO.credit + "");
		jtextBirthdayShow.setDate(userVO.birthDate);
	}

}
