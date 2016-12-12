package hrs.client.UI.UserUI.OrderInfoUI.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hrs.client.UI.UserUI.OrderInfoUI.OrderShowPanel;

public class revokeListener implements ActionListener {
	private OrderShowPanel panel;
	public revokeListener(OrderShowPanel panel){
		this.panel = panel;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		panel.revoke();

	}

}
