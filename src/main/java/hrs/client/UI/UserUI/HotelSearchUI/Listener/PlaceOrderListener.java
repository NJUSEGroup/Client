package hrs.client.UI.UserUI.HotelSearchUI.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hrs.client.UI.UserUI.HotelSearchUI.HotelDetailPanel;

public class PlaceOrderListener implements ActionListener {
	private HotelDetailPanel panel;
	public PlaceOrderListener(HotelDetailPanel panel){
		this.panel = panel;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		panel.placeOrder();

	}

}
