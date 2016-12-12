package hrs.client.UI.UserUI.OrderInfoUI;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import com.mysql.cj.fabric.xmlrpc.base.Array;

import hrs.client.util.EnumHelper;
import hrs.common.VO.OrderVO;
import hrs.common.util.DateHelper;
import hrs.common.util.type.RoomType;

/**
 * 订单表格的TableModel 接受List<OrderVO>参数，将其显示
 * 
 * @author 涵
 *
 */
public class OrderTableModel implements TableModel {
	List<OrderVO> orders;

	public OrderTableModel(List<OrderVO> orders) {
		this.orders = orders;
	}

	// 表格的行数（有几个对象就有几行）
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return orders.size();
	}

	// 每个orderVO对象要显示7种属性，所以有7列
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 7;
	}

	@Override
	public String getColumnName(int columnIndex) {
		// TODO Auto-generated method stub
		List<String> l = new ArrayList<>();
		l.add("订单号");
		l.add("下单时间");
		l.add("酒店名称");
		l.add("房间类型");
		l.add("房间数量");
		l.add("金额");
		l.add("订单状态");
		return l.get(columnIndex);
	}

	// 显示的都是String类型
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		return String.class;
	}

	// 单元格不可编辑
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	// 得到某行某列的数据
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		OrderVO vo = orders.get(rowIndex);
		List<String> l = new ArrayList<>();
		l.add(vo.id + "");// 第一列为订单号
		l.add(DateHelper.format(vo.placeTime));// 第二列为下单时间
		l.add(vo.hotel.name);// 第三列为订单号
		l.add(EnumHelper.RoomFormat(vo.type));// 第四列为房间类型
		l.add(vo.roomNum + "");// 第五列为房间数量
		l.add(vo.value + "");// 第六列为金额
		l.add(EnumHelper.StatusFormat(vo.status));// 第七列为订单状态

		return l.get(columnIndex);
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
