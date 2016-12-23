package hrs.client.UI.LoginUI.LoginPanel.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hrs.client.UI.LoginUI.LoginPanel.LoginPanel;

public class LoginJBListener implements ActionListener {
	private LoginPanel panel;
	public LoginJBListener(LoginPanel panel){
		this.panel = panel;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		panel.login();

	}

}
