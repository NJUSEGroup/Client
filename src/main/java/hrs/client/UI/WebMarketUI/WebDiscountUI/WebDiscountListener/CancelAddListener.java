package hrs.client.UI.WebMarketUI.WebDiscountUI.WebDiscountListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import hrs.client.UI.WebMarketUI.WebDiscountUI.AddWebDiscountDialog;

public class CancelAddListener implements MouseListener {
	AddWebDiscountDialog jdAddWebDiscount;

	public CancelAddListener(AddWebDiscountDialog jdAddWebDiscount) {
		// TODO Auto-generated constructor stub
		this.jdAddWebDiscount = jdAddWebDiscount;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		jdAddWebDiscount.dispose();
		jdAddWebDiscount.refresh();
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
