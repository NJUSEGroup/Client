package hrs.client.UI.WebMarketUI.CreditChargeUI.CreditChargeListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import hrs.client.UI.WebMarketUI.CreditChargeUI.CreditChargePanel;

public class ChargeMouseListener implements MouseListener {
	private CreditChargePanel creditChargePanel;
	private JTextField jtChargeValue;

	public ChargeMouseListener(CreditChargePanel creditChargePanel, JTextField jtChargeValue) {
		// TODO Auto-generated constructor stub
		this.jtChargeValue = jtChargeValue;
		this.creditChargePanel = creditChargePanel;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (creditChargePanel.getUsername().equals("")) {
			JOptionPane.showMessageDialog(creditChargePanel, "请先搜索用户！", "Error!", JOptionPane.ERROR_MESSAGE);
		} else {
			if (jtChargeValue.getText().equals("") || Integer.parseInt(jtChargeValue.getText()) <= 0) {
				JOptionPane.showMessageDialog(creditChargePanel, "充值大于0的整数", "Error!", JOptionPane.ERROR_MESSAGE);
			} else {
				creditChargePanel.charge(Integer.parseInt(jtChargeValue.getText()));
			}
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
