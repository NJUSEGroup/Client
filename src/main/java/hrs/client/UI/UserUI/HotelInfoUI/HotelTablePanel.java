package hrs.client.UI.UserUI.HotelInfoUI;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import hrs.client.UI.UserUI.Components.CommonPanel;
import hrs.client.UI.UserUI.Components.CommonTable;
import hrs.client.UI.UserUI.HotelInfoUI.Listener.DetailInfoListener;
import hrs.client.UI.UserUI.HotelInfoUI.Listener.HotelTableListener;
import hrs.client.UI.UserUI.HotelSearchUI.SearchResultTableModel;
import hrs.client.util.ControllerFactory;
import hrs.client.util.HMSBlueButton;
import hrs.client.util.UIConstants;
import hrs.common.Controller.UserController.IUserHotelController;
import hrs.common.Exception.OrderService.OrderNotFoundException;
import hrs.common.VO.HotelVO;
import hrs.common.VO.OrderVO;
import hrs.common.VO.UserVO;

/**
 * 以列表显示所有预订过的酒店
 * @author 涵
 *
 */
public class HotelTablePanel extends CommonPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8321086070784935629L;
	private JScrollPane scrollPane;
	private JTable table;
	private UserVO user;
	private HMSBlueButton detailJB;
	private HotelInfoPanel panel;
	Font font = UIConstants.JLABEL_FONT;
	private IUserHotelController controller;
	public HotelTablePanel(UserVO user,HotelInfoPanel panel) {
		this.user = user;
		this.panel = panel;
		controller = ControllerFactory.getUserHotelController();
		init();
	}
	@Override
	public void init() {
		table = new CommonTable();
		
		
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);
		scrollPane.setBounds(30, 30, 1020, 550);
		// scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setBorder(BorderFactory.createLineBorder(new Color(145, 189, 214), 2));
		scrollPane.getViewport().setBackground(new Color(211, 237, 249));
		scrollPane.setOpaque(true);
		
		table.addMouseListener(new HotelTableListener(this));
		
		IUserHotelController controller = ControllerFactory.getUserHotelController();
		Map<HotelVO, List<OrderVO>> map = new HashMap<>();
		try {
			map = controller.findOrderedHotelAndOrder(user.username);
		} catch (OrderNotFoundException e) {
			
			
		} 
		
		List<HotelVO> hotels = new ArrayList<>();
		Iterator<Entry<HotelVO, List<OrderVO>>> iter = ((Map<HotelVO, List<OrderVO>>) map).entrySet().iterator();
		while (iter.hasNext()) {
			@SuppressWarnings("rawtypes")
			Map.Entry entry = (Map.Entry) iter.next();
			HotelVO key = (HotelVO) entry.getKey();
			hotels.add(key);
		}
		
		table.setModel(new SearchResultTableModel(hotels));
		add(scrollPane);
		
		setDetailTable();
	}
	private void setDetailTable() {
		detailJB = new HMSBlueButton("详细信息");
		detailJB.setFont(font);
		detailJB.setBounds(this.getWidth() - 230, 645, 120, 40);
		detailJB.setEnabled(false);
		detailJB.addActionListener(new DetailInfoListener(this));
		add(detailJB);
		
	}
	public void showDetail() {
		int i = table.getSelectedRow();
		String hotelName = (String)table.getValueAt(i, 0);
		
		Map<HotelVO, List<OrderVO>> map = new HashMap<>();
		try {
			map = controller.findOrderedHotelAndOrder(user.username);
		} catch (OrderNotFoundException e) {
		}
		
		HotelVO hotel = null;
		Iterator<Entry<HotelVO, List<OrderVO>>> iter = ((Map<HotelVO, List<OrderVO>>) map).entrySet().iterator();
		while (iter.hasNext()) {
			@SuppressWarnings("rawtypes")
			Map.Entry entry = (Map.Entry) iter.next();
			HotelVO key = (HotelVO) entry.getKey();
			if(key.name.equals(hotelName) ){
				hotel = key;
				break;
			}
			
		}
		
		panel.showDetail(hotel);
		
		
		
		
		
		
	}
	public void setButtonStatus() {
		int i = table.getSelectedRow();
		if(i != -1){
			detailJB.setEnabled(true);
		}
		
		
	}

}
