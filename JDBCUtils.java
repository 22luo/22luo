package com.hoosee.topic1.utils;

import java.sql.*;

public class JDBCUtils {

    private static final String URL="jdbc:mysql://127.0.0.1:3306/goods_db";
    private static final String user="root";
    private static final String password="123456";

    static {
        try {
            //1.加载驱动程序
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //获取Connection对象
    public static Connection getConnection() throws Exception{
        //2.获得数据库链接
        return DriverManager.getConnection(URL, user, password);
    }

    //关闭资源
    public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet){
        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //关闭PreparedStatement对象
        if(preparedStatement!=null){
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //关闭Connection对象
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
