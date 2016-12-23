package hrs.client.UI.WebMarketUI.Listener;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenulistPanelMouseListener extends MouseAdapter {
	private JLabel jLabel = new JLabel();
	private static CardLayout cardLayout;
	private static JPanel jPanel;

	@SuppressWarnings("static-access")
	public void setCard(CardLayout cardLayout, JPanel jPanel) {
		this.cardLayout = cardLayout;
		this.jPanel = jPanel;
	}

	public void mouseEntered(MouseEvent me) {
		jLabel = (JLabel) me.getSource();
		jLabel.setBackground(Color.WHITE);
		jLabel.setForeground(Color.GRAY);
	}

	public void mouseClicked(MouseEvent me) {
		jLabel = (JLabel) me.getSource();
		String string = jLabel.getText();
		if (string.equals("促销策略")) {
			cardLayout.show(jPanel, "促销策略");
		} else if (string.equals("异常订单")) {
			cardLayout.show(jPanel, "异常订单");
		} else if (string.equals("信用充值")) {
			cardLayout.show(jPanel, "信用充值");
		}
	}

	public void mouseExited(MouseEvent e) {
		jLabel = (JLabel) e.getSource();
		jLabel.setBackground(new Color(0, 160, 233));
		jLabel.setForeground(Color.white);
	}

}
