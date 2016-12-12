package hrs.client.UI.HotelUI.HotelOrderUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;

import hrs.client.UI.HotelUI.Components.OrderListTableModel;
import hrs.client.UI.HotelUI.HotelOrderUI.Listener.CheckinListener;
import hrs.client.UI.HotelUI.HotelOrderUI.Listener.CheckoutListener;
import hrs.client.UI.HotelUI.HotelOrderUI.Listener.DelayCheckinListener;
import hrs.client.UI.HotelUI.HotelOrderUI.Listener.DetailListener;
import hrs.client.UI.HotelUI.HotelOrderUI.Listener.OrderSelectedListener;
import hrs.client.UI.HotelUI.HotelOrderUI.Listener.SearchByIdOrUsernameListener;
import hrs.client.UI.HotelUI.HotelOrderUI.Listener.SearchByOrderTypeListener;
import hrs.client.util.ControllerFactory;
import hrs.client.util.HMSBlueButton;
import hrs.client.util.UIConstants;
import hrs.common.Controller.HotelController.IHotelOrderController;
import hrs.common.Exception.OrderService.OrderNotFoundException;
import hrs.common.VO.HotelVO;
import hrs.common.VO.OrderVO;
import hrs.common.util.type.OrderStatus;

public class HotelOrderUIPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -978383534264507721L;
	private JPanel jpSearch;
	private JPanel jpOrder;
	private JPanel jpButton;
	private JScrollPane jspOrderList;
	private JLabel jlOrderType;
	private JLabel jlSearch;
	private JComboBox<String> jcbOrderType;
	private JComboBox<String> jcbSearch;
	private JTextField jtfSearch;
	private HMSBlueButton jbConfirm1;
	private HMSBlueButton jbConfirm2;
	private HMSBlueButton jbDetail;
	private HMSBlueButton jbCheckin;
	private HMSBlueButton jbCheckout;
	private HMSBlueButton jbDelay;
	private JTable jtOrderList;
	private JTableHeader jthOrderList;
	private OrderListTableModel orderListTableModel;
	private IHotelOrderController hotelOrderController;
	private SearchByOrderTypeListener searchListener1;
	private SearchByIdOrUsernameListener searchListener2;
	private OrderSelectedListener orderSelectedListener;
	private DetailListener detailListener;
	private CheckinListener checkinListener;
	private CheckoutListener checkoutListener;
	private DelayCheckinListener delayListener;
	private HotelVO hotel;
	private Font orderFont;
	private Font tableFont;
	private Color panelColor;
	private Color tableHeadColor;
	
	/**
	 * 初始化酒店订单管理界面面板
	 * @param jpMain
	 * @param hotel
	 */
	public HotelOrderUIPanel(HotelOrderMainPanel jpMain, HotelVO hotel){
		init(jpMain, hotel);
	}
	
	public void init(HotelOrderMainPanel jpMain, HotelVO hotel){
		this.hotel = hotel;
		this.setSize(1080, 722);
		this.setLayout(null);
		
		detailListener = new DetailListener(jpMain, this);
		hotelOrderController = ControllerFactory.getHotelOrderController();
		
		this.setFontAndColor();
		this.setPanel();
		this.setSearchPanel();
		this.setOrderPanel();
		this.setButtonPanel();
	}
	
	public void setFontAndColor(){
		orderFont = UIConstants.FONT_19;
		tableFont = UIConstants.FONT_16;
		panelColor = UIConstants.JFRAME;
		tableHeadColor = UIConstants.JTABLEHEADER_COLOR;
	}
	
	/**
	 * 设置面板
	 */
	public void setPanel(){
		jpSearch = new JPanel();
		jpSearch.setBounds(0, 0, 1080, 170);
		jpSearch.setBackground(panelColor);
		jpSearch.setLayout(null);
		
		jpOrder = new JPanel();
		jpOrder.setBounds(0, 170, 1080, 472);
		jpOrder.setBackground(panelColor);
		jpOrder.setLayout(null);
		
		jpButton = new JPanel();
		jpButton.setBounds(0, 642, 1080, 80);
		jpButton.setBackground(panelColor);
		jpButton.setLayout(null);
		
		this.add(jpSearch);
		this.add(jpOrder);
		this.add(jpButton);
	}
	
	/**
	 * 设置搜索面板
	 */
	public void setSearchPanel(){
		jlOrderType = new JLabel();
		jlOrderType.setBounds(20, 20, 90, 30);
		jlOrderType.setText("订单类型");
		jlOrderType.setHorizontalAlignment(SwingConstants.CENTER);
		jlOrderType.setFont(orderFont);
		
		jlSearch = new JLabel();
		jlSearch.setBounds(20, 100, 90, 30);
		jlSearch.setText("搜索");
		jlSearch.setHorizontalAlignment(SwingConstants.CENTER);
		jlSearch.setFont(orderFont);
		
		jcbOrderType = new JComboBox<String>(new DefaultComboBoxModel<String>(new String[] {"未执行", "已执行", "异常", "已撤销"}));
		jcbOrderType.setBounds(130, 20, 230, 30);
		jcbOrderType.setFont(orderFont);
		jcbOrderType.setOpaque(true);
		jcbOrderType.setBackground(Color.WHITE);
		jcbOrderType.setEditable(false);
		
		jcbSearch = new JComboBox<String>(new DefaultComboBoxModel<String>(new String[] {"用户名", "订单号"}));
		jcbSearch.setBounds(130, 100, 230, 30);
		jcbSearch.setFont(orderFont);
		jcbSearch.setOpaque(true);
		jcbSearch.setBackground(Color.WHITE);
		jcbSearch.setEditable(false);
		
		jtfSearch = new JTextField();
		jtfSearch.setBounds(400, 100, 230, 30);
		jtfSearch.setFont(orderFont);
		jtfSearch.setEditable(true);
		
		searchListener1 = new SearchByOrderTypeListener(this);
		searchListener2 = new SearchByIdOrUsernameListener(this);
		
		jbConfirm1 = new HMSBlueButton("确认");
		jbConfirm1.setBounds(681, 15, 90, 40);
		jbConfirm1.addMouseListener(searchListener1);
		
		jbConfirm2 = new HMSBlueButton("确认");
		jbConfirm2.setBounds(681, 95, 90, 40);
		jbConfirm2.addMouseListener(searchListener2);
		
		jpSearch.add(jlOrderType);
		jpSearch.add(jlSearch);
		jpSearch.add(jcbOrderType);
		jpSearch.add(jcbSearch);
		jpSearch.add(jtfSearch);
		jpSearch.add(jbConfirm1);
		jpSearch.add(jbConfirm2);
	}
	
	/**
	 * 设置订单面板
	 */
	public void setOrderPanel(){
		orderSelectedListener = new OrderSelectedListener(this);
		
		List<OrderVO> orderList = new ArrayList<OrderVO>();
		orderList = this.getAllOrders();
		
		orderListTableModel = new OrderListTableModel(orderList);
		
		jtOrderList = new JTable(orderListTableModel);
		jtOrderList.setBackground(Color.WHITE);
		jtOrderList.setFont(tableFont);
		jtOrderList.setRowHeight(40);
		jtOrderList.setShowVerticalLines(false);
		jtOrderList.addMouseListener(orderSelectedListener);
		
		jthOrderList = jtOrderList.getTableHeader(); 
		jthOrderList.setPreferredSize(new Dimension(jtOrderList.getWidth(),40)); 
		jthOrderList.setBackground(tableHeadColor);
		jthOrderList.setEnabled(false);
		jthOrderList.setBorder(new EmptyBorder(0,0,0,0));
		jthOrderList.setFont(tableFont);
		
		jspOrderList = new JScrollPane(jtOrderList);
		jspOrderList.setBounds(10, 10, 1060, 452);
		jspOrderList.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jspOrderList.getViewport().setOpaque(false);
		jspOrderList.setBackground(panelColor);
		
		jpOrder.add(jspOrderList);
	}
	
	/**
	 * 设置按钮面板
	 */
	public void setButtonPanel(){
		jbDetail = new HMSBlueButton("查看详细");
		jbDetail.setBounds(410, 13, 110, 40);
		jbDetail.addMouseListener(detailListener);
		jbDetail.setEnabled(false);
		
		checkinListener = new CheckinListener(this);
		
		jbCheckin = new HMSBlueButton("入住");
		jbCheckin.setBounds(550, 13, 110, 40);
		jbCheckin.setEnabled(false);
		jbCheckin.addMouseListener(checkinListener);
		
		checkoutListener = new CheckoutListener(this);
		
		jbCheckout = new HMSBlueButton("退房");
		jbCheckout.setBounds(690, 13, 110, 40);
		jbCheckout.setEnabled(false);
		jbCheckout.addMouseListener(checkoutListener);
		
		delayListener = new DelayCheckinListener(this);
		
		jbDelay = new HMSBlueButton("延迟入住");
		jbDelay.setBounds(830, 13, 110, 40);
		jbDelay.setEnabled(false);
		jbDelay.addMouseListener(delayListener);
		
		jpButton.add(jbDetail);
		jpButton.add(jbCheckin);
		jpButton.add(jbCheckout);
		jpButton.add(jbDelay);
	}
	
	/**
	 * 获取该酒店的所有订单
	 * @return
	 */
	public List<OrderVO> getAllOrders(){
		List<OrderVO> orderList = new ArrayList<OrderVO>();
		
		try {
			orderList = hotelOrderController.findOrderByHotelID(hotel.id);
		} catch (OrderNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "您的酒店尚无订单！", "提示", JOptionPane.INFORMATION_MESSAGE);
		}
		
		return orderList;
	}
	
	/**
	 * 刷新订单列表
	 * @param orderList
	 */
	public void refreshOrderList(List<OrderVO> orderList){
		orderListTableModel = new OrderListTableModel(orderList);
		jtOrderList.setModel(orderListTableModel);
	}
	
	/**
	 * 刷新搜索条件面板
	 */
	public void refreshSearchTerms(){
		jcbOrderType.setSelectedIndex(0);
		jcbSearch.setSelectedIndex(0);
		jtfSearch.setText("");
	}
	
	/**
	 * 获取当前选择的订单类型
	 * @return
	 */
	public String getOrderType(){
		return (String) jcbOrderType.getSelectedItem();
	}
	
	/**
	 * 获取当前选择的搜索条件（用户名或订单号）
	 * @return
	 */
	public String getSearchInfo(){
		return (String) jcbSearch.getSelectedItem();
	}
	
	/**
	 * 获取输入的用户名
	 * @return
	 */
	public String getUsername(){
		return jtfSearch.getText();
	}
	
	/**
	 * 获取输入的订单号
	 * @return
	 */
	public String getOrderID(){
		return jtfSearch.getText();
	}
	
	/**
	 * 获取在表格中被选中的行数
	 * @return
	 */
	public int getSelectedRow(){
		return jtOrderList.getSelectedRow();
	}
	
	/**
	 * 获取在表格中被选中的订单
	 * @return
	 */
	public OrderVO getSelectedOrder(int row){
		int id = Integer.valueOf((String) jtOrderList.getValueAt(row, 0));
		List<OrderVO> orderList = this.searchByOrderID(id);
		OrderVO order = orderList.get(0);
		
		return order;
	}
	
	/**
	 * 通过订单类型搜索订单
	 * @param orderType
	 * @return
	 */
	public List<OrderVO> searchByOrderType(String orderType){
		List<OrderVO> orderList = new ArrayList<OrderVO>();
		List<OrderVO> orderList1 = new ArrayList<OrderVO>();
		List<OrderVO> orderList2 = new ArrayList<OrderVO>();
		
		if(orderType.equals("未执行")){
			try {
				orderList = hotelOrderController.findOrderByHotelAndStatus(hotel.id, OrderStatus.Unexecuted);
			} catch (OrderNotFoundException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(this, "您的酒店尚无未执行订单！", "提示", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else if(orderType.equals("已执行")){
			try {
				orderList = hotelOrderController.findOrderByHotelAndStatus(hotel.id, OrderStatus.Executed);
			} catch (OrderNotFoundException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(this, "您的酒店尚无已执行订单！", "提示", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else if(orderType.equals("异常")){
			try {
				orderList = hotelOrderController.findOrderByHotelAndStatus(hotel.id, OrderStatus.Abnormal);
			} catch (OrderNotFoundException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(this, "您的酒店尚无异常订单！", "提示", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else if(orderType.equals("已撤销")){
			try {
				orderList = hotelOrderController.findOrderByHotelAndStatus(hotel.id, OrderStatus.RevokedFullValue);
				orderList1 = hotelOrderController.findOrderByHotelAndStatus(hotel.id, OrderStatus.RevokedHalfValue);
				orderList2 = hotelOrderController.findOrderByHotelAndStatus(hotel.id, OrderStatus.UserRevoked);
			} catch (OrderNotFoundException e) {
				// TODO Auto-generated catch block
			}
			
			orderList.addAll(orderList1);
			orderList.addAll(orderList2);
			
			if(orderList.size()==0){
				JOptionPane.showMessageDialog(this, "您的酒店尚无已撤销订单！", "提示", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
		return orderList;
	}
	
	/**
	 * 通过用户名搜索订单
	 * @param username
	 * @return
	 */
	public List<OrderVO> searchByUsername(String username){
		List<OrderVO> orderList = new ArrayList<OrderVO>();
		
		try {
			orderList = hotelOrderController.findOrderByHotelAndUsername(hotel.id, username);
		} catch (OrderNotFoundException e) {
			 //TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "该用户不存在！", "错误", JOptionPane.WARNING_MESSAGE);
		}
		
		return orderList;
	}
	
	/**
	 * 通过订单id搜索订单
	 * @param id
	 * @return
	 */
	public List<OrderVO> searchByOrderID(int id){
		List<OrderVO> orderList = new ArrayList<OrderVO>();
		OrderVO order;
		
		try {
			order =  hotelOrderController.findOrderByID(id);
			orderList.add(order);
		} catch (OrderNotFoundException e) {
			 //TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "该订单不存在！", "错误", JOptionPane.WARNING_MESSAGE);
		}
		
		return orderList;
	}
	
	/**
	 * 当表格中的某个订单被选中时，根据该订单的状态将按钮面板的相应按钮设置为可用，并在不可用按钮上设置提示信息
	 */
	public void OrderSelected(){
		int row = getSelectedRow();
		OrderVO order = null;
		if(row != -1){
			order = this.getSelectedOrder(row);
			jbDetail.setEnabled(true);
			if(order.status==OrderStatus.Unexecuted){
				jbCheckin.setEnabled(true);
				jbCheckout.setEnabled(false);
				jbCheckout.setToolTipText("您只能对未进行过退房操作的已执行订单进行退房操作");
				jbDelay.setEnabled(false);
				jbDelay.setToolTipText("您只能对异常订单进行延迟入住操作");
			}
			else if(order.status==OrderStatus.Executed){
				jbCheckin.setEnabled(false);
				jbCheckin.setBackground(Color.lightGray);
				jbCheckin.setToolTipText("您只能对未执行订单进行入住操作");
				jbDelay.setEnabled(false);
				jbDelay.setToolTipText("您只能对异常订单进行延迟入住操作");
				
				String checkoutTime = "";
				try {
					checkoutTime = order.checkoutTime.toString();
				} catch (NullPointerException e) {
					// TODO Auto-generated catch block
					checkoutTime = "";
				}
				if(checkoutTime.equals("")){
					jbCheckout.setEnabled(true);
				}
				else{
					jbCheckout.setEnabled(false);
					jbCheckout.setToolTipText("您只能对未进行过退房操作的已执行订单进行退房操作");
				}
			}
			else if(order.status==OrderStatus.Abnormal){
				jbCheckin.setEnabled(false);
				jbCheckin.setToolTipText("您只能对未执行订单进行入住操作");
				jbCheckout.setEnabled(false);
				jbCheckout.setToolTipText("您只能对未进行过退房操作的已执行订单进行退房操作");
				jbDelay.setEnabled(true);
			}
			else if((order.status==OrderStatus.RevokedFullValue)||(order.status==OrderStatus.RevokedHalfValue)
					||(order.status==OrderStatus.UserRevoked)){
				jbCheckin.setEnabled(false);
				jbCheckin.setToolTipText("您只能对未执行订单进行入住操作");
				jbCheckout.setEnabled(false);
				jbCheckout.setToolTipText("您只能对未进行过退房操作的已执行订单进行退房操作");
				jbDelay.setEnabled(false);
				jbDelay.setToolTipText("您只能对异常订单进行延迟入住操作");
			}
		}
	}
	
	/**
	 * 当表格中没有订单被选中时，按钮面板的四个按钮皆不可用
	 */
	public void OrderNotSelected(){
		jbDetail.setEnabled(false);
		jbCheckin.setEnabled(false);
		jbCheckout.setEnabled(false);
		jbDelay.setEnabled(false);
	}
	
	/**
	 * 对未执行订单进行入住操作
	 * @param order
	 */
	public void checkin(OrderVO order){
		hotelOrderController.checkin(order);
		JOptionPane.showMessageDialog(null, "订单信息已更新！", "更新成功", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * 对未执行过退房操作的已执行订单进行退房操作
	 * @param order
	 */
	public void checkout(OrderVO order){
		hotelOrderController.checkout(order);
		JOptionPane.showMessageDialog(null, "订单信息已更新！", "更新成功", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * 对异常订单进行延迟入住操作
	 * @param order
	 */
	public void delayCheckin(OrderVO order){
		hotelOrderController.delayCheckin(order);
		JOptionPane.showMessageDialog(null, "订单信息已更新！", "更新成功", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * 获得相应按钮的可用状态
	 */
	public boolean isButtonEnable(String buttonName){
		if(buttonName.equals("入住")){
			return jbCheckin.isEnabled();
		}
		else if(buttonName.equals("退房")){
			return jbCheckout.isEnabled();
		}
		else{
			return jbDelay.isEnabled();
		}
	}
}