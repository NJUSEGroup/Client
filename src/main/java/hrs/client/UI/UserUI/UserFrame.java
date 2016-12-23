package hrs.client.UI.UserUI;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.springframework.web.bind.annotation.InitBinder;

import hrs.client.UI.UserUI.CreditInfoUI.CreditInfoPanel;
import hrs.client.UI.UserUI.HotelInfoUI.HotelInfoPanel;
import hrs.client.UI.UserUI.HotelSearchUI.HotelPanel;
import hrs.client.UI.UserUI.OrderInfoUI.OrderInfoPanel;
import hrs.client.UI.UserUI.UserInfoUI.UserInfoPanel;
import hrs.client.util.ControllerFactory;
import hrs.common.Controller.UserController.IUserController;
import hrs.common.Exception.UserService.UserNotFoundException;
import hrs.common.VO.UserVO;

public class UserFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2942323300288708231L;
	Color frameColor = new Color(211, 237, 249);
	private int height, width;
	private JPanel leftPanel ;
	
	private UserInfoPanel userInfoPanel ;
	private CreditInfoPanel creditInfoPanel;
	private OrderInfoPanel orderInfoPanel;
	private HotelPanel hotelPanel;
	private HotelInfoPanel hotelInfoPanel;
	
	public CardLayout card;
	public JPanel cardPanel;
	
	private UserVO userVO;
	private String username;
	
	public UserFrame(UserVO userVO){
		this.userVO = userVO;
		height = 768;
		width = 1366;
		this.setSize(width,height);
		this.setLocationRelativeTo(null);
		this.setTitle("酒店预订系统");
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//设置背景色
		this.getContentPane().setBackground(frameColor);
		//空布局
		this.setLayout(null);
		
		this.setResizable(false);
		
		this.username = userVO.username;
		
		card=new CardLayout();
		cardPanel = new JPanel();
		cardPanel.setLayout(card);
		cardPanel.setBounds(263,0,1103,768);
		searchHotel();
		//设置左侧面板
		leftPanel = new LeftPanel(userVO,this);
		this.add(leftPanel);
		

		this.add(cardPanel);

		
	}
	
	public static void main(String[] args){
		IUserController controller = ControllerFactory.getUserController();
		UserVO vo;
		try {
			vo = controller.findUserByUsername("admin");
			new UserFrame(vo);
		} catch (UserNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}
	public void showOrder() {
		orderInfoPanel = new OrderInfoPanel(userVO);
		cardPanel.add("orderInfoPanel",orderInfoPanel);
		card.show(cardPanel, "orderInfoPanel");
		
	}
	public void showUserInfo(){
		userInfoPanel = new UserInfoPanel(userVO);
		userInfoPanel.setFrame(this);
		cardPanel.add("userInfoPanel",userInfoPanel);
		card.show(cardPanel, "userInfoPanel");
	}

	public void showCredit() {
		creditInfoPanel = new CreditInfoPanel(username);
		cardPanel.add("creditInfoPanel",creditInfoPanel);
		card.show(cardPanel, "creditInfoPanel");
	}

	public void searchHotel() {
		hotelPanel = new HotelPanel(userVO);
		cardPanel.add("hotelPanel",hotelPanel);
		card.show(cardPanel, "hotelPanel");
	}

	public void showHotel() {
		hotelInfoPanel = new HotelInfoPanel(userVO);
		cardPanel.add("hotelInfoPanel",hotelInfoPanel);
		card.show(cardPanel, "hotelInfoPanel");
	}

	
}
