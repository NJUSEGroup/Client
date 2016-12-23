package hrs.client.UI.UserUI.OrderInfoUI.Listener;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;

import hrs.client.UI.UserUI.OrderInfoUI.OrderShowPanel;
import hrs.common.util.type.OrderStatus;

public class StatusBoxListener implements ItemListener {

	private JComboBox<String> jb;
	private OrderShowPanel panel;
	public StatusBoxListener(JComboBox<String> jb,OrderShowPanel panel) {
		this.jb = jb;
		this.panel = panel;
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange()== ItemEvent.SELECTED){
			
			if(jb.getSelectedItem() == "未执行"){
				panel.setStatus(OrderStatus.Unexecuted);
				panel.setButtonUnable();
				
			}
			
			if(jb.getSelectedItem() == "已执行"){
				panel.setStatus(OrderStatus.Executed);
				panel.setButtonUnable();
			}
			
			if(jb.getSelectedItem() == "异常"){
				panel.setStatus(OrderStatus.Abnormal);
				panel.setButtonUnable();
				
			}
			
			if(jb.getSelectedItem() == "已撤销"){
				panel.setStatus(OrderStatus.UserRevoked);
				panel.setButtonUnable();
			}
			
		}

	}

}
