package hrs.client.UI.HotelUI.HotelOrderUI.Listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import hrs.client.UI.HotelUI.HotelOrderUI.HotelOrderUIPanel;
import hrs.common.VO.OrderVO;

public class DelayCheckinListener implements MouseListener{

	private HotelOrderUIPanel jpHotelOrder;
	
	public DelayCheckinListener(HotelOrderUIPanel jpHotelOrder){
		this.jpHotelOrder = jpHotelOrder;
	}
	
	/**
	 * 对异常订单执行延迟入住操作
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(jpHotelOrder.isButtonEnable("延迟入住")){
			int row = jpHotelOrder.getSelectedRow();
			OrderVO order = jpHotelOrder.getSelectedOrder(row);
			jpHotelOrder.delayCheckin(order);
			jpHotelOrder.refreshOrderList(jpHotelOrder.getAllOrders());
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
