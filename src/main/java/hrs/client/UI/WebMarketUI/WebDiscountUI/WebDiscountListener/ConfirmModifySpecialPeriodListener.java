package hrs.client.UI.WebMarketUI.WebDiscountUI.WebDiscountListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import hrs.client.UI.WebMarketUI.WebDiscountUI.SpecialPeriodDialog;
import hrs.client.UI.WebMarketUI.WebDiscountUI.WebDiscountPanel;

public class ConfirmModifySpecialPeriodListener implements MouseListener {
	private WebDiscountPanel WebDiscountPanel;
	private SpecialPeriodDialog specialPeriodDialog;

	public ConfirmModifySpecialPeriodListener(WebDiscountPanel webDiscountPanel,
			SpecialPeriodDialog specialPeriodDialog) {
		// TODO Auto-generated constructor stub
		this.WebDiscountPanel = webDiscountPanel;
		this.specialPeriodDialog = specialPeriodDialog;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (specialPeriodDialog.getNewDiscount() < 0 || specialPeriodDialog.getNewDiscount() >= 1) {
			JOptionPane.showMessageDialog(null, "折扣大于0，小于1！", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			WebDiscountPanel.modifyWebDiscount();
			specialPeriodDialog.dispose();
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
