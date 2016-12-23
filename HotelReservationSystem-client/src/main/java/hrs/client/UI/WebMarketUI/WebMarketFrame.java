package hrs.client.UI.WebMarketUI;

import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import hrs.client.UI.WebMarketUI.CreditChargeUI.CreditChargePanel;
import hrs.client.UI.WebMarketUI.Listener.MenulistPanelMouseListener;
import hrs.client.UI.WebMarketUI.WebDiscountUI.WebDiscountPanel;
import hrs.client.UI.WebMarketUI.WebOrderUI.WebOrderPanel;
import hrs.client.util.UIConstants;
import hrs.common.VO.StaffVO;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class WebMarketFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4135325882994307575L;
	private JPanel contentPane;
	private JPanel jpCard;
	private MenulistPanel jpMenulist;
	private WebOrderPanel jpWebOrder;
	private WebDiscountPanel jpWebDiscount;
	private CreditChargePanel jpCreditCharge;
	private MenulistPanelMouseListener listener;
	private StaffVO staffVO;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WebMarketFrame frame = new WebMarketFrame(new StaffVO());
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
	public WebMarketFrame(StaffVO staffVO) {
		this.staffVO = staffVO;
		init();
	}

	public void init() {
		setTitle("酒店管理系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1366, 768);
		setLocationRelativeTo(null);
		setResizable(false);

		contentPane = new JPanel();
		contentPane.setBackground(UIConstants.JZONE);
		setContentPane(contentPane);

		jpCard = new JPanel();
		jpCard.setBounds(273, 5, 1080, 722);
		jpCard.setBackground(UIConstants.JFRAME);

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap(270, Short.MAX_VALUE)
						.addComponent(jpCard, GroupLayout.PREFERRED_SIZE, 1080, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addComponent(jpCard, GroupLayout.PREFERRED_SIZE, 722, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(16, Short.MAX_VALUE)));
		CardLayout cardLayout = new CardLayout();

		jpWebOrder = new WebOrderPanel();
		jpWebDiscount = new WebDiscountPanel();
		jpCreditCharge = new CreditChargePanel();

		jpCard.setLayout(cardLayout);
		jpCard.add(jpWebDiscount, "促销策略");
		jpCard.add(jpWebOrder, "异常订单");
		jpCard.add(jpCreditCharge, "信用充值");
		cardLayout.show(jpCard, "促销策略");

		listener = new MenulistPanelMouseListener();
		listener.setCard(cardLayout, jpCard);

		jpMenulist = new MenulistPanel(jpWebOrder,this);
		jpMenulist.setBounds(5, 5, 263, 722);

		contentPane.setLayout(gl_contentPane);
		contentPane.add(jpMenulist);

	}

	public String getName() {
		return staffVO.username;
	}
}
