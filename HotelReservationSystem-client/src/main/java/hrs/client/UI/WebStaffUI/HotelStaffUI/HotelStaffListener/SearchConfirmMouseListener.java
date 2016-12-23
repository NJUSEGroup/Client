package hrs.client.UI.WebStaffUI.HotelStaffUI.HotelStaffListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import hrs.client.UI.WebStaffUI.HotelStaffUI.HotelStaffUIPanel;

public class SearchConfirmMouseListener implements MouseListener {
	private HotelStaffUIPanel HotelStaffUIPanel;

	public SearchConfirmMouseListener(HotelStaffUIPanel hotelStaffUIPanel) {
		// TODO Auto-generated constructor stub
		this.HotelStaffUIPanel = hotelStaffUIPanel;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		// HotelStaffUIPanel.search();
		HotelStaffUIPanel.selectHotelAndShow();

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
