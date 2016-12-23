package hrs.client.UI.WebStaffUI.HotelAddUI.HotelAddListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import hrs.client.UI.WebStaffUI.HotelAddUI.HotelStaffAddUIPanel;
import hrs.client.util.RegExpHelper;

public class ConfirmMouseListener implements MouseListener {
	private HotelStaffAddUIPanel hotelStaffAddUIPanel;

	public ConfirmMouseListener(HotelStaffAddUIPanel hotelStaffAddUIPanel) {
		// TODO Auto-generated constructor stub
		this.hotelStaffAddUIPanel = hotelStaffAddUIPanel;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		// System.out.println(hotelStaffAddUIPanel.passwordValid());
		if (!(RegExpHelper.matchUsernameAndPWD(hotelStaffAddUIPanel.getUsername())
				&& RegExpHelper.matchUsernameAndPWD(hotelStaffAddUIPanel.getPassword()))) {
			JOptionPane.showMessageDialog(null, "用户名和密码要求至少6位，且含字母和数字！", "Attention", JOptionPane.ERROR_MESSAGE);
		} else {
			if (hotelStaffAddUIPanel.passwordValid() == 1) {
				hotelStaffAddUIPanel.addHotelStaff();
				// JOptionPane.showMessageDialog(hotelStaffAddUIPanel,
				// "添加酒店成功！");
			} else {
				JOptionPane.showMessageDialog(hotelStaffAddUIPanel, "两次密码不符，请重新输入！", "Error",
						JOptionPane.ERROR_MESSAGE);
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
