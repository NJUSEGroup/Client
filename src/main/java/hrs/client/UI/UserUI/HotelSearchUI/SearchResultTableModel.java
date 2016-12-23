package hrs.client.UI.UserUI.HotelSearchUI;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import org.springframework.beans.factory.support.ManagedList;

import hrs.common.VO.HotelVO;
import hrs.common.VO.RoomVO;

public class SearchResultTableModel implements TableModel {
	private List<HotelVO> hotels;
	
	
	public SearchResultTableModel(List<HotelVO> hotels) {
		this.hotels = hotels;
		
		
//		allInfo = new ArrayList<>();
//		Iterator<Entry<HotelVO, List<RoomVO>>> iter = hotels.entrySet().iterator();
//		while (iter.hasNext()) {
//			@SuppressWarnings("rawtypes")
//			Map.Entry entry = (Map.Entry) iter.next();
//			HotelVO key = (HotelVO) entry.getKey();
//			allInfo.add(key);
//		}
		
	}
	
	@Override
	public int getRowCount() {
		return hotels.size();
	}

	@Override
	public int getColumnCount() {
		//四列：酒店名称，酒店地址，星级，评分
		return 4;
	}

	@Override
	public String getColumnName(int columnIndex) {
		// TODO Auto-generated method stub
		String[] l = {"酒店名称","酒店地址","星级","评分"};
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
		list.add(currentInfo.name);
		list.add(currentInfo.location.name+currentInfo.street);
		list.add(currentInfo.star+"");
		list.add(currentInfo.score+"");
		
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
