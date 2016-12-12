package hrs.client.UI.HotelUI.HotelOrderUI.Listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import hrs.client.UI.HotelUI.HotelOrderUI.HotelOrderUIPanel;
import hrs.common.VO.OrderVO;

public class SearchByOrderTypeListener implements MouseListener{

	HotelOrderUIPanel jpHotelOrder;
	
	public SearchByOrderTypeListener(HotelOrderUIPanel jpHotelOrder){
		this.jpHotelOrder = jpHotelOrder;
	}
	
	/**
	 * 根据所选择的订单类型搜索订单
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		jpHotelOrder.OrderNotSelected();
		
		String orderType = jpHotelOrder.getOrderType();
		List<OrderVO> orderList = null;
		
		orderList = jpHotelOrder.searchByOrderType(orderType);
		
		jpHotelOrder.refreshOrderList(orderList);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
