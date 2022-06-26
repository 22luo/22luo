package com.hoosee.topic1.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.hoosee.topic1.dao.TbGoodsDao;
import com.hoosee.topic1.model.TbGoods;

import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWin extends JFrame {

	private JPanel contentPane;
	public JTextField textField;
	private JTable table;

	private TbGoodsDao tbGoodsDao = new TbGoodsDao();

	/**
	 * 程序入口
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWin frame = new MainWin();
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
	public MainWin() {
		setTitle("商品管理");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 659, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("请输入商品名称：");
		lblNewLabel.setBounds(61, 41, 109, 15);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(180, 38, 145, 21);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("查询");
		//为“查询”按钮绑定单击事件，点击查询按钮时调用refreshTable()方法刷新表格数据
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//获取搜索框中的搜索关键字
				String goodName = textField.getText();
				//刷新表格中的数据
				refreshTable(goodName);
			}
		});
		btnNewButton.setBounds(347, 37, 79, 23);
		contentPane.add(btnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(46, 93, 452, 214);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		//刷新表格中的数据
		refreshTable(null);
		
		JButton btnNewButton_1 = new JButton("添加");
		//为“新增”按钮绑定单击事件，点击按钮时弹出新增对话框
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddWin addWin = new AddWin();
				//调用AddWin类中的createAddWin静态方法创建对话框，参数为当前主窗体，作为弹出框的所有者
				addWin.createAddWin(MainWin.this);
			}
		});
		btnNewButton_1.setBounds(532, 96, 84, 23);
		contentPane.add(btnNewButton_1);
		setLocationRelativeTo(null);
	}

	// 刷新表格数据
	public void refreshTable(String goodName) {
		String[] header = new String[] { "商品编号", "商品名称", "数量", "单价" };
		// 调用数据操纵层查询商品列表
		List<TbGoods> list = tbGoodsDao.list(goodName);
		// 将查询结果从list转换成二维数组（JTable插入数据需要二维数组格式）
		// 二维数组中第一个[]中的数值为行数,第二个[]中的数组为列数
		Object[][] data = new Object[list.size()][4];
		for (int i = 0; i < list.size(); i++) {
			TbGoods tg = list.get(i);
			data[i][0] = tg.getGoodId();
			data[i][1] = tg.getGoodName();
			data[i][2] = tg.getNum();
			data[i][3] = tg.getPrice();
		}
		// 借助DefaultTableModel对象刷新JTable中的数据
		DefaultTableModel dtm = new DefaultTableModel(data, header);
		table.setModel(dtm);
	}
}
