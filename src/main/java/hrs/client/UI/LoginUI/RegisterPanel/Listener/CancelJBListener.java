package hrs.client.UI.LoginUI.RegisterPanel.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hrs.client.UI.LoginUI.LoginPanel.LoginPanel;
import hrs.client.UI.LoginUI.RegisterPanel.RegisterPanel;

public class CancelJBListener implements ActionListener {
	private RegisterPanel panel;
	public CancelJBListener(RegisterPanel panel){
		this.panel = panel;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		panel.cancel();

	}

}
