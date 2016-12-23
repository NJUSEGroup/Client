package hrs.client.UI.UserUI.HotelSearchUI.Listener;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import hrs.client.UI.UserUI.HotelSearchUI.PlaceOrderPanel;

public class OrderDocumentListener implements DocumentListener {
	private PlaceOrderPanel panel;
	public OrderDocumentListener(PlaceOrderPanel panel) {
		this.panel = panel;
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		panel.changePeopleNum();

	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		panel.changePeopleNum();

	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		panel.changePeopleNum();

	}

}
