package hrs.client.UI.HotelUI.HotelDiscountUI.Listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import hrs.client.UI.HotelUI.HotelDiscountUI.HotelDiscountUIPanel;
import hrs.common.VO.HotelDiscountVO;

public class DeleteListener implements MouseListener{

	private HotelDiscountUIPanel jpDiscount;
	
	public DeleteListener(HotelDiscountUIPanel jpDiscount){
		this.jpDiscount = jpDiscount;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(jpDiscount.isButtonEnable("删除")){
			int value = JOptionPane.showConfirmDialog(null, "您确定要删除该促销策略吗？", "请确认修改", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
			
			if(value==JOptionPane.OK_OPTION){
				HotelDiscountVO discount = jpDiscount.getSelectedDiscount();
				jpDiscount.deleteDiscount(discount);
				jpDiscount.getAllDiscounts();
				jpDiscount.refresh();
				JOptionPane.showMessageDialog(null, "促销策略已更新！", "更新成功", JOptionPane.INFORMATION_MESSAGE);
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
