package com.hoosee.topic1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hoosee.topic1.model.TbGoods;
import com.hoosee.topic1.utils.JDBCUtils;

public class TbGoodsDao {

	/**
	 * 查询商品列表
	 * @param goodName
	 * @return
	 */
	public List<TbGoods> list(String goodName) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<TbGoods> list = new ArrayList<TbGoods>();
		try {
			//1.获取数据库连接
			conn = JDBCUtils.getConnection();
			//2.声明sql语句
			String sql = "SELECT goodId,goodName,num,price FROM tb_goods WHERE 1=1";
			//如果goodName参数为null，意味着没有查询条件，直接查询全表数据
			//如果goodName参数不为null，意味着需要根据商品名称进行模糊查询
			if(goodName!=null&&!"".equals(goodName)) {
				sql += " and goodName like ?";
			}
			//3.获取prepareStatement对象
			preparedStatement = conn.prepareStatement(sql);
			//4.为sql语句注入参数，当goodName不为null时，需要为sql语句中的"?"占位符填充实际参数
			if(goodName!=null&&!"".equals(goodName)) {
				//因为要进行模糊查询，所以goodName要写成%goodName%的形式
				preparedStatement.setString(1, "%"+goodName+"%");
			}
			//5.执行sql语句
			resultSet = preparedStatement.executeQuery();
			//6.从resultSet中读取查询结果
			//resultSet对象视为查询结果表，表中的指针指向表头
			//resultSet.next()往下读取一行数据，能够读取到数据返回true，读取不到数据返回false
			while(resultSet.next()) {
				//将resultSet中的一行数据读取出来，装入一个TbGoods对象中
				TbGoods tg = new TbGoods();
				tg.setGoodId(resultSet.getInt("goodId"));
				tg.setGoodName(resultSet.getString("goodName"));
				tg.setNum(resultSet.getInt("num"));
				tg.setPrice(resultSet.getDouble("price"));
				//将装好数据的TbGoods对象加入集合中
				list.add(tg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//7.关闭资源
			JDBCUtils.close(conn, preparedStatement, resultSet);
		}
		//将查询结果返回给控制层
		return list;
	}
	
	/**
	 * 新增商品信息
	 * @param tbGoods
	 */
	public void insertTbGoods(TbGoods tbGoods) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			//1.获取数据库连接
			conn = JDBCUtils.getConnection();
			//2.声明sql语句
			String sql = "INSERT INTO `tb_goods` VALUES (?, ?, ?, ?)";
			//3.获取prepareStatement对象
			preparedStatement = conn.prepareStatement(sql);
			//4.为sql语句注入参数
			preparedStatement.setInt(1, tbGoods.getGoodId());
			preparedStatement.setString(2, tbGoods.getGoodName());
			preparedStatement.setInt(3, tbGoods.getNum());
			preparedStatement.setDouble(4, tbGoods.getPrice());
			//5.执行sql语句
			preparedStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//6.关闭资源
			JDBCUtils.close(conn, preparedStatement, resultSet);
		}
	}
	
}
