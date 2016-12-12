package hrs.client.UI.WebStaffUI.HotelStaffUI.HotelStaffListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import hrs.client.UI.WebStaffUI.HotelStaffUI.HotelStaffUIPanel;
import hrs.client.util.RegExpHelper;

public class ModifyHotelStaffMouseListener implements MouseListener {
	private HotelStaffUIPanel hotelStaffUIPanel;

	public ModifyHotelStaffMouseListener(HotelStaffUIPanel hotelStaffUIPanel) {
		// TODO Auto-generated constructor stub
		this.hotelStaffUIPanel = hotelStaffUIPanel;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (hotelStaffUIPanel.getUsername().equals("")) {
			JOptionPane.showMessageDialog(null, "请先搜索酒店工作人员！", "Error", JOptionPane.ERROR_MESSAGE);

		} else {
			if (!RegExpHelper.matchUsernameAndPWD(hotelStaffUIPanel.getPassword())) {
				JOptionPane.showMessageDialog(null, "密码要求至少6位，且含字母和数字！", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				int result = JOptionPane.showConfirmDialog(null, "是否确定修改？", "提示", JOptionPane.YES_NO_OPTION,
						JOptionPane.INFORMATION_MESSAGE);
				// System.out.println(result);
				if (result == 0) {
					hotelStaffUIPanel.modify();
					JOptionPane.showConfirmDialog(null, "信息修改成功", "修改成功", JOptionPane.PLAIN_MESSAGE,
							JOptionPane.INFORMATION_MESSAGE);
				}
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
