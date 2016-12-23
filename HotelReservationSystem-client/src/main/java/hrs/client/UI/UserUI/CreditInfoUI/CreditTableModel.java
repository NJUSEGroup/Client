package hrs.client.UI.UserUI.CreditInfoUI;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import hrs.common.VO.CreditRecordVO;
import hrs.common.util.DateHelper;
import hrs.common.util.type.CreditRecordType;

public class CreditTableModel implements TableModel {
	private List<CreditRecordVO> creditList;
	private ResourceBundle rb = ResourceBundle.getBundle("creditAction", Locale.getDefault());
	
	public CreditTableModel(List<CreditRecordVO> creditList) {
		this.creditList = creditList;
	}

	@Override
	// 表格的行数（有几个对象就有几行）
	public int getRowCount() {
		
		return creditList.size();
	}

	@Override
	// 每个creditVO对象有5个值，所以有5列
	public int getColumnCount() {
		
		return 5;
	}

	// 取每一列的列名
	@Override
	public String getColumnName(int columnIndex) {
		String[] l = {"时间","订单号","动作","信用值变化","当前信用值"};
		return l[columnIndex];
	}

	// 得到某列的数据类型
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		
		return String.class;

	}

	@Override
	// 全部不可编辑
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		
		return false;
	}

	// 得到第rowIndex行，第columnIndex列数据
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		CreditRecordVO info = creditList.get(rowIndex);
		
		List<String> list = new ArrayList<>();
		list.add(DateHelper.format(info.date));// 第一列为日期
		list.add(info.order.id+"");// 第二列为id
		String type = rb.getString("Credit." + info.type.toString());
		list.add(type);// 第三列为动作
		list.add(info.variation+"");// 第四列为信用值变化值
		list.add(info.currCredit+"");// 第五列为当前信用值
		return list.get(columnIndex);
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		

	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		

	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		

	}

}
