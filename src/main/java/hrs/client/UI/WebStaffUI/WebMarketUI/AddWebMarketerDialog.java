package hrs.client.UI.WebStaffUI.WebMarketUI;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hrs.client.UI.WebStaffUI.WebMarketUI.WebMarketListener.AddWebMarketerDialogConfirmMouseListener;
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
	private JTextField jtextPassword;
	private JTextField jtextRealName;
	private AddWebMarketerDialogConfirmMouseListener addWebMarketerDialogConfirmMouseListener;
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

	public void init() {		
		setTitle("添加网站营销人员");
		setBounds(100, 100, 400, 280);
		this.setResizable(false);
		
		getContentPane().setLayout(null);
		getContentPane().setBackground(UIConstants.JFRAME);
		jpAddWebMarketer.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(jpAddWebMarketer, BorderLayout.CENTER);

		jlUsername = new JLabel("用户名");
		jlUsername.setBounds(86, 33, 61, 16);
		getContentPane().add(jlUsername);

		jlPassword = new JLabel("密码");
		jlPassword.setBounds(86, 77, 61, 16);
		getContentPane().add(jlPassword);

		jlRealName = new JLabel("真实姓名");
		jlRealName.setBounds(86, 125, 61, 16);
		getContentPane().add(jlRealName);

		jtextUsername = new JTextField();
		jtextUsername.setBounds(181, 28, 130, 26);
		getContentPane().add(jtextUsername);
		jtextUsername.setColumns(10);

		jtextPassword = new JTextField();
		jtextPassword.setBounds(181, 72, 130, 26);
		getContentPane().add(jtextPassword);
		jtextPassword.setColumns(10);

		jtextRealName = new JTextField();
		jtextRealName.setBounds(181, 120, 130, 26);
		getContentPane().add(jtextRealName);
		jtextRealName.setColumns(10);

		jbConfirm = new HMSBlueButton("确认");
		jbConfirm.setFont(UIConstants.FONT_13);
		jbConfirm.setBounds(107, 181, 75, 29);
		getContentPane().add(jbConfirm);
		addWebMarketerDialogConfirmMouseListener = new AddWebMarketerDialogConfirmMouseListener(webMarketerUIPanel);
		jbConfirm.addMouseListener(addWebMarketerDialogConfirmMouseListener);

		jbCancel = new HMSBlueButton("取消");
		jbCancel.setFont(UIConstants.FONT_13);
		jbCancel.setBounds(211, 181, 75, 29);
		getContentPane().add(jbCancel);
	}

	public StaffVO getInput() {
		String addUsername = jtextUsername.getText();
		String addPassword = jtextPassword.getText();
		String addRealName = jtextRealName.getText();
		StaffVO addWebMarketerVO = new StaffVO(addUsername, addPassword, addRealName, StaffType.WebsiteMarketer, null);
		// System.out.println(addWebMarketerVO);
		return addWebMarketerVO;
	}
}
