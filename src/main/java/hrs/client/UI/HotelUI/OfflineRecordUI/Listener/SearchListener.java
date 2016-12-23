package hrs.client.UI.HotelUI.OfflineRecordUI.Listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import hrs.client.UI.HotelUI.OfflineRecordUI.OfflineRecordUIPanel;
import hrs.client.util.RegExpHelper;
import hrs.common.VO.OfflineRecordVO;

public class SearchListener implements MouseListener{

	private OfflineRecordUIPanel jpRecord;
	
	public SearchListener(OfflineRecordUIPanel jpRecord){
		this.jpRecord = jpRecord;
	}
	
	/**
	 * 通过线下入住记录编号查询相应的线下入住记录
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		jpRecord.recordNotSelected();
		
		String sid = jpRecord.getID();
		int id = 0;
		if(!RegExpHelper.matchOnlyNum(sid)){
			JOptionPane.showMessageDialog(null, "编号中不能包含非数字字符！", "错误", JOptionPane.ERROR_MESSAGE);
		}
		else{
			id = Integer.valueOf(sid);
			List<OfflineRecordVO> record = new ArrayList<OfflineRecordVO>();
			record = jpRecord.searchRecordByID(id);
			jpRecord.refresh(record);
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
