package hrs.client.UI.UserUI.OrderInfoUI.Listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import hrs.client.UI.UserUI.OrderInfoUI.OrderShowPanel;

public class TableListener extends MouseAdapter {
	private OrderShowPanel panel;
	public TableListener(OrderShowPanel panel) {
		this.panel = panel;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		panel.setButtonStatus();
	}
	
}
