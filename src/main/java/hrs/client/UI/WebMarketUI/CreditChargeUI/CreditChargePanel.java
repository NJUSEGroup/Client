package hrs.client.UI.WebMarketUI.CreditChargeUI;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.SwingConstants;

import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;

import hrs.client.UI.WebMarketUI.CreditChargeUI.CreditChargeListener.ChargeMouseListener;
import hrs.client.UI.WebMarketUI.CreditChargeUI.CreditChargeListener.ConfirmMouseListener;
import hrs.client.util.ControllerFactory;
import hrs.client.util.HMSBlueButton;
import hrs.client.util.UIConstants;
import hrs.common.Controller.WebMarketController.IWebCreditController;
import hrs.common.Exception.UserService.UserNotFoundException;
import hrs.common.VO.UserVO;
import java.awt.Font;

public class CreditChargePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5309610749415781785L;
	private IWebCreditController webCreditController = ControllerFactory.getWebCreditController();
	private JTextField jtUsername;
	private JTextField jtChargeValue;
	private CreditChargeModel model;
	private JScrollPane scrollPane;
	private JLabel jlFindUser;
	private HMSBlueButton jbConfirm, jbChargeValue;
	private JLabel jlChargeValue;
	private JTableHeader jTableHeader;
	private JTable jTable;
	private UserVO userVO;
	private String username;
	private CreditChargeModel creditChargeModel;

	/**
	 * Create the panel.
	 */
	public CreditChargePanel() {
		init();
	}

	public void init() {
		setSize(1080, 722);
		setBackground(UIConstants.JFRAME);

		jlFindUser = new JLabel("搜索用户");
		jlFindUser.setBounds(14, 23, 114, 36);
		jlFindUser.setHorizontalAlignment(SwingConstants.CENTER);
		jlFindUser.setFont(UIConstants.JLABEL_FONT);

		jtUsername = new JTextField();
		jtUsername.setFont(UIConstants.FONT_18);
		jtUsername.setBounds(193, 23, 219, 36);
		jtUsername.setColumns(10);

		jbConfirm = new HMSBlueButton("搜索");
		jbConfirm.setFont(UIConstants.FONT_17);
		jbConfirm.setBounds(483, 25, 85, 35);
		jbConfirm.setFont(UIConstants.FONT_18);
		jbConfirm.addMouseListener(new ConfirmMouseListener(this));

		jlChargeValue = new JLabel("充值额度");
		jlChargeValue.setBounds(14, 248, 114, 32);
		jlChargeValue.setHorizontalAlignment(SwingConstants.CENTER);
		jlChargeValue.setFont(new Font("宋体", Font.PLAIN, 21));

		jtChargeValue = new JTextField();
		jtChargeValue.setFont(UIConstants.FONT_17);
		jtChargeValue.setBounds(193, 249, 219, 36);
		jtChargeValue.setColumns(10);

		jbChargeValue = new HMSBlueButton("充值");
		jbChargeValue.setBounds(483, 249, 90, 40);
		jbChargeValue.setFont(UIConstants.FONT_20);
		jbChargeValue.addMouseListener(new ChargeMouseListener(this, jtChargeValue));

		jTable = new JTable();
		model = new CreditChargeModel();
		jTable.setModel(model);
		jTable.setBackground(UIConstants.JFRAME);
		jTable.setFont(UIConstants.FONT_18);
		jTable.setRowHeight(40);
		jTable.setShowVerticalLines(false);
		jTable.setShowHorizontalLines(true);

		// 设置表头
		jTableHeader = jTable.getTableHeader();
		jTableHeader.setPreferredSize(new Dimension(jTableHeader.getWidth(), 35));
		jTableHeader.setBackground(UIConstants.JTABLEHEADER_COLOR);
		jTableHeader.setEnabled(false);
		jTableHeader.setBorder(new EmptyBorder(0, 0, 0, 0));
		jTableHeader.setFont(UIConstants.FONT_18);

		scrollPane = new JScrollPane();
		scrollPane.setViewportView(jTable);
		scrollPane.setBounds(3, 85, 1000, 100);
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.getViewport().setBackground(UIConstants.JFRAME);
		setLayout(null);
		scrollPane.setOpaque(true);
		add(scrollPane);
		add(scrollPane);
		add(jlChargeValue);
		add(jlFindUser);
		add(jtUsername);
		add(jtChargeValue);
		add(jbConfirm);
		add(jbChargeValue);
	}

	public UserVO getUserVOAndShow() throws UserNotFoundException {
		userVO = null;
		if (jtUsername.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "请输入用户名！", "Enter The Username", JOptionPane.ERROR_MESSAGE);
		} else {
			username = jtUsername.getText();
			try {
				userVO = webCreditController.findUserByUsername(username);
			} catch (UserNotFoundException e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "用户名不存在", "No Such Username", JOptionPane.ERROR_MESSAGE);
				jtUsername.setText("");
			}
			creditChargeModel = new CreditChargeModel(userVO);
			jTable.setModel(creditChargeModel);
			// jbChargeValue.setEnabled(true);
		}
		return userVO;
	}

	public void charge(int value) {
		int result = JOptionPane.showConfirmDialog(null, "是否确定充值？", "提示", JOptionPane.YES_NO_OPTION,
				JOptionPane.INFORMATION_MESSAGE);
		if (result == 0) {
			value = Integer.parseInt(jtChargeValue.getText());
			webCreditController.charge(userVO, value);
			try {
				userVO = webCreditController.findUserByUsername(username);
			} catch (UserNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			creditChargeModel = new CreditChargeModel(userVO);
			jTable.setModel(creditChargeModel);
			JOptionPane.showMessageDialog(null,"信用充值成功！");
			jtChargeValue.setText("");
		}

	}

	public String getUsername() {
		return jtUsername.getText();
	}
	// public static void main(String[] args) {
	// JFrame frame = new JFrame();
	// frame.setSize(1000, 700);
	// CreditChargePanel p = new CreditChargePanel();
	// frame.add(p);
	// frame.setVisible(true);
	// }
}
