package hrs.client.UI.UserUI.HotelInfoUI.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hrs.client.UI.UserUI.HotelInfoUI.HotelTablePanel;
import hrs.client.UI.UserUI.HotelSearchUI.HotelDetailPanel;

public class DetailInfoListener implements ActionListener {
	private HotelTablePanel panel;
	public DetailInfoListener(HotelTablePanel panel) {
		this.panel = panel;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		panel.showDetail();

	}

}
