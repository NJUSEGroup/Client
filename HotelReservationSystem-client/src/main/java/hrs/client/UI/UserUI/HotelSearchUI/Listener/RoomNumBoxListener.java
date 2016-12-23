package hrs.client.UI.UserUI.HotelSearchUI.Listener;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import hrs.client.UI.UserUI.HotelSearchUI.PlaceOrderPanel;

public class RoomNumBoxListener implements ItemListener {
	private PlaceOrderPanel panel;
	public RoomNumBoxListener(PlaceOrderPanel panel){
		this.panel = panel;
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED)
			panel.changeRoomNum();

	}

}
