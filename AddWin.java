package frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import dao.TbOrderDao;

import model.TbOrder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddWin extends JDialog {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	//实例化dao层
	TbOrderDao dao = new TbOrderDao();
	
	//子窗口要存父窗口的实例
	public static MainWin parent;


	/**
	 * Create the frame.
	 */
	public AddWin(MainWin mainWin) {
		//启用模态窗口
		super(mainWin,true);
		parent = mainWin;
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u6DFB\u52A0\u8BA2\u5355\u4FE1\u606F");
		lblNewLabel.setBounds(174, 10, 100, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5546\u54C1\u540D\u79F0");
		lblNewLabel_1.setBounds(82, 49, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel label = new JLabel("\u5546\u54C1\u4EF7\u683C");
		label.setBounds(82, 87, 54, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u8BA2\u5355\u7F16\u53F7");
		label_1.setBounds(82, 124, 54, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u8BA2\u5355\u63CF\u8FF0");
		label_2.setBounds(82, 164, 54, 15);
		contentPane.add(label_2);
		
		textField = new JTextField();
		textField.setBounds(162, 46, 152, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(162, 84, 152, 21);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(162, 121, 152, 21);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(162, 161, 152, 21);
		contentPane.add(textField_3);
		
		JButton btnNewButton = new JButton("\u786E\u8BA4\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText();
				String price = textField_1.getText();
				String orderId = textField_2.getText();
				String desc = textField_3.getText();
				//数据校验
				if(name!=null&&!"".equals(name)&&price!=null&&!"".equals(price)&&orderId!=null&&!"".equals(orderId)&&desc!=null&&!"".equals(desc)){
					//将数据封装到TbOrder对象中
					TbOrder tbOrder = new TbOrder();
					tbOrder.setName(name);
					tbOrder.setPrice(Double.parseDouble(price));
					tbOrder.setOrderId(orderId);
					tbOrder.setDescinfo(desc);
					//新增
					dao.insert(tbOrder);
					JOptionPane.showMessageDialog(null, "添加成功");
					//刷新父窗口
					parent.refresh();
					//关闭子窗口
					parent.addWin.dispose();
				}else{
					JOptionPane.showMessageDialog(null, "必须全都填","错误",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(75, 214, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u8FD4\u56DE\u4E3B\u9875");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//调用父窗口销毁当前窗口
				parent.addWin.dispose();
			}
		});
		btnNewButton_1.setBounds(259, 214, 93, 23);
		contentPane.add(btnNewButton_1);
	}
}
