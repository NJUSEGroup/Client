package hrs.client.UI.UserUI.OrderInfoUI;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hrs.client.UI.UserUI.Components.CommonLabel;
import hrs.client.UI.UserUI.Components.CommonPanel;
import hrs.client.UI.UserUI.OrderInfoUI.Listener.BackJBListener;
import hrs.client.util.EnumHelper;
import hrs.client.util.HMSBlueButton;
import hrs.client.util.UIConstants;
import hrs.common.VO.OrderVO;
import hrs.common.util.DateHelper;

public class DetailedOrderPanel extends CommonPanel {
	private OrderVO vo;
	private static int LABEL_HEIGHT = 40;//每个标签的高度
	private static int LABEL_WIDTH = 160;//每个标签的宽度
	private static int GAP_X = 30;//第一个标签（即最左上角的标签）的横坐标
	private static int GAP_Y = 30;//第一个标签的纵坐标
	private static int RIGHTP_X = 220;//右侧面板位置横坐标
	private static int RIGHTP_Y = 30;//右侧面板位置纵坐标
	
	
	private JPanel infoPanel = new JPanel();//右侧显示ordervo实际信息的界面，包含了右下角返回按钮
	private OrderInfoPanel panel;
	
	public DetailedOrderPanel(OrderVO vo,OrderInfoPanel panel) {
		this.vo = vo;
		this.panel = panel;
		init();

	}

	// 实际信息标签设置
	private void infoInit() {
		setButton();
		infoPanel.setBounds(RIGHTP_X, RIGHTP_Y, this.getWidth(), this.getHeight()-RIGHTP_Y);
		infoPanel.setBackground(UIConstants.JFRAME);
		infoPanel.setLayout(null);
		this.add(infoPanel);
		
		JLabel idInfoJL = new CommonLabel(vo.id+"", JLabel.LEFT);
		JLabel placeTmJL = new CommonLabel(DateHelper.format(vo.placeTime),JLabel.LEFT);
		JLabel execTmJL = new CommonLabel(DateHelper.format(vo.execTime), JLabel.LEFT);
		JLabel checkInTmJL = new CommonLabel(DateHelper.format(vo.checkinTime), JLabel.LEFT);
		JLabel expectedCheckOutTmJL = new CommonLabel(DateHelper.format(vo.expectedCheckoutTime), JLabel.LEFT);
		JLabel checkOutTmJL = new CommonLabel(DateHelper.format(vo.checkoutTime), JLabel.LEFT);
		JLabel revokeTmJL = new CommonLabel(DateHelper.format(vo.revokeTime), JLabel.LEFT);
		JLabel hotelJL = new CommonLabel(vo.hotel.name, JLabel.LEFT);
		JLabel roomTypeJL = new CommonLabel(EnumHelper.RoomFormat(vo.type), JLabel.LEFT);
		JLabel roomNumJL = new CommonLabel(vo.roomNum+"", JLabel.LEFT);
		JLabel peopleNumJL = new CommonLabel(vo.peopleNum+"", JLabel.LEFT);
		JLabel hasChildJL = new JLabel();
		if(vo.hasChild == false){
			hasChildJL = new CommonLabel("无", JLabel.LEFT);
		}
		else {
			hasChildJL = new CommonLabel("有", JLabel.LEFT);
		}
		JLabel valueJL = new CommonLabel(vo.value+"", JLabel.LEFT);
		JLabel statusJL = new CommonLabel(EnumHelper.StatusFormat(vo.status), JLabel.LEFT);
		JLabel scoreJL = new CommonLabel(vo.score+"", JLabel.LEFT);
		JLabel evalueJL = new CommonLabel(vo.evaluation, JLabel.LEFT);
		
		//设定位置
		idInfoJL.setBounds(0, 0, LABEL_WIDTH, LABEL_HEIGHT);
		placeTmJL.setBounds(0, LABEL_HEIGHT, LABEL_WIDTH, LABEL_HEIGHT);
		execTmJL.setBounds(0, LABEL_HEIGHT*2, LABEL_WIDTH, LABEL_HEIGHT);
		checkInTmJL.setBounds(0, LABEL_HEIGHT*3, LABEL_WIDTH, LABEL_HEIGHT);
		expectedCheckOutTmJL.setBounds(0, LABEL_HEIGHT*4, LABEL_WIDTH, LABEL_HEIGHT);
		checkOutTmJL.setBounds(0, LABEL_HEIGHT*5, LABEL_WIDTH, LABEL_HEIGHT);
		revokeTmJL.setBounds(0, LABEL_HEIGHT*6, LABEL_WIDTH, LABEL_HEIGHT);
		hotelJL.setBounds(0, LABEL_HEIGHT*7, LABEL_WIDTH, LABEL_HEIGHT);
		roomTypeJL.setBounds(0, LABEL_HEIGHT*8, LABEL_WIDTH, LABEL_HEIGHT);
		roomNumJL.setBounds(0, LABEL_HEIGHT*9, LABEL_WIDTH, LABEL_HEIGHT);
		peopleNumJL.setBounds(0, LABEL_HEIGHT*10, LABEL_WIDTH, LABEL_HEIGHT);
		hasChildJL.setBounds(0, LABEL_HEIGHT*11, LABEL_WIDTH, LABEL_HEIGHT);
		valueJL.setBounds(0, LABEL_HEIGHT*12, LABEL_WIDTH, LABEL_HEIGHT);
		statusJL.setBounds(0, LABEL_HEIGHT*13, LABEL_WIDTH, LABEL_HEIGHT);
		scoreJL.setBounds(0, LABEL_HEIGHT*14, LABEL_WIDTH, LABEL_HEIGHT);
		evalueJL.setBounds(0, LABEL_HEIGHT*15, 600, LABEL_HEIGHT);
		
		infoPanel.add(idInfoJL);
		infoPanel.add(placeTmJL);
		infoPanel.add(execTmJL);
		infoPanel.add(checkInTmJL);
		infoPanel.add(expectedCheckOutTmJL);
		infoPanel.add(checkOutTmJL);
		infoPanel.add(revokeTmJL);
		infoPanel.add(hotelJL);
		infoPanel.add(roomTypeJL);
		infoPanel.add(roomNumJL);
		infoPanel.add(peopleNumJL);
		infoPanel.add(hasChildJL);
		infoPanel.add(valueJL);
		infoPanel.add(statusJL);
		infoPanel.add(scoreJL);
		infoPanel.add(evalueJL);
		
		
	}

	private void setButton() {
		HMSBlueButton backButton = new HMSBlueButton("返回");
		backButton.setFont(UIConstants.JLABEL_FONT);
		backButton.setBounds(this.getWidth()-RIGHTP_X-200,this.getHeight()-RIGHTP_Y-130, 100, 40);
		infoPanel.add(backButton);
		backButton.addActionListener(new BackJBListener(panel));
		
	}

	@Override
	public void init() {
		
		JLabel idLabel = new CommonLabel("订单号", JLabel.LEFT);// "订单号"
		JLabel placeLabel = new CommonLabel("下单时间", JLabel.LEFT);// "下单时间"
		JLabel execLabel = new CommonLabel("执行时间", JLabel.LEFT);// "执行时间"
		JLabel checkinLabel = new CommonLabel("入住时间", JLabel.LEFT);// "入住时间"
		JLabel expectedCheckoutLabel = new CommonLabel("预计离开时间", JLabel.LEFT);// "预计离开时间"
		JLabel checkoutLabel = new CommonLabel("退房时间", JLabel.LEFT);// "退房时间"
		JLabel revokeLabel = new CommonLabel("撤销时间", JLabel.LEFT);// "撤销时间"
		JLabel hotelLabel = new CommonLabel("酒店名称", JLabel.LEFT);// "酒店名称"
		JLabel RoomTypeLabel = new CommonLabel("房间类型", JLabel.LEFT);// "房间类型"
		JLabel RoomNumLabel = new CommonLabel("房间数量", JLabel.LEFT);// "房间数量"
		JLabel peopleNumLabel = new CommonLabel("入住人数", JLabel.LEFT);// "入住人数"
		JLabel hasChildLabel = new CommonLabel("有无儿童", JLabel.LEFT);// "有无儿童"
		JLabel valueLabel = new CommonLabel("金额", JLabel.LEFT);// "金额"
		JLabel orderStatusLabel = new CommonLabel("订单状态", JLabel.LEFT);// "订单状态"
		JLabel scoreLabel = new CommonLabel("评分", JLabel.LEFT);// "评分"
		JLabel evalueLabel = new CommonLabel("评价", JLabel.LEFT);// "评价"

		// 设置位置
		idLabel.setBounds(GAP_X, GAP_Y, LABEL_WIDTH, LABEL_HEIGHT);
		placeLabel.setBounds(GAP_X, GAP_Y + LABEL_HEIGHT, LABEL_WIDTH, LABEL_HEIGHT);
		execLabel.setBounds(GAP_X, GAP_Y + LABEL_HEIGHT * 2, LABEL_WIDTH, LABEL_HEIGHT);
		checkinLabel.setBounds(GAP_X, GAP_Y + LABEL_HEIGHT * 3, LABEL_WIDTH, LABEL_HEIGHT);
		expectedCheckoutLabel.setBounds(GAP_X, GAP_Y + LABEL_HEIGHT * 4, LABEL_WIDTH, LABEL_HEIGHT);
		checkoutLabel.setBounds(GAP_X, GAP_Y + LABEL_HEIGHT * 5, LABEL_WIDTH, LABEL_HEIGHT);
		revokeLabel.setBounds(GAP_X, GAP_Y + LABEL_HEIGHT * 6, LABEL_WIDTH, LABEL_HEIGHT);
		hotelLabel.setBounds(GAP_X, GAP_Y + LABEL_HEIGHT * 7, LABEL_WIDTH, LABEL_HEIGHT);
		RoomTypeLabel.setBounds(GAP_X, GAP_Y + LABEL_HEIGHT * 8, LABEL_WIDTH, LABEL_HEIGHT);
		RoomNumLabel.setBounds(GAP_X, GAP_Y + LABEL_HEIGHT * 9, LABEL_WIDTH, LABEL_HEIGHT);
		peopleNumLabel.setBounds(GAP_X, GAP_Y + LABEL_HEIGHT * 10, LABEL_WIDTH, LABEL_HEIGHT);
		hasChildLabel.setBounds(GAP_X, GAP_Y + LABEL_HEIGHT * 11, LABEL_WIDTH, LABEL_HEIGHT);
		valueLabel.setBounds(GAP_X, GAP_Y + LABEL_HEIGHT * 12, LABEL_WIDTH, LABEL_HEIGHT);
		orderStatusLabel.setBounds(GAP_X, GAP_Y + LABEL_HEIGHT * 13, LABEL_WIDTH, LABEL_HEIGHT);
		scoreLabel.setBounds(GAP_X, GAP_Y + LABEL_HEIGHT * 14, LABEL_WIDTH, LABEL_HEIGHT);
		evalueLabel.setBounds(GAP_X, GAP_Y + LABEL_HEIGHT * 15, LABEL_WIDTH, LABEL_HEIGHT);

		add(idLabel);
		add(placeLabel);
		add(execLabel);
		add(checkinLabel);
		add(checkoutLabel);
		add(checkoutLabel);
		add(expectedCheckoutLabel);
		add(revokeLabel);
		add(hotelLabel);
		add(RoomTypeLabel);
		add(RoomNumLabel);
		add(peopleNumLabel);
		add(hasChildLabel);
		add(valueLabel);
		add(orderStatusLabel);
		add(scoreLabel);
		add(evalueLabel);

		infoInit();
	}

}
