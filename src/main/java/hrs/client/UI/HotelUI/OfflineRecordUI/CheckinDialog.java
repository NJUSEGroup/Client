package hrs.client.UI.HotelUI.OfflineRecordUI;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hrs.client.UI.HotelUI.OfflineRecordUI.Listener.CheckRoomNumListener;
import hrs.client.UI.HotelUI.OfflineRecordUI.Listener.CheckRoomTypeListener;
import hrs.client.UI.HotelUI.OfflineRecordUI.Listener.CheckinCancelListener;
import hrs.client.UI.HotelUI.OfflineRecordUI.Listener.CheckinConfirmListener;
import hrs.client.util.ControllerFactory;
import hrs.client.util.DateChoosePanel;
import hrs.client.util.UIConstants;
import hrs.common.Controller.HotelController.IOfflineRecordController;
import hrs.common.VO.HotelVO;
import hrs.common.VO.OfflineRecordVO;
import hrs.common.VO.RoomVO;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.Color;

public class CheckinDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8902202799700210181L;
	private final JPanel contentPanel = new JPanel();
	private JPanel jpDate;
	private JPanel jpRoom;
	private JPanel jpButton;
	private JLabel jlCheckinTime;
	private JLabel jlExpectedCheckoutTime;
	private JLabel jlRoomType;
	private JLabel jlRoomNum;
	private JButton jbConfirm;
	private JButton jbCancel;
	private JButton jbCheckRoom;
	private JComboBox<String> jcbRoomType;
	private JComboBox<String> jcbRoomNum;
	private IOfflineRecordController recordController;
	private HotelVO hotel;
	private DateChoosePanel dcpCheckin;
	private DateChoosePanel dcpCheckout;
	private CheckRoomTypeListener checkRoomTypeListener;
	private CheckRoomNumListener checkRoomNumListener;
	private CheckinConfirmListener confirmListener;
	private CheckinCancelListener cancelListener;
	private List<RoomVO> rooms;
	private OfflineRecordUIPanel jpRecord;

	/**
	 * 初始化线下记录入住对话框
	 */
	public CheckinDialog(HotelVO hotel, OfflineRecordUIPanel jpRecord) {
		this.jpRecord = jpRecord;
		this.hotel = hotel;
		setSize(531, 485);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		this.setPanel();
		this.setDatePanel();
		this.setRoomPanel();
		this.setButtonPanel();
		
		rooms = new ArrayList<RoomVO>();
		recordController = ControllerFactory.getOfflineRecordController();
		
		this.setTitle("请输入线下入住的信息");
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
	/**
	 * 设置面板
	 */
	public void setPanel(){
		jpDate = new JPanel();
		jpDate.setBounds(0, 0, 513, 201);
		jpDate.setLayout(null);
		jpDate.setBackground(UIConstants.JFRAME);
		
		jpRoom = new JPanel();
		jpRoom.setBounds(0, 200, 513, 170);
		jpRoom.setLayout(null);
		jpRoom.setBackground(UIConstants.JFRAME);
		
		jpButton = new JPanel();
		jpButton.setBounds(0, 369, 513, 69);
		jpButton.setLayout(null);
		jpButton.setBackground(UIConstants.JFRAME);
		
		contentPanel.add(jpDate);
		contentPanel.add(jpRoom);
		contentPanel.add(jpButton);
	}
	
	/**
	 * 设置日期信息面板
	 */
	public void setDatePanel(){
		checkRoomTypeListener = new CheckRoomTypeListener(this);
		
		jbCheckRoom = new JButton();
		jbCheckRoom.setForeground(Color.WHITE);
		jbCheckRoom.setFont(new Font("宋体", Font.PLAIN, 17));
		jbCheckRoom.setBounds(169, 146, 148, 42);
		jbCheckRoom.setText("查看可用房间");
		jbCheckRoom.setBackground(UIConstants.JBUTTON_BLUE);
		jbCheckRoom.addMouseListener(checkRoomTypeListener);
		
		jlCheckinTime = new JLabel();
		jlCheckinTime.setFont(new Font("宋体", Font.PLAIN, 21));
		jlCheckinTime.setText("入住时间");
		jlCheckinTime.setBounds(15, 13, 114, 40);
		
		jlExpectedCheckoutTime = new JLabel();
		jlExpectedCheckoutTime.setFont(new Font("宋体", Font.PLAIN, 21));
		jlExpectedCheckoutTime.setText("预计离开时间");
		jlExpectedCheckoutTime.setBounds(15, 78, 135, 40);
		
		dcpCheckin = new DateChoosePanel();
		dcpCheckin.setBounds(169, 13, 330, 40);
		
		dcpCheckout = new DateChoosePanel();
		dcpCheckout.setBounds(169, 78, 330, 40);
		
		jpDate.add(jlCheckinTime);
		jpDate.add(jlExpectedCheckoutTime);
		jpDate.add(dcpCheckin);
		jpDate.add(dcpCheckout);
		jpDate.add(jbCheckRoom);
	}
	
	/**
	 * 设置房间信息面板
	 */
	public void setRoomPanel(){
		jlRoomType = new JLabel();
		jlRoomType.setFont(new Font("宋体", Font.PLAIN, 21));
		jlRoomType.setText("房间类型");
		jlRoomType.setBounds(15, 24, 100, 40);
		
		jlRoomNum = new JLabel();
		jlRoomNum.setFont(new Font("宋体", Font.PLAIN, 21));
		jlRoomNum.setText("房间数量");
		jlRoomNum.setBounds(15, 97, 100, 40);
		
		checkRoomNumListener = new CheckRoomNumListener(this);
		
		jcbRoomType = new JComboBox<String>();
		jcbRoomType.setFont(new Font("宋体", Font.PLAIN, 18));
		jcbRoomType.setBounds(169, 25, 200, 40);
		jcbRoomType.addItemListener(checkRoomNumListener);
		
		jcbRoomNum = new JComboBox<String>();
		jcbRoomNum.setFont(new Font("宋体", Font.PLAIN, 18));
		jcbRoomNum.setBounds(169, 100, 200, 40);
		
		jpRoom.add(jlRoomType);
		jpRoom.add(jlRoomNum);
		jpRoom.add(jcbRoomType);
		jpRoom.add(jcbRoomNum);
	}
	
	public void setButtonPanel(){
		confirmListener = new CheckinConfirmListener(this);
		
		jbConfirm = new JButton();
		jbConfirm.setFont(new Font("宋体", Font.PLAIN, 16));
		jbConfirm.setText("确定");
		jbConfirm.setBounds(123, 13, 70, 40);
		jbConfirm.addMouseListener(confirmListener);
		
		cancelListener = new CheckinCancelListener(this);
		
		jbCancel = new JButton();
		jbCancel.setFont(new Font("宋体", Font.PLAIN, 16));
		jbCancel.setText("取消");
		jbCancel.setBounds(323, 13, 70, 40);
		jbCancel.addMouseListener(cancelListener);
		
		jpButton.add(jbConfirm);
		jpButton.add(jbCancel);
	}
	
	/**
	 * 查找此时酒店的可用客房类型
	 */
	public void checkRoomType(){
		Date checkin = dcpCheckin.getDate();
		Date checkout = dcpCheckout.getDate();
		
		rooms = recordController.findAvailableByHotelID(hotel.id, checkin, checkout);
		
		for(int i=0;i<rooms.size();i++){
			String roomType = rooms.get(i).type.toString();
			String type = "";
			
			if(roomType.equals("Single")){
				type = "单人房";
			}
			else if(roomType.equals("Double")){
				type = "双人房";
			}
			else if(roomType.equals("KingSize")){
				type = "大床间";
			}
			else if(roomType.equals("Standard")){
				type = "标准间";
			}
			else if(roomType.equals("Deluxe")){
				type = "豪华间";
			}
			else if(roomType.equals("Business")){
				type = "商务标间";
			}
			else{
				type = "行政标间";
			}
			
			jcbRoomType.addItem(type);
		}
	}
	
	/**
	 * 查找此时所选择的房间类型的可用房间数量
	 */
	public void checkRoomNum(){
		int typeIndex =  jcbRoomType.getSelectedIndex();
		int roomNum = rooms.get(typeIndex).availableRoomNum;
		
		jcbRoomNum.removeAllItems();
		for(int i=1;i<=roomNum;i++){
			jcbRoomNum.addItem(Integer.toString(i));
		}
	}
	
	/**
	 * 确认执行入住操作
	 */
	public void checkinConfirm(){
		OfflineRecordVO newRecord = new OfflineRecordVO();
		
		newRecord.hotel = hotel;
		newRecord.checkinTime = dcpCheckin.getDate();
		newRecord.expectedCheckoutTime = dcpCheckout.getDate();
		int typeIndex =  jcbRoomType.getSelectedIndex();
		newRecord.type = rooms.get(typeIndex).type;
		newRecord.num = Integer.valueOf((String) jcbRoomNum.getSelectedItem());
		
		recordController.offlineCheckin(newRecord);
		jpRecord.refresh(jpRecord.getAllRecords());
		
		this.dispose();
		
		JOptionPane.showMessageDialog(null, "线下入住记录已更新！", "更新成功", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * 取消入住操作
	 */
	public void checkinCancel(){
		this.dispose();
	}
	
}
