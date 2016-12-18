package hrs.client.UI.HotelUI.HotelOrderUI.Listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import hrs.client.UI.HotelUI.HotelOrderUI.HotelOrderUIPanel;
import hrs.common.VO.OrderVO;

public class CheckinListener implements MouseListener{

	private HotelOrderUIPanel jpHotelOrder;
	
	public CheckinListener(HotelOrderUIPanel jpHotelOrder){
		this.jpHotelOrder = jpHotelOrder;
	}
	
	/**
	 * 对未执行订单进行入住操作
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(jpHotelOrder.isButtonEnable("入住")){
			int value = JOptionPane.showConfirmDialog(null, "您确定要对该订单执行入住操作吗？", "请确认入住", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
			if(value==JOptionPane.OK_OPTION){
				int row = jpHotelOrder.getSelectedRow();
				OrderVO order = jpHotelOrder.getSelectedOrder(row);
				jpHotelOrder.checkin(order);
				order = jpHotelOrder.getSelectedOrder(row);
				List<OrderVO> orders = new ArrayList<OrderVO>();
				orders.add(order);
				jpHotelOrder.refreshOrderList(orders);
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
