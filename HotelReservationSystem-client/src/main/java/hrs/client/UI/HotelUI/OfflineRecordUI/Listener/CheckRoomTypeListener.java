package hrs.client.UI.HotelUI.OfflineRecordUI.Listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import hrs.client.UI.HotelUI.OfflineRecordUI.CheckinDialog;

public class CheckRoomTypeListener implements MouseListener{

	private CheckinDialog checkinDialog;
	
	public CheckRoomTypeListener(CheckinDialog checkinDialog){
		this.checkinDialog = checkinDialog;
	}
	
	/**
	 * 查找此时酒店的可用客房类型
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		checkinDialog.checkRoomType();
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
