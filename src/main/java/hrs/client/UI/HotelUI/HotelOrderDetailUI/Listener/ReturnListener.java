package hrs.client.UI.HotelUI.HotelOrderDetailUI.Listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import hrs.client.UI.HotelUI.HotelOrderUI.HotelOrderMainPanel;

public class ReturnListener implements MouseListener{

	private HotelOrderMainPanel jpMain;
	
	public ReturnListener(HotelOrderMainPanel jpMain){
		this.jpMain = jpMain;
	}
	
	/**
	 * 从酒店详细订单界面返回酒店订单管理界面
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		jpMain.showList();
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
