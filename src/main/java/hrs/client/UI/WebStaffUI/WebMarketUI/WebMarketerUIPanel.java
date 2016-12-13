package hrs.client.UI.WebStaffUI.WebMarketUI;

import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import hrs.client.UI.WebStaffUI.WebMarketUI.WebMarketListener.AddWebMarketerMouseListener;
import hrs.client.UI.WebStaffUI.WebMarketUI.WebMarketListener.ModifyWebMarketerMouseListener;
import hrs.client.UI.WebStaffUI.WebMarketUI.WebMarketListener.SearchWebMarketerConfirmMouseListener;
import hrs.client.util.ControllerFactory;
import hrs.client.util.HMSBlueButton;
import hrs.client.util.RegExpHelper;
import hrs.client.util.UIConstants;
import hrs.common.Controller.WebStaffController.IWebStaffController;
import hrs.common.Exception.StaffService.StaffExistedException;
import hrs.common.Exception.StaffService.StaffNotFoundExceptioon;
import hrs.common.VO.StaffVO;

public class WebMarketerUIPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3770078005719525032L;
	private JLabel jlWebMarketerSearch;
	private JLabel jlWebMarketerUsername;
	private JLabel jlWebMarketerPassword;
	private JLabel jlWebMarketerRealName;
	private JTextField jtextWebMarketerUsername;
	private JTextField jtextPassword;
	private JTextField jtextWebMarketerRealName;
	private HMSBlueButton jbSearchWebMarketerConfirm;
	private HMSBlueButton jbModifyWebMarketer;
	private HMSBlueButton jbAddWebMarketer;
	private IWebStaffController controller = ControllerFactory.getWebStaffController();
	private StaffVO webMarketerVO;
	private SearchWebMarketerConfirmMouseListener searchWebMarketerConfirmMouseListener;
	private ModifyWebMarketerMouseListener modifyWebMarketerMouseListener;
	private AddWebMarketerMouseListener addWebMarketerMouseListener;
	private AddWebMarketerDialog addWebMarketerDialog = new AddWebMarketerDialog(this);
	private JLabel jlUsernameShow;

	/**
	 * Create the panel.
	 */
	public WebMarketerUIPanel() {
		init();
	}

	public void init() {
		this.setSize(1080, 722);		
		this.setBackground(UIConstants.JFRAME);

		jlWebMarketerSearch = new JLabel("搜索网站营销人员");
		jlWebMarketerSearch.setBounds(61, 55, 168, 26);
		jlWebMarketerSearch.setFont(UIConstants.JLABEL_FONT);

		jlWebMarketerUsername = new JLabel("用户名");
		jlWebMarketerUsername.setBounds(61, 131, 63, 26);
		jlWebMarketerUsername.setFont(UIConstants.JLABEL_FONT);

		jlWebMarketerPassword = new JLabel("密码");
		jlWebMarketerPassword.setBounds(61, 200, 42, 26);
		jlWebMarketerPassword.setFont(UIConstants.JLABEL_FONT);

		jlWebMarketerRealName = new JLabel("真实姓名");
		jlWebMarketerRealName.setBounds(61, 278, 84, 26);
		jlWebMarketerRealName.setFont(UIConstants.JLABEL_FONT);

		jtextWebMarketerUsername = new JTextField();
		jtextWebMarketerUsername.setFont(UIConstants.FONT_19);
		jtextWebMarketerUsername.setBounds(298, 53, 215, 37);
		jtextWebMarketerUsername.setColumns(10);

		jtextPassword = new JTextField();
		jtextPassword.setFont(UIConstants.FONT_19);
		jtextPassword.setBounds(298, 198, 215, 37);
		jtextPassword.setColumns(10);

		jtextWebMarketerRealName = new JTextField();
		jtextWebMarketerRealName.setFont(UIConstants.FONT_19);
		jtextWebMarketerRealName.setBounds(298, 276, 215, 37);
		jtextWebMarketerRealName.setColumns(10);

		jbSearchWebMarketerConfirm = new HMSBlueButton("搜索");
		jbSearchWebMarketerConfirm.setBounds(579, 54, 76, 32);
		jbSearchWebMarketerConfirm.setFont(UIConstants.FONT_19);
		searchWebMarketerConfirmMouseListener = new SearchWebMarketerConfirmMouseListener(this);
		jbSearchWebMarketerConfirm.addMouseListener(searchWebMarketerConfirmMouseListener);

		jbModifyWebMarketer = new HMSBlueButton("修改");
		jbModifyWebMarketer.setBounds(711, 503, 90, 40);
		jbModifyWebMarketer.setFont(UIConstants.FONT_18);
		modifyWebMarketerMouseListener = new ModifyWebMarketerMouseListener(this);
		jbModifyWebMarketer.addMouseListener(modifyWebMarketerMouseListener);

		jbAddWebMarketer = new HMSBlueButton("添加");
		jbAddWebMarketer.setBounds(881, 503, 90, 40);
		jbAddWebMarketer.setFont(UIConstants.FONT_18);
		addWebMarketerMouseListener = new AddWebMarketerMouseListener(this);
		jbAddWebMarketer.addMouseListener(addWebMarketerMouseListener);

		jlUsernameShow = new JLabel();
		jlUsernameShow.setBounds(298, 131, 215, 24);
		jlUsernameShow.setFont(UIConstants.FONT_19);
		
		setLayout(null);
		add(jlWebMarketerSearch);
		add(jlWebMarketerUsername);
		add(jlWebMarketerPassword);
		add(jlWebMarketerRealName);
		add(jtextWebMarketerRealName);
		add(jtextPassword);
		add(jtextWebMarketerUsername);
		add(jlUsernameShow);
		add(jbSearchWebMarketerConfirm);
		add(jbModifyWebMarketer);
		add(jbAddWebMarketer);
	}

	public StaffVO searchAndShow() {
		if (jtextWebMarketerUsername.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "请先输入网站营销人员用户名！", "Error", JOptionPane.ERROR_MESSAGE);
			return null;
		} else {
			try {
				webMarketerVO = controller.findStaffByUsername(jtextWebMarketerUsername.getText());
			} catch (StaffNotFoundExceptioon e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(this, "网站营销人员不存在！", "No Such WebMarketer", JOptionPane.ERROR_MESSAGE);
			}
			jlUsernameShow.setText(webMarketerVO.username);
			jtextPassword.setText(webMarketerVO.password);
			jtextWebMarketerRealName.setText(webMarketerVO.name);
			return webMarketerVO;
		}
	}

	public String getUsername() {
		return jlUsernameShow.getText();
	}

	public String getPassword() {
		return jtextPassword.getText();
	}

	public void modify() {
		String newPassword = jtextPassword.getText();
		String newName = jtextWebMarketerRealName.getText();
		webMarketerVO.password = newPassword;
		webMarketerVO.name = newName;
		controller.updateStaff(webMarketerVO);
	}

	public void add() {
		StaffVO addStaffVO = addWebMarketerDialog.getInput();
		if (!RegExpHelper.matchUsernameAndPWD(addStaffVO.username)
				|| !RegExpHelper.matchUsernameAndPWD(addStaffVO.password)) {
			JOptionPane.showMessageDialog(null, "用户名和密码要求至少6位，且为字母或数字！", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			int result = JOptionPane.showConfirmDialog(null, "是否确定添加？", "提示", JOptionPane.YES_NO_OPTION,
					JOptionPane.INFORMATION_MESSAGE);
			if (result == 0) {
				try {
					controller.addStaff(addStaffVO);
					JOptionPane.showConfirmDialog(null, "信息添加成功", "添加成功", JOptionPane.PLAIN_MESSAGE,
							JOptionPane.INFORMATION_MESSAGE);
				} catch (StaffExistedException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(this, "网站营销人员已存在！", "Such WebMarketer Existed",
							JOptionPane.ERROR_MESSAGE);
				}
			}
			addWebMarketerDialog.dispose();
		}
	}

	public void showDialog() {
		// addWebMarketerDialog.show();
		addWebMarketerDialog=new AddWebMarketerDialog(this);
		addWebMarketerDialog.setVisible(true);
		addWebMarketerDialog.setLocationRelativeTo(null);
	}

}
