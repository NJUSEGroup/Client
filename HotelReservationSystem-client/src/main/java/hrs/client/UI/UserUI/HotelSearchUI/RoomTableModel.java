package hrs.client.UI.UserUI.HotelSearchUI;

import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import hrs.client.util.EnumHelper;
import hrs.common.VO.RoomVO;

public class RoomTableModel implements TableModel {
	private List<RoomVO> rooms;
	
	public RoomTableModel(List<RoomVO> rooms) {
		this.rooms = rooms;
	}
	@Override
	public int getRowCount() {
		return rooms.size();
	}

	@Override
	public int getColumnCount() {
		
		return 6;
	}

	@Override
	public String getColumnName(int columnIndex) {
		String[] l = {"房间类型","价格(元/间)","","","",""};
		return l[columnIndex];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		
		return String.class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		RoomVO room = rooms.get(rowIndex);
		String[] l = {EnumHelper.RoomFormat(room.type),room.roomValue+"","","","",""};
		return l[columnIndex];
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
