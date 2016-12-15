package hrs.client.UI.HotelUI.HotelOrderUI.Listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import hrs.client.UI.HotelUI.HotelOrderUI.HotelOrderUIPanel;
import hrs.common.VO.OrderVO;

public class CheckoutListener implements MouseListener{

	private HotelOrderUIPanel jpHotelOrder;
	
	public CheckoutListener(HotelOrderUIPanel jpHotelOrder){
		this.jpHotelOrder = jpHotelOrder;
	}
	
	/**
	 * 对未执行过退房操作的已执行订单执行退房操作
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(jpHotelOrder.isButtonEnable("退房")){
			int row = jpHotelOrder.getSelectedRow();
			OrderVO order = jpHotelOrder.getSelectedOrder(row);
			jpHotelOrder.checkout(order);
			order = jpHotelOrder.getSelectedOrder(row);
			List<OrderVO> orders = new ArrayList<OrderVO>();
			orders.add(order);
			jpHotelOrder.refreshOrderList(orders);
		}
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
