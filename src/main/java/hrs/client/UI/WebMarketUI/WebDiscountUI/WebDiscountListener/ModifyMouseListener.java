package hrs.client.UI.WebMarketUI.WebDiscountUI.WebDiscountListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import hrs.client.UI.WebMarketUI.WebDiscountUI.WebDiscountPanel;

public class ModifyMouseListener implements MouseListener {
	private WebDiscountPanel webDiscountPanel;

	public ModifyMouseListener(WebDiscountPanel webDiscountPanel) {
		// TODO Auto-generated constructor stub
		this.webDiscountPanel = webDiscountPanel;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		webDiscountPanel.showModifyDialog();
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
