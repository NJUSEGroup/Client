package hrs.client.UI.WebMarketUI.WebDiscountUI.WebDiscountListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import hrs.client.UI.WebMarketUI.WebDiscountUI.SpecialPeriodDialog;

public class CancelModifySpecialPeriodDiscountListener implements MouseListener {
	private SpecialPeriodDialog specialPeriodDialog;

	public CancelModifySpecialPeriodDiscountListener(SpecialPeriodDialog specialPeriodDialog) {
		// TODO Auto-generated constructor stub
		this.specialPeriodDialog = specialPeriodDialog;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		specialPeriodDialog.dispose();
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
