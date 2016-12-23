package hrs.client.UI.HotelUI.HotelOrderUI.Listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import hrs.client.UI.HotelUI.HotelOrderUI.HotelOrderUIPanel;

public class OrderSelectedListener implements MouseListener{
	
	private HotelOrderUIPanel jpOrderList;
	
	public OrderSelectedListener(HotelOrderUIPanel jpOrderList){
		this.jpOrderList = jpOrderList;
	}
	
	/**
	 * 当表格中的某个订单被选中时，根据该订单的状态将按钮面板的相应按钮设置为可用，并在不可用按钮上设置提示信息
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		jpOrderList.OrderSelected();
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
