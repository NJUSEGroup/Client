package hrs.client.UI.WebMarketUI.WebDiscountUI.WebDiscountListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import hrs.client.UI.WebMarketUI.WebDiscountUI.VIPDiaog;
import hrs.client.UI.WebMarketUI.WebDiscountUI.WebDiscountPanel;

public class ConfirmModifyVIPListener implements MouseListener {
	private WebDiscountPanel WebDiscountPanel;
	private VIPDiaog vipDiaog;

	public ConfirmModifyVIPListener(WebDiscountPanel webDiscountPanel, VIPDiaog vipDiaog) {
		// TODO Auto-generated constructor stub
		this.WebDiscountPanel = webDiscountPanel;
		this.vipDiaog = vipDiaog;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (vipDiaog.getNewDiscount() < 0 || vipDiaog.getNewDiscount() >= 1) {
			JOptionPane.showMessageDialog(null, "折扣大于0，小于1！", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			WebDiscountPanel.modifyWebDiscount();
			vipDiaog.dispose();
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
