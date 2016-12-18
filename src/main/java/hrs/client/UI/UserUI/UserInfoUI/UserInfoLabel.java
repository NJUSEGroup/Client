package hrs.client.UI.UserUI.UserInfoUI;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;

import hrs.client.util.UIConstants;

public class UserInfoLabel extends JLabel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6584384605641975423L;
	Font font = UIConstants.JLABEL_FONT;
	public UserInfoLabel(String s){
		setFont(font);
		
		//标签固定大小
		setPreferredSize(new Dimension(100,60));
		
		
		//设置显示的文字及居中
		setHorizontalAlignment(JLabel.CENTER);
		this.setText(s);
		
		
	}
}
