package hrs.client.UI.HotelUI.RoomUI.Listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import hrs.client.UI.HotelUI.RoomUI.AddRoomDialog;


public class AddCancelListener implements MouseListener{

	private AddRoomDialog addRoomDialog;
	
	public AddCancelListener(AddRoomDialog addRoomDialog){
		this.addRoomDialog = addRoomDialog;
	}
	
	/**
	 * 取消添加房间
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		addRoomDialog.addCancel();
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
