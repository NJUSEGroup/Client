package hrs.client.UI.WebMarketUI.WebOrderUI.WebOrderListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import hrs.client.UI.WebMarketUI.WebOrderUI.WebOrderPanel;

public class SearchConfirmMouseListener implements MouseListener {
	WebOrderPanel webOrderPanel;

	public SearchConfirmMouseListener(WebOrderPanel webOrderPanel) {
		// TODO Auto-generated constructor stub
		this.webOrderPanel = webOrderPanel;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		webOrderPanel.search();
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
