package hrs.client.UI.UserUI.HotelSearchUI.Listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import hrs.client.UI.UserUI.HotelSearchUI.HotelSearchPanel;

public class SearchTableListener extends MouseAdapter {
	private HotelSearchPanel panel;
	public SearchTableListener(HotelSearchPanel panel) {
		this.panel = panel;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		panel.setButtonStatus();
	}
}
