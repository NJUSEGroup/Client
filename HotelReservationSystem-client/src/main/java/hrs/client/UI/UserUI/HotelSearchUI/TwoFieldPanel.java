package hrs.client.UI.UserUI.HotelSearchUI;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hrs.client.UI.UserUI.Components.CommonLabel;
import hrs.client.util.UIConstants;
/**
 * 带有两个输入域
 * 可通过getLow得到小值,getHigh得到大值
 * 大小为160*40
 * @author 涵
 *
 */
public class TwoFieldPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8874311645731410760L;
	private JTextField lowField;
	private JTextField highField;
	public TwoFieldPanel(){
		lowField = new JTextField();
		highField = new JTextField();
		Init();
	}
	private void Init() {
		setBackground(UIConstants.JFRAME);
		setLayout(null);
		setSize(160,40);
		
		JLabel jl = new CommonLabel("~");
		jl.setBounds(65, 0, 30, 40);
		add(jl);
		
		lowField.setFont(UIConstants.JLABEL_FONT);
		lowField.setBounds(0, 5, 65, 30);
		add(lowField);
		
		highField.setFont(UIConstants.JLABEL_FONT);
		highField.setBounds(95, 5, 65, 30);
		add(highField);
		
	}
	
	public Double getLow(){
		if(lowField.getText().equals("")){
			return null;
		}
		else{
			Double x = Double.parseDouble(lowField.getText());
			return x;
		}
	}
	
	public Double getHigh(){
		if(highField.getText().equals("")){
			return null;
		}
		else{
			Double x = Double.parseDouble(highField.getText());
			return x;
		}
	}
}
