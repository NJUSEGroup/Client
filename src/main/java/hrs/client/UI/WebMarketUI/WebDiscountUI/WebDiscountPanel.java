package hrs.client.UI.WebMarketUI.WebDiscountUI;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;

import hrs.client.UI.WebMarketUI.WebDiscountUI.WebDiscountListener.AddMouseListener;
import hrs.client.UI.WebMarketUI.WebDiscountUI.WebDiscountListener.DeleteMouseListener;
import hrs.client.UI.WebMarketUI.WebDiscountUI.WebDiscountListener.ModifyMouseListener;
import hrs.client.util.ControllerFactory;
import hrs.client.util.HMSBlueButton;
import hrs.client.util.HMSRedButton;
import hrs.client.util.UIConstants;
import hrs.common.Controller.WebMarketController.IWebDiscountController;
import hrs.common.Exception.Promotion.WebDiscountService.WebDiscountNotFoundException;
import hrs.common.VO.WebDiscountVO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WebDiscountPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6524280989363498476L;
	private IWebDiscountController webDiscountController;
	private List<WebDiscountVO> webDiscountList;
	private WebDiscountModel model;
	private HMSBlueButton jbAdd, jbModify;
	private HMSRedButton jbDelete;

	private DeleteMouseListener listener;
	private AddMouseListener addMouseListener;
	private ModifyMouseListener modifyMouseListener;

	private JLabel jlNumberOfPO;
	private JTable jTable;
	private JTableHeader jTableHeader;
	private JScrollPane scrollPane;
	private AddWebDiscountDialog jdAddWebDiscount;
	private WebDiscountVO addVo;
	private SpecialCommercialCircleDialog jdSpecialCommercialCircle;
	private SpecialPeriodDialog jdSpecialPeriod;
	private VIPDiaog jdVIP;

	/**
	 * Create the panel.
	 */
	public WebDiscountPanel() {
		init();
	}

	public void init() {
		webDiscountController = ControllerFactory.getWebDiscountController();
		webDiscountList = getWebDiscountList();
		model = new WebDiscountModel(webDiscountList);

		this.setSize(1080, 722);
		this.setBackground(UIConstants.JFRAME);

		jbAdd = new HMSBlueButton("添加");
		jbAdd.setBounds(612, 641, 90, 40);
		jdAddWebDiscount = new AddWebDiscountDialog(this);// this
		addMouseListener = new AddMouseListener(this);
		jbAdd.addMouseListener(addMouseListener);

		jbModify = new HMSBlueButton("修改");
		jbModify.setBounds(751, 641, 90, 40);
		modifyMouseListener = new ModifyMouseListener(this);
		jbModify.addMouseListener(modifyMouseListener);

		jbDelete = new HMSRedButton("删除");
		jbDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		jbDelete.setBounds(887, 641, 90, 40);
		listener = new DeleteMouseListener(this);
		jbDelete.addMouseListener(listener);

		jlNumberOfPO = new JLabel();
		jlNumberOfPO.setBounds(41, 587, 120, 23);
		jlNumberOfPO.setText("共 " + webDiscountList.size() + " 条记录");
		jlNumberOfPO.setFont(UIConstants.FONT_17);

		jTable = new JTable();
		jTable.setModel(model);
		// jTable.setEnabled(false);

		jTable.setBackground(UIConstants.JFRAME);
		jTable.setFont(UIConstants.FONT_18);
		jTable.setRowHeight(40);
		jTable.setShowVerticalLines(false);
		jTable.setShowHorizontalLines(true);

		// 设置表头
		jTableHeader = jTable.getTableHeader();
		jTableHeader.setPreferredSize(new Dimension(jTableHeader.getWidth(), 25));
		jTableHeader.setBackground(UIConstants.JTABLEHEADER_COLOR);
		jTableHeader.setEnabled(false);
		jTableHeader.setBorder(new EmptyBorder(0, 0, 0, 0));
		jTableHeader.setFont(UIConstants.FONT_18);

		scrollPane = new JScrollPane();
		scrollPane.setViewportView(jTable);
		scrollPane.setBounds(3, 20, 1060, 530);
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.getViewport().setBackground(UIConstants.JFRAME);
		setLayout(null);
		scrollPane.setOpaque(true);
		add(scrollPane);
		add(scrollPane);
		add(jbAdd);
		add(jbModify);
		add(jbDelete);
		add(jlNumberOfPO);
	}

	public List<WebDiscountVO> getWebDiscountList() {
		List<WebDiscountVO> list = new ArrayList<>();
		try {
			list = webDiscountController.findAll();

		} catch (WebDiscountNotFoundException e) {
			JOptionPane.showMessageDialog(this, "此时促销策略为空！", "NullWebDiscount", JOptionPane.INFORMATION_MESSAGE);

		}
		return list;
	}

	public void addWebDiscount() {
		addVo = jdAddWebDiscount.jdaddWebDiscount();
		webDiscountController.add(addVo);
		refresh();
	}

	public void deleteWebDiscount(WebDiscountVO vo) {
		webDiscountController.delete(vo.id);
		refresh();
	}

	public void showModifyDialog() {
		if (getSelected() == null) {
			JOptionPane.showMessageDialog(this, "请选中要修改的促销策略！", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			switch (getSelected().type) {
			case SpecialCommercialCircle:
				jdSpecialCommercialCircle = new SpecialCommercialCircleDialog(this);
				jdSpecialCommercialCircle.setVisible(true);
				jdSpecialCommercialCircle.setLocationRelativeTo(null);
				break;
			case SpecialPeriod:
				jdSpecialPeriod = new SpecialPeriodDialog(this);
				jdSpecialPeriod.setVisible(true);
				jdSpecialPeriod.setLocationRelativeTo(null);
				break;
			case VIP:
				jdVIP = new VIPDiaog(this);
				jdVIP.setVisible(true);
				jdVIP.setLocationRelativeTo(null);
				break;
			default:
				break;
			}
		}
	}

	public void modifyWebDiscount() {
		WebDiscountVO modifyVO = null;
		switch (getSelected().type) {
		case SpecialCommercialCircle:
			modifyVO = jdSpecialCommercialCircle.getModifyVO();
			break;
		case SpecialPeriod:
			modifyVO = jdSpecialPeriod.getModifyVO();
			break;
		case VIP:
			modifyVO = jdVIP.getModifyVO();
			break;
		default:
			break;
		}
		webDiscountController.update(modifyVO);
		refresh();
		JOptionPane.showMessageDialog(null, "促销策略成功修改！", "Success", JOptionPane.PLAIN_MESSAGE, null);
	}

	public WebDiscountVO getSelected() {
		if (jTable.getSelectedRow() != -1) {
			return model.getValue(jTable.getSelectedRow());
		} else
			return null;
	}

	public void showAddDialog() {
		jdAddWebDiscount = new AddWebDiscountDialog(this);
		jdAddWebDiscount.setVisible(true);
		jdAddWebDiscount.setLocationRelativeTo(null);
	}

	public void refresh() {
		model = new WebDiscountModel(getWebDiscountList());
		jTable.setModel(model);
		jlNumberOfPO.setText("共 " + getWebDiscountList().size() + " 条记录");
		jlNumberOfPO.setFont(UIConstants.FONT_17);
	}
}
