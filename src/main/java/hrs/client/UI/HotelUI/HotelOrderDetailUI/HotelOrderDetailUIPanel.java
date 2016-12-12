package hrs.client.UI.HotelUI.HotelOrderDetailUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import hrs.client.UI.HotelUI.HotelOrderDetailUI.Listener.ReturnListener;
import hrs.client.UI.HotelUI.HotelOrderUI.HotelOrderMainPanel;
import hrs.client.util.HMSBlueButton;
import hrs.client.util.UIConstants;
import hrs.common.VO.OrderVO;
import hrs.common.util.DateHelper;

public class HotelOrderDetailUIPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1880061535262342363L;
	private JPanel jpDetail;
	private JPanel jpButton;
	private HMSBlueButton jbReturn;
	private JLabel jlID;
	private JLabel jlPlaceOrder;
	private JLabel jlExecute;
	private JLabel jlCheckin;
	private JLabel jlExpectedCheckout;
	private JLabel jlCheckout;
	private JLabel jlCancel;
	private JLabel jlRoomType;
	private JLabel jlRoomNum;
	private JLabel jlPeople;
	private JLabel jlChildren;
	private JLabel jlMoney;
	private JLabel jlOrderStatus;
	private JLabel jlUsername;
	private JLabel jlName;
	private JLabel jlBirthday;
	private JLabel jlPhoneNum;
	private JLabel jlFirm;
	private JLabel jlCredit;
	private JTextField jtfID;
	private JTextField jtfPlaceOrder;
	private JTextField jtfExecute;
	private JTextField jtfCheckin;
	private JTextField jtfExpectedCheckout;
	private JTextField jtfCheckout;
	private JTextField jtfCancel;
	private JTextField jtfRoomType;
	private JTextField jtfRoomNum;
	private JTextField jtfPeople;
	private JTextField jtfChildren;
	private JTextField jtfMoney;
	private JTextField jtfOrderStatus;
	private JTextField jtfUsername;
	private JTextField jtfName;
	private JTextField jtfBirthday;
	private JTextField jtfPhoneNum;
	private JTextField jtfFirm;
	private JTextField jtfCredit;
	private ReturnListener returnListener;
	private Color panelColor;
	private Font font;
	
	/**
	 * 初始化酒店详细订单界面
	 */
	public HotelOrderDetailUIPanel(HotelOrderMainPanel jpMain) {
		init(jpMain);
	}
	
	public void init(HotelOrderMainPanel jpMain){
		this.setSize(1080, 722);
		this.setLayout(null);
		
		panelColor = UIConstants.JFRAME;
		font = UIConstants.FONT_19;
		
		jpDetail = new JPanel();
		jpDetail.setBounds(0, 0, 1080, 642);
		jpDetail.setBackground(panelColor);
		GridBagLayout gbl_jpDetail = new GridBagLayout();
		gbl_jpDetail.columnWidths = new int[]{160, 190, 160, 356, 90, 0};
		gbl_jpDetail.rowHeights = new int[]{45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45};
		gbl_jpDetail.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_jpDetail.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		jpDetail.setLayout(gbl_jpDetail);
		
		
		jpButton = new JPanel();
		jpButton.setBounds(0, 642, 1080, 80);
		jpButton.setBackground(panelColor);
		jpButton.setLayout(null);
		
		returnListener = new ReturnListener(jpMain);
		
		jbReturn = new HMSBlueButton("返回");
		jbReturn.setBounds(805, 13, 90, 40);
		jbReturn.addMouseListener(returnListener);
		
		jpButton.add(jbReturn);
		
		this.add(jpDetail);
		
		jlID = new JLabel("订单号");
		jlID.setFont(font);
		jlID.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_jlID = new GridBagConstraints();
		gbc_jlID.insets = new Insets(0, 0, 5, 5);
		gbc_jlID.gridx = 0;
		gbc_jlID.gridy = 0;
		jpDetail.add(jlID, gbc_jlID);
		
		jtfID = new JTextField();
		jtfID.setEditable(false);
		jtfID.setFont(font);
		jtfID.setOpaque(true);
		jtfID.setBorder(new EmptyBorder(0,0,0,0));
		jtfID.setBackground(panelColor);
		GridBagConstraints gbc_jtfID = new GridBagConstraints();
		gbc_jtfID.fill = GridBagConstraints.BOTH;
		gbc_jtfID.insets = new Insets(0, 0, 5, 5);
		gbc_jtfID.gridx = 1;
		gbc_jtfID.gridy = 0;
		jpDetail.add(jtfID, gbc_jtfID);
		jtfID.setColumns(10);
		
		jlUsername = new JLabel("用户名");
		jlUsername.setHorizontalAlignment(SwingConstants.CENTER);
		jlUsername.setFont(font);
		GridBagConstraints gbc_jlUsername = new GridBagConstraints();
		gbc_jlUsername.insets = new Insets(0, 0, 5, 5);
		gbc_jlUsername.gridx = 2;
		gbc_jlUsername.gridy = 0;
		jpDetail.add(jlUsername, gbc_jlUsername);
		
		jtfUsername = new JTextField();
		jtfUsername.setFont(font);
		jtfUsername.setEditable(false);
		jtfUsername.setOpaque(true);
		jtfUsername.setBorder(new EmptyBorder(0,0,0,0));
		jtfUsername.setBackground(panelColor);
		GridBagConstraints gbc_jtfUsername = new GridBagConstraints();
		gbc_jtfUsername.insets = new Insets(0, 0, 5, 5);
		gbc_jtfUsername.fill = GridBagConstraints.BOTH;
		gbc_jtfUsername.gridx = 3;
		gbc_jtfUsername.gridy = 0;
		jpDetail.add(jtfUsername, gbc_jtfUsername);
		jtfUsername.setColumns(10);
		
		jlPlaceOrder = new JLabel("下单时间");
		jlPlaceOrder.setFont(font);
		jlPlaceOrder.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_jlPlaceOrder = new GridBagConstraints();
		gbc_jlPlaceOrder.insets = new Insets(0, 0, 5, 5);
		gbc_jlPlaceOrder.gridx = 0;
		gbc_jlPlaceOrder.gridy = 1;
		jpDetail.add(jlPlaceOrder, gbc_jlPlaceOrder);
		
		jtfPlaceOrder = new JTextField();
		jtfPlaceOrder.setEditable(false);
		jtfPlaceOrder.setFont(font);
		jtfPlaceOrder.setOpaque(true);
		jtfPlaceOrder.setBorder(new EmptyBorder(0,0,0,0));
		jtfPlaceOrder.setBackground(panelColor);
		GridBagConstraints gbc_jtfPlaceOrder = new GridBagConstraints();
		gbc_jtfPlaceOrder.insets = new Insets(0, 0, 5, 5);
		gbc_jtfPlaceOrder.fill = GridBagConstraints.BOTH;
		gbc_jtfPlaceOrder.gridx = 1;
		gbc_jtfPlaceOrder.gridy = 1;
		jpDetail.add(jtfPlaceOrder, gbc_jtfPlaceOrder);
		jtfPlaceOrder.setColumns(10);
		
		jlName = new JLabel("真实姓名");
		jlName.setHorizontalAlignment(SwingConstants.CENTER);
		jlName.setFont(font);
		GridBagConstraints gbc_jlName = new GridBagConstraints();
		gbc_jlName.insets = new Insets(0, 0, 5, 5);
		gbc_jlName.gridx = 2;
		gbc_jlName.gridy = 1;
		jpDetail.add(jlName, gbc_jlName);
		
		jtfName = new JTextField();
		jtfName.setFont(font);
		jtfName.setEditable(false);
		jtfName.setOpaque(true);
		jtfName.setBorder(new EmptyBorder(0,0,0,0));
		jtfName.setBackground(panelColor);
		GridBagConstraints gbc_jtfName = new GridBagConstraints();
		gbc_jtfName.insets = new Insets(0, 0, 5, 5);
		gbc_jtfName.fill = GridBagConstraints.BOTH;
		gbc_jtfName.gridx = 3;
		gbc_jtfName.gridy = 1;
		jpDetail.add(jtfName, gbc_jtfName);
		jtfName.setColumns(10);
		
		jlExecute = new JLabel("执行时间");
		jlExecute.setHorizontalAlignment(SwingConstants.CENTER);
		jlExecute.setFont(font);
		GridBagConstraints gbc_jlExecute = new GridBagConstraints();
		gbc_jlExecute.insets = new Insets(0, 0, 5, 5);
		gbc_jlExecute.gridx = 0;
		gbc_jlExecute.gridy = 2;
		jpDetail.add(jlExecute, gbc_jlExecute);
		
		jtfExecute = new JTextField();
		jtfExecute.setEditable(false);
		jtfExecute.setFont(font);
		jtfExecute.setOpaque(true);
		jtfExecute.setBorder(new EmptyBorder(0,0,0,0));
		jtfExecute.setBackground(panelColor);
		GridBagConstraints gbc_jtfExecute = new GridBagConstraints();
		gbc_jtfExecute.insets = new Insets(0, 0, 5, 5);
		gbc_jtfExecute.fill = GridBagConstraints.BOTH;
		gbc_jtfExecute.gridx = 1;
		gbc_jtfExecute.gridy = 2;
		jpDetail.add(jtfExecute, gbc_jtfExecute);
		jtfExecute.setColumns(10);
		
		jlBirthday = new JLabel("生日");
		jlBirthday.setHorizontalAlignment(SwingConstants.CENTER);
		jlBirthday.setFont(font);
		GridBagConstraints gbc_jlBirthday = new GridBagConstraints();
		gbc_jlBirthday.insets = new Insets(0, 0, 5, 5);
		gbc_jlBirthday.gridx = 2;
		gbc_jlBirthday.gridy = 2;
		jpDetail.add(jlBirthday, gbc_jlBirthday);
		
		jtfBirthday = new JTextField();
		jtfBirthday.setFont(font);
		jtfBirthday.setEditable(false);
		jtfBirthday.setOpaque(true);
		jtfBirthday.setBorder(new EmptyBorder(0,0,0,0));
		jtfBirthday.setBackground(panelColor);
		GridBagConstraints gbc_jtfBirthday = new GridBagConstraints();
		gbc_jtfBirthday.insets = new Insets(0, 0, 5, 5);
		gbc_jtfBirthday.fill = GridBagConstraints.BOTH;
		gbc_jtfBirthday.gridx = 3;
		gbc_jtfBirthday.gridy = 2;
		jpDetail.add(jtfBirthday, gbc_jtfBirthday);
		jtfBirthday.setColumns(10);
		
		jlCheckin = new JLabel("入住时间");
		jlCheckin.setHorizontalAlignment(SwingConstants.CENTER);
		jlCheckin.setFont(font);
		GridBagConstraints gbc_jlCheckin = new GridBagConstraints();
		gbc_jlCheckin.insets = new Insets(0, 0, 5, 5);
		gbc_jlCheckin.gridx = 0;
		gbc_jlCheckin.gridy = 3;
		jpDetail.add(jlCheckin, gbc_jlCheckin);
		
		jtfCheckin = new JTextField();
		jtfCheckin.setEditable(false);
		jtfCheckin.setFont(font);
		jtfCheckin.setOpaque(true);
		jtfCheckin.setBorder(new EmptyBorder(0,0,0,0));
		jtfCheckin.setBackground(panelColor);
		GridBagConstraints gbc_jtfCheckin = new GridBagConstraints();
		gbc_jtfCheckin.insets = new Insets(0, 0, 5, 5);
		gbc_jtfCheckin.fill = GridBagConstraints.BOTH;
		gbc_jtfCheckin.gridx = 1;
		gbc_jtfCheckin.gridy = 3;
		jpDetail.add(jtfCheckin, gbc_jtfCheckin);
		jtfCheckin.setColumns(10);
		
		jlPhoneNum = new JLabel("联系方式");
		jlPhoneNum.setHorizontalAlignment(SwingConstants.CENTER);
		jlPhoneNum.setFont(font);
		GridBagConstraints gbc_jlPhoneNum = new GridBagConstraints();
		gbc_jlPhoneNum.insets = new Insets(0, 0, 5, 5);
		gbc_jlPhoneNum.gridx = 2;
		gbc_jlPhoneNum.gridy = 3;
		jpDetail.add(jlPhoneNum, gbc_jlPhoneNum);
		
		jtfPhoneNum = new JTextField();
		jtfPhoneNum.setFont(font);
		jtfPhoneNum.setEditable(false);
		jtfPhoneNum.setOpaque(true);
		jtfPhoneNum.setBorder(new EmptyBorder(0,0,0,0));
		jtfPhoneNum.setBackground(panelColor);
		GridBagConstraints gbc_jtfPhoneNum = new GridBagConstraints();
		gbc_jtfPhoneNum.insets = new Insets(0, 0, 5, 5);
		gbc_jtfPhoneNum.fill = GridBagConstraints.BOTH;
		gbc_jtfPhoneNum.gridx = 3;
		gbc_jtfPhoneNum.gridy = 3;
		jpDetail.add(jtfPhoneNum, gbc_jtfPhoneNum);
		jtfPhoneNum.setColumns(10);
		
		jlExpectedCheckout = new JLabel("预计离开时间");
		jlExpectedCheckout.setHorizontalAlignment(SwingConstants.CENTER);
		jlExpectedCheckout.setFont(font);
		GridBagConstraints gbc_jlExpectedCheckout = new GridBagConstraints();
		gbc_jlExpectedCheckout.insets = new Insets(0, 0, 5, 5);
		gbc_jlExpectedCheckout.gridx = 0;
		gbc_jlExpectedCheckout.gridy = 4;
		jpDetail.add(jlExpectedCheckout, gbc_jlExpectedCheckout);
		
		jtfExpectedCheckout = new JTextField();
		jtfExpectedCheckout.setEditable(false);
		jtfExpectedCheckout.setFont(font);
		jtfExpectedCheckout.setOpaque(true);
		jtfExpectedCheckout.setBorder(new EmptyBorder(0,0,0,0));
		jtfExpectedCheckout.setBackground(panelColor);
		GridBagConstraints gbc_jtfExpectedCheckout = new GridBagConstraints();
		gbc_jtfExpectedCheckout.insets = new Insets(0, 0, 5, 5);
		gbc_jtfExpectedCheckout.fill = GridBagConstraints.BOTH;
		gbc_jtfExpectedCheckout.gridx = 1;
		gbc_jtfExpectedCheckout.gridy = 4;
		jpDetail.add(jtfExpectedCheckout, gbc_jtfExpectedCheckout);
		jtfExpectedCheckout.setColumns(10);
		
		jlFirm = new JLabel("企业名称");
		jlFirm.setFont(font);
		jlFirm.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_jlFirm = new GridBagConstraints();
		gbc_jlFirm.insets = new Insets(0, 0, 5, 5);
		gbc_jlFirm.gridx = 2;
		gbc_jlFirm.gridy = 4;
		jpDetail.add(jlFirm, gbc_jlFirm);
		
		jtfFirm = new JTextField();
		jtfFirm.setFont(font);
		jtfFirm.setEditable(false);
		jtfFirm.setOpaque(true);
		jtfFirm.setBorder(new EmptyBorder(0,0,0,0));
		jtfFirm.setBackground(panelColor);
		GridBagConstraints gbc_jftFirm = new GridBagConstraints();
		gbc_jftFirm.insets = new Insets(0, 0, 5, 5);
		gbc_jftFirm.fill = GridBagConstraints.BOTH;
		gbc_jftFirm.gridx = 3;
		gbc_jftFirm.gridy = 4;
		jpDetail.add(jtfFirm, gbc_jftFirm);
		jtfFirm.setColumns(10);
		
		jlCheckout = new JLabel("退房时间");
		jlCheckout.setHorizontalAlignment(SwingConstants.CENTER);
		jlCheckout.setFont(font);
		GridBagConstraints gbc_jlCheckout = new GridBagConstraints();
		gbc_jlCheckout.insets = new Insets(0, 0, 5, 5);
		gbc_jlCheckout.gridx = 0;
		gbc_jlCheckout.gridy = 5;
		jpDetail.add(jlCheckout, gbc_jlCheckout);
		
		jtfCheckout = new JTextField();
		jtfCheckout.setFont(font);
		jtfCheckout.setEditable(false);
		jtfCheckout.setOpaque(true);
		jtfCheckout.setBorder(new EmptyBorder(0,0,0,0));
		jtfCheckout.setBackground(panelColor);
		GridBagConstraints gbc_jtfCheckout = new GridBagConstraints();
		gbc_jtfCheckout.insets = new Insets(0, 0, 5, 5);
		gbc_jtfCheckout.fill = GridBagConstraints.BOTH;
		gbc_jtfCheckout.gridx = 1;
		gbc_jtfCheckout.gridy = 5;
		jpDetail.add(jtfCheckout, gbc_jtfCheckout);
		jtfCheckout.setColumns(10);
		
		jlCredit = new JLabel("信用值");
		jlCredit.setHorizontalAlignment(SwingConstants.CENTER);
		jlCredit.setFont(font);
		GridBagConstraints gbc_jlCredit = new GridBagConstraints();
		gbc_jlCredit.insets = new Insets(0, 0, 5, 5);
		gbc_jlCredit.gridx = 2;
		gbc_jlCredit.gridy = 5;
		jpDetail.add(jlCredit, gbc_jlCredit);
		
		jtfCredit = new JTextField();
		jtfCredit.setFont(font);
		jtfCredit.setEditable(false);
		jtfCredit.setOpaque(true);
		jtfCredit.setBorder(new EmptyBorder(0,0,0,0));
		jtfCredit.setBackground(panelColor);
		GridBagConstraints gbc_jtfCredit = new GridBagConstraints();
		gbc_jtfCredit.insets = new Insets(0, 0, 5, 5);
		gbc_jtfCredit.fill = GridBagConstraints.BOTH;
		gbc_jtfCredit.gridx = 3;
		gbc_jtfCredit.gridy = 5;
		jpDetail.add(jtfCredit, gbc_jtfCredit);
		jtfCredit.setColumns(10);
		
		jlCancel = new JLabel("撤销时间");
		jlCancel.setHorizontalAlignment(SwingConstants.CENTER);
		jlCancel.setFont(font);
		GridBagConstraints gbc_jlCancel = new GridBagConstraints();
		gbc_jlCancel.insets = new Insets(0, 0, 5, 5);
		gbc_jlCancel.gridx = 0;
		gbc_jlCancel.gridy = 6;
		jpDetail.add(jlCancel, gbc_jlCancel);
		
		jtfCancel = new JTextField();
		jtfCancel.setFont(font);
		jtfCancel.setEditable(false);
		jtfCancel.setOpaque(true);
		jtfCancel.setBorder(new EmptyBorder(0,0,0,0));
		jtfCancel.setBackground(panelColor);
		GridBagConstraints gbc_jtfCancel = new GridBagConstraints();
		gbc_jtfCancel.insets = new Insets(0, 0, 5, 5);
		gbc_jtfCancel.fill = GridBagConstraints.BOTH;
		gbc_jtfCancel.gridx = 1;
		gbc_jtfCancel.gridy = 6;
		jpDetail.add(jtfCancel, gbc_jtfCancel);
		jtfCancel.setColumns(10);
		
		jlRoomType = new JLabel("房间类型");
		jlRoomType.setFont(font);
		jlRoomType.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_jlRoomType = new GridBagConstraints();
		gbc_jlRoomType.insets = new Insets(0, 0, 5, 5);
		gbc_jlRoomType.gridx = 0;
		gbc_jlRoomType.gridy = 7;
		jpDetail.add(jlRoomType, gbc_jlRoomType);
		
		jtfRoomType = new JTextField();
		jtfRoomType.setEditable(false);
		jtfRoomType.setFont(font);
		jtfRoomType.setOpaque(true);
		jtfRoomType.setBorder(new EmptyBorder(0,0,0,0));
		jtfRoomType.setBackground(panelColor);
		GridBagConstraints gbc_jtfRoomType = new GridBagConstraints();
		gbc_jtfRoomType.insets = new Insets(0, 0, 5, 5);
		gbc_jtfRoomType.fill = GridBagConstraints.BOTH;
		gbc_jtfRoomType.gridx = 1;
		gbc_jtfRoomType.gridy = 7;
		jpDetail.add(jtfRoomType, gbc_jtfRoomType);
		jtfRoomType.setColumns(10);
		
		jlRoomNum = new JLabel("房间数量");
		jlRoomNum.setFont(font);
		GridBagConstraints gbc_jlRoomNum = new GridBagConstraints();
		gbc_jlRoomNum.insets = new Insets(0, 0, 5, 5);
		gbc_jlRoomNum.gridx = 0;
		gbc_jlRoomNum.gridy = 8;
		jpDetail.add(jlRoomNum, gbc_jlRoomNum);
		
		jtfRoomNum = new JTextField();
		jtfRoomNum.setFont(font);
		jtfRoomNum.setEditable(false);
		jtfRoomNum.setOpaque(true);
		jtfRoomNum.setBorder(new EmptyBorder(0,0,0,0));
		jtfRoomNum.setBackground(panelColor);
		GridBagConstraints gbc_jtfRoomNum = new GridBagConstraints();
		gbc_jtfRoomNum.insets = new Insets(0, 0, 5, 5);
		gbc_jtfRoomNum.fill = GridBagConstraints.BOTH;
		gbc_jtfRoomNum.gridx = 1;
		gbc_jtfRoomNum.gridy = 8;
		jpDetail.add(jtfRoomNum, gbc_jtfRoomNum);
		jtfRoomNum.setColumns(10);
		
		jlPeople = new JLabel("入住人数");
		jlPeople.setHorizontalAlignment(SwingConstants.CENTER);
		jlPeople.setFont(font);
		GridBagConstraints gbc_jlPeople = new GridBagConstraints();
		gbc_jlPeople.insets = new Insets(0, 0, 5, 5);
		gbc_jlPeople.gridx = 0;
		gbc_jlPeople.gridy = 9;
		jpDetail.add(jlPeople, gbc_jlPeople);
		
		jtfPeople = new JTextField();
		jtfPeople.setFont(font);
		jtfPeople.setEditable(false);
		jtfPeople.setOpaque(true);
		jtfPeople.setBorder(new EmptyBorder(0,0,0,0));
		jtfPeople.setBackground(panelColor);
		GridBagConstraints gbc_jtfPeople = new GridBagConstraints();
		gbc_jtfPeople.insets = new Insets(0, 0, 5, 5);
		gbc_jtfPeople.fill = GridBagConstraints.BOTH;
		gbc_jtfPeople.gridx = 1;
		gbc_jtfPeople.gridy = 9;
		jpDetail.add(jtfPeople, gbc_jtfPeople);
		jtfPeople.setColumns(10);
		
		jlChildren = new JLabel("有无儿童");
		jlChildren.setFont(font);
		jlChildren.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_jlChildren = new GridBagConstraints();
		gbc_jlChildren.insets = new Insets(0, 0, 5, 5);
		gbc_jlChildren.gridx = 0;
		gbc_jlChildren.gridy = 10;
		jpDetail.add(jlChildren, gbc_jlChildren);
		
		jtfChildren = new JTextField();
		jtfChildren.setFont(font);
		jtfChildren.setEditable(false);
		jtfChildren.setOpaque(true);
		jtfChildren.setBorder(new EmptyBorder(0,0,0,0));
		jtfChildren.setBackground(panelColor);
		GridBagConstraints gbc_jtfChildren = new GridBagConstraints();
		gbc_jtfChildren.insets = new Insets(0, 0, 5, 5);
		gbc_jtfChildren.fill = GridBagConstraints.BOTH;
		gbc_jtfChildren.gridx = 1;
		gbc_jtfChildren.gridy = 10;
		jpDetail.add(jtfChildren, gbc_jtfChildren);
		jtfChildren.setColumns(10);
		
		jlMoney = new JLabel("金额");
		jlMoney.setFont(font);
		GridBagConstraints gbc_jlMoney = new GridBagConstraints();
		gbc_jlMoney.insets = new Insets(0, 0, 5, 5);
		gbc_jlMoney.gridx = 0;
		gbc_jlMoney.gridy = 11;
		jpDetail.add(jlMoney, gbc_jlMoney);
		
		jtfMoney = new JTextField();
		jtfMoney.setFont(font);
		jtfMoney.setEditable(false);
		jtfMoney.setOpaque(true);
		jtfMoney.setBorder(new EmptyBorder(0,0,0,0));
		jtfMoney.setBackground(panelColor);
		GridBagConstraints gbc_jtfMoney = new GridBagConstraints();
		gbc_jtfMoney.insets = new Insets(0, 0, 5, 5);
		gbc_jtfMoney.fill = GridBagConstraints.BOTH;
		gbc_jtfMoney.gridx = 1;
		gbc_jtfMoney.gridy = 11;
		jpDetail.add(jtfMoney, gbc_jtfMoney);
		jtfMoney.setColumns(10);
		
		jlOrderStatus = new JLabel("订单状态");
		jlOrderStatus.setHorizontalAlignment(SwingConstants.CENTER);
		jlOrderStatus.setFont(font);
		GridBagConstraints gbc_jlOrderStatus = new GridBagConstraints();
		gbc_jlOrderStatus.insets = new Insets(0, 0, 0, 5);
		gbc_jlOrderStatus.gridx = 0;
		gbc_jlOrderStatus.gridy = 12;
		jpDetail.add(jlOrderStatus, gbc_jlOrderStatus);
		
		jtfOrderStatus = new JTextField();
		jtfOrderStatus.setFont(font);
		jtfOrderStatus.setEditable(false);
		jtfOrderStatus.setOpaque(true);
		jtfOrderStatus.setBorder(new EmptyBorder(0,0,0,0));
		jtfOrderStatus.setBackground(panelColor);
		GridBagConstraints gbc_jtfOrderStatus = new GridBagConstraints();
		gbc_jtfOrderStatus.insets = new Insets(0, 0, 0, 5);
		gbc_jtfOrderStatus.fill = GridBagConstraints.BOTH;
		gbc_jtfOrderStatus.gridx = 1;
		gbc_jtfOrderStatus.gridy = 12;
		jpDetail.add(jtfOrderStatus, gbc_jtfOrderStatus);
		jtfOrderStatus.setColumns(10);
		this.add(jpButton);
	}
	
	/**
	 * 显示相应订单的详细信息
	 * @param order
	 */
	public void showDetailInfo(OrderVO order){
		jtfID.setText(Integer.toString(order.id));
		jtfPlaceOrder.setText(DateHelper.format(order.placeTime));
		jtfExecute.setText(DateHelper.format(order.execTime));
		jtfCheckin.setText(DateHelper.format(order.checkinTime));
		jtfExpectedCheckout.setText(DateHelper.format(order.expectedCheckoutTime));
		jtfCheckout.setText(DateHelper.format(order.checkoutTime));
		jtfCancel.setText(DateHelper.format(order.revokeTime));
		
		if(order.type.toString().equals("Single")){
			jtfRoomType.setText("单人房");
		}
		else if(order.type.toString().equals("Double")){
			jtfRoomType.setText("双人房");
		}
		else if(order.type.toString().equals("KingSize")){
			jtfRoomType.setText("大床间");
		}
		else if(order.type.toString().equals("Standard")){
			jtfRoomType.setText("标准间");
		}
		else if(order.type.toString().equals("Deluxe")){
			jtfRoomType.setText("豪华间");
		}
		else if(order.type.toString().equals("Business")){
			jtfRoomType.setText("商务标间");
		}
		else{
			jtfRoomType.setText("行政标间");
		}
		
		jtfRoomNum.setText(Integer.toString(order.roomNum));
		jtfPeople.setText(Integer.toString(order.peopleNum));
		
		if(order.hasChild){
			jtfChildren.setText("有");
		}
		else{
			jtfChildren.setText("无");
		}
		
		jtfMoney.setText(Double.toString(order.value));
		
		if(order.status.toString().equals("Unexecuted")){
			jtfOrderStatus.setText("未执行");
		}
		else if(order.status.toString().equals("Executed")){
			jtfOrderStatus.setText("已执行");
		}
		else if(order.status.toString().equals("Abnormal")){
			jtfOrderStatus.setText("异常");
		}
		else if(order.status.toString().equals("RevokedHalfValue")||order.type.toString().equals("RevokedFullValue")||order.type.toString().equals("UserRevoked")){
			jtfOrderStatus.setText("已撤销");
		}
		
		jtfUsername.setText(order.user.username);
		jtfName.setText(order.user.name);
		jtfBirthday.setText(DateHelper.format(order.user.birthDate));
		jtfPhoneNum.setText(order.user.phone);
		jtfFirm.setText(order.user.enterprise);
		jtfCredit.setText(Double.toString(order.user.credit));
	}
}