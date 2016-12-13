package hrs.client.UI.UserUI.UserInfoUI.UserInfoListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JOptionPane;


import hrs.client.UI.UserUI.UserInfoUI.UserInfoLabel;
import hrs.client.UI.UserUI.UserInfoUI.UserInfoPanel;
import hrs.client.util.ControllerFactory;
import hrs.common.Controller.UserController.IUserController;
import hrs.common.VO.UserVO;
/**
 * 
 * 用户信息界面确认按钮事件监听
 * 
 * @author 涵
 *
 */
public class ConfirmListener implements ActionListener {
	private IUserController controller = ControllerFactory.getUserController();
	private UserInfoPanel panel;
	private UserVO userVO;
	public ConfirmListener(UserInfoPanel panel,UserVO userVO) {
		this.panel = panel;
		this.userVO = userVO;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		int result = JOptionPane.showConfirmDialog
				(null, "是否保存更改？", "提示", 
				JOptionPane.YES_NO_OPTION,
				JOptionPane.INFORMATION_MESSAGE);
		
		if(result == JOptionPane.NO_OPTION){
			panel.init();
			
			
		}
		else if(result == JOptionPane.YES_OPTION){
			panel.update();
			JOptionPane.showConfirmDialog(null,
					"信息修改成功", "成功", JOptionPane.PLAIN_MESSAGE,JOptionPane.INFORMATION_MESSAGE);
		}
		else{
			panel.init();
		}
	}

	
	
	
}
