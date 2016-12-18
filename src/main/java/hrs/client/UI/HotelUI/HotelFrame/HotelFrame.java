package hrs.client.UI.HotelUI.HotelFrame;


import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import hrs.client.UI.HotelUI.HotelDiscountUI.HotelDiscountUIPanel;
import hrs.client.UI.HotelUI.HotelFrame.Listener.MenuListListener;
import hrs.client.UI.HotelUI.HotelOrderUI.HotelOrderMainPanel;
import hrs.client.UI.HotelUI.HotelUI.HotelUIPanel;
import hrs.client.UI.HotelUI.OfflineRecordUI.OfflineRecordUIPanel;
import hrs.client.UI.HotelUI.RoomUI.RoomUIPanel;
import hrs.client.util.ControllerFactory;
import hrs.client.util.ImageLoader;
import hrs.client.util.UIConstants;
import hrs.common.Controller.HotelController.IHotelController;
import hrs.common.Exception.HotelService.HotelNotFoundException;
import hrs.common.Exception.OrderService.OrderNotFoundException;
import hrs.common.Exception.RoomService.RoomNotFoundException;
import hrs.common.VO.HotelVO;
import hrs.common.VO.StaffVO;

import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class HotelFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7856445850346641745L;
	private CardLayout card;
	private JPanel jpMenuList;
	private JPanel jpCard;
	private JLabel jlZone;
	private JLabel jlIdentity;
	private JLabel jlUsername;
	private JLabel jlHotelInfo;
	private JLabel jlHotelOrder;
	private JLabel jlRoom;
	private JLabel jlHotelDiscount;
	private JLabel jlOfflineRecord;
	private HotelUIPanel jpHotelUI;
	private HotelOrderMainPanel jpHotelOrderUI;
	private RoomUIPanel jpRoomUI;
	private HotelDiscountUIPanel jpHotelDiscountUI;
	private OfflineRecordUIPanel jpOfflineRecordUI;
	private MenuListListener menuListListener;
	private StaffVO staff;
	private HotelVO hotel;
	private IHotelController controller;
	private Font zoneFont;
	private Font labelFont;
	private Color frameColor;
	private Color panelColor;
	private Color labelColor;
	private int cardNum = -1;//指示现在显示的是哪张界面
	private ImageIcon hotelImage;
	private ImageIcon orderImage;
	private ImageIcon roomImage;
	private ImageIcon discountImage;
	private ImageIcon recordImage;
	
	public static void main(String args[])
	{
		HotelFrame frame = new HotelFrame();
	}
	/**
	 * 初始化酒店管理中心界面主框架
	 * @throws RoomNotFoundException 
	 * @throws OrderNotFoundException 
	 */
	public HotelFrame(/**StaffVO staff**/){
		init(/**staff**/);
	}
	
	public void init(/**StaffVO staff**/){
//		this.staff = staff;
//		hotel = staff.hotel;
		
		controller = ControllerFactory.getHotelController();
		
		try {
			hotel = controller.findHotelByID(4);
		} catch (HotelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.setFontAndColor();
		
		this.setSize(1366, 768);
		this.setLocationRelativeTo(null);
		this.setTitle("酒店预订系统");
		this.getContentPane().setLayout(null);
		this.getContentPane().setBackground(frameColor);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		
		this.setPanel();
		this.setInfo();
		this.setMenuList();
		
		this.setVisible(true);
	}
	
	public void setFontAndColor(){
		zoneFont = UIConstants.JZONE_FONT;
		labelFont = UIConstants.JLABEL_FONT;
		frameColor = UIConstants.CONTENTPANE_COLOR;
		panelColor = UIConstants.JFRAME;
		labelColor = UIConstants.JLABEL;
	}
	
	/**
	 * 设置面板
	 */
	public void setPanel(){
		card = new CardLayout();
		
		jpHotelUI = new HotelUIPanel(hotel);
		jpHotelOrderUI = new HotelOrderMainPanel(hotel);
		jpRoomUI = new RoomUIPanel(hotel);
		jpHotelDiscountUI = new HotelDiscountUIPanel(hotel);
		jpOfflineRecordUI = new OfflineRecordUIPanel(hotel);
		
		jpMenuList = new JPanel();
		jpMenuList.setBounds(5, 5, 263, 722);
		jpMenuList.setBackground(panelColor);
		jpMenuList.setLayout(null);
		
		jpCard = new JPanel(card);
		jpCard.setBounds(273, 5, 1080, 722);
		jpCard.setBackground(panelColor);
		jpCard.add(jpHotelUI, "HotelUI");
		jpCard.add(jpHotelOrderUI, "HotelOrderUI");
		jpCard.add(jpRoomUI, "RoomUI");
		jpCard.add(jpHotelDiscountUI, "HotelDiscountUI");
		jpCard.add(jpOfflineRecordUI, "OfflineRecordUI");
		
		this.getContentPane().add(jpMenuList);
		this.getContentPane().add(jpCard);
	}
	
	/**
	 * 设置信息栏
	 */
	public void setInfo(){
		jlZone = new JLabel();
		jlZone.setBounds(0, 0, 263, 79);
		jlZone.setText("酒店管理中心");
		jlZone.setHorizontalAlignment(SwingConstants.CENTER);
		jlZone.setFont(zoneFont);
		jlZone.setOpaque(true);
		jlZone.setBackground(UIConstants.JZONE);
		jlZone.setForeground(UIConstants.JZONE_FONT_COLOR);
		
		jlIdentity = new JLabel();
		jlIdentity.setBounds(0, 79, 263, 29);
		jlIdentity.setText("酒店工作人员");
		jlIdentity.setHorizontalAlignment(SwingConstants.CENTER);
		jlIdentity.setFont(labelFont);
		
		jlUsername = new JLabel();
		jlUsername.setBounds(0, 108, 263, 29);
		jlUsername.setText("Username");
//		jlUsername.setText(staff.username);
		jlUsername.setHorizontalAlignment(SwingConstants.CENTER);
		jlUsername.setFont(labelFont);
		
		jpMenuList.add(jlZone);
		jpMenuList.add(jlIdentity);
		jpMenuList.add(jlUsername);
	}
	
	/**
	 * 设置菜单栏
	 */
	public void setMenuList(){
		menuListListener = new MenuListListener(this);
		ImageLoader loader = ImageLoader.getInstance();		
		
		hotelImage = loader.getIcon("HotelFrame/HotelInfo.png");
		hotelImage.setImage(hotelImage.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT));
		jlHotelInfo = new JLabel();
		jlHotelInfo.setBounds(0, 200, 263, 65);
		jlHotelInfo.setText("酒店信息");
		jlHotelInfo.setFont(labelFont);
		jlHotelInfo.setForeground(Color.WHITE);
		jlHotelInfo.setHorizontalAlignment(SwingConstants.CENTER);
		jlHotelInfo.setOpaque(true);
		jlHotelInfo.setBackground(labelColor);
		jlHotelInfo.addMouseListener(menuListListener);
		jlHotelInfo.setIcon(hotelImage);
		
		orderImage = loader.getIcon("HotelFrame/HotelOrder.png");
		orderImage.setImage(orderImage.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT));
		jlHotelOrder = new JLabel();
		jlHotelOrder.setBounds(0, 265, 263, 65);
		jlHotelOrder.setText("订单管理");
		jlHotelOrder.setFont(labelFont);
		jlHotelOrder.setForeground(Color.WHITE);
		jlHotelOrder.setHorizontalAlignment(SwingConstants.CENTER);
		jlHotelOrder.setOpaque(true);
		jlHotelOrder.setBackground(labelColor);
		jlHotelOrder.addMouseListener(menuListListener);
		jlHotelOrder.setIcon(orderImage);
		
		roomImage = loader.getIcon("HotelFrame/Room.png");
		roomImage.setImage(roomImage.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT));
		jlRoom = new JLabel();
		jlRoom.setBounds(0, 330, 263, 65);
		jlRoom.setText("录入客房");
		jlRoom.setFont(labelFont);
		jlRoom.setForeground(Color.WHITE);
		jlRoom.setHorizontalAlignment(SwingConstants.CENTER);
		jlRoom.setOpaque(true);
		jlRoom.setBackground(labelColor);
		jlRoom.addMouseListener(menuListListener);
		jlRoom.setIcon(roomImage);
		
		discountImage = loader.getIcon("HotelFrame/HotelDiscount.png");
		discountImage.setImage(discountImage.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT));
		jlHotelDiscount = new JLabel();
		jlHotelDiscount.setBounds(0, 395, 263, 65);
		jlHotelDiscount.setText("促销策略");
		jlHotelDiscount.setFont(labelFont);
		jlHotelDiscount.setForeground(Color.WHITE);
		jlHotelDiscount.setHorizontalAlignment(SwingConstants.CENTER);
		jlHotelDiscount.setOpaque(true);
		jlHotelDiscount.setBackground(labelColor);
		jlHotelDiscount.addMouseListener(menuListListener);
		jlHotelDiscount.setIcon(discountImage);
		
		recordImage = loader.getIcon("HotelFrame/OfflineRecord.png");
		recordImage.setImage(recordImage.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT));
		jlOfflineRecord = new JLabel();
		jlOfflineRecord.setBounds(0, 460, 263, 65);
		jlOfflineRecord.setText("线下入住");
		jlOfflineRecord.setFont(labelFont);
		jlOfflineRecord.setForeground(Color.WHITE);
		jlOfflineRecord.setHorizontalAlignment(SwingConstants.CENTER);
		jlOfflineRecord.setOpaque(true);
		jlOfflineRecord.setBackground(labelColor);
		jlOfflineRecord.addMouseListener(menuListListener);
		jlOfflineRecord.setIcon(recordImage);
		
		jpMenuList.add(jlHotelInfo);
		jpMenuList.add(jlHotelOrder);
		jpMenuList.add(jlRoom);
		jpMenuList.add(jlHotelDiscount);
		jpMenuList.add(jlOfflineRecord);
	}
	
	/**
	 * 根据鼠标点击的标签展示相应界面，标签变色
	 * @param label
	 */
	public void show(String label){
		if(label.equals("酒店信息")){
			cardNum = 0;
			card.show(jpCard, "HotelUI");
			jpHotelUI.showHotelInfo();
			jlHotelInfo.setBackground(Color.WHITE);
			jlHotelInfo.setForeground(Color.GRAY);
			jlHotelOrder.setBackground(labelColor);
			jlHotelOrder.setForeground(Color.WHITE);
			jlRoom.setBackground(labelColor);
			jlRoom.setForeground(Color.WHITE);
			jlHotelDiscount.setBackground(labelColor);
			jlHotelDiscount.setForeground(Color.WHITE);
			jlOfflineRecord.setBackground(labelColor);
			jlOfflineRecord.setForeground(Color.WHITE);
		}
		else if(label.equals("订单管理")){
			cardNum = 1;
			card.show(jpCard, "HotelOrderUI");
			jpHotelOrderUI.refresh();
			jlHotelInfo.setBackground(labelColor);
			jlHotelInfo.setForeground(Color.WHITE);
			jlHotelOrder.setBackground(Color.WHITE);
			jlHotelOrder.setForeground(Color.GRAY);
			jlRoom.setBackground(labelColor);
			jlRoom.setForeground(Color.WHITE);
			jlHotelDiscount.setBackground(labelColor);
			jlHotelDiscount.setForeground(Color.WHITE);
			jlOfflineRecord.setBackground(labelColor);
			jlOfflineRecord.setForeground(Color.WHITE);
		}
		else if(label.equals("录入客房")){
			cardNum = 2;
			card.show(jpCard, "RoomUI");
			jpRoomUI.refreshRoomList();
			jlHotelInfo.setBackground(labelColor);
			jlHotelInfo.setForeground(Color.WHITE);
			jlHotelOrder.setBackground(labelColor);
			jlHotelOrder.setForeground(Color.WHITE);
			jlRoom.setBackground(Color.WHITE);
			jlRoom.setForeground(Color.GRAY);
			jlHotelDiscount.setBackground(labelColor);
			jlHotelDiscount.setForeground(Color.WHITE);
			jlOfflineRecord.setBackground(labelColor);
			jlOfflineRecord.setForeground(Color.WHITE);
		}
		else if(label.equals("促销策略")){
			cardNum = 3;
			card.show(jpCard, "HotelDiscountUI");
			jpHotelDiscountUI.refresh();
			jlHotelInfo.setBackground(labelColor);
			jlHotelInfo.setForeground(Color.WHITE);
			jlHotelOrder.setBackground(labelColor);
			jlHotelOrder.setForeground(Color.WHITE);
			jlRoom.setBackground(labelColor);
			jlRoom.setForeground(Color.WHITE);
			jlHotelDiscount.setBackground(Color.WHITE);
			jlHotelDiscount.setForeground(Color.GRAY);
			jlOfflineRecord.setBackground(labelColor);
			jlOfflineRecord.setForeground(Color.WHITE);
		}
		else if(label.equals("线下入住")){
			cardNum = 4;
			card.show(jpCard, "OfflineRecordUI");
			jpOfflineRecordUI.refresh(jpOfflineRecordUI.getAllRecords());
			jlHotelInfo.setBackground(labelColor);
			jlHotelInfo.setForeground(Color.WHITE);
			jlHotelOrder.setBackground(labelColor);
			jlHotelOrder.setForeground(Color.WHITE);
			jlRoom.setBackground(labelColor);
			jlRoom.setForeground(Color.WHITE);
			jlHotelDiscount.setBackground(labelColor);
			jlHotelDiscount.setForeground(Color.WHITE);
			jlOfflineRecord.setBackground(Color.WHITE);
			jlOfflineRecord.setForeground(Color.GRAY);
		}
	}
	
	/**
	 * 当光标置于标签上时，标签变色
	 * @param e
	 */
	public void changeColorWhenEnter(MouseEvent e){
		String label = ((JLabel) e.getSource()).getText();
		
		if(label.equals("酒店信息")){
			jlHotelInfo.setBackground(Color.WHITE);
			jlHotelInfo.setForeground(Color.GRAY);
		}
		else if(label.equals("订单管理")){
			jlHotelOrder.setBackground(Color.WHITE);
			jlHotelOrder.setForeground(Color.GRAY);
		}
		else if(label.equals("录入客房")){
			jlRoom.setBackground(Color.WHITE);
			jlRoom.setForeground(Color.GRAY);
		}
		else if(label.equals("促销策略")){
			jlHotelDiscount.setBackground(Color.WHITE);
			jlHotelDiscount.setForeground(Color.GRAY);
		}
		else if(label.equals("线下入住")){
			jlOfflineRecord.setBackground(Color.WHITE);
			jlOfflineRecord.setForeground(Color.GRAY);
		}
	}
	
	/**
	 * 当光标离开标签时，标签变色
	 * @param e
	 */
	public void changeColorWhenExit(MouseEvent e){
		String label = ((JLabel) e.getSource()).getText();
		
		if(label.equals("酒店信息")&&cardNum!=0){
			jlHotelInfo.setBackground(labelColor);
			jlHotelInfo.setForeground(Color.WHITE);
		}
		else if(label.equals("订单管理")&&cardNum!=1){
			jlHotelOrder.setBackground(labelColor);
			jlHotelOrder.setForeground(Color.WHITE);
		}
		else if(label.equals("录入客房")&&cardNum!=2){
			jlRoom.setBackground(labelColor);
			jlRoom.setForeground(Color.WHITE);
		}
		else if(label.equals("促销策略")&&cardNum!=3){
			jlHotelDiscount.setBackground(labelColor);
			jlHotelDiscount.setForeground(Color.WHITE);
		}
		else if(label.equals("线下入住")&&cardNum!=4){
			jlOfflineRecord.setBackground(labelColor);
			jlOfflineRecord.setForeground(Color.WHITE);
		}
	}
}
