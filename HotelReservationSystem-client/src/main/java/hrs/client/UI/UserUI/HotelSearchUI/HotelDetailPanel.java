package hrs.client.UI.UserUI.HotelSearchUI;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import hrs.client.UI.UserUI.Components.ComHotelDetail;
import hrs.client.UI.UserUI.Components.ComNeedBackPanel;
import hrs.client.UI.UserUI.Components.CommonPanel;
import hrs.client.UI.UserUI.Components.CommonTable;
import hrs.client.UI.UserUI.HotelInfoUI.HotelDetailInfoPanel;
import hrs.client.UI.UserUI.HotelSearchUI.Listener.BackListener;
import hrs.client.UI.UserUI.HotelSearchUI.Listener.PlaceOrderListener;
import hrs.client.UI.UserUI.OrderInfoUI.OrderTableModel;
import hrs.client.util.ControllerFactory;
import hrs.client.util.HMSBlueButton;
import hrs.client.util.UIConstants;
import hrs.common.Controller.UserController.IUserHotelController;
import hrs.common.Controller.UserController.IUserOrderController;
import hrs.common.Exception.OrderService.OrderNotFoundException;
import hrs.common.VO.HotelVO;
import hrs.common.VO.OrderVO;
import hrs.common.VO.RoomVO;
import hrs.common.VO.UserVO;

/**
 * 酒店详细信息显示界面
 * 含有HotelDetailInfoPanel,RoomTable,OrderTable
 * 
 * @author 涵
 *
 */
public class HotelDetailPanel extends ComHotelDetail {
	private static final long serialVersionUID = 7566236145344049160L;
	Font font = UIConstants.JLABEL_FONT;
	public HotelDetailPanel(HotelVO hotel,List<RoomVO> rooms,UserVO user){
		super(hotel, rooms, user);
		init();
	}
	
	
	
	@Override
	public void init() {
		setDetailInfo();
		setRoomTable();
		setOrderTable();
		setBackButton();
		setOrderButton();

	}
	
	
	public void setOrderButton(){
		HMSBlueButton orderJB = new HMSBlueButton("立即下单");
		orderJB.setFont(font);
		orderJB.setBounds(this.getWidth() - 300, 650, 120, 40);
		orderJB.addActionListener(new PlaceOrderListener(this));
		add(orderJB);	
	}


	
	private void setRoomTable(){
		CommonTable roomTable = new CommonTable();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(roomTable);
		scrollPane.setBounds(30,340, 1020, 120);
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
//		scrollPane.setBorder(BorderFactory.createLineBorder(new Color(145, 189, 214), 2));
		scrollPane.getViewport().setBackground(new Color(211, 237, 249));
		scrollPane.setOpaque(true);
		
		RoomTableModel model = new RoomTableModel(rooms);
		roomTable.setModel(model);
		add(scrollPane);
	}
	
	public void placeOrder() {
		panel.placeOrder();
		
	}
	

}
