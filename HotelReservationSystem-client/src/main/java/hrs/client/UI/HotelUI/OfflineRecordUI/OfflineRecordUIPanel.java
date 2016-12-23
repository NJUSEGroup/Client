package hrs.client.UI.HotelUI.OfflineRecordUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;

import hrs.client.UI.HotelUI.Components.OfflineRecordTableModel;
import hrs.client.UI.HotelUI.OfflineRecordUI.Listener.CheckinListener;
import hrs.client.UI.HotelUI.OfflineRecordUI.Listener.CheckoutListener;
import hrs.client.UI.HotelUI.OfflineRecordUI.Listener.RecordSelectedListener;
import hrs.client.UI.HotelUI.OfflineRecordUI.Listener.SearchListener;
import hrs.client.util.ControllerFactory;
import hrs.client.util.HMSBlueButton;
import hrs.client.util.UIConstants;
import hrs.common.Controller.HotelController.IOfflineRecordController;
import hrs.common.Exception.OfflineRecordService.OfflineRecordNotFoundException;
import hrs.common.VO.HotelVO;
import hrs.common.VO.OfflineRecordVO;

public class OfflineRecordUIPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2688792422499013247L;
	private JPanel jpSearch;
	private JPanel jpRecord;
	private JPanel jpButton;
	private JScrollPane jspRecord;
	private JLabel jlInput;
	private JLabel jlTotal;
	private JLabel jlNum;
	private JLabel jlRecord;
	private JTextField jtfInput;
	private HMSBlueButton jbConfirm;
	private JTable jtRecord;
	private JTableHeader jth;
	private HMSBlueButton jbCheckin;
	private HMSBlueButton jbCheckout;
	private OfflineRecordTableModel model;
	private IOfflineRecordController controller;
	private SearchListener searchListener;
	private RecordSelectedListener recordSelectedListener;
	private CheckinListener checkinListener;
	private CheckoutListener checkoutListener;
	private HotelVO hotel;
	private Color panelColor;
	private Color tableHeadColor;
	private Font font;
	private Font tableFont;
	
	/**
	 * 初始化线下记录界面面板
	 */
	public OfflineRecordUIPanel(HotelVO hotel) {
		init(hotel);
	}
	
	public void init(HotelVO hotel){
		this.hotel = hotel;
		this.setSize(1080, 722);
		this.setLayout(null);
		
		controller = ControllerFactory.getOfflineRecordController();
		
		this.setFontAndColor();
		this.setPanel();
		this.setSearchPanel();
		this.setRecordPanel();
		this.setButtonPanel();
	}
	
	public void setFontAndColor(){
		panelColor = UIConstants.JFRAME;
		tableHeadColor = UIConstants.JTABLEHEADER_COLOR;
		font = UIConstants.FONT_19;
		tableFont = UIConstants.FONT_16;
	}
	
	/**
	 * 设置面板
	 */
	public void setPanel(){
		jpSearch = new JPanel();
		jpSearch.setBounds(0, 0, 1080, 80);
		jpSearch.setBackground(panelColor);
		jpSearch.setLayout(null);
		
		jpRecord = new JPanel();
		jpRecord.setBounds(0, 80, 1080, 562);
		jpRecord.setBackground(panelColor);
		jpRecord.setLayout(null);
		
		jpButton = new JPanel();
		jpButton.setBounds(0, 642, 1080, 80);
		jpButton.setBackground(panelColor);
		jpButton.setLayout(null);
		
		this.add(jpSearch);
		this.add(jpRecord);
		this.add(jpButton);
	}
	
	/**
	 * 设置搜索面板
	 */
	public void setSearchPanel(){
		jlInput = new JLabel();
		jlInput.setBounds(30, 20, 120, 30);
		jlInput.setText("请输入编号");
		jlInput.setHorizontalAlignment(SwingConstants.CENTER);
		jlInput.setFont(font);
		
		jtfInput = new JTextField();
		jtfInput.setBounds(180, 20, 140, 30);
		jtfInput.setFont(font);
		jtfInput.setEditable(true);
		
		searchListener = new SearchListener(this);
		
		jbConfirm = new HMSBlueButton("确认");
		jbConfirm.setBounds(362, 15, 90, 40);
		jbConfirm.addMouseListener(searchListener);
		
		jpSearch.add(jlInput);
		jpSearch.add(jtfInput);
		jpSearch.add(jbConfirm);
	}
	
	/**
	 * 设置线下记录信息面板
	 */
	public void setRecordPanel(){
		recordSelectedListener = new RecordSelectedListener(this);
		
		List<OfflineRecordVO> record = new ArrayList<OfflineRecordVO>();
		record = this.getAllRecords();
		
		model = new OfflineRecordTableModel(record);
		
		jtRecord = new JTable(model);
		jtRecord.setBackground(Color.WHITE);
		jtRecord.setFont(tableFont);
		jtRecord.setRowHeight(40);
		jtRecord.setShowVerticalLines(false);
		jtRecord.addMouseListener(recordSelectedListener);
		
		jth = jtRecord.getTableHeader(); 
		jth.setPreferredSize(new Dimension(jtRecord.getWidth(),40)); 
		jth.setBackground(tableHeadColor);
		jth.setEnabled(false);
		jth.setBorder(new EmptyBorder(0,0,0,0));
		jth.setFont(font);
		
		jspRecord = new JScrollPane(jtRecord);
		jspRecord.setBounds(10, 10, 1060, 542);
		jspRecord.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jspRecord.setOpaque(false);
		jspRecord.getViewport().setOpaque(false);
		jspRecord.setBackground(panelColor);
		
		jpRecord.add(jspRecord);
	}
	
	/**
	 * 设置按钮面板
	 */
	public void setButtonPanel(){
		jlTotal = new JLabel();
		jlTotal.setBounds(15, 15, 35, 20);
		jlTotal.setFont(tableFont);
		jlTotal.setText("共有");
		
		jlNum = new JLabel();
		jlNum.setBounds(50, 15, 25, 20);
		jlNum.setFont(tableFont);
		
		jlRecord = new JLabel();
		jlRecord.setBounds(80, 15, 50, 20);
		jlRecord.setFont(tableFont);
		jlRecord.setText("条记录");
		
		checkinListener = new CheckinListener(this);
		
		jbCheckin = new HMSBlueButton("入住");
		jbCheckin.setBounds(715, 13, 90, 40);
		jbCheckin.addMouseListener(checkinListener);
		
		checkoutListener = new CheckoutListener(this);
		
		jbCheckout = new HMSBlueButton("退房");
		jbCheckout.setBounds(869, 13, 90, 40);
		jbCheckout.setEnabled(false);
		jbCheckout.addMouseListener(checkoutListener);
		
		jpButton.add(jbCheckin);
		jpButton.add(jbCheckout);
		jpButton.add(jlTotal);
		jpButton.add(jlNum);
		jpButton.add(jlRecord);
	}
	
	/**
	 * 获得当前输入的线下记录编号
	 * @return
	 */
	public String getID(){
		return jtfInput.getText();
	}
	
	/**
	 * 获得该酒店的所有线下记录
	 * @return
	 */
	public List<OfflineRecordVO> getAllRecords(){
		List<OfflineRecordVO> allRecords = new ArrayList<OfflineRecordVO>();
		
		try {
			allRecords = controller.findByHotelID(hotel.id);
		} catch (OfflineRecordNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "您的酒店尚无线下入住记录！", "提示", JOptionPane.INFORMATION_MESSAGE);
		}
		
		return allRecords;
	}
	
	/**
	 * 通过线下记录编号查询相应的线下记录
	 * @param id
	 * @return
	 */
	public List<OfflineRecordVO> searchRecordByID(int id){
		OfflineRecordVO record = new OfflineRecordVO();
		List<OfflineRecordVO> records = new ArrayList<OfflineRecordVO>();
		
		try {
			record = controller.findOfflineRecordByID(id);
			records.add(record);
		} catch (OfflineRecordNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "该记录不存在！", "错误", JOptionPane.WARNING_MESSAGE);
		}
		
		return records;
	}
	
	/**
	 * 刷新线下记录列表
	 * @param record
	 */
	public void refresh(List<OfflineRecordVO> record){
		model = new OfflineRecordTableModel(record);
		jtRecord.setModel(model);
		jlNum.setText(Integer.toString(record.size()));
	}
	
	/**
	 * 当表格中的某项线下记录被选中时，根据线下记录状态设置退房按钮的可用状态
	 */
	public void recordSelected(){
		String checkoutTime = "";
		OfflineRecordVO record = new OfflineRecordVO();
		if(jtRecord.getSelectedRow() != -1){
			record = this.getSelectedRecord();
			
			if(record.checkoutTime!=null){
				checkoutTime = record.checkoutTime.toString();
			}
			else{
				checkoutTime = "";
			}
			
			if(checkoutTime.equals("")){
				jbCheckout.setEnabled(true);
			}
			else{
				jbCheckout.setEnabled(false);
				jbCheckout.setToolTipText("该记录已执行过退房操作，无法再次执行！");
			}
		}
	}
	
	/**
	 * 当表格中没有记录被选中时，退房按钮不可用
	 */
	public void recordNotSelected(){
		jbCheckout.setEnabled(false);
	}
	
	/**
	 * 获得被选中的线下记录
	 * @return
	 */
	public OfflineRecordVO getSelectedRecord(){
		int row = jtRecord.getSelectedRow();
		int id = Integer.valueOf((String) jtRecord.getValueAt(row, 0));
		OfflineRecordVO record = searchRecordByID(id).get(0);
		return record;
	}
	
	/**
	 * 点击入住按钮，弹出入住对话框
	 */
	public void checkin(){
		CheckinDialog checkinDialog = new CheckinDialog(hotel, this);
	}

	/**
	 * 执行退房操作
	 * @param theRecord
	 */
	public void checkout(OfflineRecordVO theRecord){
		controller.offlineCheckout(theRecord);
		JOptionPane.showMessageDialog(null, "线下入住记录已更新！", "更新成功", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * 获得退房按钮的可用状态
	 */
	public boolean isCheckoutEnable(){
			return jbCheckout.isEnabled();
	}
}
