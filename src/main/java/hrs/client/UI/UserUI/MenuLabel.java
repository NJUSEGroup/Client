package hrs.client.UI.UserUI;

import java.awt.Color;
import java.awt.Dimension;


import javax.swing.JLabel;

import hrs.client.util.UIConstants;

public class MenuLabel extends JLabel {
	private static final long serialVersionUID = 8744552006885034016L;
	/**
	 * 
	 */
	
	Color color = UIConstants.JLABEL;

	
	public MenuLabel(String s,UserFrame frame){
		MenuLabelListener listener = new MenuLabelListener(frame);
		this.setFont(UIConstants.JLABEL_FONT);
		
		//标签固定大小
		setPreferredSize(new Dimension(260,70)); 
		
		this.setText(s);
		this.setOpaque(true);
		
		//初始背景色
		this.setBackground(color);
		//初始字体色
		this.setForeground(Color.white);
		//设置文字居中
		setHorizontalAlignment(JLabel.CENTER);
		
		this.addMouseListener(listener);
	}
	
	
}
