package hrs.client.UI.HotelUI.OfflineRecordUI.Listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import hrs.client.UI.HotelUI.OfflineRecordUI.OfflineRecordUIPanel;

public class CheckoutListener implements MouseListener{

	private OfflineRecordUIPanel jpRecord;
	
	public CheckoutListener(OfflineRecordUIPanel jpRecord){
		this.jpRecord = jpRecord;
	}
	
	/**
	 * 执行退房操作
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(jpRecord.isCheckoutEnable()){
			jpRecord.checkout(jpRecord.getSelectedRecord());
			jpRecord.refresh(jpRecord.getAllRecords());
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
