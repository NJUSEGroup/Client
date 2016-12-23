package hrs.client.UI.WebStaffUI.HotelAddUI.HotelAddListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import hrs.client.UI.WebStaffUI.HotelAddUI.HotelStaffAddUIPanel;

public class LastStepMouseListener implements MouseListener {
	private HotelStaffAddUIPanel hotelStaffAddUIPanel;

	public LastStepMouseListener(HotelStaffAddUIPanel hotelStaffAddUIPanel) {
		// TODO Auto-generated constructor stub
		this.hotelStaffAddUIPanel = hotelStaffAddUIPanel;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		hotelStaffAddUIPanel.showHotelAddUIPanel();
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
