package hrs.client.UI.WebMarketUI.WebOrderUI;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import hrs.common.VO.OrderVO;
import hrs.common.util.DateHelper;

public class WebOrderModel implements TableModel {
	private List<OrderVO> ordervoList;
	private ResourceBundle rb = ResourceBundle.getBundle("orderStatus", Locale.getDefault());
	private ResourceBundle rb_Second = ResourceBundle.getBundle("hotel", Locale.getDefault());
	
	public WebOrderModel(List<OrderVO> orderVoList) {
		// TODO Auto-generated constructor stub
		this.ordervoList = orderVoList;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return ordervoList.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 9;
	}

	@Override
	public String getColumnName(int columnIndex) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
		list.add("订单号");
		list.add("下单时间");
		list.add("执行时间");
		list.add("用户名");
		list.add("酒店名称");
		list.add("房间类型");
		list.add("房间数量");
		list.add("金额");
		list.add("订单状态");
		return list.get(columnIndex);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		return String.class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		OrderVO orderVO = ordervoList.get(rowIndex);
		try {
			if (columnIndex == 0) {
				return orderVO.id;
			} else if (columnIndex == 1) {
				Date date = orderVO.placeTime;
				String string = DateHelper.format(date);
				return string;
			} else if (columnIndex == 2) {
				Date date = orderVO.execTime;
				String string = DateHelper.format(date);
				return string;
			} else if (columnIndex == 3) {
				return orderVO.user.username;
			} else if (columnIndex == 4) {
				return orderVO.hotel.name;
			} else if (columnIndex == 5) {
				String type = rb_Second.getString("Room." + orderVO.type.toString());
				return type;
			} else if (columnIndex == 6) {
				return orderVO.roomNum + "";
			} else if (columnIndex == 7) {
				return orderVO.value + "";
			} else {
				String outputType = rb.getString("Order." + orderVO.status.toString());
				return outputType;
			}

		} catch (NullPointerException e) {
			// TODO: handle exception
			return "";
		}

	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

	public OrderVO getValue(int selectedRow) {
		// TODO Auto-generated method stub
		return ordervoList.get(selectedRow);
	}

}
