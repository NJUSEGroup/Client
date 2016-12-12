package hrs.client.UI.UserUI.OrderInfoUI.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hrs.client.UI.UserUI.OrderInfoUI.OrderInfoPanel;

public class BackJBListener implements ActionListener {
	private OrderInfoPanel panel;
	public BackJBListener(OrderInfoPanel panel) {
		this.panel = panel;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		panel.back();

	}

}
