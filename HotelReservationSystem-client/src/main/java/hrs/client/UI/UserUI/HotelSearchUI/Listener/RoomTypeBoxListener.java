package hrs.client.UI.UserUI.HotelSearchUI.Listener;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import hrs.client.UI.UserUI.HotelSearchUI.PlaceOrderPanel;

public class RoomTypeBoxListener implements ItemListener {
	private PlaceOrderPanel panel;
	public RoomTypeBoxListener(PlaceOrderPanel panel){
		this.panel = panel;
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED)
			panel.changeRoomType();

	}

}
