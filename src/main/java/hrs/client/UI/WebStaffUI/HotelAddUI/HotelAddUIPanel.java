package hrs.client.UI.WebStaffUI.HotelAddUI;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import hrs.client.UI.WebStaffUI.WebStaffFrame;
import hrs.client.UI.WebStaffUI.HotelAddUI.HotelAddListener.NextStepMouseListener;
import hrs.client.util.HMSBlueButton;
import hrs.client.util.UIConstants;
import hrs.common.VO.HotelVO;

import javax.swing.JTextField;

public class HotelAddUIPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7480076228789132561L;
	private JTextField jtextHotelName;
	private JPanel jpHotelAdd;
	private JPanel jpHotelStaffAdd;
	private JLabel jlpanelIN;
	private JLabel lblNewLabel;
	private NextStepMouseListener nextStepMouseListener;
	private WebStaffFrame webStaffFrame;
	private JLabel jlHotelName;
	private HMSBlueButton jbNextStep;

	/**
	 * Create the panel.
	 */
	public HotelAddUIPanel(WebStaffFrame webStaffFrame) {
		this.webStaffFrame = webStaffFrame;
		init();

	}

	public void init() {
		this.setSize(1080, 722);
		this.setBackground(UIConstants.JFRAME);

		jpHotelAdd = new JPanel();
		jpHotelAdd.setBackground(Color.WHITE);

		jpHotelStaffAdd = new JPanel();
		jpHotelStaffAdd.setBackground(new Color(176, 224, 230));

		jlHotelName = new JLabel("酒店名称");
		jlHotelName.setHorizontalAlignment(SwingConstants.CENTER);
		jlHotelName.setFont(UIConstants.FONT_19);

		jtextHotelName = new JTextField();
		jtextHotelName.setFont(UIConstants.FONT_19);
		jtextHotelName.setColumns(10);

		jbNextStep = new HMSBlueButton("下一步");
		jbNextStep.setFont(UIConstants.FONT_18);
		nextStepMouseListener = new NextStepMouseListener(this);
		jbNextStep.addMouseListener(nextStepMouseListener);

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addGap(60)
										.addComponent(jpHotelAdd, GroupLayout.PREFERRED_SIZE, 202,
												GroupLayout.PREFERRED_SIZE)
										.addGap(30).addComponent(jpHotelStaffAdd, GroupLayout.PREFERRED_SIZE, 243,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup().addGap(93)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(jbNextStep, GroupLayout.PREFERRED_SIZE, 128,
														GroupLayout.PREFERRED_SIZE)
												.addGroup(groupLayout.createSequentialGroup()
														.addComponent(jlHotelName, GroupLayout.PREFERRED_SIZE, 101,
																GroupLayout.PREFERRED_SIZE)
														.addGap(39)
														.addComponent(jtextHotelName, GroupLayout.PREFERRED_SIZE, 231,
																GroupLayout.PREFERRED_SIZE)))))
						.addContainerGap(545, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(47)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(jpHotelStaffAdd, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										47, Short.MAX_VALUE)
								.addComponent(jpHotelAdd, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 47,
										GroupLayout.PREFERRED_SIZE))
						.addGap(46)
						.addGroup(
								groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(jlHotelName, GroupLayout.PREFERRED_SIZE, 36,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(jtextHotelName, GroupLayout.PREFERRED_SIZE, 41,
												GroupLayout.PREFERRED_SIZE))
						.addGap(40).addComponent(jbNextStep, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addGap(453)));

		jlpanelIN = new JLabel("添加酒店工作人员");
		jlpanelIN.setHorizontalAlignment(SwingConstants.CENTER);
		jlpanelIN.setFont(UIConstants.FONT_20);
		jlpanelIN.setForeground(new Color(128, 138, 235));

		GroupLayout gl_jpHotelStaffAdd = new GroupLayout(jpHotelStaffAdd);
		gl_jpHotelStaffAdd
				.setHorizontalGroup(gl_jpHotelStaffAdd.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jpHotelStaffAdd.createSequentialGroup().addContainerGap()
								.addComponent(jlpanelIN, GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
								.addContainerGap()));
		gl_jpHotelStaffAdd
				.setVerticalGroup(gl_jpHotelStaffAdd.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jpHotelStaffAdd.createSequentialGroup().addContainerGap()
								.addComponent(jlpanelIN, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
								.addContainerGap()));
		jpHotelStaffAdd.setLayout(gl_jpHotelStaffAdd);

		lblNewLabel = new JLabel("添加酒店");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(UIConstants.FONT_20);
		lblNewLabel.setForeground(new Color(128, 138, 235));

		GroupLayout gl_jpHotelAdd = new GroupLayout(jpHotelAdd);
		gl_jpHotelAdd
				.setHorizontalGroup(gl_jpHotelAdd.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
						gl_jpHotelAdd.createSequentialGroup().addContainerGap()
								.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
								.addContainerGap()));
		gl_jpHotelAdd
				.setVerticalGroup(gl_jpHotelAdd.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jpHotelAdd.createSequentialGroup().addContainerGap()
								.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
								.addContainerGap()));
		jpHotelAdd.setLayout(gl_jpHotelAdd);
		setLayout(groupLayout);
	}

	public String getHotelName() {
		return jtextHotelName.getText();
	}

	public void showHotalStaffAddUIPanel() {
		webStaffFrame.showHotelStaffAddUIPanel();
	}

	public HotelVO getHotelVO() {
		HotelVO hotelVO = new HotelVO(getHotelName(), 0, 0, null, null, null, null, null, 0);
		// HotelVO hotelVO=new HotelVO(getHotelName());
		return hotelVO;
	}

	public void refresh() {
		jtextHotelName.setText("");
	}

}
