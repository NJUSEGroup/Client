package hrs.client.UI.UserUI.HotelSearchUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

import org.springframework.core.annotation.Order;

import hrs.client.UI.UserUI.Components.CommonLabel;
import hrs.client.UI.UserUI.Components.CommonPanel;
import hrs.client.UI.UserUI.Components.CommonTable;
import hrs.client.UI.UserUI.HotelSearchUI.Listener.DetailListener;
import hrs.client.UI.UserUI.HotelSearchUI.Listener.OrderListener;
import hrs.client.UI.UserUI.HotelSearchUI.Listener.SearchListener;
import hrs.client.UI.UserUI.HotelSearchUI.Listener.SearchTableListener;
import hrs.client.util.ControllerFactory;
import hrs.client.util.HMSBlueButton;
import hrs.client.util.UIConstants;
import hrs.common.Controller.UserController.IUserHotelController;
import hrs.common.VO.HotelVO;
import hrs.common.VO.RoomVO;
import hrs.common.VO.UserVO;
import hrs.common.util.FilterCondition.FilterCondition;
import hrs.common.util.type.OrderRule;
import hrs.common.util.type.RoomType;

/**
 * 酒店搜索面板 含有显示搜索结果的表格
 * 
 * @author 涵
 *
 */
public class HotelSearchPanel extends CommonPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 666845916774725335L;
	private UserVO user;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private SearchPanel searchPanel;
	private IUserHotelController controller;
	private CommonTable table;
	private HMSBlueButton orderJB;
	private HMSBlueButton detailJB;
	private HotelPanel panel;
	
	private JRadioButton priceButton;
	private JRadioButton starButton;
	private JRadioButton scoreButton;
	private JRadioButton lowToHighButton;
	private JRadioButton highToLowButton;
	
	private ButtonGroup conditionGroup;
	private ButtonGroup wayGroup;

	Font font = UIConstants.JLABEL_FONT;

	public HotelSearchPanel(UserVO user) {
		this.user = user;
		controller = ControllerFactory.getUserHotelController();
		init();
	}

	@Override
	public void init() {
		setLayout(null);

		contentPane = new JPanel();
//		contentPane.setBounds(0, 30, this.getWidth(), this.getHeight());
		contentPane.setBackground(UIConstants.JFRAME);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(contentPane);
		scrollPane.setBounds(0, 13, 1063, 772);
//		scrollPane.setBorder(BorderFactory.createLineBorder(new Color(145, 189, 214), 2));
		scrollPane.getViewport().setBackground(new Color(211, 237, 249));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setOpaque(true);
		
		
		contentPane.setPreferredSize(new Dimension(this.getWidth()-30,1000));
		contentPane.revalidate();

		add(scrollPane);

		setdownButton();// 立即下单和详细信息按钮
		setSearchPanel();
		setSearchButton();// 搜索按钮
		setTable();

		// scrollPane = new JScrollPane(contentPane);
		// scrollPane.setBounds(0, 30, this.getWidth(),this.getHeight()-30);
		// scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		// add(scrollPane);

	}

	public void setPanel(HotelPanel panel) {
		this.panel = panel;
	}

	private void setdownButton() {

		detailJB = new HMSBlueButton("详细信息");
		// detailJB.setFont(font);
		detailJB.setBounds(774, 850, 120, 40);
		detailJB.setEnabled(false);
		detailJB.addActionListener(new DetailListener(this));
		contentPane.add(detailJB);

		orderJB = new HMSBlueButton("立即下单");
		orderJB.setBounds(930, 850, 120, 40);
		// orderJB.setFont(font);
		orderJB.setEnabled(false);
		orderJB.addActionListener(new OrderListener(this));
		contentPane.add(orderJB);

	}

	private void setTable() {
		// 默认空表
		table = new CommonTable();


		
		List<HotelVO> hotels = new ArrayList<>();

		table.setModel(new SearchResultTableModel(hotels));
		table.addMouseListener(new SearchTableListener(this));
		
		JScrollPane tableScrollPane = new JScrollPane();
		tableScrollPane.setViewportView(table);
		tableScrollPane.setBounds(12, 555, 1036, 232);
		tableScrollPane.setBorder(BorderFactory.createLineBorder(new Color(145, 189, 214), 2));
		tableScrollPane.getViewport().setBackground(new Color(211, 237, 249));
		tableScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		tableScrollPane.setOpaque(true);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(350);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		table.getColumnModel().getColumn(3).setPreferredWidth(150);
		table.getColumnModel().getColumn(4).setPreferredWidth(220);
		
//		table.setBounds(30, 617, 1020, 233);
//		table.setOpaque(true);
//		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		contentPane.add(tableScrollPane);
		
		JPanel sortPanel = new JPanel();
		sortPanel.setBorder(new LineBorder(new Color(145, 189, 214), 3));
		sortPanel.setBackground(UIConstants.JFRAME);
		sortPanel.setBounds(12, 346, 1008, 114);
		sortPanel.setLayout(null);
		contentPane.add(sortPanel);
		
		JLabel conditionJL = new CommonLabel("条件", JLabel.LEFT);;
		conditionJL.setBounds(14, 13, 97, 35);
		sortPanel.add(conditionJL);
		
		JLabel requireJL = new CommonLabel("排序要求", JLabel.LEFT);
		requireJL.setText("排序方式");
		requireJL.setBounds(14, 49, 97, 35);
		sortPanel.add(requireJL);
		
		priceButton = new JRadioButton("价格");
		priceButton.setFont(font);
		priceButton.setBackground(UIConstants.JFRAME);
		priceButton.setBounds(109, 20, 157, 27);
		sortPanel.add(priceButton);
		
		starButton = new JRadioButton("星级");
		starButton.setBackground(UIConstants.JFRAME);
		starButton.setFont(font);
		starButton.setBounds(307, 20, 157, 27);
		sortPanel.add(starButton);
		
		scoreButton = new JRadioButton("评分");
		scoreButton.setBackground(UIConstants.JFRAME);
		scoreButton.setFont(font);
		scoreButton.setBounds(504, 20, 157, 27);
		sortPanel.add(scoreButton);
		
		conditionGroup = new ButtonGroup();
		conditionGroup.add(scoreButton);
		conditionGroup.add(starButton);
		conditionGroup.add(priceButton);
		
		lowToHighButton = new JRadioButton("从高到低");
		lowToHighButton.setBackground(UIConstants.JFRAME);
		lowToHighButton.setFont(font);
		lowToHighButton.setBounds(109, 57, 157, 27);
		sortPanel.add(lowToHighButton);
		
		highToLowButton = new JRadioButton("从低到高");
		highToLowButton.setBackground(UIConstants.JFRAME);
		highToLowButton.setSelected(true);
		highToLowButton.setFont(font);
		highToLowButton.setBounds(307, 56, 157, 27);
		sortPanel.add(highToLowButton);
		
		wayGroup = new ButtonGroup();
		wayGroup.add(highToLowButton);
		wayGroup.add(lowToHighButton);
		
		JLabel sortLabel= new CommonLabel("排序", JLabel.LEFT);
		sortLabel.setBackground(new Color(145, 179, 179));
		sortLabel.setBounds(10, 312, 1010, 34);
		sortLabel.setOpaque(true);
		contentPane.add(sortLabel);
//		contentPane.add(scrollPane);

	}

	

	private void setSearchPanel() {
		searchPanel = new SearchPanel(user);
		searchPanel.setBounds(12, 0, 1008, 283);
		contentPane.add(searchPanel);
	}

	private void setSearchButton() {
		HMSBlueButton searchJB = new HMSBlueButton("搜索");
		searchJB.setBounds(920, 475, 100, 40);
		// searchJB.setFont(font);
		contentPane.add(searchJB);
		searchJB.addActionListener(new SearchListener(this));
	}

	public void doSearch() {
		BeginAndLeaveTime orderTime = getOrderTime();
		if (orderTime.endTime.before(orderTime.beginTime)) {
			JOptionPane.showMessageDialog(null, "退房时间需比入住时间晚!", "提示", JOptionPane.INFORMATION_MESSAGE);
			List<HotelVO> hotels = new ArrayList<>();
			table.setModel(new SearchResultTableModel(hotels));
			return;
		}

		Map<HotelVO, List<RoomVO>> map = getSearchResult();
		Map<HotelVO, List<RoomVO>> newmap = null;

		List<FilterCondition> conditions = searchPanel.getFilters();// 从搜索条件面板中得到所有筛选条件

		if (conditions != null) {
			newmap = controller.filterHotels(map, conditions);
		}
		
		//从高到低还是从低到高
		boolean isDecrease = true;
		if(lowToHighButton.isSelected()){
			isDecrease = false;
		}
		
		//排序
		OrderRule  rule;
		if(priceButton.isSelected()){
			rule = OrderRule.Value;
			newmap = controller.orderHotels(newmap, rule, isDecrease);
		}
		else if (starButton.isSelected()){
			rule = OrderRule.Star;
			newmap = controller.orderHotels(newmap, rule, isDecrease);
		}
		else if(scoreButton.isSelected()){
			rule = OrderRule.Score;
			newmap = controller.orderHotels(newmap, rule, isDecrease);
		}
		
		
		List<HotelVO> hotels = new ArrayList<>();
		Iterator<Entry<HotelVO, List<RoomVO>>> iter = ((Map<HotelVO, List<RoomVO>>) newmap).entrySet().iterator();
		while (iter.hasNext()) {
			@SuppressWarnings("rawtypes")
			Map.Entry entry = (Map.Entry) iter.next();
			HotelVO key = (HotelVO) entry.getKey();
			hotels.add(key);
		}

		table.setModel(new SearchResultTableModel(hotels));
		table.getColumnModel().getColumn(0).setPreferredWidth(350);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		table.getColumnModel().getColumn(3).setPreferredWidth(150);
		table.getColumnModel().getColumn(4).setPreferredWidth(220);
		if (newmap.size() == 0) {
			JOptionPane.showMessageDialog(null, "未找到酒店!", "提示", JOptionPane.INFORMATION_MESSAGE);
		}
		detailJB.setEnabled(false);
		orderJB.setEnabled(false);
	}

	private Map<HotelVO, List<RoomVO>> getSearchResult() {
		return searchPanel.findHotels();
	}

	public void setButtonStatus() {
		int i = table.getSelectedRow();
		if (i != -1) {
			detailJB.setEnabled(true);
			orderJB.setEnabled(true);
		}

	}

	@SuppressWarnings("unchecked")
	public void showDetail() {
		Map<HotelVO, List<RoomVO>> map = getChooseOne();

		HotelVO hotel = null;
		List<RoomVO> rooms = new ArrayList<>();

		Iterator<Entry<HotelVO, List<RoomVO>>> iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			@SuppressWarnings("rawtypes")
			Map.Entry entry = (Map.Entry) iter.next();
			HotelVO key = (HotelVO) entry.getKey();
			hotel = key;
			rooms = (List<RoomVO>) entry.getValue();
			break;
		}

		RoomType type = searchPanel.getRoomType();

		List<RoomVO> resultRoom = new ArrayList<>();
		if (type != null) {
			for (RoomVO vo : rooms) {
				if (vo.type.equals(type)) {
					resultRoom.add(vo);
					break;
				}
			}
		} else {
			resultRoom = rooms;
		}
		panel.showDetail(hotel, resultRoom);

	}

	/**
	 * 返回需要显示的酒店详细信息 map里只有一个元素
	 * 
	 * @return
	 */
	@SuppressWarnings({ "unchecked" })
	private Map<HotelVO, List<RoomVO>> getChooseOne() {
		int i = table.getSelectedRow();
		String name = (String) table.getValueAt(i, 0);
		String[] infos = name.split(" ");
		name = infos[0];
		HotelVO hotel = null;
		List<RoomVO> rooms = null;

		Map<HotelVO, List<RoomVO>> map = getSearchResult();

		Iterator<Entry<HotelVO, List<RoomVO>>> iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			@SuppressWarnings("rawtypes")
			Map.Entry entry = (Map.Entry) iter.next();
			HotelVO key = (HotelVO) entry.getKey();
			if (key.name.equals(name)) {
				hotel = key;
				rooms = (List<RoomVO>) entry.getValue();
			}
		}

		Map<HotelVO, List<RoomVO>> result = new HashMap<>();
		result.put(hotel, rooms);
		return result;

	}

	private BeginAndLeaveTime getOrderTime() {
		return searchPanel.getOrderTime();
	}

	@SuppressWarnings("unchecked")
	public void placeOrder() {
		Map<HotelVO, List<RoomVO>> map = getChooseOne();

		HotelVO hotel = null;
		List<RoomVO> rooms = null;

		Iterator<Entry<HotelVO, List<RoomVO>>> iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			@SuppressWarnings("rawtypes")
			Map.Entry entry = (Map.Entry) iter.next();
			HotelVO key = (HotelVO) entry.getKey();
			hotel = key;
			rooms = (List<RoomVO>) entry.getValue();
			break;
		}

		BeginAndLeaveTime orderTime = getOrderTime();
		if (orderTime.endTime.before(orderTime.beginTime)) {
			JOptionPane.showMessageDialog(null, "退房时间需比入住时间晚!", "提示", JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		panel.showOrderPanel(hotel, rooms, orderTime, user);

	}
}
