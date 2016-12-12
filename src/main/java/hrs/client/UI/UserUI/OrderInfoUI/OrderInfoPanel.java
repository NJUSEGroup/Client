package hrs.client.UI.UserUI.OrderInfoUI;

import java.awt.CardLayout;

import javax.swing.JPanel;

import hrs.client.UI.UserUI.Components.CommonPanel;
import hrs.common.VO.OrderVO;
import hrs.common.VO.UserVO;

public class OrderInfoPanel extends CommonPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5849665936669289324L;
	private JPanel cardPanel = new JPanel();
	private CardLayout card = new CardLayout();
	private JPanel detailedOrderPanel;//订单详细信息面板
	private JPanel orderShowPanel;//订单列表的面板
	private UserVO userVO;
	public OrderInfoPanel(UserVO userVO){
		
		this.userVO = userVO;
		init();
		
	}
	@Override
	public void init() {
		
		//面板初始化
		setPanel();
		
		//卡片布局初始化
		setCard();
		
		
	}
	private void setPanel() {
		
		orderShowPanel = new OrderShowPanel(userVO,this);
	}
	
	private void setCard() {
		cardPanel.setLayout(card);
		cardPanel.setBounds(0,0,1103,768);
		
		cardPanel.add("orderShowPanel",orderShowPanel);
		card.show(cardPanel, "orderShowPanel");
		
		add(cardPanel);
	}
	public void showDetail(OrderVO vo) {
		detailedOrderPanel = new DetailedOrderPanel(vo,this);
		cardPanel.add("detailedOrderPanel",detailedOrderPanel);
		card.show(cardPanel,"detailedOrderPanel");
		
	}
	public void back() {
		card.show(cardPanel, "orderShowPanel");
		
		
	}

}
