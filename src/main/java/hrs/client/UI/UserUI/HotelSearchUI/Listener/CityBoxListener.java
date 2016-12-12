package hrs.client.UI.UserUI.HotelSearchUI.Listener;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import hrs.client.UI.UserUI.HotelSearchUI.SearchPanel;

public class CityBoxListener implements ItemListener {
	private SearchPanel panel;

	public CityBoxListener(SearchPanel panel) {
		this.panel = panel;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED)
			panel.changeCity();

	}

}
