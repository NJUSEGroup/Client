package hrs.client.UI.UserUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import hrs.client.util.UIConstants;

public class MenuLabelListener extends MouseAdapter {
	Color color = UIConstants.JLABEL;
	private JLabel jl = new JLabel();
//	private static CardLayout card ;
//	private static JPanel panel ;
	private UserFrame frame;
	public MenuLabelListener(UserFrame frame){
		this.frame = frame;
	}
	public void mouseEntered(MouseEvent e){
		jl = (JLabel)e.getSource();
		//鼠标在标签上时更换背景及字体色
		jl.setBackground(Color.WHITE);
		jl.setForeground(Color.BLACK);
	}
	
	 public void mouseClicked(MouseEvent e){
		 jl = (JLabel)e.getSource();
		 String s = jl.getText();
		 if(s.equals("信用记录")){
			 frame.showCredit();
		 }
		 if(s.equals("订单信息")){
			 frame.showOrder();;
		 }	 
		 if(s.equals("个人信息")){
			 frame.showUserInfo();		 }
		 if(s.equals("搜索酒店")){
			 frame.searchHotel();
		 }
			
		 if(s.equals("酒店信息")){
			 frame.showHotel();
		 }
			 
	 }

	 public void mouseExited(MouseEvent e){
		 jl = (JLabel)e.getSource();
		//鼠标离开标签时更换背景及字体色
		 jl.setBackground(color);
		 jl.setForeground(Color.white);
	 } 
	 
	 
}
