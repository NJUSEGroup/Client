package hrs.client.UI.HotelUI.Components;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import hrs.common.VO.OrderVO;
import hrs.common.util.DateHelper;

public class OrderListTableModel implements TableModel{

	private List<OrderVO> orderList;
	
	public OrderListTableModel(List<OrderVO> orderList){
		this.orderList = orderList;
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		
			return orderList.size();
		
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		
		return 7;
	}

	@Override
	public String getColumnName(int columnIndex) {
		// TODO Auto-generated method stub
		
		List<String> tableHeader = new ArrayList<>();
		
		tableHeader.add("订单号");
		tableHeader.add("下单时间");
		tableHeader.add("用户名");
		tableHeader.add("房间类型");
		tableHeader.add("房间数量");
		tableHeader.add("金额");
		tableHeader.add("订单状态");
		
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
		OrderVO order = orderList.get(rowIndex);
		
		//订单号
		if (columnIndex == 0) {
			String ID = Integer.toString(order.id);
			
			return ID;
		}
		
		//下单时间
		else if (columnIndex == 1){
			String placeTime = DateHelper.format(order.placeTime);
			
			return placeTime;
		}
		
		//用户名
		else if (columnIndex == 2) {
			String username = order.user.username;
			return username;
		}
		
		//房间类型
		else if (columnIndex == 3) {
			String roomType = order.type.toString();
			
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
		else if(columnIndex == 4){
			String roomNum = Integer.toString(order.roomNum);

			return roomNum;
		}
		
		//金额
		else if(columnIndex == 5){
			String money = Double.toString(order.value);

			return money;
		}
		
		//订单状态
		else if(columnIndex == 6){
			String status = order.status.toString();
			
			if(status.equals("Unexecuted")){
				return "未执行";
			}
			else if(status.equals("Executed")){
				return "已执行";
			}
			else if(status.equals("Abnormal")){
				return "异常";
			}
			else if(status.equals("RevokedHalfValue")||status.equals("RevokedFullValue")||status.equals("UserRevoked")){
				return "已撤销";
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
