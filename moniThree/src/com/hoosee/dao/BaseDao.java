package com.hoosee.dao;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BaseDao<T> {
    protected String url = "jdbc:mysql://localhost:3306/library_db";
    protected String name = "root";
    protected String password = "123456";
    protected String driver = "com.mysql.cj.jdbc.Driver";
    protected Connection conn = null;
    protected PreparedStatement pstmt = null;
    protected ResultSet rs = null;

    /**
     * 执行增删改查，返回受影响的行数
     * @param sql
     * @param objects
     * @return
     */
    public int update(String sql,Object...objects){
        try {
            connect();
            pstmt = conn.prepareStatement(sql);
            for (int i = 0; i < objects.length; i++) {
                pstmt.setObject(i+1,objects[i]);
            }
           return pstmt.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }finally {
            closeAll();
        }
        return -1;
    }

    /**
     * 执行查询，返回对象列表
     * @param sql
     * @param clazz
     * @param objects
     * @return
     */
    public List<T> getList(String sql,Class<T> clazz, Object...objects){
        ArrayList<T> list = null;
        try {
            connect();
            pstmt = conn.prepareStatement(sql);
            for (int i = 0; i < objects.length; i++) {
                pstmt.setObject(i+1,objects[i]);
            }
            rs = pstmt.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            list = new ArrayList<>();
            while (rs.next()) {
                T t = clazz.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    Object columnValue = rs.getObject(i + 1);
                    String columnLabel = rsmd.getColumnLabel(i + 1);
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, columnValue);
                }
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return list;
    }

    /**
     * 用于查询特殊值的通用方法，例如select count(*)...这样的sql语句
     * @param sql
     * @param objects
     * @return
     */
    public Object getValue(String sql, Object... objects) {
        try {
            connect();
            pstmt = conn.prepareStatement(sql);
            for (int i = 0; i < objects.length; i++) {
                pstmt.setObject(i+1,objects[i]);
            }
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getObject(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll();
        }
        return null;
    }

    /**
     * 统一的获取数据库连接操作
     * @throws Exception
     */
    private void connect(){
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, name, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 统一的关闭资源操作
     */
    private void closeAll(){
        try {
            if (rs != null) {
                rs.close();
            }
            if(pstmt!=null){
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}