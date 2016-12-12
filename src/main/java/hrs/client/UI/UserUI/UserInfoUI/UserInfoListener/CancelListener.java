package hrs.client.UI.UserUI.UserInfoUI.UserInfoListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import hrs.client.UI.UserUI.UserInfoUI.UserInfoLabel;
import hrs.client.UI.UserUI.UserInfoUI.UserInfoPanel;

public class CancelListener implements ActionListener {
	private UserInfoPanel panel;
	public CancelListener(UserInfoPanel panel) {
		this.panel = panel;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		panel.refresh();
		
	}

}
