package hrs.client.UI.UserUI.HotelSearchUI;

import java.awt.CardLayout;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import hrs.client.UI.UserUI.Components.ComNeedBackPanel;
import hrs.client.util.ControllerFactory;
import hrs.common.Controller.UserController.IUserHotelController;
import hrs.common.Controller.UserController.IUserOrderController;
import hrs.common.VO.HotelVO;
import hrs.common.VO.RoomVO;
import hrs.common.VO.UserVO;

/**
 * 搜索酒店主界面
 * 由CardLayout布局的JPanel组成
 * @author 涵
 *
 */
public class HotelPanel extends ComNeedBackPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1513105401650788833L;
	private JPanel hotelCardPanel = new JPanel();
	private CardLayout hotelCard = new CardLayout();
	
	private HotelSearchPanel hotelSearchPanel;
	private PlaceOrderPanel placeOrderPanel;
	private HotelDetailPanel hotelDetailPanel;
	
	private UserVO user;
	private IUserHotelController controller = ControllerFactory.getUserHotelController();
	public HotelPanel(UserVO user){
		this.user = user;
		init();
	}
	@Override
	public void init() {
		setCard();
		
	}
	private void setCard() {
		hotelSearchPanel = new HotelSearchPanel(user);
		hotelSearchPanel.setPanel(this);
		hotelCardPanel.setLayout(hotelCard);
		hotelCardPanel.add("hotelSearch", hotelSearchPanel);
		hotelCardPanel.setBounds(0,0,1103,768);
		hotelCard.show(hotelCardPanel, "hotelSearch");
		
		add(hotelCardPanel);
		
	}
	
	
	
	/**
	 * 显示酒店详细信息界面
	 * @param hotel 需要显示的酒店信息
	 * @param rooms 需要显示的房间信息
	 */
	public void showDetail(HotelVO hotel,List<RoomVO> rooms){
		hotelDetailPanel = new HotelDetailPanel(hotel,rooms,user);
		hotelDetailPanel.setPanel(this);
//		hotelDetailPanel.setOrderButton();
		hotelCardPanel.add("hotelDetail", hotelDetailPanel);
		hotelCard.show(hotelCardPanel, "hotelDetail");
	}
	
	/**
	 * 酒店信息展示界面及下单界面返回酒店搜索界面
	 */
	@Override
	public void back(){
		hotelCard.show(hotelCardPanel, "hotelSearch");
	}
	
	/**
	 * 酒店详细信息展示界面调用以部署下单界面
	 * 调用本界面内的hotelSearchPanel里placeOrder方法以实现
	 */
	@Override
	public void placeOrder() {
		IUserOrderController orderController = ControllerFactory.getUserOrderController();
		if(orderController.validateCredit(user.username))
			hotelSearchPanel.placeOrder();
		else{
			JOptionPane.showMessageDialog(null, "信用值不足，请充值！", "提示", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
	}
	
	/**
	 * 显示下单界面
	 * @param hotel 下单界面需要的酒店信息
	 * @param rooms 下单需要的房间信息
	 * @param orderTime 下单需要的预计入房时间和预计退房时间
	 * @param user 
	 */
	public void showOrderPanel(HotelVO hotel,List<RoomVO> rooms,BeginAndLeaveTime orderTime, UserVO user){
		IUserOrderController orderController = ControllerFactory.getUserOrderController();
		if(!orderController.validateCredit(user.username)){
			JOptionPane.showMessageDialog(null, "信用值不足，请充值！", "提示", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
	
		placeOrderPanel = new PlaceOrderPanel(hotel, rooms, orderTime,user);
		placeOrderPanel.setPanel(this);
		hotelCardPanel.add("placeOrder", placeOrderPanel);
		hotelCard.show(hotelCardPanel, "placeOrder");
	}
	
	
}
