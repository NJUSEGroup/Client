package hrs.client.UI.UserUI.UserInfoUI;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JTextField;

import hrs.client.util.UIConstants;

public class UserInfoText extends JTextField {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2548607212487394410L;
	Font font = UIConstants.JLABEL_FONT;
	public UserInfoText(){
		setFont(font);
		setPreferredSize(new Dimension(180,40));
	}
}
