package hrs.client.util;

import javax.swing.ImageIcon;
/**
 * 客户端：单线程，不必考虑多线程问题
* @ClassName: ImageLoader
* @Description: TODO
* @author NewSong
* @date 2016年11月26日 下午3:58:17
*
 */
public class ImageLoader {
	private static ImageLoader instance;
	private ImageLoader() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @Title: getInstance
	 * @Description: 双重检查加锁机制
	 * @param @return   
	 * @return ImageLoader   
	 * @throws
	 */
	public static ImageLoader getInstance(){
		if(instance == null){
			instance = new ImageLoader();
		}
		return instance;
	}
	
	
	public  ImageIcon getIcon(String iconName){
		return new ImageIcon(this.getClass().getResource("/imgs/"+iconName));
	}
}
