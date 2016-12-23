package hrs.client.UI.UserUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hrs.client.util.ImageLoader;

public class MenuPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2780811634437624154L;
	private JLabel searchJLabel ;
	private JLabel infoJLabel ;
	private JLabel orderJLabel;
	private JLabel hotelJLabel ;
	private JLabel creditJLabel ;
	
	private final int LABEL_WIDTH = 260;
	private final int LABEL_HEIGHT = 70;
	
	
	
	public MenuPanel(UserFrame frame){
		ImageLoader loader = ImageLoader.getInstance();
		setBounds(0, 140, 260, 628);
//		jp.setBackground(frameColor);
		setLayout(null);
		setBackground(new Color(211, 237, 249));
		
		searchJLabel = new MenuLabel("搜索酒店",frame);
		ImageIcon search = loader.getIcon("UserUI/search.png");
		search.setImage(search.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT));
		searchJLabel.setIcon(search);
		
		infoJLabel = new MenuLabel("个人信息",frame);
		ImageIcon userInfo = loader.getIcon("UserUI/userinfo.png");
		userInfo.setImage(userInfo.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT));
		infoJLabel.setIcon(userInfo);
		
		orderJLabel = new MenuLabel("订单信息",frame);
		ImageIcon order = loader.getIcon("UserUI/order.png");
		order.setImage(order.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT));
		orderJLabel.setIcon(order);
		
		hotelJLabel = new MenuLabel("酒店信息",frame);
		ImageIcon hotel = loader.getIcon("UserUI/hotel.png");
		hotel.setImage(hotel.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT));
		hotelJLabel.setIcon(hotel);
		
		creditJLabel = new MenuLabel("信用记录",frame);
		ImageIcon credit = loader.getIcon("UserUI/credit.png");
		credit.setImage(credit.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT));
		creditJLabel.setIcon(credit);
		
		searchJLabel.setBounds(0,0,LABEL_WIDTH,LABEL_HEIGHT);
		infoJLabel.setBounds(0,LABEL_HEIGHT,LABEL_WIDTH,LABEL_HEIGHT);
		orderJLabel.setBounds(0,2*LABEL_HEIGHT,LABEL_WIDTH,LABEL_HEIGHT);
		hotelJLabel.setBounds(0,3*LABEL_HEIGHT,LABEL_WIDTH,LABEL_HEIGHT);
		creditJLabel.setBounds(0,4*LABEL_HEIGHT,LABEL_WIDTH,LABEL_HEIGHT);
		
		
		
		add(searchJLabel);
		add(infoJLabel);
		add(orderJLabel);
		add(hotelJLabel);
		add(creditJLabel);
	}
	
	
}
