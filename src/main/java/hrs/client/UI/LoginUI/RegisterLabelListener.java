package hrs.client.UI.LoginUI;

import java.awt.event.MouseEvent;

public class RegisterLabelListener extends LoginLabelListener {

	public RegisterLabelListener(LoginFrame frame) {
		super(frame);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		super.mouseEntered(e);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		frame.showRegister();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		super.mouseExited(e);
	}

}
