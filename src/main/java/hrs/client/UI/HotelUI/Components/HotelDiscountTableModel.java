package hrs.client.UI.HotelUI.Components;


import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import hrs.common.VO.HotelDiscountVO;
import hrs.common.util.DateHelper;

public class HotelDiscountTableModel implements TableModel{

	private List<HotelDiscountVO> discounts;
	
	public HotelDiscountTableModel(){
		
	}
	
	public HotelDiscountTableModel(List<HotelDiscountVO> discounts){
		this.discounts = discounts;
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		
		return discounts.size();
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
		
		tableHeader.add("折扣类型");
		tableHeader.add("开始时间");
		tableHeader.add("结束时间");
		tableHeader.add("最小房间预订数量");
		tableHeader.add("合作企业");
		tableHeader.add("折扣信息");
		
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
		HotelDiscountVO discount = discounts.get(rowIndex);
		
		//折扣类型
		if (columnIndex == 0) {
			String discountType = discount.type.toString();
			
			if(discountType.equals("Birthday")){
				return "生日特惠折扣";
			}
			else if(discountType.equals("LargeQty")){
				return "房间预订特惠";
			}
			else if(discountType.equals("Enterprise")){
				return "合作企业客户折扣";
			}
			else{
				return "特定期间折扣";
			}
		}
		
		//开始时间
		else if (columnIndex == 1){
			String beginDate = DateHelper.format(discount.beginTime);
			
			return beginDate;
		}
		
		//结束时间
		else if (columnIndex == 2) {
			String endDate = DateHelper.format(discount.endTime);
			
			return endDate;
		}
		
		//最小房间预订数量
		else if (columnIndex == 3){
			String roomNum = Integer.toString(discount.minQty);
			
			return roomNum;
		}
		
		//合作企业
		else if (columnIndex == 4){
			String firm = "";
			try {
				firm = discount.enterprise.name;
			} catch (NullPointerException e) {
				// TODO Auto-generated catch block
				firm = "";
			}
			
			return firm;
		}
		
		//折扣信息
		else if (columnIndex == 5){
			String discountInfo = Double.toString(discount.discount);
			
			return discountInfo;
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

