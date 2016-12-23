package hrs.client.UI.HotelUI.OfflineRecordUI.Listener;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import hrs.client.UI.HotelUI.OfflineRecordUI.CheckinDialog;

public class CheckRoomNumListener implements ItemListener{

	private CheckinDialog checkinDialog;
	
	public CheckRoomNumListener(CheckinDialog checkinDialog){
		this.checkinDialog = checkinDialog;
	}
	
	/**
	 * 查找此时所选择的房间类型的可用房间数量
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getStateChange() == ItemEvent.SELECTED){
			checkinDialog.checkRoomNum();
		}
	}

}
