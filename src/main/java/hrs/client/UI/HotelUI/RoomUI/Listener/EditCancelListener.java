package hrs.client.UI.HotelUI.RoomUI.Listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import hrs.client.UI.HotelUI.RoomUI.EditRoomDialog;


public class EditCancelListener implements MouseListener{

	private EditRoomDialog editRoomDialog;
	
	public EditCancelListener(EditRoomDialog editRoomDialog){
		this.editRoomDialog = editRoomDialog;
	}
	
	/**
	 * 取消修改房间信息
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		editRoomDialog.editCancel();
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
