package hrs.client.UI.WebMarketUI.CreditChargeUI.CreditChargeListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import hrs.client.UI.WebMarketUI.CreditChargeUI.CreditChargePanel;
import hrs.common.Exception.UserService.UserNotFoundException;

public class ConfirmMouseListener implements MouseListener {
	private CreditChargePanel creditChargePanel;

	public ConfirmMouseListener(CreditChargePanel creditChargePanel) {
		// TODO Auto-generated constructor stub
		this.creditChargePanel = creditChargePanel;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		try {
			creditChargePanel.getUserVOAndShow();
		} catch (UserNotFoundException e2) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(creditChargePanel, "用户名不存在", "No Such Username", JOptionPane.ERROR_MESSAGE);
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
