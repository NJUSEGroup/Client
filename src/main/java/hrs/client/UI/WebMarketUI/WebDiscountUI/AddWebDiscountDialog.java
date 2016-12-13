package hrs.client.UI.WebMarketUI.WebDiscountUI;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hrs.client.UI.WebMarketUI.WebDiscountUI.WebDiscountListener.CancelAddListener;
import hrs.client.UI.WebMarketUI.WebDiscountUI.WebDiscountListener.OKListener;
import hrs.client.util.ControllerFactory;
import hrs.client.util.DateChoosePanel;
import hrs.client.util.DoubleFormat;
import hrs.client.util.HMSBlueButton;
import hrs.client.util.UIConstants;
import hrs.common.Controller.WebMarketController.IWebDiscountController;
import hrs.common.VO.CommercialCircleVO;
import hrs.common.VO.LocationVO;
import hrs.common.VO.WebDiscountVO;
import hrs.common.util.type.WebsiteDiscountType;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddWebDiscountDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5923810422972507715L;

	private JPanel jpAdd;
	private DateChoosePanel jtextBegintime;
	private DateChoosePanel jtextEndtime;
	private JTextField jtextDiscount;
	private JLabel jlBeginTime;
	private JLabel jlEndTime;
	private JLabel jlLocation;
	private JLabel jlCommercialCircle;
	private JLabel jlPromotionType;
	private JLabel jlVIPLevel;
	private JLabel jlDiscount;
	private HMSBlueButton jbOK, jbCancel;

	private WebDiscountPanel jpWebDiscount;
	private WebDiscountVO addVO;
	private OKListener listener;
	private CancelAddListener cancelAddListener;

	private JComboBox<Object> jcomboBoxType;
	private JComboBox<Object> jcomboBoxCommercialCircle;
	private JComboBox<Object> jcomboBoxLocation;
	private JComboBox<Object> jcomboBoxVIPLevel;

	private LocationVO location;
	private CommercialCircleVO commercialCircle;
	private IWebDiscountController controller = ControllerFactory.getWebDiscountController();
	private List<LocationVO> locs;
	private List<CommercialCircleVO> commercialCircleList;
	private int locationIndex;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public AddWebDiscountDialog(WebDiscountPanel panel) {
		jpWebDiscount = panel;
		init();
	}

	public void init() {
		this.setTitle("酒店促销策略添加");
		this.setBounds(100, 100, 600, 450);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setModal(true);

		getContentPane().setLayout(new BorderLayout());
		jpAdd = new JPanel();
		jpAdd.setBorder(new EmptyBorder(5, 5, 5, 5));
		jpAdd.setBackground(UIConstants.JFRAME);
		getContentPane().add(jpAdd, BorderLayout.CENTER);

		jlPromotionType = new JLabel("折扣类型");
		jlPromotionType.setFont(UIConstants.FONT_16);
		jlPromotionType.setBounds(108, 15, 76, 26);

		jlBeginTime = new JLabel("开始时间");
		jlBeginTime.setFont(UIConstants.FONT_16);
		jlBeginTime.setBounds(108, 57, 76, 34);

		jlEndTime = new JLabel("结束时间");
		jlEndTime.setFont(UIConstants.FONT_16);
		jlEndTime.setBounds(108, 104, 76, 34);

		jlLocation = new JLabel("城市");
		jlLocation.setFont(UIConstants.FONT_16);
		jlLocation.setBounds(108, 151, 76, 34);

		jlCommercialCircle = new JLabel("商圈");
		jlCommercialCircle.setFont(UIConstants.FONT_16);
		jlCommercialCircle.setBounds(108, 198, 76, 34);

		jlVIPLevel = new JLabel("VIP等级");
		jlVIPLevel.setFont(UIConstants.FONT_16);
		jlVIPLevel.setBounds(108, 245, 76, 34);

		jlDiscount = new JLabel("折扣信息");
		jlDiscount.setFont(UIConstants.FONT_16);
		jlDiscount.setBounds(108, 292, 76, 34);

		jcomboBoxType = new JComboBox<>();
		jcomboBoxType.setFont(UIConstants.FONT_17);
		jcomboBoxType.setBounds(238, 16, 261, 27);
		jcomboBoxType.addItem("会员等级折扣");
		jcomboBoxType.addItem("特定期间折扣");
		jcomboBoxType.addItem("特定商圈专属折扣");
		jcomboBoxType.setSelectedIndex(-1);

		jtextBegintime = new DateChoosePanel();
		jtextBegintime.dayBox.setBounds(180, 5, 50, 28);
		jtextBegintime.monthBox.setBounds(100, 5, 50, 28);
		jtextBegintime.yearBox.setBounds(0, 5, 70, 28);
		jtextBegintime.setBounds(238, 60, 261, 33);

		jtextEndtime = new DateChoosePanel();
		jtextEndtime.dayBox.setBounds(180, 5, 50, 27);
		jtextEndtime.monthBox.setBounds(100, 5, 50, 27);
		jtextEndtime.yearBox.setBounds(0, 5, 70, 27);
		jtextEndtime.setBounds(238, 106, 261, 32);

		jcomboBoxLocation = new JComboBox<>();
		jcomboBoxLocation.setFont(UIConstants.FONT_17);
		for (int i = 0; i < locToName().length; i++) {
			jcomboBoxLocation.addItem(locToName()[i]);
		}
		jcomboBoxLocation.setBounds(238, 156, 261, 27);
		jcomboBoxLocation.setSelectedIndex(-1);

		jcomboBoxCommercialCircle = new JComboBox<>();
		jcomboBoxCommercialCircle.setFont(UIConstants.FONT_17);
		jcomboBoxCommercialCircle.setBounds(238, 203, 261, 27);

		jcomboBoxVIPLevel = new JComboBox<>();
		jcomboBoxVIPLevel.setFont(UIConstants.FONT_16);
		jcomboBoxVIPLevel.setBounds(238, 250, 261, 27);
		jcomboBoxVIPLevel.addItem("1");
		jcomboBoxVIPLevel.addItem("2");
		jcomboBoxVIPLevel.addItem("3");
		jcomboBoxVIPLevel.addItem("4");
		jcomboBoxVIPLevel.addItem("5");
		jcomboBoxVIPLevel.setSelectedIndex(-1);

		jtextDiscount = new JTextField();
		jtextDiscount.setFont(UIConstants.FONT_17);
		jtextDiscount.setBounds(238, 297, 261, 26);
		jtextDiscount.setColumns(10);
		jtextDiscount.setText("");

		jbOK = new HMSBlueButton("确认添加");
		jbOK.setBounds(165, 348, 92, 34);
		jbOK.setFont(UIConstants.FONT_17);
		listener = new OKListener(jpWebDiscount, this);
		jbOK.addMouseListener(listener);

		jbCancel = new HMSBlueButton("取消添加");
		jbCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		jbCancel.setBounds(326, 348, 92, 34);
		jbCancel.setFont(UIConstants.FONT_17);
		cancelAddListener = new CancelAddListener(this);
		jbCancel.addMouseListener(cancelAddListener);

		setUnableAndCombox();

		initWebDiscountDialog();

		jpAdd.setLayout(null);
		jpAdd.add(jlDiscount);
		jpAdd.add(jlCommercialCircle);
		jpAdd.add(jlLocation);
		jpAdd.add(jlEndTime);
		jpAdd.add(jlBeginTime);
		jpAdd.add(jlPromotionType);
		jpAdd.add(jlVIPLevel);
		jpAdd.add(jtextDiscount);
		jpAdd.add(jtextEndtime);
		jpAdd.add(jcomboBoxCommercialCircle);
		jpAdd.add(jcomboBoxLocation);
		jpAdd.add(jcomboBoxVIPLevel);
		jpAdd.add(jtextBegintime);
		jpAdd.add(jcomboBoxType);
		jpAdd.add(jbOK);
		jpAdd.add(jbCancel);
	}

	public void initWebDiscountDialog() {
		jcomboBoxType.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					if (jcomboBoxType.getSelectedItem().toString().equals("特定商圈专属折扣")) {
						jcomboBoxLocation.addItemListener(new ItemListener() {
							@Override
							public void itemStateChanged(ItemEvent e1) {
								// TODO Auto-generated method stub
								locationIndex = jcomboBoxLocation.getSelectedIndex();
								System.out.println(locationIndex);
								location = locs.get(locationIndex);
								commercialCircleList = controller.findCircleByLoc(location.id);
								Object[] circleName = new Object[commercialCircleList.size()];

								for (int i = 0; i != commercialCircleList.size(); ++i) {
									circleName[i] = commercialCircleList.get(i).name;
								}

								DefaultComboBoxModel<Object> model = new DefaultComboBoxModel<>(circleName);
								jcomboBoxCommercialCircle.setModel(model);
							}
						});
					}
				}
			}
		});
	}

	public void setUnableAndCombox() {
		jcomboBoxType.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				switch (jcomboBoxType.getSelectedItem().toString()) {
				case "特定商圈专属折扣":// 需要显示商圈，城市，折扣
					// jcomboBoxLocation = new JComboBox<>(locToName());
					// //显示所有的城市
					// 根据选的城市来显示商圈名
					jcomboBoxVIPLevel.setSelectedIndex(-1);
					jcomboBoxCommercialCircle.setSelectedIndex(-1);
					jcomboBoxLocation.setSelectedIndex(-1);
					jtextBegintime.setUnusable();
					jtextEndtime.setUnusable();
					jtextDiscount.setText("");
					jcomboBoxVIPLevel.setBackground(Color.LIGHT_GRAY);
					jcomboBoxCommercialCircle.setEnabled(true);
					jcomboBoxLocation.setEnabled(true);
					jcomboBoxVIPLevel.setEnabled(false);
					break;
				case "特定期间折扣":// 改成DateChoosePanel
					jcomboBoxVIPLevel.setSelectedIndex(-1);
					jcomboBoxCommercialCircle.setSelectedIndex(-1);
					jcomboBoxLocation.setSelectedIndex(-1);
					jtextDiscount.setText("");
					jtextBegintime.setEnabled();
					jtextEndtime.setEnabled();
					jcomboBoxCommercialCircle.setEnabled(false);
					jcomboBoxLocation.setEnabled(false);
					jcomboBoxVIPLevel.setEnabled(false);
					break;
				case "会员等级折扣":
					jcomboBoxVIPLevel.setSelectedIndex(-1);
					jcomboBoxVIPLevel.setEnabled(true);
					jtextDiscount.setText("");
					jcomboBoxVIPLevel.setBackground(Color.WHITE);
					jtextBegintime.setUnusable();
					jtextEndtime.setUnusable();
					jcomboBoxCommercialCircle.setSelectedIndex(-1);
					jcomboBoxLocation.setSelectedIndex(-1);
					jcomboBoxCommercialCircle.setEnabled(false);
					jcomboBoxLocation.setEnabled(false);
					break;
				default:
					break;
				}

			}
		});

	}

	public WebDiscountVO jdaddWebDiscount() {
		switch (jcomboBoxType.getSelectedItem().toString()) {
		case "特定商圈专属折扣":
			if (jtextDiscount.getText().equals("") || jcomboBoxCommercialCircle.getSelectedIndex() == -1
					|| jcomboBoxLocation.getSelectedIndex() == -1) {
				JOptionPane.showMessageDialog(null, "请完整填写折扣信息！", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				double commercialCircleDiscount = Double.parseDouble(DoubleFormat.format(jtextDiscount.getText()));
				locationIndex = jcomboBoxLocation.getSelectedIndex();
				location = locs.get(locationIndex);
				int commercialCircleIndex = jcomboBoxCommercialCircle.getSelectedIndex();
				commercialCircle = commercialCircleList.get(commercialCircleIndex);
				addVO = new WebDiscountVO(commercialCircleDiscount, WebsiteDiscountType.SpecialCommercialCircle,
						location, commercialCircle, null, null, 0);
			}
			break;
		case "特定期间折扣":// vo改变
			if (jtextDiscount.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "请完整填写折扣信息！", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				double specialPeriodDiscount = Double.parseDouble(DoubleFormat.format(jtextDiscount.getText()));
				Date discountBeginTime = jtextBegintime.getDate();
				Date discountEndTime = jtextEndtime.getDate();
				addVO = new WebDiscountVO(specialPeriodDiscount, WebsiteDiscountType.SpecialPeriod, null, null,
						discountBeginTime, discountEndTime, 0);
			}
			break;
		case "会员等级折扣":
			if (jcomboBoxVIPLevel.getSelectedIndex() == -1 || jtextDiscount.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "请完整填写折扣信息！", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				int VIPLevel = Integer.parseInt(jcomboBoxVIPLevel.getSelectedItem().toString());
				double vipDiscount = Double.parseDouble(DoubleFormat.format(jtextDiscount.getText()));
				addVO = new WebDiscountVO(vipDiscount, WebsiteDiscountType.VIP, null, null, null, null, VIPLevel);
			}
			break;
		default:
			JOptionPane.showMessageDialog(null, "请选择折扣类型！", "Error", JOptionPane.ERROR_MESSAGE);
			break;
		}
		return addVO;// 从dialog返回一个有数据的vo给jp
	}

	public int getSelectedType() {
		return jcomboBoxType.getSelectedIndex();
	}

	public double getDiscount() {
		return jdaddWebDiscount().discount;
	}

	private Object[] locToName() {
		locs = controller.findAllLocations();
		Object[] names = new Object[locs.size()];
		for (int i = 0; i != names.length; ++i) {
			names[i] = locs.get(i).name;
		}
		return names;
	}

	public void refresh() {
		jtextBegintime = new DateChoosePanel();
		jtextEndtime = new DateChoosePanel();
		jcomboBoxType.setSelectedIndex(-1);
		jcomboBoxCommercialCircle.setSelectedIndex(-1);
		jcomboBoxLocation.setSelectedIndex(-1);
		jcomboBoxVIPLevel.setSelectedIndex(-1);
	}
}
