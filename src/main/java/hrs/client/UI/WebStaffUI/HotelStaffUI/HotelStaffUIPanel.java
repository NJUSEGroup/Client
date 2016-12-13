package hrs.client.UI.WebStaffUI.HotelStaffUI;

import javax.swing.JPanel;
import javax.swing.JOptionPane;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

import hrs.client.UI.WebStaffUI.HotelStaffUI.HotelStaffListener.SearchConfirmMouseListener;
import hrs.client.util.ControllerFactory;
import hrs.client.util.HMSBlueButton;
import hrs.client.util.UIConstants;
import hrs.common.Controller.WebStaffController.IWebStaffController;
import hrs.common.Exception.StaffService.StaffNotFoundExceptioon;
import hrs.common.VO.StaffVO;
import hrs.client.UI.WebStaffUI.HotelStaffUI.HotelStaffListener.ModifyHotelStaffMouseListener;

public class HotelStaffUIPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8596027990923031324L;
	private JTextField jtextInput;
	private JLabel jlPassword;
	private JLabel jlHotelStaffUsername;
	private JLabel jlSearchHotelStaff;
	private JComboBox<Object> jcomboBoxType;
	private JLabel jlHotelName;
	private JTextField jtextPassword;
	private JTextField jtextRealName;
	private HMSBlueButton jbSearchHotelStaffConfirm;
	private HMSBlueButton jbModifyHotelStaff;
	private SearchConfirmMouseListener confirmMouseListener;
	private ModifyHotelStaffMouseListener modifyHotelStaffMouseListener;
	private IWebStaffController controller = ControllerFactory.getWebStaffController();
	private StaffVO selection = new StaffVO();
	private JLabel jlHotelNameShow;
	private JLabel jlUsernameShow;
	private JLabel jlRealName;

	/**
	 * Create the panel.
	 */
	public HotelStaffUIPanel() {
		init();
	}

	public void init() {
		this.setSize(1080, 722);
		this.setBackground(UIConstants.JFRAME);

		jlSearchHotelStaff = new JLabel("搜索酒店工作人员");
		jlSearchHotelStaff.setBounds(55, 42, 168, 35);
		jlSearchHotelStaff.setFont(UIConstants.JLABEL_FONT);

		jcomboBoxType = new JComboBox<Object>();
		jcomboBoxType.setBounds(241, 49, 173, 26);
		jcomboBoxType.setFont(UIConstants.FONT_17);
		jcomboBoxType.setModel(new DefaultComboBoxModel<Object>(new String[] { "酒店名称", "酒店工作人员用户名" }));
		jcomboBoxType.setSelectedIndex(-1);

		jtextInput = new JTextField();
		jtextInput.setFont(UIConstants.FONT_19);
		jtextInput.setBounds(432, 45, 217, 35);
		jtextInput.setColumns(10);

		jbSearchHotelStaffConfirm = new HMSBlueButton("搜索");
		jbSearchHotelStaffConfirm.setBounds(667, 45, 75, 34);
		jbSearchHotelStaffConfirm.setFont(UIConstants.FONT_16);
		confirmMouseListener = new SearchConfirmMouseListener(this);
		jbSearchHotelStaffConfirm.addMouseListener(confirmMouseListener);

		jlHotelStaffUsername = new JLabel("用户名");
		jlHotelStaffUsername.setBounds(55, 126, 63, 26);
		jlHotelStaffUsername.setFont(UIConstants.JLABEL_FONT);

		jlPassword = new JLabel("密码");
		jlPassword.setBounds(55, 184, 63, 26);
		jlPassword.setFont(UIConstants.JLABEL_FONT);

		jlRealName = new JLabel("真实姓名");
		jlRealName.setBounds(55, 247, 84, 26);
		jlRealName.setFont(UIConstants.JLABEL_FONT);

		jlHotelName = new JLabel("酒店名称");
		jlHotelName.setBounds(55, 309, 84, 26);
		jlHotelName.setFont(UIConstants.JLABEL_FONT);

		jtextPassword = new JTextField();
		jtextPassword.setFont(UIConstants.FONT_17);
		jtextPassword.setBounds(218, 183, 196, 35);
		jtextPassword.setColumns(10);

		jtextRealName = new JTextField();
		jtextRealName.setFont(UIConstants.FONT_17);
		jtextRealName.setBounds(218, 246, 196, 35);
		jtextRealName.setColumns(10);

		jbModifyHotelStaff = new HMSBlueButton("修改");
		jbModifyHotelStaff.setBounds(796, 521, 90, 40);
		jbModifyHotelStaff.setFont(UIConstants.FONT_18);
		modifyHotelStaffMouseListener = new ModifyHotelStaffMouseListener(this);
		jbModifyHotelStaff.addMouseListener(modifyHotelStaffMouseListener);

		jlHotelNameShow = new JLabel();
		jlHotelNameShow.setFont(UIConstants.FONT_19);
		jlHotelNameShow.setBounds(218, 309, 196, 26);

		jlUsernameShow = new JLabel();
		jlUsernameShow.setFont(UIConstants.FONT_19);
		jlUsernameShow.setBounds(218, 126, 196, 29);
		
		setLayout(null);
		add(jlSearchHotelStaff);
		add(jcomboBoxType);
		add(jlPassword);
		add(jlHotelStaffUsername);
		add(jlRealName);
		add(jlHotelName);
		add(jlUsernameShow);
		add(jlHotelNameShow);
		add(jtextRealName);
		add(jtextPassword);
		add(jtextInput);
		add(jbSearchHotelStaffConfirm);
		add(jbModifyHotelStaff);

	}

	public List<StaffVO> search() {
		List<StaffVO> staffVOs = new ArrayList<>();
		String findTypeText = getSearchInput();
		Object findTypeComboBox = jcomboBoxType.getSelectedItem();
		if (getSearchInput().equals("")) {
			clear();
			JOptionPane.showMessageDialog(null, "请输入酒店名称或酒店工作人员名称", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			if (findTypeComboBox.equals("酒店名称")) {
				try {
					staffVOs = controller.findStaffByHotelName(findTypeText);
				} catch (StaffNotFoundExceptioon e) {
					// TODO Auto-generated catch block
					clear();
					JOptionPane.showMessageDialog(null, "酒店及工作人员不存在！", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			if (findTypeComboBox.equals("酒店工作人员用户名")) {
				try {
					staffVOs.add(controller.findStaffByUsername(findTypeText));
				} catch (StaffNotFoundExceptioon e1) {
					// TODO Auto-generated catch block
					clear();
					JOptionPane.showMessageDialog(null, "此酒店工作人员不存在！", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		// System.out.println(staffVOs);
		return staffVOs;
	}

	// list按顺序加到joptionpane里面
	public void selectHotelAndShow() {
		List<StaffVO> toAddStaffVOs = search();
		if (toAddStaffVOs.size() == 1) {
			selection = toAddStaffVOs.get(0);
			jlUsernameShow.setText(selection.username);
			jtextPassword.setText(selection.password);
			jtextRealName.setText(selection.name);
			jlHotelNameShow.setText(selection.hotel.name);
		}
		if (toAddStaffVOs.size() > 1) {
			int index;
			String[] vos = new String[toAddStaffVOs.size()];
			for (int i = 0; i < toAddStaffVOs.size(); i++) {
				vos[i] = toAddStaffVOs.get(i).hotel.name;
			} // 根据用户的选择酒店名称hhhh知道vos[i]的i,get就可以得到了；
				// selection = (StaffVO) JOptionPane.showInputDialog(null,
				// "搜索到多家酒店，请选择一家：\n", "酒店选择",
				// JOptionPane.PLAIN_MESSAGE, null, vos, toAddStaffVOs.get(0));
				// System.out.println(selection);
				// System.out.println(JOptionPane.showInputDialog(null,
				// "搜索到多家酒店，请选择一家：\n", "酒店选择",
				// JOptionPane.PLAIN_MESSAGE, null, vos, toAddStaffVOs.get(0)));
			String userSelected = (String) JOptionPane.showInputDialog(null, "搜索到多家酒店，请选择一家：\n", "酒店选择",
					JOptionPane.PLAIN_MESSAGE, null, vos, toAddStaffVOs.get(0));
			for (index = 0; index < toAddStaffVOs.size(); ++index) {
				if (vos[index].equals(userSelected))
					break;
			}
			selection = toAddStaffVOs.get(index);
			jlUsernameShow.setText(selection.username);
			jtextPassword.setText(selection.password);
			jtextRealName.setText(selection.name);
			jlHotelNameShow.setText(selection.hotel.name);
		}
		toAddStaffVOs = new ArrayList<>();
	}

	public String getSearchInput() {
		return jtextInput.getText();
	}

	public String getUsername() {
		return jlUsernameShow.getText();
	}

	public void modify() {
		String newPassword = jtextPassword.getText();
		String newRealName = jtextRealName.getText();
		selection.password = newPassword;
		selection.name = newRealName;
		selection.hotel = selection.hotel;
		controller.updateStaff(selection);
	}// 酒店名称默认不可修改

	public String getPassword() {
		return jtextPassword.getText();
	}

	public void clear() {
		jlUsernameShow.setText("");
		jtextPassword.setText("");
		jtextRealName.setText("");
		jlHotelNameShow.setText("");
	}

}
