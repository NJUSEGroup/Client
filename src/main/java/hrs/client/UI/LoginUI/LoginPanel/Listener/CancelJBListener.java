package hrs.client.UI.LoginUI.LoginPanel.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hrs.client.UI.LoginUI.LoginPanel.LoginPanel;

public class CancelJBListener implements ActionListener {
	private LoginPanel panel;
	public CancelJBListener(LoginPanel panel){
		this.panel = panel;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		panel.cancel();

	}

}
