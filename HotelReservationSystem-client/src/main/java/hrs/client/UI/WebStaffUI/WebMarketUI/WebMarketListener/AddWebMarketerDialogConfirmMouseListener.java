package hrs.client.UI.WebStaffUI.WebMarketUI.WebMarketListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import hrs.client.UI.WebStaffUI.WebMarketUI.WebMarketerUIPanel;

public class AddWebMarketerDialogConfirmMouseListener implements MouseListener {
	private WebMarketerUIPanel webMarketerUIPanel;

	public AddWebMarketerDialogConfirmMouseListener(WebMarketerUIPanel webMarketerUIPanel) {
		// TODO Auto-generated constructor stub
		this.webMarketerUIPanel = webMarketerUIPanel;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		webMarketerUIPanel.add();
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
