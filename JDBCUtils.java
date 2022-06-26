package com.hoosee1.utils;
import java.sql.*;


public class JDBCUtils {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/goods_db";
    private static final String user = "root";
    private static final String password = "123456";

    static {
        // 1.加载数据库驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 增删改操作
     * @param sql 更新语句
     * @param objects 更新语句的参数
     */
    public static void addAndUpdate(String sql,Object...objects){
        Connection conn = null;
        PreparedStatement statement = null;
        //2.获取数据库连接
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("数据库连接成功!");

            //4.获取PreparedStatement对象
            statement = conn.prepareStatement(sql);

            //5.填充sql参数
            for(int i=0;i<objects.length;i++){
                statement.setObject(i+1, objects[i]);
            }


            //6.执行sql语句
            statement.execute();
            System.out.println("执行成功!");

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            //7.释放资源
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     *
     * @param sql 查询语句
     * @param column 查询结果的列数
     * @param objects 查询语句的参数
     */
    public static String[][] select(String sql,int column,Object...objects){
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        String[][] data = null;
        //2.获取数据库连接
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("数据库连接成功!");

            //4.获取PreparedStatement对象
            statement = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

            //5.填充sql参数
            for(int i=0;i<objects.length;i++){
                statement.setObject(i+1, objects[i]);
            }

            //6.执行sql语句
            rs = statement.executeQuery();

            //7.封装数据
            //统计数据行数
            int rows = 0;
            while(rs.next()){
                rows++;
            }
            //重置resultset的指针
            rs.beforeFirst();

            data = new String[rows][column];
            int rowsNow = 0;//当前行号
            while(rs.next()){
                for(int i = 0;i<column;i++){
                    data[rowsNow][i] = rs.getString(i+1);
                }
                rowsNow++;
            }

            System.out.println("执行成功");

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            //7.释放资源
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return data;
    }

}
