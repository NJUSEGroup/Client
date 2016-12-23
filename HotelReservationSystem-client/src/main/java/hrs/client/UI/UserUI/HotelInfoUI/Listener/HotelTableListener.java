package hrs.client.UI.UserUI.HotelInfoUI.Listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import hrs.client.UI.UserUI.HotelInfoUI.HotelTablePanel;

public class HotelTableListener extends MouseAdapter {
	private HotelTablePanel panel;
	
	public HotelTableListener(HotelTablePanel panel) {
		this.panel = panel;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		panel.setButtonStatus();
	}
	

}
