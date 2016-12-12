package hrs.client.UI.LoginUI;

import java.awt.Color;

import javax.swing.JLabel;

import hrs.client.util.UIConstants;

public class LoginJL extends JLabel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2377168664787340271L;
	Color color = UIConstants.JLABEL;
	protected LoginFrame frame;

	public LoginJL(LoginFrame frame, String s) {
		this.frame = frame;
		setText(s);
		init();
		addListener();

	}

	protected void addListener() {
		addMouseListener(new LoginLabelListener(frame));
		
	}

	protected void init() {
		
		setFont(UIConstants.JLABEL_FONT);
		setOpaque(true);

		// 初始背景色
		setBackground(color);
		// 初始字体色
		setForeground(Color.white);
		// 设置文字居中
		setHorizontalAlignment(JLabel.CENTER);
	}
}
