package hrs.client.UI.WebMarketUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hrs.client.UI.WebMarketUI.Listener.MenulistPanelMouseListener;
import hrs.client.UI.WebMarketUI.WebOrderUI.WebOrderPanel;
import hrs.client.util.ImageLoader;
import hrs.client.util.UIConstants;

public class MenulistPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -617125775570164635L;
	private JLabel jlZone;
	private JLabel jlIdentity;
	private JLabel jlUsername;
	private JLabel jlPromotion;
	private JLabel jlUnexecuted;
	private JLabel jlAbnormal;
	private JLabel jlCreditCharge;
	private WebOrderPanel webOrderPanel;
	private ImageIcon webDiscount, unexecutedOrder,abnormalOrder, creditCharge;
	private MenulistPanelMouseListener jpMenulistMouseListener;
	private Color jlabel_color = UIConstants.JLABEL;
	private Font jlabel_font = UIConstants.JLABEL_FONT;
	private WebMarketFrame webMarketFrame;

	public MenulistPanel(WebOrderPanel webOrderPanel, WebMarketFrame webMarketFrame) {
		this.webMarketFrame = webMarketFrame;
		this.webOrderPanel = webOrderPanel;
		init();
	}

	public void init() {
		setBounds(5, 5, 263, 722);
		setLayout(null);
		setBackground(UIConstants.JFRAME);

		ImageLoader loader = ImageLoader.getInstance();

		jlZone = new JLabel("网站营销中心", JLabel.CENTER);
		jlZone.setBounds(0, 0, 263, 79);
		jlZone.setFont(UIConstants.JZONE_FONT);
		jlZone.setOpaque(true);
		jlZone.setForeground(UIConstants.JZONE_FONT_COLOR);
		jlZone.setBackground(UIConstants.JZONE);

		jlIdentity = new JLabel("网站营销人员", JLabel.CENTER);
		jlIdentity.setBounds(0, 79, 263, 29);
		jlIdentity.setFont(UIConstants.JLABEL_FONT);

		jlUsername = new JLabel(webMarketFrame.getName(), JLabel.CENTER);
		jlUsername.setBounds(0, 108, 263, 29);
		jlUsername.setFont(UIConstants.JLABEL_FONT);

		webDiscount = loader.getIcon("WebMarketUI/WebDiscount.png");
		webDiscount.setImage(webDiscount.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT));

		jlPromotion = new JLabel("促销策略", JLabel.CENTER);
		jlPromotion.setBounds(0, 200, 263, 65);
		jlPromotion.setIcon(webDiscount);
		jlPromotion.setFont(jlabel_font);
		jlPromotion.setForeground(Color.WHITE);
		jlPromotion.setOpaque(true);
		jlPromotion.setBackground(jlabel_color);
		jpMenulistMouseListener = new MenulistPanelMouseListener();
		jlPromotion.addMouseListener(jpMenulistMouseListener);

		unexecutedOrder=loader.getIcon("WebMarketUI/UnexecutedOrder.png");
		unexecutedOrder.setImage(unexecutedOrder.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT));
		
		jlUnexecuted=new JLabel("未执行订单",JLabel.CENTER);
		jlUnexecuted.setBounds(0,265,263,65);
		jlUnexecuted.setIcon(unexecutedOrder);
		jlUnexecuted.setFont(jlabel_font);
		jlUnexecuted.setForeground(Color.WHITE);
		jlUnexecuted.setOpaque(true);
		jlUnexecuted.setBackground(jlabel_color);
		jlUnexecuted.addMouseListener(jpMenulistMouseListener);
		
		abnormalOrder = loader.getIcon("WebMarketUI/AbnormalOrder.png");
		abnormalOrder.setImage(abnormalOrder.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT));

		jlAbnormal = new JLabel("异常订单", JLabel.CENTER);
		jlAbnormal.setBounds(0, 330, 263, 65);
		jlAbnormal.setIcon(abnormalOrder);
		jlAbnormal.setFont(jlabel_font);
		jlAbnormal.setForeground(Color.WHITE);
		jlAbnormal.setOpaque(true);
		jlAbnormal.setBackground(jlabel_color);
		jlAbnormal.addMouseListener(jpMenulistMouseListener);
		jlAbnormal.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				webOrderPanel.refresh();
			}
		});

		creditCharge = loader.getIcon("WebMarketUI/CreditCharge.png");
		creditCharge.setImage(creditCharge.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT));

		jlCreditCharge = new JLabel("信用充值", JLabel.CENTER);
		jlCreditCharge.setBounds(0,395,263,65);
		jlCreditCharge.setIcon(creditCharge);
		jlCreditCharge.setFont(jlabel_font);
		jlCreditCharge.setForeground(Color.WHITE);
		jlCreditCharge.setOpaque(true);
		jlCreditCharge.setBackground(jlabel_color);
		jlCreditCharge.addMouseListener(jpMenulistMouseListener);

		add(jlZone);
		add(jlIdentity);
		add(jlUsername);
		add(jlPromotion);
		add(jlUnexecuted);
		add(jlAbnormal);
		add(jlCreditCharge);
	}
}
