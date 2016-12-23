package hrs.client.UI.UserUI.HotelSearchUI;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hrs.client.UI.UserUI.Components.CommonLabel;
import hrs.client.UI.UserUI.HotelSearchUI.Listener.CityBoxListener;
import hrs.client.util.ControllerFactory;
import hrs.client.util.DateChoosePanel;
import hrs.client.util.UIConstants;
import hrs.common.Controller.UserController.IUserHotelController;
import hrs.common.Exception.HotelService.HotelNotFoundException;
import hrs.common.VO.CommercialCircleVO;
import hrs.common.VO.HotelVO;
import hrs.common.VO.LocationVO;
import hrs.common.VO.RoomVO;
import hrs.common.VO.UserVO;
import hrs.common.util.FilterCondition.FilterCondition;
import hrs.common.util.FilterCondition.IfOrderedFilterCondition;
import hrs.common.util.FilterCondition.NameFilterCondition;
import hrs.common.util.FilterCondition.RoomNumFilterCondition;
import hrs.common.util.FilterCondition.RoomTypeFilterCondition;
import hrs.common.util.FilterCondition.ScoreFilterCondition;
import hrs.common.util.FilterCondition.StarFilterCondition;
import hrs.common.util.FilterCondition.ValueFilterCondition;
import hrs.common.util.type.FilterType;
import hrs.common.util.type.RoomType;

/**
 * 查询条件 面板 大小为1000*280
 * 
 * @author 涵
 *
 */
public class SearchPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3831127469024773580L;

	private IUserHotelController controller;

	private static int JL_HEIGHT = 40;// 所有标签的高度均为40
	private static int JL_WIDTH = 105;// 标签的宽度均为105
	private static int TEXT_H = 30;// 输入域高度为30
	private static int GAP = (JL_HEIGHT - TEXT_H) / 2;// 输入域保持对齐的位置偏移

	private static int LEFTJL_X = 10;// 左侧一列标签的起始x位置
	private static int RIGHTJL_X = 510;// 右侧一列标签的起始x位置

	private static int LEFTIN_X = LEFTJL_X + JL_WIDTH;// 左侧一列输入域的起始x位置
	private static int RIGHTIN_X = RIGHTJL_X + JL_WIDTH;// 右侧一列输入域的起始x位置

	private List<LocationVO> locs;

	private JComboBox<String> cityBox;// 城市选择框
	private JComboBox<String> commercialBox;// 城市选择框
	private DateChoosePanel checkInDate;// 入住时间选择面板
	private DateChoosePanel checkOutDate;// 退房时间选择面板
	private JComboBox<String> roomTypeBox;// 房间类型选框
	private JTextField roomNumField;// 房间数量
	private TwoFieldPanel valueField;// 价格区间
	private TwoFieldPanel scoreField;// 评分区间
	private JComboBox<String> starBox;// 星级选框
	private JTextField hotelNameField;// 酒店名称输入区
	private JCheckBox hasOrderedBox;
	Font font = UIConstants.JLABEL_FONT;
	private UserVO userVO;

	public SearchPanel(UserVO userVO) {
		this.userVO = userVO;
		controller = ControllerFactory.getUserHotelController();
		Init();
	}

	private void Init() {
		setSize(1020, 286);
		setLayout(null);
		setBackground(UIConstants.JFRAME);
		setBorder(BorderFactory.createLineBorder(new Color(145, 189, 214), 3));

		JLabel conditionJL = new CommonLabel("查询条件", JLabel.LEFT);
		conditionJL.setBackground(new Color(145, 179, 179));
		conditionJL.setOpaque(true);
		conditionJL.setBounds(0, 0, this.getWidth(), JL_HEIGHT);
		add(conditionJL);

		setLeftLabel();
		setRightLabel();
		setLeftText();// 左边输入区域初始化
		setRightText();// 右侧输入区域初始化

	}

	private void setRightText() {
		commercialBox = new JComboBox<>();
		commercialBox.setBounds(RIGHTIN_X, JL_HEIGHT + GAP, 150, TEXT_H);
		commercialBox.setFont(font);
		LocationVO defauleLoc = controller.findAllLocations().get(0);// 将得到的位置列表中第一个设为默认位置
		List<CommercialCircleVO> commercials = controller.findCircleByLoc(defauleLoc.id);
		for (int i = 0; i < commercials.size(); i++) {
			commercialBox.addItem(commercials.get(i).name);
		}
		add(commercialBox);

		checkOutDate = new DateChoosePanel();
		checkOutDate.setCurrent();
		checkOutDate.setBounds(RIGHTIN_X, JL_HEIGHT * 2+5, checkInDate.getWidth(), checkInDate.getHeight());
		add(checkOutDate);

		roomNumField = new JTextField();
		roomNumField.setBounds(RIGHTIN_X, JL_HEIGHT * 3 + GAP, 150, TEXT_H);
		roomNumField.setFont(font);
		add(roomNumField);

		scoreField = new TwoFieldPanel();
		scoreField.setBounds(RIGHTIN_X, JL_HEIGHT * 4, scoreField.getWidth(), scoreField.getHeight());
		add(scoreField);

		hasOrderedBox = new JCheckBox("我曾预订过的酒店");
		hasOrderedBox.setFont(font);
		hasOrderedBox.setBackground(UIConstants.JFRAME);
		hasOrderedBox.setSelected(false);// 默认未选中
		hasOrderedBox.setBounds(RIGHTJL_X, JL_HEIGHT * 5, 200, 40);
		add(hasOrderedBox);
	}

	private void setLeftText() {
		cityBox = new JComboBox<>();
		locs = controller.findAllLocations();
		for (int i = 0; i < locs.size(); i++) {
			cityBox.addItem(locs.get(i).name);
		}
		cityBox.setFont(font);
		cityBox.setBounds(LEFTIN_X, JL_HEIGHT + GAP, 150, TEXT_H);
		cityBox.setSelectedItem(locs.get(0).name);
		cityBox.addItemListener(new CityBoxListener(this));
		add(cityBox);

		checkInDate = new DateChoosePanel();
		checkInDate.setCurrent();
		checkInDate.setBounds(LEFTIN_X, JL_HEIGHT * 2+5, checkInDate.getWidth(), checkInDate.getHeight());
		add(checkInDate);

		roomTypeBox = new JComboBox<>();
		String[] l = { "无限制", "商务标间", "豪华房", "双人房", "单人房", "标准房", "大床间", "行政标间" };
		for (int i = 0; i <= 7; i++) {
			roomTypeBox.addItem(l[i]);
		}
		roomTypeBox.setBounds(LEFTIN_X, JL_HEIGHT * 3 + GAP, 150, TEXT_H);
		roomTypeBox.setFont(font);
		add(roomTypeBox);

		valueField = new TwoFieldPanel();
		valueField.setBounds(LEFTIN_X, JL_HEIGHT * 4, valueField.getWidth(), valueField.getHeight());
		add(valueField);

		starBox = new JComboBox<>();
		starBox.addItem("空");
		for (Integer i = 1; i <= 5; i++) {
			starBox.addItem(i+"");
		}
		starBox.setFont(font);
		starBox.setSelectedItem("空");
		starBox.setBounds(LEFTIN_X, JL_HEIGHT * 5 + GAP, 60, TEXT_H);
		add(starBox);

		hotelNameField = new JTextField();
		hotelNameField.setBounds(LEFTIN_X, JL_HEIGHT * 6 + GAP, 300, TEXT_H);
		hotelNameField.setFont(font);
		add(hotelNameField);
	}

	private void setRightLabel() {

		JLabel commercialJL = new CommonLabel("商    圈*", JLabel.LEFT);
		commercialJL.setBounds(RIGHTJL_X, JL_HEIGHT, JL_WIDTH, JL_HEIGHT);
		add(commercialJL);

		JLabel checkOutJL = new CommonLabel("退房时间*", JLabel.LEFT);
		checkOutJL.setBounds(RIGHTJL_X, JL_HEIGHT * 2, JL_WIDTH, JL_HEIGHT);
		add(checkOutJL);

		JLabel roomNumJL = new CommonLabel("房间数量", JLabel.LEFT);
		roomNumJL.setBounds(RIGHTJL_X, JL_HEIGHT * 3, JL_WIDTH, JL_HEIGHT);
		add(roomNumJL);

		JLabel scoreJL = new CommonLabel("评分区间", JLabel.LEFT);
		scoreJL.setBounds(RIGHTJL_X, JL_HEIGHT * 4, JL_WIDTH, JL_HEIGHT);
		add(scoreJL);

		// JLabel hasOrderedJL = new CommonLabel("我曾预订过的酒店", JLabel.LEFT);
		// hasOrderedJL.setBounds(RIGHTJL_X, JL_HEIGHT*5,168, JL_HEIGHT);
		// add(hasOrderedJL);
	}

	private void setLeftLabel() {

		JLabel cityJL = new CommonLabel("城    市*", JLabel.LEFT);
		cityJL.setBounds(LEFTJL_X, JL_HEIGHT, JL_WIDTH, JL_HEIGHT);
		add(cityJL);

		JLabel checkInJL = new CommonLabel("入住时间*", JLabel.LEFT);
		checkInJL.setBounds(LEFTJL_X, JL_HEIGHT * 2, JL_WIDTH, JL_HEIGHT);
		add(checkInJL);

		JLabel roomTypeJL = new CommonLabel("房间类型", JLabel.LEFT);
		roomTypeJL.setBounds(LEFTJL_X, JL_HEIGHT * 3, JL_WIDTH, JL_HEIGHT);
		add(roomTypeJL);

		JLabel valueJL = new CommonLabel("价格区间", JLabel.LEFT);
		valueJL.setBounds(LEFTJL_X, JL_HEIGHT * 4, JL_WIDTH, JL_HEIGHT);
		add(valueJL);

		JLabel starJL = new CommonLabel("酒店星级", JLabel.LEFT);
		starJL.setBounds(LEFTJL_X, JL_HEIGHT * 5, JL_WIDTH, JL_HEIGHT);
		add(starJL);

		JLabel hotelNameJL = new CommonLabel("酒店名称", JLabel.LEFT);
		hotelNameJL.setBounds(LEFTJL_X, JL_HEIGHT * 6, JL_WIDTH, JL_HEIGHT);
		add(hotelNameJL);

	}

	public Map<HotelVO, List<RoomVO>> findHotels() {
		Map<HotelVO, List<RoomVO>> hotels = new HashMap<>();

		int locID = getLocID();
		int circleID = 1;

		// 得到商圈ID
		List<CommercialCircleVO> circles = controller.findCircleByLoc(locID);
		for (CommercialCircleVO vo : circles) {
			if (vo.name.equals((String) commercialBox.getSelectedItem())) {
				circleID = vo.id;
				break;
			}

		}

		Date begin = checkInDate.getDate();
		Date end = checkOutDate.getDate();

		try {
			hotels = controller.findHotels(locID, circleID, begin, end, userVO.username);
		} catch (HotelNotFoundException e) {

		}
		return hotels;
	}

	// 城市选择改变时，改变商圈
	public void changeCity() {
		commercialBox.removeAllItems();
		int locID = getLocID();

		List<CommercialCircleVO> circles = controller.findCircleByLoc(locID);
		for (CommercialCircleVO vo : circles) {
			commercialBox.addItem(vo.name);
		}

	}

	// 根据城市名得到ID
	private int getLocID() {
		int locID = 1;
		for (LocationVO vo : locs) {
			if (vo.name.equals((String) cityBox.getSelectedItem())) {
				locID = vo.id;
				break;
			}

		}
		return locID;
	}

	public List<FilterCondition> getFilters() {
		List<FilterCondition> list = new ArrayList<>();
		RoomTypeFilterCondition RoomTypeFilter = new RoomTypeFilterCondition(FilterType.RoomType);
		NameFilterCondition nameFilter = new NameFilterCondition(FilterType.Name);
		ScoreFilterCondition scoreFilter = new ScoreFilterCondition(FilterType.Score);
		StarFilterCondition starFilter = new StarFilterCondition(FilterType.Star);
		ValueFilterCondition valueFilter = new ValueFilterCondition(FilterType.Value);
		IfOrderedFilterCondition ifOrderedFilter = new IfOrderedFilterCondition(FilterType.IfOrdered);
		RoomNumFilterCondition roomNumFilter = new RoomNumFilterCondition(FilterType.RoomNum);

		if (roomTypeBox.getSelectedItem() != "无限制") {
			RoomTypeFilter.setRoomType(RoomType.getRoomType((String) roomTypeBox.getSelectedItem()));
			;
			list.add(RoomTypeFilter);
		}

		nameFilter.setHotelName(hotelNameField.getText());
		list.add(nameFilter);

		if (scoreField.getLow() != null && scoreField.getHigh() != null) {
			scoreFilter.setLow(scoreField.getLow());
			scoreFilter.setHigh(scoreField.getHigh());
			list.add(scoreFilter);
		}
		if (valueField.getLow() != null && valueField.getHigh() != null) {
			valueFilter.setLow(valueField.getLow());
			valueFilter.setHigh(valueField.getHigh());
			list.add(valueFilter);
		}
		if ( !starBox.getSelectedItem().equals("空")) {
			int star = Integer.parseInt((String)starBox.getSelectedItem());
			starFilter.setStar(star);
			list.add(starFilter);
		}
		if (hasOrderedBox.isSelected())
			list.add(ifOrderedFilter);
		if (roomNumField.getText().equals("")) {
		} else {
			 
			 System.out.println(Integer.parseInt(roomNumField.getText()));
			 roomNumFilter.setRoomNum(Integer.parseInt(roomNumField.getText()));
			 list.add(roomNumFilter);
		}
		return list;
	}

	public RoomType getRoomType() {
		if (!roomTypeBox.getSelectedItem() .equals("无限制") ) {
			return RoomType.getRoomType((String) roomTypeBox.getSelectedItem());
		}
		return null;
	}

	public BeginAndLeaveTime getOrderTime() {
		return new BeginAndLeaveTime(checkInDate.getDate(), checkOutDate.getDate());
	}

	

}
