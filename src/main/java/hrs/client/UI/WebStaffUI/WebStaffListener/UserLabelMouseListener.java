package hrs.client.UI.WebStaffUI.WebStaffListener;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import hrs.client.UI.WebStaffUI.MenulistPanel;
import hrs.client.util.UIConstants;

public class UserLabelMouseListener implements MouseListener {
	@SuppressWarnings("unused")
	private MenulistPanel menulistPanel;
	private JLabel jLabel;
	private JLabel jlUserInfo;

	public UserLabelMouseListener(JLabel jLabel, MenulistPanel menulistPanel) {
		this.jLabel = jLabel;
		this.menulistPanel = menulistPanel;
		jlUserInfo = menulistPanel.jlUserInfo();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

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
		jlUserInfo.setBackground(Color.WHITE);
		jlUserInfo.setForeground(Color.GRAY);
		jLabel.setForeground(UIConstants.JZONE_FONT_COLOR);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		jlUserInfo.setBackground(UIConstants.JLABEL);
		jlUserInfo.setForeground(Color.white);
		jLabel.setForeground(Color.BLACK);
	}

}
