package com.hoosee.dao;

import com.hoosee.model.TbBook;

import java.util.List;

public class TbBookDao extends BaseDao{

    /**
     * 查询全部，并按找名称排序
     * @return
     */
    public List<TbBook> selectAll(){
        String sql="SELECT * FROM `tb_book` ORDER BY book_name";
        return getList(sql,TbBook.class);
    }

    /**
     * 新增
     */
    public void insert(String book_name,String book_author,Float book_price,String book_publisher,Integer book_state,String add_time){
        String sql="INSERT INTO `library_db`.`tb_book`(`book_name`, `book_author`, `book_price`, `book_publisher`, `book_state`, `add_time`) VALUES (?,?,?, ?,?, ?)";
        update(sql,book_name,book_author,book_price,book_publisher,book_state,add_time);
    }

    /**
     * 修改
     */
    public void update(String book_state,Integer book_id){
        String sql="UPDATE `library_db`.`tb_book` SET `book_state` = ? WHERE `book_id` = ?";
        update(sql,book_state,book_id);
    }

}
