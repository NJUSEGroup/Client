package hrs.client.UI.UserUI.HotelSearchUI.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import hrs.client.UI.UserUI.HotelSearchUI.HotelSearchPanel;
import hrs.client.UI.UserUI.HotelSearchUI.SearchPanel;

public class SearchListener implements ActionListener {
	private HotelSearchPanel panel;
	public SearchListener(HotelSearchPanel panel){
		this.panel = panel;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		panel.doSearch();

	}

}
