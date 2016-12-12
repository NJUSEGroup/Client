package hrs.client.UI.LoginUI;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import hrs.client.util.UIConstants;

public class LoginLabelListener extends MouseAdapter {
	protected LoginFrame frame;
	protected Color color = UIConstants.JLABEL;
	protected JLabel jl = new JLabel();

	public LoginLabelListener(LoginFrame frame) {
		this.frame = frame;
	}

	public void mouseEntered(MouseEvent e) {
		jl = (JLabel) e.getSource();
		// 鼠标在标签上时更换背景及字体色
		jl.setBackground(Color.WHITE);
		jl.setForeground(Color.BLACK);
	}

	public void mouseClicked(MouseEvent e) {
		frame.showLogin();
	}

	public void mouseExited(MouseEvent e) {
		jl = (JLabel) e.getSource();
		// 鼠标离开标签时更换背景及字体色
		jl.setBackground(color);
		jl.setForeground(Color.white);
	}
}
