package com.mhys.dao;

import com.mhys.model.TbBook;

import java.util.List;

public class TbBookDao extends BaseDao {
    //查询
    public List<TbBook>selectTbBook(){
        String sql="select * from tb_book";
        return getList(sql,TbBook.class);
    }
    //修改
    public int updateTbBook(String state,String id){
        String sql="UPDATE `library_db`.`tb_book` SET `book_state` = ? WHERE `book_id` = ?";
        return update(sql,state,id);
    }
    //新增
    public int insertTbBook(TbBook tbBook){
        String sql="INSERT INTO `library_db`.`tb_book`(`book_name`, `book_author`, `book_price`, `book_publisher`, `book_state`, `add_time`) VALUES (?, ?, ?, ?, ?, ?)";
        return update(sql,tbBook.getBook_name(),tbBook.getBook_author(),tbBook.getBook_price(),tbBook.getBook_publisher(),tbBook.getBook_state(),tbBook.getAdd_time());
    }
}
