package hrs.client.UI.UserUI.HotelSearchUI.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hrs.client.UI.UserUI.HotelSearchUI.HotelSearchPanel;

public class DetailListener implements ActionListener {
	private HotelSearchPanel panel;
	public DetailListener(HotelSearchPanel panel) {
		this.panel = panel;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		panel.showDetail();

	}

}
