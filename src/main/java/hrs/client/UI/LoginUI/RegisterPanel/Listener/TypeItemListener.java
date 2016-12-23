package hrs.client.UI.LoginUI.RegisterPanel.Listener;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import hrs.client.UI.LoginUI.RegisterPanel.RegisterPanel;

public class TypeItemListener implements ItemListener {
	private RegisterPanel panel;
	
	public TypeItemListener(RegisterPanel panel) {
		this.panel = panel;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED){
			panel.setEnterprise();
		}

	}

}
