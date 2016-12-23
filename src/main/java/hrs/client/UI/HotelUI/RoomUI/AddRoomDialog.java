package hrs.client.UI.HotelUI.RoomUI;

import java.awt.BorderLayout;
import java.awt.Font;

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

import hrs.client.UI.HotelUI.RoomUI.RoomUIPanel;
import hrs.client.UI.HotelUI.RoomUI.Listener.AddCancelListener;
import hrs.client.UI.HotelUI.RoomUI.Listener.AddConfirmListener;
import hrs.client.util.HMSBlueButton;
import hrs.client.util.HMSGrayButton;
import hrs.client.util.RegExpHelper;
import hrs.common.Exception.RoomService.RoomNotFoundException;
import hrs.common.VO.RoomVO;
import hrs.common.util.type.RoomType;

import java.util.List;

public class AddRoomDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4148886207645624250L;
	private final JPanel contentPanel = new JPanel();
	private JPanel jpRoom;
	private JPanel jpButton;
	private JLabel jlRoomType;
	private JLabel jlRoomNum;
	private JLabel jlRoomMoney;
	private JLabel jlRMB;
	private JComboBox<String> jcbRoomType;
	private JSpinner jsRoomNum;
	private JTextField jtfMoney;
	private HMSBlueButton jbConfirm;
	private HMSGrayButton jbCancel;
	private AddCancelListener addCancelListener;
	private AddConfirmListener addConfirmListener;
	private RoomUIPanel jpRoomUI;

	/**
	 * 初始化添加房间对话框
	 */
	public AddRoomDialog(List<RoomType> roomType, RoomUIPanel jpRoomUI) {
		this.jpRoomUI = jpRoomUI;
		setSize(450, 300);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		this.setPanel();
		this.setRoomPanel();
		this.getRoomTypes(roomType);
		this.setButtonPanel();
		
		this.setTitle("请输入新增房间的信息");
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
	/**
	 * 设置面板
	 */
	public void setPanel(){
		jpRoom = new JPanel();
		jpRoom.setBounds(0, 0, 432, 181);
		jpRoom.setLayout(null);
		
		jpButton = new JPanel();
		jpButton.setBounds(0, 181, 432, 69);
		jpButton.setLayout(null);
		
		contentPanel.add(jpRoom);
		contentPanel.add(jpButton);
	}
	
	/**
	 * 设置房间信息面板
	 */
	public void setRoomPanel(){
		jlRoomType = new JLabel();
		jlRoomType.setFont(new Font("宋体", Font.PLAIN, 18));
		jlRoomType.setText("房间类型");
		jlRoomType.setBounds(25, 13, 80, 30);
		
		jlRoomNum = new JLabel();
		jlRoomNum.setFont(new Font("宋体", Font.PLAIN, 18));
		jlRoomNum.setText("房间数量");
		jlRoomNum.setBounds(25, 71, 80, 30);
		
		jlRoomMoney = new JLabel();
		jlRoomMoney.setFont(new Font("宋体", Font.PLAIN, 18));
		jlRoomMoney.setText("原始价格");
		jlRoomMoney.setBounds(25, 129, 80, 30);
		
		jlRMB = new JLabel();
		jlRMB.setFont(new Font("宋体", Font.PLAIN, 18));
		jlRMB.setText("元");
		jlRMB.setBounds(323, 129, 80, 30);
		
		jcbRoomType = new JComboBox<String>();
		jcbRoomType.setBounds(150, 15, 145, 30);
		jcbRoomType.setEditable(false);
		
		jsRoomNum = new JSpinner();
		jsRoomNum.setBounds(150, 73, 145, 30);
		jsRoomNum.setModel(new SpinnerNumberModel());
		
		jtfMoney = new JTextField();
		jtfMoney.setBounds(150, 131, 145, 30);
		jtfMoney.setEditable(true);
		
		jpRoom.add(jlRoomType);
		jpRoom.add(jlRoomNum);
		jpRoom.add(jlRoomMoney);
		jpRoom.add(jlRMB);
		jpRoom.add(jcbRoomType);
		jpRoom.add(jsRoomNum);
		jpRoom.add(jtfMoney);
	}
	
	/**
	 * 设置按钮面板
	 */
	public void setButtonPanel(){
		addConfirmListener = new AddConfirmListener(this);
		
		jbConfirm = new HMSBlueButton("确定");
		jbConfirm.setFont(new Font("宋体", Font.PLAIN, 16));
		jbConfirm.setBounds(92, 13, 70, 40);
		jbConfirm.addMouseListener(addConfirmListener);
		
		addCancelListener = new AddCancelListener(this);
		
		jbCancel = new HMSGrayButton("取消");
		jbCancel.setFont(new Font("宋体", Font.PLAIN, 16));
		jbCancel.setBounds(264, 13, 70, 40);
		jbCancel.addMouseListener(addCancelListener);
		
		jpButton.add(jbConfirm);
		jpButton.add(jbCancel);
	}
	
	/**
	 * 获得可选的房间类型，放进房间类型下拉框中
	 * @param roomType
	 */
	public void getRoomTypes(List<RoomType> roomType){
		int size = roomType.size();
		String roomTypes[] = new String[size];
		
		for(int i=0;i<size;i++){
			if(roomType.get(i).toString().equals("Single")){
				roomTypes[i] =  "单人房";
			}
			else if(roomType.get(i).toString().equals("Double")){
				roomTypes[i] = "双人房";
			}
			else if(roomType.get(i).toString().equals("KingSize")){
				roomTypes[i] = "大床间";
			}
			else if(roomType.get(i).toString().equals("Standard")){
				roomTypes[i] = "标准间";
			}
			else if(roomType.get(i).toString().equals("Deluxe")){
				roomTypes[i] = "豪华间";
			}
			else if(roomType.get(i).toString().equals("Business")){
				roomTypes[i] = "商务标间";
			}
			else if(roomType.get(i).toString().equals("Executive")){
				roomTypes[i] = "行政标间";
			}
			
			jcbRoomType.addItem(roomTypes[i]);
		}
	}
	
	/**
	 * 确认添加房间
	 * @throws RoomNotFoundException 
	 */
	public void addConfirm(){
		RoomVO newRoom = new RoomVO();
		
		String newType = (String) jcbRoomType.getSelectedItem();
		newRoom.type = RoomType.getRoomType(newType);
		
		if(((Integer) jsRoomNum.getValue()).intValue()<0){
			JOptionPane.showMessageDialog(this, "房间数量不能为负数！", "错误", JOptionPane.ERROR_MESSAGE);
		}
		else if(((Integer) jsRoomNum.getValue()).intValue()==0){
			JOptionPane.showMessageDialog(this, "房间数量不能为零！", "错误", JOptionPane.ERROR_MESSAGE);
		}
		else if(!RegExpHelper.matchOnlyNum(jtfMoney.getText())){
			JOptionPane.showMessageDialog(this, "原始价格中不能包含非数字字符！", "错误", JOptionPane.ERROR_MESSAGE);
		}
		else if(Double.valueOf(jtfMoney.getText())<0){
			JOptionPane.showMessageDialog(this, "原始价格不能为负数！", "错误", JOptionPane.ERROR_MESSAGE);
		}
		else{
			newRoom.roomNum = ((Integer) jsRoomNum.getValue()).intValue();
			newRoom.roomValue = Double.valueOf(jtfMoney.getText());
			
			jpRoomUI.addRoom(newRoom);
			jpRoomUI.refreshRoomList();
			
			this.dispose();
			
			JOptionPane.showMessageDialog(this, "房间信息已更新", "更新成功", JOptionPane.INFORMATION_MESSAGE);
		}

	}
	
	/**
	 * 取消添加房间
	 */
	public void addCancel(){
		this.dispose();
	}
	
}
