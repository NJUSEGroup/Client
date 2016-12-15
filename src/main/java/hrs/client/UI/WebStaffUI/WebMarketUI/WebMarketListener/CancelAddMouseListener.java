package hrs.client.UI.WebStaffUI.WebMarketUI.WebMarketListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import hrs.client.UI.WebStaffUI.WebMarketUI.AddWebMarketerDialog;

public class CancelAddMouseListener implements MouseListener {
	private AddWebMarketerDialog addWebMarketerDialog;

	public CancelAddMouseListener(AddWebMarketerDialog addWebMarketerDialog) {
		// TODO Auto-generated constructor stub
		this.addWebMarketerDialog = addWebMarketerDialog;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		addWebMarketerDialog.dispose();
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
