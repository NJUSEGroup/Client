package hrs.client.UI.WebMarketUI.WebDiscountUI;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import hrs.common.VO.WebDiscountVO;
import hrs.common.util.DateHelper;

public class WebDiscountModel implements TableModel {
	private List<WebDiscountVO> webDiscountList;
	private ResourceBundle rb = ResourceBundle.getBundle("webDiscount", Locale.getDefault());

	public WebDiscountModel(List<WebDiscountVO> webDiscountList) {
		// TODO Auto-generated constructor stub
		this.webDiscountList = webDiscountList;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		//
		return webDiscountList.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 7;
	}

	@Override
	public String getColumnName(int columnIndex) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
		list.add("折扣类型");
		list.add("开始时间");
		list.add("结束时间");
		list.add("城市");
		list.add("商圈");
		list.add("VIP等级");
		list.add("折扣信息");
		return list.get(columnIndex);
	}

	// location!!
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		return String.class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		WebDiscountVO webDiscountVO = webDiscountList.get(rowIndex);
		try {
			if (columnIndex == 0) {
				String outputType = rb.getString("WebDiscount." + webDiscountVO.type.toString());
				return outputType;
			} else if (columnIndex == 1) {
				Date date = webDiscountVO.beginTime;
				String string = DateHelper.format(date);
				return string;

			} else if (columnIndex == 2) {
				Date date = webDiscountVO.endTime;
				String string = DateHelper.format(date);
				return string;
			} else if (columnIndex == 3) {
				return webDiscountVO.location.name;
			} else if (columnIndex == 4) {
				// System.out.println(webDiscountVO .commercialCircle.name);
				return webDiscountVO.commercialCircle.name;

			} else if (columnIndex == 5) {
				return webDiscountVO.VIPlevel + "";
			} else {
				String string = webDiscountVO.discount + "";
				return string;
			}
		} catch (NullPointerException e) {
			return "";
		}
	}

	public WebDiscountVO getValue(int rowIndex) {
		return webDiscountList.get(rowIndex);
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