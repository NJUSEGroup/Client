package hrs.client.UI.WebStaffUI.WebMarketUI.WebMarketListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

import hrs.client.UI.WebStaffUI.WebMarketUI.WebMarketerUIPanel;
import hrs.client.util.RegExpHelper;

public class ModifyWebMarketerMouseListener implements MouseListener {
	private WebMarketerUIPanel WebMarketerUIPanel;

	public ModifyWebMarketerMouseListener(WebMarketerUIPanel webMarketerUIPanel) {
		// TODO Auto-generated constructor stub
		this.WebMarketerUIPanel = webMarketerUIPanel;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (WebMarketerUIPanel.getUsername().equals("")) {
			JOptionPane.showMessageDialog(null, "请先搜索网站营销人员！", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			if (!RegExpHelper.matchUsernameAndPWD(WebMarketerUIPanel.getPassword())) {
				JOptionPane.showMessageDialog(null, "密码要求至少6位，且含字母和数字！", "Attention", JOptionPane.ERROR_MESSAGE);
			} else {
				int result = JOptionPane.showConfirmDialog(null, "是否确定修改？", "提示", JOptionPane.YES_NO_OPTION,
						JOptionPane.INFORMATION_MESSAGE);
				// System.out.println(result);
				if (result == 0) {
					WebMarketerUIPanel.modify();
					JOptionPane.showConfirmDialog(null, "信息修改成功", "修改成功", JOptionPane.PLAIN_MESSAGE,
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}

}
