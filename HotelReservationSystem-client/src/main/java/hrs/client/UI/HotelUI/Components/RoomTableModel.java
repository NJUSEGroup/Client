package hrs.client.UI.HotelUI.Components;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import hrs.common.VO.RoomVO;

public class RoomTableModel implements TableModel{

	private List<RoomVO> rooms;
	
	public RoomTableModel(){
		
	}
	
	public RoomTableModel(List<RoomVO> rooms){
		this.rooms = rooms;
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		
		return rooms.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		
		return 3;
	}

	@Override
	public String getColumnName(int columnIndex) {
		// TODO Auto-generated method stub
		
		List<String> tableHeader = new ArrayList<>();
		
		tableHeader.add("房间类型");
		tableHeader.add("房间数量");
		tableHeader.add("原始价格");
		
		return tableHeader.get(columnIndex);
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
		RoomVO room = rooms.get(rowIndex);
		
		//房间类型
		if (columnIndex == 0) {
			String roomType = room.type.toString();
			
			if(roomType.equals("Single")){
				return "单人房";
			}
			else if(roomType.equals("Double")){
				return "双人房";
			}
			else if(roomType.equals("KingSize")){
				return "大床间";
			}
			else if(roomType.equals("Standard")){
				return "标准间";
			}
			else if(roomType.equals("Deluxe")){
				return "豪华间";
			}
			else if(roomType.equals("Business")){
				return "商务标间";
			}
			else{
				return "行政标间";
			}
		}
		
		//房间数量
		else if (columnIndex == 1){
			int num = room.roomNum;
			String roomNum = Integer.toString(num);
			
			return roomNum;
		}
		
		//原始价格
		else if (columnIndex == 2) {
			double money = room.roomValue;
			String roomMoney = Double.toString(money);
			
			return roomMoney;
		}
		
		return null;
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
