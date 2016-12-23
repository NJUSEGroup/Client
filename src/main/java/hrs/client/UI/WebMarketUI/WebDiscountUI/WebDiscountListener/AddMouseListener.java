package hrs.client.UI.WebMarketUI.WebDiscountUI.WebDiscountListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import hrs.client.UI.WebMarketUI.WebDiscountUI.WebDiscountPanel;

public class AddMouseListener implements MouseListener {
	WebDiscountPanel jpWebDiscount;

	public AddMouseListener(WebDiscountPanel jpWebDiscount) {
		this.jpWebDiscount = jpWebDiscount;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		jpWebDiscount.showAddDialog();
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
