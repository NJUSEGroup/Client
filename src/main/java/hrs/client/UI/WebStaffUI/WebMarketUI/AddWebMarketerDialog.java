package hrs.client.UI.WebStaffUI.WebMarketUI;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import hrs.client.UI.WebStaffUI.WebMarketUI.WebMarketListener.AddWebMarketerDialogConfirmMouseListener;
import hrs.client.UI.WebStaffUI.WebMarketUI.WebMarketListener.CancelAddMouseListener;
import hrs.client.util.HMSBlueButton;
import hrs.client.util.UIConstants;
import hrs.common.VO.StaffVO;
import hrs.common.util.type.StaffType;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddWebMarketerDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3078896695933787804L;
	private final JPanel jpAddWebMarketer = new JPanel();
	private JTextField jtextUsername;
	private JPasswordField jtextPassword;
	private JTextField jtextRealName;
	private AddWebMarketerDialogConfirmMouseListener addWebMarketerDialogConfirmMouseListener;
	private CancelAddMouseListener cancelAddMouseListener;
	private WebMarketerUIPanel webMarketerUIPanel;
	private JLabel jlUsername;
	private JLabel jlPassword;
	private JLabel jlRealName;
	private HMSBlueButton jbConfirm, jbCancel;

	// /**
	// * Launch the application.
	// */
	// public static void main(String[] args) {
	// try {
	// AddWebMarketerDialog dialog = new AddWebMarketerDialog();
	// dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	// dialog.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }

	/**
	 * Create the dialog.
	 */
	public AddWebMarketerDialog(WebMarketerUIPanel webMarketerUIPanel) {// panel!
		this.webMarketerUIPanel = webMarketerUIPanel;
		init();
	}

	/**
	 * 刷新网站营销人员添加界面
	 */
	public void init() {
		setTitle("添加网站营销人员");
		setBounds(100, 100, 400, 280);
		this.setResizable(false);

		getContentPane().setLayout(null);
		getContentPane().setBackground(UIConstants.JFRAME);
		jpAddWebMarketer.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(jpAddWebMarketer, BorderLayout.CENTER);

		jlUsername = new JLabel("用户名");
		jlUsername.setFont(UIConstants.FONT_19);
		jlUsername.setBounds(86, 33, 84, 16);
		getContentPane().add(jlUsername);

		jlPassword = new JLabel("密码");
		jlPassword.setFont(UIConstants.FONT_19);
		jlPassword.setBounds(86, 77, 84, 16);
		getContentPane().add(jlPassword);

		jlRealName = new JLabel("真实姓名");
		jlRealName.setFont(UIConstants.FONT_19);
		jlRealName.setBounds(86, 125, 84, 16);
		getContentPane().add(jlRealName);

		jtextUsername = new JTextField();
		jtextUsername.setFont(UIConstants.FONT_19);
		jtextUsername.setBounds(196, 28, 130, 26);
		getContentPane().add(jtextUsername);
		jtextUsername.setColumns(10);

		jtextPassword = new JPasswordField();
		jtextPassword.setFont(UIConstants.FONT_19);
		jtextPassword.setBounds(196, 72, 130, 26);
		getContentPane().add(jtextPassword);
		jtextPassword.setColumns(10);

		jtextRealName = new JTextField();
		jtextRealName.setFont(UIConstants.FONT_19);
		jtextRealName.setBounds(196, 120, 130, 26);
		getContentPane().add(jtextRealName);
		jtextRealName.setColumns(10);

		jbConfirm = new HMSBlueButton("确认");
		jbConfirm.setFont(UIConstants.FONT_19);
		jbConfirm.setBounds(107, 181, 75, 29);
		getContentPane().add(jbConfirm);
		addWebMarketerDialogConfirmMouseListener = new AddWebMarketerDialogConfirmMouseListener(webMarketerUIPanel);
		jbConfirm.addMouseListener(addWebMarketerDialogConfirmMouseListener);

		jbCancel = new HMSBlueButton("取消");
		jbCancel.setFont(UIConstants.FONT_19);
		jbCancel.setBounds(211, 181, 75, 29);
		getContentPane().add(jbCancel);
		cancelAddMouseListener = new CancelAddMouseListener(this);
		jbCancel.addMouseListener(cancelAddMouseListener);
	}

	public StaffVO getInput() {
		String addUsername = jtextUsername.getText();
		String addPassword = new String(jtextPassword.getPassword());
		String addRealName = jtextRealName.getText();
		StaffVO addWebMarketerVO = new StaffVO(addUsername, addPassword, addRealName, StaffType.WebsiteMarketer, null);
		// System.out.println(addWebMarketerVO);
		return addWebMarketerVO;
	}
}
