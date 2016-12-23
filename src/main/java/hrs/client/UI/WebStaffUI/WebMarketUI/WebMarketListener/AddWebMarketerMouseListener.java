package hrs.client.UI.WebStaffUI.WebMarketUI.WebMarketListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import hrs.client.UI.WebStaffUI.WebMarketUI.WebMarketerUIPanel;

public class AddWebMarketerMouseListener implements MouseListener {
	private WebMarketerUIPanel WebMarketerUIPanel;

	public AddWebMarketerMouseListener(WebMarketerUIPanel webMarketerUIPanel) {
		// TODO Auto-generated constructor stub
		this.WebMarketerUIPanel = webMarketerUIPanel;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		WebMarketerUIPanel.showDialog();
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
