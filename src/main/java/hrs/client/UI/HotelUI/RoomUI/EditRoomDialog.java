package hrs.client.UI.HotelUI.RoomUI;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import hrs.client.UI.HotelUI.RoomUI.RoomUIPanel;
import hrs.client.UI.HotelUI.RoomUI.Listener.EditCancelListener;
import hrs.client.UI.HotelUI.RoomUI.Listener.EditConfirmListener;
import hrs.client.util.HMSBlueButton;
import hrs.client.util.HMSGrayButton;
import hrs.client.util.RegExpHelper;
import hrs.common.VO.RoomVO;
import hrs.common.util.type.RoomType;

public class EditRoomDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2803056740619493737L;
	private final JPanel contentPanel = new JPanel();
	private JPanel jpRoom;
	private JPanel jpButton;
	private JLabel jlRoomType;
	private JLabel jlRoomNum;
	private JLabel jlRoomMoney;
	private JLabel jlRMB;
	private JTextField jtfRoomType;
	private JSpinner jsRoomNum;
	private JTextField jtfRoomMoney;
	private HMSBlueButton jbConfirm;
	private HMSGrayButton jbCancel;
	private RoomUIPanel jpRoomUI;
	private EditConfirmListener editConfirmListener;
	private EditCancelListener editCancelListener;

	/**
	 * 初始化修改房间对话框
	 */
	public EditRoomDialog(RoomUIPanel jpRoom) {
		init(jpRoom);
	}
	
	public void init(RoomUIPanel jpRoomUI){
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
		this.setButtonPanel();
		
		this.setTitle("请输入修改房间的信息");
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
		
		jtfRoomType = new JTextField();
		jtfRoomType.setText(jpRoomUI.getSelectedRoomType());
		jtfRoomType.setBounds(150, 15, 145, 30);
		jtfRoomType.setEditable(false);
		
		jsRoomNum = new JSpinner();
		jsRoomNum.setBounds(150, 73, 145, 30);
		jsRoomNum.setModel(new SpinnerNumberModel());
		
		jtfRoomMoney = new JTextField();
		jtfRoomMoney.setBounds(150, 131, 145, 30);
		jtfRoomMoney.setEditable(true);
		
		jpRoom.add(jlRoomType);
		jpRoom.add(jlRoomNum);
		jpRoom.add(jlRoomMoney);
		jpRoom.add(jlRMB);
		jpRoom.add(jtfRoomType);
		jpRoom.add(jsRoomNum);
		jpRoom.add(jtfRoomMoney);
	}
	
	/**
	 * 设置按钮面板
	 */
	public void setButtonPanel(){
		editConfirmListener = new EditConfirmListener(this);
		
		jbConfirm = new HMSBlueButton("确定");
		jbConfirm.setFont(new Font("宋体", Font.PLAIN, 16));
		jbConfirm.setBounds(92, 13, 70, 40);
		jbConfirm.addMouseListener(editConfirmListener);
		
		editCancelListener = new EditCancelListener(this);
		
		jbCancel = new HMSGrayButton("取消");
		jbCancel.setFont(new Font("宋体", Font.PLAIN, 16));
		jbCancel.setBounds(264, 13, 70, 40);
		jbCancel.addMouseListener(editCancelListener);
		
		jpButton.add(jbConfirm);
		jpButton.add(jbCancel);
	}
	
	/**
	 * 确认修改房间信息
	 */
	public void editConfirm(){
		RoomVO editRoom = new RoomVO();
		
		String editRoomType = jtfRoomType.getText();
		editRoom.type = RoomType.getRoomType(editRoomType);
		
		if(((Integer) jsRoomNum.getValue()).intValue()<0){
			JOptionPane.showMessageDialog(this, "房间数量不能为负数！", "错误", JOptionPane.ERROR_MESSAGE);
		}
		else if(((Integer) jsRoomNum.getValue()).intValue()==0){
			JOptionPane.showMessageDialog(this, "房间数量不能为零！", "错误", JOptionPane.ERROR_MESSAGE);
		}
		else if(!RegExpHelper.matchOnlyNum(jtfRoomMoney.getText())){
			JOptionPane.showMessageDialog(this, "原始价格中不能包含非数字字符！", "错误", JOptionPane.ERROR_MESSAGE);
		}
		else if(Double.valueOf(jtfRoomMoney.getText())<0){
			JOptionPane.showMessageDialog(this, "原始价格不能为负数！", "错误", JOptionPane.ERROR_MESSAGE);
		}
		else{
			editRoom.roomNum = ((Integer) jsRoomNum.getValue()).intValue();
			editRoom.roomValue = Double.valueOf(jtfRoomMoney.getText());
			
			jpRoomUI.editRoom(editRoom);
			jpRoomUI.refreshRoomList();
			
			this.dispose();
			
			JOptionPane.showMessageDialog(this, "房间信息已更新", "更新成功", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	/**
	 * 取消修改房间信息
	 */
	public void editCancel(){
		this.dispose();
	}
}
