package hrs.client.UI.HotelUI.HotelDiscountUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import hrs.client.UI.HotelUI.HotelDiscountUI.Listener.AddConfirmListener;
import hrs.client.UI.HotelUI.HotelDiscountUI.Listener.EditCancelListener;
import hrs.client.UI.HotelUI.HotelDiscountUI.Listener.EditConfirmListener;
import hrs.client.UI.HotelUI.HotelDiscountUI.Listener.TypeSelectedListener;
import hrs.client.util.ControllerFactory;
import hrs.client.util.DateChoosePanel;
import hrs.client.util.HMSBlueButton;
import hrs.client.util.HMSGrayButton;
import hrs.client.util.UIConstants;
import hrs.common.Controller.HotelController.IHotelDiscountController;
import hrs.common.Exception.PromotionService.EnterpriseNotFoundException;
import hrs.common.VO.EnterpriseVO;
import hrs.common.VO.HotelDiscountVO;
import hrs.common.VO.HotelVO;
import hrs.common.util.type.HotelDiscountType;

public class EditDiscountDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private HotelVO hotel;
	private HotelDiscountUIPanel jpDiscountUI;
	private IHotelDiscountController controller;
	private JPanel jpDiscount;
	private JPanel jpButton;
	private JLabel jlType;
	private JLabel jlBegin;
	private JLabel jlEnd;
	private JLabel jlRoomNum;
	private JLabel jlFirm;
	private JLabel jlDiscount;
	private JTextField jtfType;
	private DateChoosePanel dcpBegin;
	private DateChoosePanel dcpEnd;
	private JSpinner jsRoomNum;
	private JComboBox<String> jcbFirm;
	private JTextField jtfDiscount;
	private HMSBlueButton jbConfirm;
	private HMSGrayButton jbCancel;
	private HotelDiscountVO theDiscount;
	private List<EnterpriseVO> allFirms;
	private EditCancelListener cancelListener;
	private EditConfirmListener editListener;


	/**
	 * Create the dialog.
	 */
	public EditDiscountDialog(HotelVO hotel, HotelDiscountUIPanel jpDiscountUI) {
		this.hotel = hotel;
		this.jpDiscountUI = jpDiscountUI;
		setSize(570, 485);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		jpDiscount = new JPanel();
		jpDiscount.setBounds(0, 0, 552, 380);
		jpDiscount.setLayout(null);
		jpDiscount.setBackground(UIConstants.JFRAME);
		
		jpButton = new JPanel();
		jpButton.setBounds(0, 377, 552, 61);
		jpButton.setLayout(null);
		jpButton.setBackground(UIConstants.JFRAME);
		
		jlType = new JLabel();
		jlType.setFont(new Font("宋体", Font.PLAIN, 21));
		jlType.setText("折扣类型");
		jlType.setBounds(10, 10, 100, 40);
		
		jlBegin = new JLabel();
		jlBegin.setFont(new Font("宋体", Font.PLAIN, 21));
		jlBegin.setText("开始时间");
		jlBegin.setBounds(10, 70, 100, 40);
		
		jlEnd = new JLabel();
		jlEnd.setFont(new Font("宋体", Font.PLAIN, 21));
		jlEnd.setText("结束时间");
		jlEnd.setBounds(10, 130, 100, 40);
		
		jlRoomNum = new JLabel();
		jlRoomNum.setFont(new Font("宋体", Font.PLAIN, 21));
		jlRoomNum.setText("最小房间预订数量");
		jlRoomNum.setBounds(10, 190, 170, 40);
		
		jlFirm = new JLabel();
		jlFirm.setFont(new Font("宋体", Font.PLAIN, 21));
		jlFirm.setText("合作企业");
		jlFirm.setBounds(10, 250, 100, 40);
		
		jlDiscount = new JLabel();
		jlDiscount.setFont(new Font("宋体", Font.PLAIN, 21));
		jlDiscount.setText("折扣信息");
		jlDiscount.setBounds(10, 310, 100, 40);
		
		jtfType = new JTextField();
		jtfType.setBounds(200, 10, 330, 40);
		jtfType.setEditable(false);
		jtfType.setBackground(UIConstants.JFRAME);
		jtfType.setFont(new Font("宋体", Font.PLAIN, 21));
		
		dcpBegin = new DateChoosePanel();
		dcpBegin.setBounds(200, 70, 330, 40);
		
		dcpEnd = new DateChoosePanel();
		dcpEnd.setBounds(200, 130, 330, 40);
		
		jsRoomNum = new JSpinner();
		jsRoomNum.setBounds(200, 190, 100, 40);
		jsRoomNum.setModel(new SpinnerNumberModel());
		jsRoomNum.setEnabled(false);
		jsRoomNum.setFont(new Font("宋体", Font.PLAIN, 21));
		
		jcbFirm = new JComboBox<String>();
		jcbFirm.setBounds(200, 250, 330, 40);
		jcbFirm.setEnabled(false);
		jcbFirm.setFont(new Font("宋体", Font.PLAIN, 21));
		
		jtfDiscount = new JTextField();
		jtfDiscount.setBounds(200, 310, 330, 40);
		jtfDiscount.setEnabled(true);
		jtfDiscount.setFont(new Font("宋体", Font.PLAIN, 21));
		
		editListener = new EditConfirmListener(this);
		
		jbConfirm = new HMSBlueButton("确定");
		jbConfirm.setFont(new Font("宋体", Font.PLAIN, 16));
		jbConfirm.setBounds(141, 13, 70, 40);
		jbConfirm.addMouseListener(editListener);
		
		cancelListener = new EditCancelListener(this);
		
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
		jpDiscount.add(jtfType);
		jpDiscount.add(dcpBegin);
		jpDiscount.add(dcpEnd);
		jpDiscount.add(jsRoomNum);
		jpDiscount.add(jcbFirm);
		jpDiscount.add(jtfDiscount);
		
		jpButton.add(jbConfirm);
		jpButton.add(jbCancel);
		
		contentPanel.add(jpDiscount);
		contentPanel.add(jpButton);
		
		controller = ControllerFactory.getHotelDiscountController();
		
		this.setTitle("请填写新增促销策略的信息");
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		
		this.getDiscount();
		this.setByType();
		this.getRawInfo();
	}
	
	/**
	 * 获取需要修改的促销策略
	 */
	public void getDiscount(){
		theDiscount = jpDiscountUI.getSelectedDiscount();
	}
	
	/**
	 * 根据获取的促销策略类型设置相应组件的可用状态
	 */
	public void setByType(){
		if(theDiscount.type==HotelDiscountType.Birthday){
			dcpBegin.setUnusable();
			dcpEnd.setUnusable();
			jsRoomNum.setEnabled(false);
			jcbFirm.setEnabled(false);
		}
		else if(theDiscount.type==HotelDiscountType.Enterprise){
			dcpBegin.setUnusable();
			dcpEnd.setUnusable();
			jsRoomNum.setEnabled(false);
			jcbFirm.setEnabled(true);
		}
		else if(theDiscount.type==HotelDiscountType.LargeQty){
			dcpBegin.setUnusable();
			dcpEnd.setUnusable();
			jsRoomNum.setEnabled(true);
			jcbFirm.setEnabled(false);
		}
		else if(theDiscount.type==HotelDiscountType.SpecialPeriod){
			dcpBegin.setEnabled();
			dcpEnd.setEnabled();
			jsRoomNum.setEnabled(false);
			jcbFirm.setEnabled(false);
		}
	}
	
	/**
	 * 获取需要修改的促销策略的原始信息
	 */
	public void getRawInfo(){
			if(theDiscount.type==HotelDiscountType.Birthday){
				jtfType.setText("生日特惠折扣");
				jtfDiscount.setText(Double.toString(theDiscount.discount));
			}
			else if(theDiscount.type==HotelDiscountType.Enterprise){
				jtfType.setText("合作企业客户折扣");
				this.getAllFirms();
				jcbFirm.setSelectedItem(theDiscount.enterprise.name);
				jtfDiscount.setText(Double.toString(theDiscount.discount));
			}
			else if(theDiscount.type==HotelDiscountType.LargeQty){
				jtfType.setText("房间预订特惠");
				jsRoomNum.setValue(theDiscount.minQty);
				jtfDiscount.setText(Double.toString(theDiscount.discount));
			}
			else if(theDiscount.type==HotelDiscountType.SpecialPeriod){
				jtfType.setText("特定期间折扣");
				jtfDiscount.setText(Double.toString(theDiscount.discount));
				dcpBegin.setDate(theDiscount.beginTime);
				dcpEnd.setDate(theDiscount.endTime);
			}
	}

	/**
	 * 获取酒店的所有合作企业名称并将它们放入合作企业下拉框中
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
	 * 确认修改促销策略
	 */
	public void edit(){
		double discount = Double.valueOf(jtfDiscount.getText());
		int roomNum = ((Integer) jsRoomNum.getValue()).intValue();
		if(discount<0){
			JOptionPane.showMessageDialog(null, "折扣信息不能小于0！", "错误", JOptionPane.WARNING_MESSAGE);
		}
		else if(discount==0.0){
			JOptionPane.showMessageDialog(null, "折扣信息不能为0！", "错误", JOptionPane.WARNING_MESSAGE);
		}
		else if(discount>=1.0){
			JOptionPane.showMessageDialog(null, "折扣信息不能大于等于1！", "错误", JOptionPane.WARNING_MESSAGE);
		}
		else{
		if(theDiscount.type==HotelDiscountType.Birthday){
			theDiscount.discount = discount;
			
			controller.update(theDiscount);
			
			jpDiscountUI.getAllDiscounts();
			jpDiscountUI.refresh();
			
			this.dispose();
			
			JOptionPane.showMessageDialog(null, "促销策略已更新！", "更新成功", JOptionPane.INFORMATION_MESSAGE);	
		}
		else if(theDiscount.type==HotelDiscountType.Enterprise){
			int firmIndex = jcbFirm.getSelectedIndex();
			theDiscount.enterprise = allFirms.get(firmIndex);
			theDiscount.discount = discount;
			
			controller.update(theDiscount);
			
			jpDiscountUI.getAllDiscounts();
			jpDiscountUI.refresh();
			
			this.dispose();
			
			JOptionPane.showMessageDialog(null, "促销策略已更新！", "更新成功", JOptionPane.INFORMATION_MESSAGE);	
		}
		else if(theDiscount.type==HotelDiscountType.LargeQty){
			if(roomNum<0){
				JOptionPane.showMessageDialog(null, "房间数量不能小于0！", "错误", JOptionPane.WARNING_MESSAGE);
			}
			else if(roomNum==0){
				JOptionPane.showMessageDialog(null, "房间数量不能为0！", "错误", JOptionPane.WARNING_MESSAGE);
			}
			else{
				theDiscount.minQty = ((Integer) jsRoomNum.getValue()).intValue();
				theDiscount.discount = discount;
			
				controller.update(theDiscount);
			
				jpDiscountUI.getAllDiscounts();
				jpDiscountUI.refresh();
			
				this.dispose();
			
				JOptionPane.showMessageDialog(null, "促销策略已更新！", "更新成功", JOptionPane.INFORMATION_MESSAGE);	
			}
		}
		else if(theDiscount.type==HotelDiscountType.SpecialPeriod){
			theDiscount.beginTime = dcpBegin.getDate();
			theDiscount.endTime = dcpEnd.getDate();
			theDiscount.discount = discount;
			
			controller.update(theDiscount);
			
			jpDiscountUI.getAllDiscounts();
			jpDiscountUI.refresh();
			
			this.dispose();
			
			JOptionPane.showMessageDialog(null, "促销策略已更新！", "更新成功", JOptionPane.INFORMATION_MESSAGE);	
		}
		}
	}
	
	/**
	 * 取消修改促销策略
	 */
	public void cancel(){
		this.dispose();
	}
}
