package hrs.client.UI.UserUI.HotelSearchUI;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import hrs.common.VO.HotelDiscountVO;
import hrs.common.VO.WebDiscountVO;
import hrs.common.util.type.HotelDiscountType;
import hrs.common.util.type.WebsiteDiscountType;

public class DiscountTableModel implements TableModel {
	Map<WebDiscountVO,Double> webDiscountsAndDouble;
	Map<HotelDiscountVO,Double> hotelDiscountsAndDouble;
	List<WebDiscountVO> webDiscounts;
	List<HotelDiscountVO> hotelDiscounts;
	List<Double> webDoubles;
	List<Double> hotelDoubles;
	private int webSize ;
	private int hotelSize ;
	public DiscountTableModel(Map<WebDiscountVO,Double> webDiscountsAndDouble,Map<HotelDiscountVO,Double> hotelDiscountsAndDouble) {
		this.webDiscountsAndDouble = webDiscountsAndDouble;
		this.hotelDiscountsAndDouble = hotelDiscountsAndDouble;
		
		webDiscounts = new ArrayList<>();
		hotelDiscounts = new ArrayList<>();
		webDoubles = new ArrayList<>();
		hotelDoubles = new ArrayList<>();
		
		Iterator<Entry<WebDiscountVO,Double>> iter = ((Map<WebDiscountVO,Double>) webDiscountsAndDouble).entrySet().iterator();
		while (iter.hasNext()) {
			@SuppressWarnings("rawtypes")
			Map.Entry entry = (Map.Entry) iter.next();
			WebDiscountVO key = (WebDiscountVO) entry.getKey();
			Double d = (Double) entry.getValue();
			webDiscounts.add(key);
			webDoubles.add(d);
			
		}
		
		Iterator<Entry<HotelDiscountVO,Double>> newiter = ((Map<HotelDiscountVO,Double>) hotelDiscountsAndDouble).entrySet().iterator();
		while (newiter.hasNext()) {
			@SuppressWarnings("rawtypes")
			Map.Entry entry = (Map.Entry) newiter.next();
			HotelDiscountVO key = (HotelDiscountVO) entry.getKey();
			Double d = (Double) entry.getValue();
			hotelDiscounts.add(key);
			hotelDoubles.add(d);
		}
		
		webSize = webDiscounts.size();
		hotelSize = hotelDiscounts.size();
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return webDiscounts.size()+hotelDiscounts.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public String getColumnName(int columnIndex) {
		String[] l = {"该订单享受优惠","优惠策略","折扣金额","",""};
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
		DecimalFormat decimalFormat = new DecimalFormat("0.00");
		if(rowIndex<webSize){
			WebDiscountVO webDiscount = webDiscounts.get(rowIndex);
			String[] result = {"网站促销",WebsiteDiscountType.toDiscountName(webDiscount.type),decimalFormat.format(webDoubles.get(rowIndex))+"","",""};
			return result[columnIndex];
		}
		else {
			HotelDiscountVO hotelDiscount = hotelDiscounts.get(rowIndex-webSize);
			String[] result = {"酒店促销",HotelDiscountType.toDiscountName(hotelDiscount.type),decimalFormat.format(hotelDoubles.get(rowIndex-webSize))+""+"","",""};
			return result[columnIndex];
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

}
