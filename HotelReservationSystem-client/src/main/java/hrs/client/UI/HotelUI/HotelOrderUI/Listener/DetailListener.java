package hrs.client.UI.HotelUI.HotelOrderUI.Listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import hrs.client.UI.HotelUI.HotelOrderUI.HotelOrderMainPanel;
import hrs.client.UI.HotelUI.HotelOrderUI.HotelOrderUIPanel;
import hrs.common.VO.OrderVO;

public class DetailListener implements MouseListener{
	
	private HotelOrderMainPanel jpMain;
	private HotelOrderUIPanel jpOrderList;
	
	public DetailListener(HotelOrderMainPanel jpMain, HotelOrderUIPanel jpOrderList){
		this.jpMain = jpMain;
		this.jpOrderList = jpOrderList;
	}
	
	/**
	 * 从酒店订单管理界面跳转到酒店详细订单界面，显示所选择的订单的详细信息
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		int row = jpOrderList.getSelectedRow();
		
		if(row != -1){
			OrderVO order = jpOrderList.getSelectedOrder(row);
			jpMain.showDetail(order);
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
