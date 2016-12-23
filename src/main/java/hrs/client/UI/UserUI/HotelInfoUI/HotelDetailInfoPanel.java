package hrs.client.UI.UserUI.HotelInfoUI;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.springframework.web.bind.annotation.InitBinder;

import hrs.client.UI.UserUI.Components.CommonLabel;
import hrs.client.util.UIConstants;
import hrs.common.VO.HotelVO;

/**
 * 酒店详细信息面板
 * 大小为1020*290
 * @author 涵
 *
 */
public class HotelDetailInfoPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4605076282300415151L;

	private static int JL_HEIGHT = 30;//所有标签的高度均为30
	
	private static int LEFTJL_X = 10;//左侧一列标签的起始x位置
	private static int GAP_Y = 10;
	
	private static int LETTER_W = 21;//标签每一个字的宽度
	
	private HotelVO hotel;
	public HotelDetailInfoPanel(HotelVO hotel){
		this.hotel = hotel;
		init();
	}
	private void init(){
		setSize(1020,290);
		setLayout(null);
		setBackground(UIConstants.JFRAME);
		setBorder(BorderFactory.createLineBorder(new Color(145, 189, 214),3));
		
		JLabel detailJL = new CommonLabel("酒店详细信息", JLabel.LEFT);
		detailJL.setBackground(new Color(145, 179, 179));
		detailJL.setOpaque(true);
		detailJL.setBounds(0, 0, this.getWidth(), JL_HEIGHT);
		add(detailJL);
		
		setLeftLabels();
		setRightLabels();
	}
	private void setRightLabels() {
		JLabel nameInfoJL = new CommonLabel(hotel.name, JLabel.LEFT);
		nameInfoJL.setBounds(LEFTJL_X+LETTER_W*5, JL_HEIGHT+GAP_Y, this.getWidth()-LETTER_W*5-LEFTJL_X, JL_HEIGHT);
		add(nameInfoJL);
		
		JLabel cityInfoJL = new CommonLabel(hotel.location.name+"市", JLabel.LEFT);
		cityInfoJL.setBounds(LEFTJL_X+LETTER_W*3, JL_HEIGHT*2+GAP_Y, this.getWidth()-LETTER_W*3-LEFTJL_X, JL_HEIGHT);
		add(cityInfoJL);
		
		JLabel circleInfoJL = new CommonLabel(hotel.commercialCircle.name, JLabel.LEFT);
		circleInfoJL.setBounds(LEFTJL_X+LETTER_W*3, JL_HEIGHT*3+GAP_Y, this.getWidth()-LETTER_W*3-LEFTJL_X, JL_HEIGHT);
		add(circleInfoJL);
		
		JLabel locInfoJL = new CommonLabel(hotel.location.name+"市"+hotel.street, JLabel.LEFT);
		locInfoJL.setBounds(LEFTJL_X+LETTER_W*3, JL_HEIGHT*4+GAP_Y, this.getWidth()-LETTER_W*3-LEFTJL_X, JL_HEIGHT);
		add(locInfoJL);
		
		JLabel profileInfoJL = new CommonLabel(hotel.profile, JLabel.LEFT);
		profileInfoJL.setBounds(LEFTJL_X+LETTER_W*3, JL_HEIGHT*5+GAP_Y, this.getWidth()-LETTER_W*3-LEFTJL_X, JL_HEIGHT);
		add(profileInfoJL);
		
		JLabel serviceinfoJL = new CommonLabel(hotel.service, JLabel.LEFT);
		serviceinfoJL.setBounds(LEFTJL_X+LETTER_W*5, JL_HEIGHT*6+GAP_Y, this.getWidth()-LETTER_W*5-LEFTJL_X, JL_HEIGHT);
		add(serviceinfoJL);
		
		JLabel starinfoJL = new CommonLabel(hotel.star+"", JLabel.LEFT);
		starinfoJL.setBounds(LEFTJL_X+LETTER_W*3, JL_HEIGHT*7+GAP_Y, this.getWidth()-LETTER_W*3-LEFTJL_X, JL_HEIGHT);
		add(starinfoJL);
		
		JLabel scoreinfoJL = new CommonLabel(hotel.star+"", JLabel.LEFT);
		scoreinfoJL.setBounds(LEFTJL_X+LETTER_W*3, JL_HEIGHT*8+GAP_Y, this.getWidth()-LETTER_W*3-LEFTJL_X, JL_HEIGHT);
		add(scoreinfoJL);
	}
	private void setLeftLabels() {
		JLabel hotelNameJL = new CommonLabel("酒店名称：", JLabel.LEFT);
		hotelNameJL.setBounds(LEFTJL_X, JL_HEIGHT+GAP_Y, LETTER_W*5, JL_HEIGHT);
		add(hotelNameJL);
		
		JLabel cityJL = new CommonLabel("城市：", JLabel.LEFT);
		cityJL.setBounds(LEFTJL_X, JL_HEIGHT*2+GAP_Y, LETTER_W*3, JL_HEIGHT);
		add(cityJL);
		
		JLabel circleJL = new CommonLabel("商圈：", JLabel.LEFT);
		circleJL.setBounds(LEFTJL_X, JL_HEIGHT*3+GAP_Y, LETTER_W*3, JL_HEIGHT);
		add(circleJL);
		
		JLabel locJL = new CommonLabel("地址：", JLabel.LEFT);
		locJL.setBounds(LEFTJL_X, JL_HEIGHT*4+GAP_Y, LETTER_W*3, JL_HEIGHT);
		add(locJL);
		
		JLabel profileJL = new CommonLabel("简介：", JLabel.LEFT);
		profileJL.setBounds(LEFTJL_X, JL_HEIGHT*5+GAP_Y, LETTER_W*3, JL_HEIGHT);
		add(profileJL);
		
		JLabel serviceJL = new CommonLabel("酒店服务：", JLabel.LEFT);
		serviceJL.setBounds(LEFTJL_X, JL_HEIGHT*6+GAP_Y, LETTER_W*5, JL_HEIGHT);
		add(serviceJL);
		
		JLabel starJL = new CommonLabel("星级：", JLabel.LEFT);
		starJL.setBounds(LEFTJL_X, JL_HEIGHT*7+GAP_Y, LETTER_W*3, JL_HEIGHT);
		add(starJL);
		
		JLabel scoreJL = new CommonLabel("评分：", JLabel.LEFT);
		scoreJL.setBounds(LEFTJL_X, JL_HEIGHT*8+GAP_Y, LETTER_W*3, JL_HEIGHT);
		add(scoreJL);
	}
}
