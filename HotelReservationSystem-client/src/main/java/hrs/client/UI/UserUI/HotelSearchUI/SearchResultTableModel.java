package hrs.client.UI.UserUI.HotelSearchUI;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import org.springframework.core.annotation.Order;

import hrs.common.VO.HotelVO;
import hrs.common.util.type.OrderStatus;

public class SearchResultTableModel implements TableModel {
	private ResourceBundle rb = ResourceBundle.getBundle("orderStatus", Locale.getDefault());
	private List<HotelVO> hotels;

	public SearchResultTableModel(List<HotelVO> hotels) {
		this.hotels = hotels;

		// allInfo = new ArrayList<>();
		// Iterator<Entry<HotelVO, List<RoomVO>>> iter =
		// hotels.entrySet().iterator();
		// while (iter.hasNext()) {
		// @SuppressWarnings("rawtypes")
		// Map.Entry entry = (Map.Entry) iter.next();
		// HotelVO key = (HotelVO) entry.getKey();
		// allInfo.add(key);
		// }

	}

	@Override
	public int getRowCount() {
		return hotels.size();
	}

	@Override
	public int getColumnCount() {
		// 四列：酒店名称，酒店地址，星级，评分,价格
		return 5;
	}

	@Override
	public String getColumnName(int columnIndex) {
		// TODO Auto-generated method stub
		String[] l = { "酒店名称", "酒店地址", "星级", "评分" ,"价格区间"};
		return l[columnIndex];
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
		
		HotelVO currentInfo = hotels.get(rowIndex);
		List<String> list = new ArrayList<>();
//		Iterator<OrderStatus> it = currentInfo.status.iterator();
		String name = currentInfo.name;
		if(!currentInfo.hasOrdered){
			name = name + " (未预订过)";
		}
		else
			name = name + " (已预订过)";
//		while (it.hasNext()) {
//		OrderStatus status = it.next();
//		String str = rb.getString("Order." + status.toString());
//		name = name + " " + str;
//		}
		list.add(name);
		list.add(currentInfo.location.name+currentInfo.street);
		list.add(currentInfo.star+"");
		list.add(currentInfo.score+"");
		list.add(currentInfo.lowValue + " ~ " +currentInfo.highValue);
		
		return list.get(columnIndex);
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

}
