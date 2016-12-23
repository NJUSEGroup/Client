package hrs.client.UI.LoginUI.LoginPanel;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import hrs.client.util.ImageLoader;

public class BGPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -744509764250621908L;
	private ImageLoader loader = ImageLoader.getInstance();
	private Image IMG_BG = loader.getIcon("LoginUI/bg.png").getImage();;
	
	@Override
	public void paintComponent(Graphics g){
		
		g.drawImage(IMG_BG,0,0,1300,480,null);
	}
}
