package com.hoosee.topic1.frame;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.hoosee.topic1.dao.TbGoodsDao;
import com.hoosee.topic1.model.TbGoods;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddWin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JDialog jd;
	
	private TbGoodsDao tbGoodsDao = new TbGoodsDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddWin frame = new AddWin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * 创建窗口
	 */
	public AddWin() {
		setTitle("添加商品");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 337, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("商品编号");
		lblNewLabel.setBounds(57, 70, 54, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("商品名称");
		lblNewLabel_1.setBounds(57, 114, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("数量");
		lblNewLabel_2.setBounds(57, 161, 54, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("价格");
		lblNewLabel_3.setBounds(57, 209, 54, 15);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(121, 67, 127, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(121, 111, 127, 21);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(121, 158, 127, 21);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(121, 206, 127, 21);
		contentPane.add(textField_3);
		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//将界面中用户输入的数据封装成TbGoods对象
				TbGoods tbGoods = new TbGoods();
				tbGoods.setGoodId(Integer.parseInt(textField.getText()));
				tbGoods.setGoodName(textField_1.getText());
				tbGoods.setNum(Integer.parseInt(textField_2.getText()));
				tbGoods.setPrice(Double.parseDouble(textField_3.getText()));
				//将TbGoods对象传递给数据操纵层，插入数据库
				tbGoodsDao.insertTbGoods(tbGoods);
				JOptionPane.showMessageDialog(null, "插入成功");
				//获取父窗口并且调用refreshTable方法刷新窗口的数据
				MainWin parent = (MainWin)jd.getParent();
				//parent.textField.getText()为父窗体中搜索栏中的内容，保持父窗体的数据一致
				parent.refreshTable(parent.textField.getText());
			}
		});
		btnNewButton.setBounds(88, 282, 75, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("取消");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jd.dispose();
			}
		});
		btnNewButton_1.setBounds(188, 282, 75, 23);
		contentPane.add(btnNewButton_1);
		setLocationRelativeTo(null);
	}
	
	//创建一个新增窗口对话框，parent为对话框的所有者，也就是主窗体
	public void createAddWin(Frame parent) {
		
		//创建对话框窗体，设置窗体基本属性
		jd = new JDialog(parent,true);
		jd.setTitle("添加商品");
		//JFrame.DISPOSE_ON_CLOSE指的是，点击对话框的关闭按钮时，销毁对话框（不能关闭整个应用程序）
		jd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jd.setBounds(100, 100, 337, 397);
		jd.getContentPane().setLayout(null);
		jd.setLocationRelativeTo(null);
		
		//*将新增窗体的内容面板复制给对话框
		jd.setContentPane(this.getContentPane());
		jd.setVisible(true);
	}

}
