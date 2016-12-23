package hrs.client.UI.WebMarketUI.WebDiscountUI.WebDiscountListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import hrs.client.UI.WebMarketUI.WebDiscountUI.SpecialCommercialCircleDialog;

public class CancelModifySpecialCommercialListener implements MouseListener {
	private SpecialCommercialCircleDialog specialCommercialCircleDialog;

	public CancelModifySpecialCommercialListener(SpecialCommercialCircleDialog specialCommercialCircleDialog) {
		// TODO Auto-generated constructor stub
		this.specialCommercialCircleDialog = specialCommercialCircleDialog;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		specialCommercialCircleDialog.dispose();
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
