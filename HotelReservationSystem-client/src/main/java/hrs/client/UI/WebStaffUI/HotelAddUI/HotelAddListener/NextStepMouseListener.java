package hrs.client.UI.WebStaffUI.HotelAddUI.HotelAddListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import hrs.client.UI.WebStaffUI.HotelAddUI.HotelAddUIPanel;

public class NextStepMouseListener implements MouseListener {
	private HotelAddUIPanel hotelAddUIPanel;

	public NextStepMouseListener(HotelAddUIPanel hotelAddUIPanel) {
		// TODO Auto-generated constructor stub
		this.hotelAddUIPanel = hotelAddUIPanel;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		// System.out.println(hotelAddUIPanel.getHotelName());
		if (hotelAddUIPanel.getHotelName().equals("")) {
			JOptionPane.showMessageDialog(hotelAddUIPanel, "请填写酒店名称！", "Error", JOptionPane.ERROR_MESSAGE);
		}
		if (hotelAddUIPanel.getHotelName().equals("") == false) {
			hotelAddUIPanel.showHotalStaffAddUIPanel();
		}

	}// !!!!!!!!!!!

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
