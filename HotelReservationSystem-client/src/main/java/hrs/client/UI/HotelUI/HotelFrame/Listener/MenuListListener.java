package hrs.client.UI.HotelUI.HotelFrame.Listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import hrs.client.UI.HotelUI.HotelFrame.HotelFrame;

public class MenuListListener implements MouseListener{
		
		private HotelFrame frame;
		
		public MenuListListener(HotelFrame frame){
			this.frame = frame;
		}
		
		/**
		 * 根据鼠标点击的标签展示相应界面
		 */
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			String label = ((JLabel) e.getSource()).getText();
			
			frame.show(label);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		/**
		 * 当光标置于标签上时，标签变色
		 */
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
			frame.changeColorWhenEnter(e);
		}

		/**
		 * 当光标离开标签时，标签变色
		 */
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
			frame.changeColorWhenExit(e);
		}

}

