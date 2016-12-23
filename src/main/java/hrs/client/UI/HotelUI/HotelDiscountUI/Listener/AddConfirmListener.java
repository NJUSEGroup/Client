package hrs.client.UI.HotelUI.HotelDiscountUI.Listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import hrs.client.UI.HotelUI.HotelDiscountUI.AddDiscountDialog;

public class AddConfirmListener implements MouseListener{

	private AddDiscountDialog addDialog;
	
	public AddConfirmListener(AddDiscountDialog addDialog){
		this.addDialog = addDialog;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		addDialog.add();
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
