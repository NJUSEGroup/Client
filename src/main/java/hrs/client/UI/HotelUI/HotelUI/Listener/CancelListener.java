package hrs.client.UI.HotelUI.HotelUI.Listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import hrs.client.UI.HotelUI.HotelUI.HotelUIPanel;

public class CancelListener implements MouseListener{
	
	HotelUIPanel jpHotelInfo;
	
	public CancelListener(HotelUIPanel jpHotelInfo){
		this.jpHotelInfo = jpHotelInfo;
	}
	
	/**
	 * 取消修改酒店信息，将酒店信息恢复为修改前的信息
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		jpHotelInfo.showHotelInfo();
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
