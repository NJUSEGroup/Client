package hrs.client.UI.HotelUI.OfflineRecordUI.Listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import hrs.client.UI.HotelUI.OfflineRecordUI.OfflineRecordUIPanel;

public class RecordSelectedListener implements MouseListener{

	private OfflineRecordUIPanel jpRecord;
	
	public RecordSelectedListener(OfflineRecordUIPanel jpRecord){
		this.jpRecord = jpRecord;
	}
	
	/**
	 * 当表格中的某项线下记录被选中时，根据线下记录状态判断退房按钮是否可用
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		jpRecord.recordSelected();
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
