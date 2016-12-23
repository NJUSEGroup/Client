package hrs.client.UI.HotelUI.HotelOrderUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.util.List;

import javax.swing.JPanel;

import hrs.client.UI.HotelUI.HotelOrderDetailUI.HotelOrderDetailUIPanel;
import hrs.common.VO.HotelVO;
import hrs.common.VO.OrderVO;

public class HotelOrderMainPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5549552621347857705L;
	private CardLayout card;
	private HotelOrderUIPanel jpOrderList;
	private HotelOrderDetailUIPanel jpOrderDetail;
	
	/**
	 * 初始化酒店订单管理主界面面板
	 * @param hotel
	 */
	public HotelOrderMainPanel(HotelVO hotel) {
		init(hotel);
	}
	
	public void init(HotelVO hotel){
		card = new CardLayout();
		jpOrderList = new HotelOrderUIPanel(this, hotel);
		jpOrderDetail = new HotelOrderDetailUIPanel(this);
		
		this.setLayout(card);
		this.setSize(1080, 722);
		this.setBackground(new Color(211, 237, 249));
		
		this.add(jpOrderList, "jpOrderList");
		this.add(jpOrderDetail, "jpOrderDetail");
		
	}
	
	/**
	 * 显示酒店订单管理界面
	 */
	public void showList(){
		card.show(this, "jpOrderList");
	}
	
	/**
	 * 刷新酒店订单管理界面
	 */
	public void refresh(){
		this.showList();
		jpOrderList.refreshSearchTerms();
		List<OrderVO> orderList = jpOrderList.getAllOrders();
		jpOrderList.refreshOrderList(orderList);
		jpOrderList.OrderNotSelected();
	}
	
	/**
	 * 显示酒店订单详细界面
	 * @param order
	 */
	public void showDetail(OrderVO order){
		card.show(this, "jpOrderDetail");
		jpOrderDetail.showDetailInfo(order);
	}
	
	

}
