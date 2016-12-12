package hrs.client.UI.WebMarketUI.WebDiscountUI.WebDiscountListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import hrs.client.UI.WebMarketUI.WebDiscountUI.SpecialCommercialCircleDialog;
import hrs.client.UI.WebMarketUI.WebDiscountUI.WebDiscountPanel;

public class ConfirmModifySpecialCommercialListener implements MouseListener {
	private WebDiscountPanel WebDiscountPanel;
	private SpecialCommercialCircleDialog specialCommercialCircleDialog;

	public ConfirmModifySpecialCommercialListener(WebDiscountPanel webDiscountPanel,
			SpecialCommercialCircleDialog specialCommercialCircleDialog) {
		// TODO Auto-generated constructor stub
		this.WebDiscountPanel = webDiscountPanel;
		this.specialCommercialCircleDialog = specialCommercialCircleDialog;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (specialCommercialCircleDialog.getNewDiscount() < 0 || specialCommercialCircleDialog.getNewDiscount() >= 1) {
			JOptionPane.showMessageDialog(null, "折扣大于0，小于1！", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			WebDiscountPanel.modifyWebDiscount();
			specialCommercialCircleDialog.dispose();
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
