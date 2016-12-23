package hrs.client.UI.UserUI.HotelSearchUI.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hrs.client.UI.UserUI.HotelSearchUI.PlaceOrderPanel;

public class OrderButtonListener implements ActionListener {
	private PlaceOrderPanel panel;
	public OrderButtonListener(PlaceOrderPanel panel) {
		this.panel = panel;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		panel.order();

	}

}
