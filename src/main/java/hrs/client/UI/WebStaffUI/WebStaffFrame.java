package hrs.client.UI.WebStaffUI;

import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import hrs.client.UI.WebStaffUI.HotelAddUI.HotelAddUIPanel;
import hrs.client.UI.WebStaffUI.HotelAddUI.HotelStaffAddUIPanel;
import hrs.client.UI.WebStaffUI.HotelStaffUI.HotelStaffUIPanel;
import hrs.client.UI.WebStaffUI.WebMarketUI.WebMarketerUIPanel;
import hrs.client.UI.WebStaffUI.WebStaffListener.WebStaffMenulistMouseListener;
import hrs.client.UI.WebStaffUI.WebUserUI.ShowUserInfoPanel;
import hrs.client.UI.WebStaffUI.WebUserUI.WebUserUIPanel;
import hrs.client.util.UIConstants;
import hrs.common.VO.StaffVO;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class WebStaffFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6293618787121106494L;
	private CardLayout cardLayout;
	private MenulistPanel menulistPanel;
	private HotelAddUIPanel jpHotelAdd;
	private HotelStaffAddUIPanel jpHotelStaffAdd;
	private WebMarketerUIPanel jpWebMarketer;
	private HotelStaffUIPanel jpHotelStaff;
	private WebUserUIPanel jpWebUser;
	private WebStaffMenulistMouseListener listener;
	private JPanel contentPane;
	private JPanel jpCard;
	private StaffVO staffVO;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WebStaffFrame frame = new WebStaffFrame(new StaffVO());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WebStaffFrame(StaffVO staffVO) {
		this.staffVO = staffVO;
		init();
	}

	public void init() {
		setTitle("酒店预订系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1366, 768);
		setLocationRelativeTo(null);
		setResizable(false);

		contentPane = new JPanel();
		contentPane.setBackground(UIConstants.JZONE);
		setContentPane(contentPane);

		menulistPanel = new MenulistPanel(this);
		menulistPanel.setBounds(5, 5, 263, 722);

		jpCard = new JPanel();

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(menulistPanel, GroupLayout.PREFERRED_SIZE, 263,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(jpCard, GroupLayout.PREFERRED_SIZE, 1080, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(10, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(menulistPanel, GroupLayout.PREFERRED_SIZE, 722,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(jpCard, GroupLayout.PREFERRED_SIZE, 722, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(105, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);

		cardLayout = new CardLayout();
		jpCard.setLayout(cardLayout);
		jpCard.setBounds(273, 5, 1080, 722);
		jpCard.setBackground(UIConstants.JFRAME);

		jpHotelAdd = new HotelAddUIPanel(this);
		jpHotelStaffAdd = new HotelStaffAddUIPanel(this, jpHotelAdd);
		jpWebMarketer = new WebMarketerUIPanel();
		jpHotelStaff = new HotelStaffUIPanel();
		jpWebUser = new WebUserUIPanel(new ShowUserInfoPanel());

		jpCard.add(jpWebUser, "用户");
		jpCard.add(jpHotelStaff, "酒店工作人员");
		jpCard.add(jpWebMarketer, "网站营销人员");
		jpCard.add(jpHotelAdd, "酒店添加");
		jpCard.add(jpHotelStaffAdd, "酒店工作人员添加");
		cardLayout.show(jpCard, "用户");

		listener = new WebStaffMenulistMouseListener();
		listener.setCard(cardLayout, jpCard);
		contentPane.add(jpCard);
	}

	public void showHotelStaffAddUIPanel() {
		cardLayout.show(jpCard, "酒店工作人员添加");
	}

	public void showHotelAddUIPanel() {
		cardLayout.show(jpCard, "酒店添加");
	}

	public String getName() {
		return staffVO.username;

	}

}
