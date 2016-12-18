package hrs.client.UI.HotelUI.HotelDiscountUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import hrs.client.UI.HotelUI.HotelDiscountUI.Listener.AddCancelListener;
import hrs.client.UI.HotelUI.HotelDiscountUI.Listener.AddConfirmListener;
import hrs.client.UI.HotelUI.HotelDiscountUI.Listener.TypeSelectedListener;
import hrs.client.util.ControllerFactory;
import hrs.client.util.DateChoosePanel;
import hrs.client.util.HMSBlueButton;
import hrs.client.util.HMSGrayButton;
import hrs.client.util.RegExpHelper;
import hrs.client.util.UIConstants;
import hrs.common.Controller.HotelController.IHotelDiscountController;
import hrs.common.Exception.PromotionService.EnterpriseNotFoundException;
import hrs.common.VO.EnterpriseVO;
import hrs.common.VO.HotelDiscountVO;
import hrs.common.VO.HotelVO;
import hrs.common.util.type.HotelDiscountType;

public class AddDiscountDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9019888856233758657L;
	private final JPanel contentPanel = new JPanel();
	private JPanel jpDiscount;
	private JPanel jpButton;
	private JLabel jlType;
	private JLabel jlBegin;
	private JLabel jlEnd;
	private JLabel jlRoomNum;
	private JLabel jlFirm;
	private JLabel jlDiscount;
	private JComboBox<String> jcbType;
	private DateChoosePanel dcpBegin;
	private DateChoosePanel dcpEnd;
	private JSpinner jsRoomNum;
	private JComboBox<String> jcbFirm;
	private JTextField jtfDiscount;
	private HMSBlueButton jbConfirm;
	private HMSGrayButton jbCancel;
	private IHotelDiscountController controller;
	private TypeSelectedListener typeSelectedListener;
	private AddConfirmListener addListener;
	private AddCancelListener cancelListener;
	private HotelVO hotel;
	private List<EnterpriseVO> allFirms;
	private HotelDiscountUIPanel jpDiscountUI;
	private Font font;
	private JLabel jlZero;
	/**
	 * Create the dialog.
	 */
	public AddDiscountDialog(HotelVO hotel, HotelDiscountUIPanel jpDiscountUI) {
		this.hotel = hotel;
		this.jpDiscountUI = jpDiscountUI;
		setSize(570, 485);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		font = UIConstants.FONT_17;
		
		jpDiscount = new JPanel();
		jpDiscount.setBounds(0, 0, 564, 380);
		jpDiscount.setLayout(null);
		jpDiscount.setBackground(UIConstants.JFRAME);
		
		jpButton = new JPanel();
		jpButton.setBounds(0, 377, 564, 73);
		jpButton.setLayout(null);
		jpButton.setBackground(UIConstants.JFRAME);
		
		jlType = new JLabel();
		jlType.setFont(font);
		jlType.setText("折扣类型");
		jlType.setBounds(30, 30, 75, 30);
		
		jlBegin = new JLabel();
		jlBegin.setFont(font);
		jlBegin.setText("开始时间");
		jlBegin.setBounds(30, 90, 75, 30);
		
		jlEnd = new JLabel();
		jlEnd.setFont(font);
		jlEnd.setText("结束时间");
		jlEnd.setBounds(30, 150, 75, 30);
		
		jlRoomNum = new JLabel();
		jlRoomNum.setFont(font);
		jlRoomNum.setText("最小房间预订数量");
		jlRoomNum.setBounds(30, 210, 170, 30);
		
		jlFirm = new JLabel();
		jlFirm.setFont(font);
		jlFirm.setText("合作企业");
		jlFirm.setBounds(30, 270, 75, 30);
		
		jlDiscount = new JLabel();
		jlDiscount.setFont(font);
		jlDiscount.setText("折扣信息");
		jlDiscount.setBounds(30, 330, 75, 30);
		
		jlZero = new JLabel("0.");
		jlZero.setBounds(200, 330, 75, 30);
		jlZero.setFont(font);
		
		typeSelectedListener = new TypeSelectedListener(this);
		
		jcbType = new JComboBox<String>();
		jcbType.setBounds(200, 30, 330, 30);
		this.getAllTypes();
		jcbType.addItemListener(typeSelectedListener);
		jcbType.setFont(font);
		
		dcpBegin = new DateChoosePanel();
		dcpBegin.setBounds(200, 90, 330, 30);
		dcpBegin.setUnusable();
		
		dcpEnd = new DateChoosePanel();
		dcpEnd.setBounds(200, 150, 330, 30);
		dcpEnd.setUnusable();
		
		jsRoomNum = new JSpinner();
		jsRoomNum.setBounds(200, 210, 100, 30);
		jsRoomNum.setModel(new SpinnerNumberModel());
		jsRoomNum.setEnabled(false);
		jsRoomNum.setFont(font);
		
		jcbFirm = new JComboBox<String>();
		jcbFirm.setBounds(200, 270, 330, 30);
		jcbFirm.setEnabled(false);
		jcbFirm.setFont(font);
		
		jtfDiscount = new JTextField();
		jtfDiscount.setBounds(221, 330, 86, 30);
		jtfDiscount.setEnabled(true);
		jtfDiscount.setFont(font);
		
		addListener = new AddConfirmListener(this);
		
		jbConfirm = new HMSBlueButton("确定");
		jbConfirm.setFont(new Font("宋体", Font.PLAIN, 16));
		jbConfirm.setBounds(141, 13, 70, 40);
		jbConfirm.addMouseListener(addListener);
		
		cancelListener = new AddCancelListener(this);
		
		jbCancel = new HMSGrayButton("取消");
		jbCancel.setFont(new Font("宋体", Font.PLAIN, 16));
		jbCancel.setBounds(321, 13, 70, 40);
		jbCancel.addMouseListener(cancelListener);
		
		jpDiscount.add(jlType);
		jpDiscount.add(jlBegin);
		jpDiscount.add(jlEnd);
		jpDiscount.add(jlRoomNum);
		jpDiscount.add(jlFirm);
		jpDiscount.add(jlDiscount);
		jpDiscount.add(jcbType);
		jpDiscount.add(dcpBegin);
		jpDiscount.add(dcpEnd);
		jpDiscount.add(jsRoomNum);
		jpDiscount.add(jcbFirm);
		jpDiscount.add(jtfDiscount);
		jpDiscount.add(jlZero);
		
		jpButton.add(jbConfirm);
		jpButton.add(jbCancel);
		
		contentPanel.add(jpDiscount);

		contentPanel.add(jpButton);
		
		controller = ControllerFactory.getHotelDiscountController();
		
		this.setTitle("请填写新增促销策略的信息");
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

	/**
	 * 获取酒店的所有促销策略类型并将它们放入折扣类型下拉框中
	 */
	
	public void getAllTypes(){
		jcbType.addItem("生日特惠折扣");
		jcbType.addItem("房间预订特惠");
		jcbType.addItem("合作企业客户折扣");
		jcbType.addItem("特定期间折扣");
	}
	
	/**
	 * 根据当前选中的促销策略类型设置组件可用状态
	 */
	public void setByType(){
		String type = (String) jcbType.getSelectedItem();
		
		if(type.equals("生日特惠折扣")){
			dcpBegin.setUnusable();
			dcpEnd.setUnusable();
			jsRoomNum.setEnabled(false);
			jcbFirm.setEnabled(false);
			jtfDiscount.setEnabled(true);
		}
		else if(type.equals("房间预订特惠")){
			dcpBegin.setUnusable();
			dcpEnd.setUnusable();
			jsRoomNum.setEnabled(true);
			jcbFirm.setEnabled(false);
			jtfDiscount.setEnabled(true);
		}
		else if(type.equals("合作企业客户折扣")){
			dcpBegin.setUnusable();
			dcpEnd.setUnusable();
			jsRoomNum.setEnabled(false);
			jcbFirm.setEnabled(true);
			jtfDiscount.setEnabled(true);
			
			this.getAllFirms();
		}
		else if(type.equals("特定期间折扣")){
			dcpBegin.setEnabled();
			dcpEnd.setEnabled();
			jsRoomNum.setEnabled(false);
			jcbFirm.setEnabled(false);
			jtfDiscount.setEnabled(true);
		}
	}
	
	/**
	 * 获取酒店的所有未添加过的合作企业名称并将它们放入合作企业下拉框中
	 */
	public void getAllFirms(){
		jcbFirm.removeAllItems();
		
		allFirms = new ArrayList<EnterpriseVO>();
		
		try {
			allFirms = controller.findNotAddedEnterpriseByHotelID(hotel.id);
		} catch (EnterpriseNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "您的酒店尚无合作企业！", "提示", JOptionPane.INFORMATION_MESSAGE);
		}
		
		int i;
		for(i=0;i<allFirms.size();i++){
			jcbFirm.addItem(allFirms.get(i).name);
		}
	}
	
	/**
	 * 新增酒店促销策略
	 */
	public void add(){
		String sdiscount = jtfDiscount.getText();
		if(!RegExpHelper.matchOnlyNum(sdiscount)){
			JOptionPane.showMessageDialog(null, "折扣信息中不能包含非数字字符！", "错误", JOptionPane.WARNING_MESSAGE);
		}
		else if(sdiscount.length()>2){
			JOptionPane.showMessageDialog(null, "折扣信息中只能包含一位或两位有效数字！", "错误", JOptionPane.WARNING_MESSAGE);
		}
		else{
			double discount = Double.valueOf(sdiscount);
			int roomNum = ((Integer) jsRoomNum.getValue()).intValue();
			if((discount==0)){
				JOptionPane.showMessageDialog(null, "折扣信息不能为0！", "错误", JOptionPane.WARNING_MESSAGE);
			}
			else{
				discount = discount / 100;
				String type = (String) jcbType.getSelectedItem();
				HotelDiscountVO newDiscount = new HotelDiscountVO();
				newDiscount.hotel = hotel;
		
				if(type.equals("生日特惠折扣")){
					newDiscount.type = HotelDiscountType.Birthday;
					newDiscount.discount = discount;
				
					controller.add(newDiscount);
				
					jpDiscountUI.getAllDiscounts();
					jpDiscountUI.refresh();
				
					this.dispose();
				
					JOptionPane.showMessageDialog(null, "促销策略已更新！", "更新成功", JOptionPane.INFORMATION_MESSAGE);	
				}
				else if(type.equals("房间预订特惠")){
					if(roomNum<0){
						JOptionPane.showMessageDialog(null, "房间数量不能小于0！", "错误", JOptionPane.WARNING_MESSAGE);
					}
					else if(roomNum==0){
						JOptionPane.showMessageDialog(null, "房间数量不能为0！", "错误", JOptionPane.WARNING_MESSAGE);
					}
					else{
						newDiscount.type = HotelDiscountType.LargeQty;
						newDiscount.minQty = roomNum;
						newDiscount.discount = discount;
					
						controller.add(newDiscount);
						
						jpDiscountUI.getAllDiscounts();
						jpDiscountUI.refresh();
					
						this.dispose();
					
						JOptionPane.showMessageDialog(null, "促销策略已更新！", "更新成功", JOptionPane.INFORMATION_MESSAGE);	
					}
				}
				else if(type.equals("合作企业客户折扣")){
					newDiscount.type = HotelDiscountType.Enterprise;
					int firmIndex = jcbFirm.getSelectedIndex();
					newDiscount.enterprise = allFirms.get(firmIndex);
					newDiscount.discount = discount;
				
					controller.add(newDiscount);
				
					jpDiscountUI.getAllDiscounts();
					jpDiscountUI.refresh();
				
					this.dispose();
				
					JOptionPane.showMessageDialog(null, "促销策略已更新！", "更新成功", JOptionPane.INFORMATION_MESSAGE);	
				}
				else if(type.equals("特定期间折扣")){
					Date begin = dcpBegin.getDate();
					Date end = dcpEnd.getDate();
					if(end.before(begin)){
						JOptionPane.showMessageDialog(null, "开始时间应早于结束时间！", "错误", JOptionPane.ERROR_MESSAGE);
					}
					else{
						newDiscount.type = HotelDiscountType.SpecialPeriod;
						newDiscount.beginTime = begin;
						newDiscount.endTime = end;
						newDiscount.discount = discount;
				
						controller.add(newDiscount);
				
						jpDiscountUI.getAllDiscounts();
						jpDiscountUI.refresh();
					
						this.dispose();
				
						JOptionPane.showMessageDialog(null, "促销策略已更新！", "更新成功", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		}
	}
	
	public void cancel(){
		this.dispose();
	}
}
