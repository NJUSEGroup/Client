package hrs.client.UI.HotelUI.HotelDiscountUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;

import hrs.client.UI.HotelUI.Components.HotelDiscountTableModel;
import hrs.client.UI.HotelUI.HotelDiscountUI.Listener.AddListener;
import hrs.client.UI.HotelUI.HotelDiscountUI.Listener.DeleteListener;
import hrs.client.UI.HotelUI.HotelDiscountUI.Listener.DiscountSelectedListener;
import hrs.client.UI.HotelUI.HotelDiscountUI.Listener.EditListener;
import hrs.client.util.ControllerFactory;
import hrs.client.util.HMSBlueButton;
import hrs.client.util.HMSRedButton;
import hrs.client.util.UIConstants;
import hrs.common.Controller.HotelController.IHotelDiscountController;
import hrs.common.Exception.Promotion.HotelDiscountService.HotelDiscountNotFoundException;
import hrs.common.VO.HotelDiscountVO;
import hrs.common.VO.HotelVO;

public class HotelDiscountUIPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6428074559081567803L;
	private JPanel jpDiscount;
	private JPanel jpButton;
	private JScrollPane jspDiscount;
	private JTable jtDiscount;
	private HotelDiscountTableModel model;
	private JTableHeader jth;
	private HMSBlueButton jbAdd;
	private HMSBlueButton jbEdit;
	private HMSRedButton jbDelete;
	private HotelVO hotel;
	private IHotelDiscountController controller;
	private DiscountSelectedListener discountSelectedListener;
	private AddListener addListener;
	private EditListener editListener;
	private DeleteListener deleteListener;
	private List<HotelDiscountVO> discounts;
	private Color panelColor;
	private Color tableHeadColor;
	private Font tableFont;
	private Font tableHeadFont;
	
	/**
	 * Create the panel.
	 */
	
	public HotelDiscountUIPanel(HotelVO hotel) {
		init(hotel);
	}

	public void init(HotelVO hotel){
		this.hotel = hotel;
		this.setSize(1080, 722);
		this.setLayout(null);
		
		this.setFontAndColor();
		this.setPanel();
		this.setDiscountPanel();
		this.setButtonPanel();
	}
	
	public void setFontAndColor(){
		tableHeadColor = UIConstants.JTABLEHEADER_COLOR;
		panelColor = UIConstants.JFRAME;
		tableFont = UIConstants.FONT_16;
		tableHeadFont = UIConstants.FONT_19;
	}
	
	/**
	 * 设置面板
	 */
	public void setPanel(){
		jpDiscount = new JPanel();
		jpDiscount.setBounds(0, 0, 1080, 642);
		jpDiscount.setBackground(panelColor);
		jpDiscount.setLayout(null);
		
		jpButton = new JPanel();
		jpButton.setBounds(0, 642, 1080, 80);
		jpButton.setBackground(panelColor);
		jpButton.setLayout(null);
		
		this.add(jpDiscount);
		this.add(jpButton);
	}
	
	/**
	 * 设置促销策略信息面板
	 */
	public void setDiscountPanel(){
		controller = ControllerFactory.getHotelDiscountController();
		
		discounts = new ArrayList<HotelDiscountVO>();
		this.getAllDiscounts();
		
		discountSelectedListener = new DiscountSelectedListener(this);
		
		model = new HotelDiscountTableModel(discounts);
		
		jtDiscount = new JTable(model);
		jtDiscount.setBackground(Color.WHITE);
		jtDiscount.setFont(tableFont);
		jtDiscount.setRowHeight(40);
		jtDiscount.setShowVerticalLines(false);
		jtDiscount.addMouseListener(discountSelectedListener);
		
		jth = jtDiscount.getTableHeader(); 
		jth.setPreferredSize(new Dimension(jtDiscount.getWidth(),40)); 
		jth.setBackground(tableHeadColor);
		jth.setEnabled(false);
		jth.setBorder(new EmptyBorder(0,0,0,0));
		jth.setFont(tableHeadFont);
		
		jspDiscount = new JScrollPane(jtDiscount);
		jspDiscount.setBounds(10, 10, 1060, 622);
		jspDiscount.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jspDiscount.setOpaque(false);
		jspDiscount.getViewport().setOpaque(false);
		jspDiscount.setBackground(panelColor);
		
		jpDiscount.add(jspDiscount);
	}
	
	/**
	 * 设置按钮面板
	 */
	public void setButtonPanel(){
		addListener = new AddListener(this);
		
		jbAdd = new HMSBlueButton("添加");
		jbAdd.setBounds(570, 13, 90, 40);
		jbAdd.addMouseListener(addListener);
		
		editListener = new EditListener(this);
		
		jbEdit = new HMSBlueButton("修改");
		jbEdit.setBounds(710, 13, 90, 40);
		jbEdit.setEnabled(false);
		jbEdit.addMouseListener(editListener);
		
		
		deleteListener = new DeleteListener(this);
		
		jbDelete = new HMSRedButton("删除");
		jbDelete.setBounds(850, 13, 90, 40);
		jbDelete.setEnabled(false);
		jbDelete.addMouseListener(deleteListener);
		
		jpButton.add(jbAdd);
		jpButton.add(jbEdit);
		jpButton.add(jbDelete);
	}
	
	/**
	 * 获得该酒店所有促销策略
	 */
	public void getAllDiscounts(){
		try {
			discounts = controller.findAllByHotelID(hotel.id);
		} catch (HotelDiscountNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "您的酒店尚无促销策略", "提示", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	/**
	 * 刷新促销策略列表
	 */
	public void refresh(){
		model = new HotelDiscountTableModel(discounts);
		jtDiscount.setModel(model);
		this.discountNotSelected();
	}
	
	/**
	 * 当表格中的某项促销策略被选中时，修改和删除按钮设置为可用
	 */
	public void discountSelected(){
		if(jtDiscount.getSelectedRow() != -1){
			jbEdit.setEnabled(true);
			jbDelete.setEnabled(true);
		}
	}
	
	/**
	 * 当表格中没有促销策略被选中时，修改和删除按钮设置为不可用
	 */
	public void discountNotSelected(){
		jbEdit.setEnabled(false);
		jbDelete.setEnabled(false);
	}
	
	/**
	 * 获取相应按钮的可用状态
	 * @return
	 */
	public boolean isButtonEnable(String buttonName){
		if(buttonName.equals("修改")){
			return jbEdit.isEnabled();
		}
		else{
			return jbDelete.isEnabled();
		}
	}
	
	/**
	 * 获取被选中的促销策略
	 */
	public HotelDiscountVO getSelectedDiscount(){
		int row = jtDiscount.getSelectedRow();
		
		return discounts.get(row);
	}
	
	public void addDiscount(){
		AddDiscountDialog addDialog = new AddDiscountDialog(hotel, this);
	}
	
	public void editDiscount(){
		EditDiscountDialog editDialog = new EditDiscountDialog(hotel, this);
	}
	
	/**
	 * 删除被选中的促销策略
	 * @param discount
	 */
	public void deleteDiscount(HotelDiscountVO discount){
		controller.delete(discount.id);
	}
}
