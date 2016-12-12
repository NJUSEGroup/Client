package hrs.client.UI.HotelUI.RoomUI.Listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import hrs.client.UI.HotelUI.RoomUI.RoomUIPanel;

public class RoomSelectedListener implements MouseListener{
	
	private RoomUIPanel jpRoom;
	
	public RoomSelectedListener(RoomUIPanel jpRoom){
		this.jpRoom = jpRoom;
	}
	
	/**
	 * 当表格中的某类房间被选中时，修改按钮可用
	 */	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		jpRoom.roomSelected();
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
