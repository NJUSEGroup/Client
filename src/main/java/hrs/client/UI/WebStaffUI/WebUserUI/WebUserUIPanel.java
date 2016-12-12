package hrs.client.UI.WebStaffUI.WebUserUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JTextField;
import hrs.client.UI.WebStaffUI.WebUserUI.WebUserListener.ModifyUserInfoMouseListener;
import hrs.client.UI.WebStaffUI.WebUserUI.WebUserListener.SearchUserConfirmMouseListener;
import hrs.client.util.ControllerFactory;
import hrs.client.util.HMSBlueButton;
import hrs.client.util.UIConstants;
import hrs.common.Controller.WebStaffController.IWebUserController;
import hrs.common.Exception.UserService.UserNotFoundException;
import hrs.common.VO.UserVO;

public class WebUserUIPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7728675080258429036L;
	private IWebUserController controller = ControllerFactory.getWebUserController();
	private JTextField jtextUsername;
	private JLabel jlUserSearch;
	private HMSBlueButton jbConfirm, jbModify;
	private ShowUserInfoPanel showUserInfoPanel;
	private SearchUserConfirmMouseListener confirmMouseListener;
	private UserVO userVO;
	private ModifyUserInfoMouseListener modifyUserInfoMouseListener;

	/**
	 * Create the panel.
	 */
	public WebUserUIPanel(ShowUserInfoPanel showUserInfoPanel) {
		this.showUserInfoPanel = showUserInfoPanel;
		init();
		this.add(showUserInfoPanel);
		showUserInfoPanel.setBounds(5, 80, 1068, 430);
		// showUserinfo(showUserInfoPanel);
	}

	public void init() {
		this.setSize(1080, 722);
		this.setBackground(UIConstants.JFRAME);

		jlUserSearch = new JLabel("搜索用户");
		jlUserSearch.setBounds(43, 40, 105, 26);
		jlUserSearch.setFont(UIConstants.JLABEL_FONT);

		jtextUsername = new JTextField();
		jtextUsername.setBounds(175, 37, 253, 38);
		jtextUsername.setColumns(10);

		jbConfirm = new HMSBlueButton("搜索");
		jbConfirm.setBounds(490, 37, 80, 34);
		confirmMouseListener = new SearchUserConfirmMouseListener(this);
		jbConfirm.addMouseListener(confirmMouseListener);

		jbModify = new HMSBlueButton("修改");
		jbModify.setBounds(850, 586, 90, 40);
		jbModify.setFont(UIConstants.FONT_21);
		modifyUserInfoMouseListener = new ModifyUserInfoMouseListener(this);
		jbModify.addMouseListener(modifyUserInfoMouseListener);

		setLayout(null);
		add(jlUserSearch);
		add(jtextUsername);
		add(jbConfirm);
		add(jbModify);
	}

	public UserVO searchUserByUsername() {
		String username = jtextUsername.getText();
		if (username.equals("")) {
			JOptionPane.showMessageDialog(this, "请输入用户名！", "Error", JOptionPane.ERROR_MESSAGE);
			return null;
		} else {
			try {
				userVO = controller.findUserByUsername(username);
			} catch (UserNotFoundException e) {
				// TODO Auto-generated catch block
				showUserInfoPanel.clear();
				JOptionPane.showMessageDialog(null, "用户不存在！", "No Such User", JOptionPane.ERROR_MESSAGE);
				return null;
			}
			return userVO;
		}

	}

	public void modify() {
		userVO.password = showUserInfoPanel.getPassword();
		userVO.name = showUserInfoPanel.getRealName();
		userVO.birthDate = showUserInfoPanel.getBirthday();
		userVO.phone = showUserInfoPanel.getPhone();
		controller.updateUser(userVO);
	}

	public String getNewPassword() {
		return showUserInfoPanel.getPassword();
	}

	public String getName() {
		return jtextUsername.getText();
	}

	public void showUserinfo() {
		if (searchUserByUsername() != null) {
			showUserInfoPanel.inputInfo(searchUserByUsername());
		}
	}

}
