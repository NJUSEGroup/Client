package hrs.client.UI.WebStaffUI.WebUserUI.WebUserListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import hrs.client.UI.WebStaffUI.WebUserUI.WebUserUIPanel;

public class SearchUserConfirmMouseListener implements MouseListener {
	private WebUserUIPanel webUserUIPanel;

	public SearchUserConfirmMouseListener(WebUserUIPanel webUserUIPanel) {
		// TODO Auto-generated constructor stub
		this.webUserUIPanel = webUserUIPanel;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		webUserUIPanel.showUserinfo();
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
