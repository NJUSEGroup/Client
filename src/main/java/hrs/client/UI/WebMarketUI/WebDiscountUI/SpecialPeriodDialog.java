package hrs.client.UI.WebMarketUI.WebDiscountUI;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hrs.client.UI.WebMarketUI.WebDiscountUI.WebDiscountListener.CancelModifySpecialPeriodDiscountListener;
import hrs.client.UI.WebMarketUI.WebDiscountUI.WebDiscountListener.ConfirmModifySpecialPeriodListener;
import hrs.client.util.DateChoosePanel;
import hrs.client.util.DoubleFormat;
import hrs.client.util.HMSBlueButton;
import hrs.client.util.UIConstants;
import hrs.common.VO.WebDiscountVO;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.util.Date;

public class SpecialPeriodDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7392840371079479208L;
	private final JPanel contentPanel = new JPanel();
	private DateChoosePanel jtextBeginTime;
	private DateChoosePanel jtextEndTime;
	private JTextField jtextDiscount;
	private HMSBlueButton jbConfirmModify, jbCancalModify;
	private JLabel jlBeginTime;
	private JLabel jlDiscount;
	private JLabel jlEndTime;
	private WebDiscountPanel webDiscountPanel;
	private WebDiscountVO webDiscountVO;
	private ConfirmModifySpecialPeriodListener listener;
	private CancelModifySpecialPeriodDiscountListener cancelListener;

	public SpecialPeriodDialog(WebDiscountPanel webDiscountPanel) {
		this.webDiscountPanel = webDiscountPanel;
		init();
	}

	/**
	 * Create the dialog.
	 */
	public void init() {
		webDiscountVO = webDiscountPanel.getSelected();

		this.setTitle("特定期间专属折扣修改");
		this.setBounds(100, 100, 420, 310);
		this.setModal(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);

		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBackground(UIConstants.JFRAME);
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		jlBeginTime = new JLabel("开始时间");
		jlBeginTime.setBounds(56, 37, 61, 16);
		contentPanel.add(jlBeginTime);

		jlEndTime = new JLabel("结束时间");
		jlEndTime.setBounds(56, 93, 61, 16);
		contentPanel.add(jlEndTime);

		jlDiscount = new JLabel("折扣信息");
		jlDiscount.setBounds(56, 154, 61, 16);
		contentPanel.add(jlDiscount);

		jtextBeginTime = new DateChoosePanel();
		jtextBeginTime.setBounds(144, 34, 249, 26);
		contentPanel.add(jtextBeginTime);
		jtextBeginTime.setDate(webDiscountVO.beginTime);

		jtextEndTime = new DateChoosePanel();
		jtextEndTime.setBounds(144, 90, 249, 26);
		contentPanel.add(jtextEndTime);
		jtextEndTime.setDate(webDiscountVO.endTime);

		jtextDiscount = new JTextField();
		jtextDiscount.setBounds(144, 149, 249, 26);
		contentPanel.add(jtextDiscount);
		jtextDiscount.setColumns(10);
		jtextDiscount.setText(webDiscountVO.discount + "");

		jbConfirmModify = new HMSBlueButton("确认修改");
		jbConfirmModify.setFont(UIConstants.FONT_12);
		jbConfirmModify.setBounds(87, 204, 103, 29);
		listener = new ConfirmModifySpecialPeriodListener(webDiscountPanel, this);
		jbConfirmModify.addMouseListener(listener);
		contentPanel.add(jbConfirmModify);

		jbCancalModify = new HMSBlueButton("取消修改");
		jbCancalModify.setFont(UIConstants.FONT_12);
		jbCancalModify.setBounds(235, 204, 103, 29);
		contentPanel.add(jbCancalModify);
		cancelListener = new CancelModifySpecialPeriodDiscountListener(this);
		jbCancalModify.addMouseListener(cancelListener);

	}

	public WebDiscountVO getModifyVO() {
		Date newBeginTime = jtextBeginTime.getDate();
		Date newEndTime = jtextEndTime.getDate();
		double newDiscount = Double.parseDouble(DoubleFormat.format(jtextDiscount.getText()));
		webDiscountVO.beginTime = newBeginTime;
		webDiscountVO.endTime = newEndTime;
		webDiscountVO.discount = newDiscount;
		return webDiscountVO;
	}

	public double getNewDiscount() {
		return getModifyVO().discount;
	}

	public Date getBegintime() {
		return getModifyVO().beginTime;
	}

	public Date getEndtime() {
		return getModifyVO().endTime;
	}

}
