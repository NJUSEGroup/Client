package hrs.client.UI.HotelUI.HotelUI.Listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import hrs.client.UI.HotelUI.HotelUI.HotelUIPanel;

public class EditListener implements MouseListener{
	
	private HotelUIPanel jpHotelInfo;
	
	public EditListener(HotelUIPanel jpHotelInfo){
		this.jpHotelInfo = jpHotelInfo;
	}
	
	/**
	 * 修改并更新酒店信息
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		jpHotelInfo.updateHotelInfo();
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
