package hrs.client.UI.WebMarketUI.UnexecutedOrderUI;

import java.awt.Dimension;
import java.util.Date;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;

import hrs.client.util.ControllerFactory;
import hrs.client.util.UIConstants;
import hrs.common.Controller.WebMarketController.IWebOrderController;
import hrs.common.Exception.OrderService.OrderNotFoundException;
import hrs.common.VO.OrderVO;
import hrs.common.util.type.OrderStatus;

public class UnexecutedOrderPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8004653106023600838L;
	private List<OrderVO> unexecutedOrders;
	private IWebOrderController controller = ControllerFactory.getWebOrderController();;
	private JLabel jlNumberOfPO;
	private UnexecutedOrderModel model;
	private JTable jTable;
	private JTableHeader jTableHeader;
	private JScrollPane scrollPane;
	private Date date;

	public UnexecutedOrderPanel() {
		init();
	}

	/**
	 * 初始化未执行订单界面
	 */
	public void init() {
		setSize(1080, 722);
		setBackground(UIConstants.JFRAME);

		date = new Date();
		try {
			unexecutedOrders = controller.findOrderByOrderStatusAndPlaceTime(OrderStatus.Unexecuted, date);
		} catch (OrderNotFoundException e) {
			JOptionPane.showMessageDialog(this, "此时未执行订单为空！", "Null", JOptionPane.INFORMATION_MESSAGE);
		}

		if (unexecutedOrders == null) {
			jlNumberOfPO = new JLabel("共 0 条记录");
		} else {
			jlNumberOfPO = new JLabel("共" + unexecutedOrders.size() + "条记录");

		}

		jlNumberOfPO.setBounds(43, 599, 100, 21);
		jlNumberOfPO.setFont(UIConstants.FONT_17);

		jTable = new JTable();
		model = new UnexecutedOrderModel(unexecutedOrders);

		jTable.setModel(model);
		jTable.setBackground(UIConstants.JFRAME);
		jTable.setFont(UIConstants.FONT_18);
		jTable.setRowHeight(40);
		jTable.setShowVerticalLines(false);
		jTable.setShowHorizontalLines(true);

		// 设置表头
		jTableHeader = jTable.getTableHeader();
		jTableHeader.setPreferredSize(new Dimension(jTableHeader.getWidth(), 30));
		jTableHeader.setBackground(UIConstants.JTABLEHEADER_COLOR);
		jTableHeader.setEnabled(false);
		jTableHeader.setBorder(new EmptyBorder(0, 0, 0, 0));
		jTableHeader.setFont(UIConstants.FONT_18);

		scrollPane = new JScrollPane();
		scrollPane.setViewportView(jTable);
		scrollPane.setBounds(3, 20, 1050, 560);
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.getViewport().setBackground(UIConstants.JFRAME);
		setLayout(null);
		scrollPane.setOpaque(true);

		add(scrollPane);
		add(jlNumberOfPO);

	}
}
