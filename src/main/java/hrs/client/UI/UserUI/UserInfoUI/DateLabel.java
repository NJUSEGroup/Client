package hrs.client.UI.UserUI.UserInfoUI;

import java.awt.Font;

import javax.swing.JLabel;

import hrs.client.util.UIConstants;

public class DateLabel extends JLabel {
	Font font = UIConstants.JLABEL_FONT;
	public DateLabel(String s){
		setFont(font);
	
		//设置显示的文字及居中
		setHorizontalAlignment(JLabel.CENTER);
		this.setText(s);
		
		
	}
}
