package hrs.client.UI.UserUI.OrderInfoUI;

import java.awt.Color;
import java.awt.Dialog.ModalityType;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import org.junit.validator.PublicClassValidator;

import hrs.client.UI.UserUI.Components.CommonLabel;
import hrs.client.UI.UserUI.Components.CommonPanel;
import hrs.client.UI.UserUI.OrderInfoUI.Listener.DetailButtonLisener;
import hrs.client.UI.UserUI.OrderInfoUI.Listener.EvalueButtonListener;
import hrs.client.UI.UserUI.OrderInfoUI.Listener.StatusBoxListener;
import hrs.client.UI.UserUI.OrderInfoUI.Listener.TableListener;
import hrs.client.UI.UserUI.OrderInfoUI.Listener.revokeListener;
import hrs.client.util.ControllerFactory;
import hrs.client.util.EnumHelper;
import hrs.client.util.HMSBlueButton;
import hrs.client.util.HMSRedButton;
import hrs.client.util.UIConstants;
import hrs.common.Controller.UserController.IUserOrderController;
import hrs.common.Exception.OrderService.OrderNotFoundException;
import hrs.common.VO.OrderVO;
import hrs.common.VO.UserVO;
import hrs.common.util.type.OrderStatus;

public class OrderShowPanel extends CommonPanel {
	/**
	* @Fields serialVersionUID : TODO
	*/ 
	private static final long serialVersionUID = -1738046961448085289L;
	
	private UserVO userVO;
	
	private IUserOrderController controller = ControllerFactory.getUserOrderController();
	JComboBox<String> statusBox;
	private OrderTable table;
	
	private HMSBlueButton evalueButton;
	private HMSBlueButton detailButton;
	private HMSRedButton revokeButton;
	
	private OrderInfoPanel panel;
	Font font = UIConstants.JLABEL_FONT;
	private JScrollPane scrollPane;
	
	private static int GAP_WIDTH = 30;
	public OrderShowPanel(UserVO userVO,OrderInfoPanel panel) {
		this.userVO = userVO;
		this.panel = panel;
		//选框设置
		setCombox();
		
		init();
	}
	
	@Override
	public void init() {
		
		
		//标签设置
		setLabel();
		
		//设置表格
		SetTable();
		// TODO Auto-generated method stub

		//设置按钮
		setButton();
	}

	private void setButton() {
		//查看详细按钮
		detailButton = new HMSBlueButton("查看详细");
		detailButton.setFont(font);
		detailButton.setBounds(550, 640, 150, 40);
		detailButton.addActionListener(new DetailButtonLisener(this));
		
		//评价按钮
		evalueButton = new HMSBlueButton("评价");
		evalueButton.setFont(font);
		evalueButton.setBounds(730, 640, 120, 40);
		evalueButton.addActionListener(new EvalueButtonListener(this));
		
		//撤销按钮
		revokeButton = new HMSRedButton("撤销");
		revokeButton.setFont(font);
		revokeButton.setBounds(880, 640, 120, 40);
		revokeButton.addActionListener(new revokeListener(this));
		
		revokeButton.setEnabled(false);
		evalueButton.setEnabled(false);
		detailButton.setEnabled(false);
		
		add(revokeButton);
		add(detailButton);
		add(evalueButton);
		
		
	}

	
	private void SetTable() {
		table = new OrderTable(getOrderList(OrderStatus.Unexecuted));
		
		
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);
		scrollPane.setBounds(30, 80, 1043,500);
		scrollPane.setBorder(new EmptyBorder(0,0,0,0));
		scrollPane.getViewport().setBackground(new Color(211, 237, 249));
		scrollPane.setOpaque(true);
		table.addMouseListener(new TableListener(this));
		
		
		add(scrollPane);
		
	}

	private void setCombox() {
		statusBox = new JComboBox<String>();
		statusBox.setBounds(GAP_WIDTH*2 + 126,10,168,40);
		statusBox.setFont(font);
		statusBox.addItem("未执行");
		statusBox.addItem("已执行");
		statusBox.addItem("异常");
		statusBox.addItem("已撤销");
		statusBox.setSelectedItem("未执行");
		
		
		statusBox.addItemListener(new StatusBoxListener(statusBox, this));
		
		add(statusBox);
	}

	private void setLabel() {
		// TODO Auto-generated method stub
		JLabel label = new CommonLabel();
		label.setText("选择订单类型");
		label.setBounds(GAP_WIDTH, 0, 126, 60);
//		label.setOpaque(true);
		this.add(label);
	}

	//得到表需要显示的订单
	private List<OrderVO> getOrderList(OrderStatus status){
		try {
			return controller.findOrdersByUsernameAndStatus(userVO.username, status);
		} catch (OrderNotFoundException e) {
			JOptionPane.showConfirmDialog(null, "未找到相关订单", "提示", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE);
			List<OrderVO> list = new ArrayList<>();
			return list;
			
		}
		
	}

	public void setStatus(OrderStatus status) {
		
		table.setModel(getOrderList(status));
			
	}

	public void showDetail() {
		int i = table.getSelectedRow();//选中行
		String status = (String) statusBox.getSelectedItem();
		OrderVO orderVO = getOrderList(EnumHelper.toStatus(status)).get(i);
		panel.showDetail(orderVO);
		
	}

	public void evalue() {
		int i = table.getSelectedRow();//选中行
		String status = (String) statusBox.getSelectedItem();
		OrderVO orderVO = getOrderList(EnumHelper.toStatus(status)).get(i);
		
		//用于评价的弹窗
		JDialog dialog = new JDialog(null, "评价订单",ModalityType.APPLICATION_MODAL);
		dialog.setSize(550, 360);
		dialog.setLocationRelativeTo(null);//居于屏幕正中
		dialog.setLayout(null);
		dialog.getContentPane().setBackground(UIConstants.JFRAME);
		
		//评分标签
		JLabel scoreJL = new JLabel("评分(0-10):");
		scoreJL.setFont(UIConstants.JLABEL_FONT);
		scoreJL.setBounds(10, 20, 120, 40);
		dialog.add(scoreJL);
		
		//评价标签
		JLabel remarkJL = new JLabel("评价:");
		remarkJL.setFont(UIConstants.JLABEL_FONT);
		remarkJL.setBounds(10, 70, 120, 30);
		dialog.add(remarkJL);
		
		//评分选择的JComboBox
		JComboBox<Integer> scoreBox = new JComboBox<>();
		for(int c = 0;c<=10;c++){
			scoreBox.addItem(c);
		}
		scoreBox.setBounds(140, 20, 80, 40);
		scoreBox.setFont(UIConstants.JLABEL_FONT);
		dialog.add(scoreBox);
		
		//评价的编辑域
		JTextArea remarkArea = new JTextArea();
		remarkArea.setFont(UIConstants.JLABEL_FONT);
		remarkArea.setLineWrap(true);
		JScrollPane remarkJS = new JScrollPane(remarkArea);
		remarkJS.setBounds(140, 70, 370, 150);
		dialog.add(remarkJS);
		
		//确认评价
		JButton confirmJB = new JButton("确认");
		confirmJB.setFont(UIConstants.JLABEL_FONT);
		confirmJB.setBounds(400, 250, 80, 30);
		confirmJB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.remark(orderVO, (int)scoreBox.getSelectedItem(), remarkArea.getText());
				JOptionPane.showMessageDialog(null, "评价成功！" + "可以随时从订单管理里查看修改您的订单", "提示",
						JOptionPane.INFORMATION_MESSAGE);
				dialog.dispose();
			}
		});
		
		dialog.add(confirmJB);
		
		dialog.setVisible(true);
	}
	
	public void revoke() {
		int i = table.getSelectedRow();//选中行
		String status = (String) statusBox.getSelectedItem();
		OrderVO orderVO = getOrderList(EnumHelper.toStatus(status)).get(i);
		controller.revoke(orderVO);
		
		table.setModel(getOrderList(EnumHelper.toStatus(status)));
	}
	
	public void setRevokeFalse(){
		revokeButton.setEnabled(false);
	}

	public void setButtonStatus() {
		int i = table.getSelectedRow();
		if(i != -1){
			revokeButton.setEnabled(true);
			evalueButton.setEnabled(true);
			detailButton.setEnabled(true);
		}
		
		if(statusBox.getSelectedItem().equals("已执行")||statusBox.getSelectedItem().equals("已撤销")){
			revokeButton.setEnabled(false);
		}
		if(statusBox.getSelectedItem().equals("未执行")||statusBox.getSelectedItem().equals("已撤销")||statusBox.getSelectedItem().equals("异常adad")){
			evalueButton.setEnabled(false);
		}
	}

	public void setButtonUnable() {
		revokeButton.setEnabled(false);
		evalueButton.setEnabled(false);
		detailButton.setEnabled(false);
		
	}
}
