package hrs.client.UI.UserUI.UserInfoUI;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;

import hrs.client.util.UIConstants;

public class UserInfoLabel extends JLabel {
	Font font = UIConstants.JZONE_FONT;
	public UserInfoLabel(String s){
		setFont(font);
		
		//标签固定大小
		setPreferredSize(new Dimension(100,60));
		
		
		//设置显示的文字及居中
		setHorizontalAlignment(JLabel.CENTER);
		this.setText(s);
		
		
	}
}
