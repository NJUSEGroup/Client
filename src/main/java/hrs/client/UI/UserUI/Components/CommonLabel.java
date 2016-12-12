package hrs.client.UI.UserUI.Components;

import java.awt.Font;

import javax.swing.JLabel;

import hrs.client.util.UIConstants;

public class CommonLabel extends JLabel {
	Font font = UIConstants.JLABEL_FONT;
	
	public CommonLabel(){
		init();
	}
	
	public CommonLabel(String s){
		init();
		setText(s);
	}
	
	public CommonLabel(String s, int horizontalAlignment){
		setFont(font);
		setText(s);
		setHorizontalAlignment(horizontalAlignment);
	}
	 
	private void init() {
		//设置字体
		setFont(font);
				
		//文字居中
		setHorizontalAlignment(JLabel.CENTER);
	}
}
