package hrs.client.UI.UserUI.Components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import hrs.client.util.UIConstants;

/**
 * 显示酒店搜索结果的面板
 * @author 涵
 *
 */
public class CommonTable extends JTable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -731486404013187955L;
	Font font = UIConstants.JLABEL_FONT;

	public CommonTable() {

		setBackground(new Color(211, 237, 249));// 背景色
		setFont(font);// 字体
		setRowHeight(40);// 行高
		setShowVerticalLines(false);// 不显示数列线

		// 设置表头
		JTableHeader tableHeader = this.getTableHeader();
		tableHeader.setPreferredSize(new Dimension(tableHeader.getWidth(), 40)); // 设定表头高度
		tableHeader.setBackground(new Color(145, 179, 179));// 设定表头背景色
		tableHeader.setEnabled(false);// 设置表头不可编辑
		tableHeader.setBorder(new EmptyBorder(0,0,0,0));
		tableHeader.setFont(font);
		((DefaultTableCellRenderer) tableHeader.getDefaultRenderer()).setHorizontalAlignment(JLabel.LEFT);

		
	}

}
