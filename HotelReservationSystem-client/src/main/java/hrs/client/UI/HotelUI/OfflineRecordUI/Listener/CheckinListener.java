package hrs.client.UI.HotelUI.OfflineRecordUI.Listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import hrs.client.UI.HotelUI.OfflineRecordUI.OfflineRecordUIPanel;

public class CheckinListener implements MouseListener{

	private OfflineRecordUIPanel jpRecord;
	
	public CheckinListener(OfflineRecordUIPanel jpRecord){
		this.jpRecord = jpRecord;
	}
	
	/**
	 * 点击入住按钮，弹出入住对话框
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
			jpRecord.checkin();
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
