package hrs.client.UI.UserUI.HotelInfoUI;


import java.awt.Font;




import hrs.client.UI.UserUI.Components.ComHotelDetail;
import hrs.client.util.UIConstants;
import hrs.common.VO.HotelVO;
import hrs.common.VO.UserVO;
/**
 * 显示酒店详细信息的界面
 * @author 涵
 *
 */
public class DetailPanel extends ComHotelDetail{
//	private UserVO user;
//	private HotelVO hotel;
//	private ComNeedBackPanel panel;
	Font font = UIConstants.JLABEL_FONT;
//	private HotelDetailInfoPanel detailInfoPanel;
	public DetailPanel(HotelVO hotel, UserVO user) {
		super(hotel, user);
		init();
	}
	
	
	@Override
	public void init(){
		setDetailInfo();
		setOrderTable();
		setBackButton();
		orderScrollPane.setBounds(30,360, 1020, 280);
	}


	
	
	

}
