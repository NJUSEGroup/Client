package hrs.client.UI.WebMarketUI.CreditChargeUI;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import hrs.common.VO.UserVO;
import hrs.common.util.DateHelper;

public class CreditChargeModel implements TableModel {
	private UserVO userVO;

	public CreditChargeModel() {

	}

	public CreditChargeModel(UserVO userVO) {
		this.userVO = userVO;

	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 6;
	}

	@Override
	public String getColumnName(int columnIndex) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
		list.add("用户名");
		list.add("真实姓名");
		list.add("生日");
		list.add("联系方式");
		list.add("企业名称");
		list.add("信用值");
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
		try {
			if (columnIndex == 0) {
				return userVO.username;
			} else if (columnIndex == 1) {
				return userVO.name;
			} else if (columnIndex == 2) {
				Date date = userVO.birthDate;
				String string = DateHelper.format(date);
				return string;
			} else if (columnIndex == 3) {
				return userVO.phone;
			} else if (columnIndex == 4) {
				return userVO.enterprise;
			} else {
				String string = userVO.credit + "";
				return string;
			}
		} catch (Exception e) {
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

}
