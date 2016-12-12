package hrs.client.UI.WebMarketUI.WebDiscountUI.WebDiscountListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import hrs.client.UI.WebMarketUI.WebDiscountUI.AddWebDiscountDialog;
import hrs.client.UI.WebMarketUI.WebDiscountUI.WebDiscountPanel;

public class OKListener implements MouseListener {
	WebDiscountPanel jpWebDiscount;
	AddWebDiscountDialog jdAddWebDiscount;

	public OKListener(WebDiscountPanel jpWebDiscount, AddWebDiscountDialog jdAddWebDiscount) {
		// TODO Auto-generated constructor stub
		this.jpWebDiscount = jpWebDiscount;
		this.jdAddWebDiscount = jdAddWebDiscount;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (jdAddWebDiscount.getSelectedType()==-1) {
			JOptionPane.showMessageDialog(null, "请先选择折扣类型！", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			if (jdAddWebDiscount.getDiscount() < 0 || jdAddWebDiscount.getDiscount() >= 1) {
				JOptionPane.showMessageDialog(null, "折扣大于0，小于1！", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				jpWebDiscount.addWebDiscount();// 从vo显示到界面上,vo????
				JOptionPane.showMessageDialog(null, "促销策略成功添加！", "Success", JOptionPane.PLAIN_MESSAGE, null);
				jdAddWebDiscount.dispose();
				jdAddWebDiscount.refresh();
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
