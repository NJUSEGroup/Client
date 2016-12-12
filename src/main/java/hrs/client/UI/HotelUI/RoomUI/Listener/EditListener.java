package hrs.client.UI.HotelUI.RoomUI.Listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import hrs.client.UI.HotelUI.RoomUI.RoomUIPanel;

public class EditListener implements MouseListener{

	private RoomUIPanel jpRoom;
	
	public EditListener(RoomUIPanel jpRoom){
		this.jpRoom = jpRoom;
	}
	
	/**
	 * 点击修改按钮，弹出修改房间对话框
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		if(jpRoom.isEditEnable()){
			jpRoom.edit();
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
