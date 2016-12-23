package hrs.client.UI.UserUI.HotelInfoUI;

import java.awt.CardLayout;

import javax.swing.JPanel;

import hrs.client.UI.UserUI.Components.ComNeedBackPanel;
import hrs.client.UI.UserUI.Components.CommonPanel;
import hrs.common.VO.HotelVO;
import hrs.common.VO.UserVO;

/**
 * 酒店信息界面的主面板
 * 含有card布局
 * @author 涵
 *
 */
public class HotelInfoPanel extends ComNeedBackPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1746045709499450739L;
	private JPanel cardPanel ;
	private CardLayout card ;
	private HotelTablePanel hotelTablePanel;
	private DetailPanel detailPanel;
	private UserVO user;
	public HotelInfoPanel(UserVO user){
		this.user = user;
		cardPanel = new JPanel();
		card = new CardLayout();
		cardPanel.setLayout(card);
		add(cardPanel);
		
		init();
	}
	@Override
	public void init() {
		cardPanel.setBounds(0,0,1103,768);
		hotelTablePanel = new HotelTablePanel(user,this);
		cardPanel.add("hotelTable",hotelTablePanel);
		card.show(cardPanel, "hotelTable");
		
	}
	public void showDetail(HotelVO hotel) {
		detailPanel = new DetailPanel(hotel, user);
		detailPanel.setPanel(this);
		cardPanel.add("detailPanel",detailPanel);
		card.show(cardPanel, "detailPanel");
		
	}
	
	@Override
	public void back(){
		card.show(cardPanel, "hotelTable");
	}

}
