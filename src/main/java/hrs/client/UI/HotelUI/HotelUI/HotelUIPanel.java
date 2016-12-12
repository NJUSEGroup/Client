package hrs.client.UI.HotelUI.HotelUI;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import hrs.client.UI.HotelUI.HotelUI.Listener.CancelListener;
import hrs.client.UI.HotelUI.HotelUI.Listener.CityListener;
import hrs.client.UI.HotelUI.HotelUI.Listener.EditListener;
import hrs.client.util.ControllerFactory;
import hrs.client.util.HMSBlueButton;
import hrs.client.util.HMSGrayButton;
import hrs.client.util.RegExpHelper;
import hrs.client.util.UIConstants;
import hrs.common.Controller.HotelController.IHotelController;
import hrs.common.VO.CommercialCircleVO;
import hrs.common.VO.HotelVO;
import hrs.common.VO.LocationVO;

public class HotelUIPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel jpHotelInfo;
	private JPanel jpButton;
	private JScrollPane jspIntro;
	private JScrollPane jspService;
	private JLabel jlHotelName;
	private JLabel jlCity;
	private JLabel jlCircle;
	private JLabel jlAddress;
	private JLabel jlIntro;
	private JLabel jlService;
	private JLabel jlStar;
	private JLabel jlScore;
	private JTextField jtfHotelName;
	private JTextField jtfAddress;
	private JTextField jtfScore;
	private JComboBox<String> jcbCity;
	private JComboBox<String> jcbCircle;
	private JTextArea jtaIntro;
	private JTextArea jtaService;
	private JComboBox<String> jcbStar;
	private HMSBlueButton jbEdit;
	private HMSGrayButton jbCancel;
	private EditListener editListener;
	private CancelListener cancelListener;
	private CityListener cityListener;
	private HotelVO hotel;
	private IHotelController hotelController;
	private List<LocationVO> city;
	private List<CommercialCircleVO> circle;
	private Font hotelUIFont;
	private Color panelColor;
	
	/**
	 * 初始化酒店信息界面面板
	 */
	public HotelUIPanel(HotelVO hotel) {
		init(hotel);
	}

	public void init(HotelVO hotel){
		this.hotel = hotel;
		this.setSize(1080, 722);
		this.setLayout(null);
		
		this.setFontAndColor();
		this.setPanel();
		this.setLabel();
		this.setInfoComponents();
		this.getCity();
		this.setButton();
		
		this.showHotelInfo();
	}
	
	public void setFontAndColor(){
		hotelUIFont = UIConstants.FONT_19;
		panelColor = UIConstants.JFRAME;
	}
	
	/**
	 * 设置面板
	 */
	public void setPanel(){
		jpHotelInfo = new JPanel();
		jpHotelInfo.setBounds(0, 0, 1080, 642);
		jpHotelInfo.setBackground(panelColor);
		jpHotelInfo.setLayout(null);
		
		jpButton = new JPanel();
		jpButton.setBounds(0, 642, 1080, 80);
		jpButton.setBackground(panelColor);
		jpButton.setLayout(null);
		
		this.add(jpHotelInfo);
		this.add(jpButton);
	}
	
	/**
	 * 设置标签
	 */
	public void setLabel(){
		jlHotelName = new JLabel();
		jlHotelName.setBounds(30, 20, 90, 30);
		jlHotelName.setText("酒店名称");
		jlHotelName.setHorizontalAlignment(SwingConstants.CENTER);
		jlHotelName.setFont(hotelUIFont);
		
		jlCity = new JLabel();
		jlCity.setBounds(30, 70, 90, 30);
		jlCity.setText("城市");
		jlCity.setHorizontalAlignment(SwingConstants.CENTER);
		jlCity.setFont(hotelUIFont);
		
		jlCircle = new JLabel();
		jlCircle.setBounds(30, 120, 90, 30);
		jlCircle.setText("商圈");
		jlCircle.setHorizontalAlignment(SwingConstants.CENTER);
		jlCircle.setFont(hotelUIFont);
		
		jlAddress = new JLabel();
		jlAddress.setBounds(30, 170, 90, 30);
		jlAddress.setText("地址");
		jlAddress.setHorizontalAlignment(SwingConstants.CENTER);
		jlAddress.setFont(hotelUIFont);
		
		jlIntro = new JLabel();
		jlIntro.setBounds(30, 220, 90, 30);
		jlIntro.setText("简介");
		jlIntro.setHorizontalAlignment(SwingConstants.CENTER);
		jlIntro.setFont(hotelUIFont);
		
		jlService = new JLabel();
		jlService.setBounds(30, 420, 90, 30);
		jlService.setText("设施服务");
		jlService.setHorizontalAlignment(SwingConstants.CENTER);
		jlService.setFont(hotelUIFont);
		
		jlStar = new JLabel();
		jlStar.setBounds(30, 550, 90, 30);
		jlStar.setText("星级");
		jlStar.setHorizontalAlignment(SwingConstants.CENTER);
		jlStar.setFont(hotelUIFont);
		
		jlScore = new JLabel();
		jlScore.setBounds(30, 600, 90, 30);
		jlScore.setText("评分");
		jlScore.setHorizontalAlignment(SwingConstants.CENTER);
		jlScore.setFont(hotelUIFont);
		
		jtfHotelName = new JTextField();
		jtfHotelName.setBounds(150, 20, 359, 30);
		jtfHotelName.setFont(hotelUIFont);
		jtfHotelName.setEditable(true);
		
		jpHotelInfo.add(jlHotelName);
		jpHotelInfo.add(jlCity);
		jpHotelInfo.add(jlCircle);
		jpHotelInfo.add(jlAddress);
		jpHotelInfo.add(jlIntro);
		jpHotelInfo.add(jlService);
		jpHotelInfo.add(jlStar);
		jpHotelInfo.add(jlScore);
	}
	
	/**
	 * 设置酒店信息组件
	 */
	public void setInfoComponents(){
		cityListener = new CityListener(this);
		
		jcbCity = new JComboBox<String>();
		jcbCity.setBounds(150, 70, 172, 30);
		jcbCity.setFont(hotelUIFont);
		jcbCity.setOpaque(true);
		jcbCity.setBackground(Color.WHITE);
		jcbCity.setEditable(false);
		jcbCity.addItemListener(cityListener);
		
		jcbCircle = new JComboBox<String>();
		jcbCircle.setBounds(150, 120, 172, 30);
		jcbCircle.setFont(hotelUIFont);
		jcbCircle.setOpaque(true);
		jcbCircle.setBackground(Color.WHITE);
		jcbCircle.setEditable(false);
		
		jtfAddress = new JTextField();
		jtfAddress.setBounds(150, 170, 853, 30);
		jtfAddress.setFont(hotelUIFont);
		jtfAddress.setEditable(true);
		
		jtaIntro = new JTextArea();
		jtaIntro.setFont(hotelUIFont);
		jtaIntro.setEditable(true);
		jtaIntro.setLineWrap(true);
		
		jspIntro = new JScrollPane(jtaIntro);
		jspIntro.setBounds(150, 220, 853, 180);
		jspIntro.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		jtaService = new JTextArea();
		jtaService.setFont(hotelUIFont);
		jtaService.setEditable(true);
		jtaService.setLineWrap(true);
		
		jspService = new JScrollPane(jtaService);
		jspService.setBounds(150, 420, 853, 110);
		jspService.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		jcbStar = new JComboBox<String>(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5"}));
		jcbStar.setBounds(150, 550, 105, 30);
		jcbStar.setFont(hotelUIFont);
		jcbStar.setOpaque(true);
		jcbStar.setBackground(Color.WHITE);
		jcbStar.setEditable(false);
		
		jtfScore = new JTextField();
		jtfScore.setBounds(150, 600, 105, 30);
		jtfScore.setFont(hotelUIFont);
		jtfScore.setBorder(new EmptyBorder(0, 0, 0, 0));
		jtfScore.setBackground(panelColor);
		jtfScore.setEditable(false);
		
		jpHotelInfo.add(jtfHotelName);
		jpHotelInfo.add(jcbCity);
		jpHotelInfo.add(jcbCircle);
		jpHotelInfo.add(jtfAddress);
		jpHotelInfo.add(jspIntro);
		jpHotelInfo.add(jspService);
		jpHotelInfo.add(jcbStar);
		jpHotelInfo.add(jtfScore);
	}
	
	/**
	 * 设置按钮
	 */
	public void setButton(){
		editListener = new EditListener(this);
		cancelListener = new CancelListener(this);
		
		jbEdit = new HMSBlueButton("修改");
		jbEdit.setBounds(251, 17, 110, 50);
		jbEdit.addMouseListener(editListener);
		
		jbCancel = new HMSGrayButton("取消");
		jbCancel.setBounds(606, 17, 110, 50);
		jbCancel.addMouseListener(cancelListener);
		
		jpButton.add(jbEdit);
		jpButton.add(jbCancel);
	}
	
	/**
	 * 获得可选的城市和对应商圈
	 */
	public void getCity(){
		hotelController = ControllerFactory.getHotelController();
		
		city = hotelController.findAllLocations();
		int citySize = city.size();
		String[] citys = new String[citySize];
		
		for(int i=0;i<citySize;i++){
			citys[i] = city.get(i).name;
			jcbCity.addItem(citys[i]);
		}
	}
	
	/**
	 * 显示酒店信息
	 */
	public void showHotelInfo(){
		jtfHotelName.setText(hotel.name);
		jcbCity.setSelectedItem(hotel.location.name);
		jcbCircle.setSelectedItem(hotel.commercialCircle.name);
		jtfAddress.setText(hotel.street);
		jtaIntro.setText(hotel.profile);
		jtaService.setText(hotel.service);
		jcbStar.setSelectedItem(Integer.toString(hotel.star));
		jtfScore.setText(Double.toString(hotel.score));
	}
	
	/**
	 * 修改并更新酒店信息
	 */
	public void updateHotelInfo(){
		int i;
		int citySize = city.size();
		int circleSize = circle.size();
		String name = "";
		String address = "";
		int value = JOptionPane.showConfirmDialog(this, "您确定要修改酒店信息吗？", "请确认修改", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
		
		if(value == JOptionPane.OK_OPTION){
			name = jtfHotelName.getText();
			address = jtfAddress.getText();
			if(name.equals("")){
				JOptionPane.showMessageDialog(null, "酒店名称不可为空！", "错误", JOptionPane.WARNING_MESSAGE);
			}
			else if(name.length()>20){
				JOptionPane.showMessageDialog(null, "酒店名称长度不可超过20！", "错误", JOptionPane.WARNING_MESSAGE);
			}
			else if(!RegExpHelper.matchCHNNumAndLetter(name)){
				JOptionPane.showMessageDialog(null, "酒店名称不可包含符号！", "错误", JOptionPane.WARNING_MESSAGE);
			}
			else if(address.equals("")){
				JOptionPane.showMessageDialog(null, "酒店地址不可为空！", "错误", JOptionPane.WARNING_MESSAGE);
			}
			else if(address.length()>40){
				JOptionPane.showMessageDialog(null, "酒店地址长度不可超过40！", "错误", JOptionPane.WARNING_MESSAGE);
			}
			else if(!RegExpHelper.matchCHNNumAndLetter(address)){
				JOptionPane.showMessageDialog(null, "酒店地址不可包含符号！", "错误", JOptionPane.WARNING_MESSAGE);
			}
			else{
				hotel.name = name;
			
				for(i=0;i<citySize;i++){
					if(city.get(i).name.equals(jcbCity.getSelectedItem())){
						hotel.location = city.get(i);
						break;
					}
				}
			
				for(i=0;i<circleSize;i++){
					if(circle.get(i).name.equals(jcbCircle.getSelectedItem())){
						hotel.commercialCircle = circle.get(i);
						break;
					}
				}
			
				hotel.street = address;
				hotel.profile = jtaIntro.getText();
				hotel.service = jtaService.getText();
				hotel.star = Integer.valueOf((String) jcbStar.getSelectedItem());
			
				hotelController.updateHotel(hotel);
			
				JOptionPane.showMessageDialog(this, "酒店信息已更新！", "更新成功", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else if(value == JOptionPane.CANCEL_OPTION){
			this.showHotelInfo();
		}
	}
	
	/**
	 * 酒店所选城市发生改变后，商圈下拉列表框中的选项也要发生改变
	 */
	public void changeCircle(){
		jcbCircle.removeAllItems();
		
		int i, citySize, circleSize;
		String newCity =(String)jcbCity.getSelectedItem();
		LocationVO theNewCity = null;
		
		citySize = city.size();
		
		for(i=0;i<citySize;i++){
			if(city.get(i).name.equals(newCity)){
				theNewCity = city.get(i);
				break;
			}
		}
		
		circle = hotelController.findCircleByLoc(theNewCity.id);
		circleSize = circle.size();
		String[] circles = new String[circleSize];
		for(i=0;i<circleSize;i++){
			circles[i] = circle.get(i).name;
			jcbCircle.addItem(circles[i]);
		}
	}
}
