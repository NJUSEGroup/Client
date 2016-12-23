package hrs.client.UI.HotelUI.Components;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import hrs.common.VO.OfflineRecordVO;
import hrs.common.util.DateHelper;

public class OfflineRecordTableModel implements TableModel{

	private List<OfflineRecordVO> offlineRecord;
	
	public OfflineRecordTableModel(List<OfflineRecordVO> offlineRecord){
		this.offlineRecord = offlineRecord;
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		
		return offlineRecord.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		
		return 6;
	}

	@Override
	public String getColumnName(int columnIndex) {
		// TODO Auto-generated method stub
		
		List<String> tableHeader = new ArrayList<>();
		
		tableHeader.add("ID");
		tableHeader.add("入住时间");
		tableHeader.add("预计离开时间");
		tableHeader.add("退房时间");
		tableHeader.add("房间类型");
		tableHeader.add("房间数量");
		
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
		
		OfflineRecordVO record = offlineRecord.get(rowIndex);
		
		//ID
		if (columnIndex == 0) {
			String id = Integer.toString(record.id);
			
			if(id.equals("0")){
				return "";
			}
			else{
				return id;
			}
		}
		
		//入住时间
		else if (columnIndex == 1){
			String checkinDate = DateHelper.format(record.checkinTime);
			
			return checkinDate;
		}
		
		//预计离开时间
		else if (columnIndex == 2) {
			String expectedCheckoutDate = DateHelper.format(record.expectedCheckoutTime);
			
			return expectedCheckoutDate;
		}
		
		//退房时间
		else if (columnIndex == 3){
			String checkoutDate = DateHelper.format(record.checkoutTime);
			
			return checkoutDate;
		}
		
		//房间类型
		else if (columnIndex == 4){
			String roomType = "";
			
			try {
				roomType = record.type.toString();
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
			} catch (NullPointerException e) {
				// TODO Auto-generated catch block
				return "";
			}
		
		}
		
		//房间数量
		else if (columnIndex == 5){
			String roomNum = Integer.toString(record.num);
			
			if(roomNum.equals("0")){
				return "";
			}
			else{
				return roomNum;
			}
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
