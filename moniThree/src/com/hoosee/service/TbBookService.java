package com.hoosee.service;

import com.hoosee.dao.TbBookDao;
import com.hoosee.model.TbBook;

import java.util.List;

public class TbBookService {
    TbBookDao tbBookDao=new TbBookDao();

    /**
     * 查询全部，并按找名称排序
     * @return
     */
    public List<TbBook> selectAll(){
        return tbBookDao.selectAll();
    }

    /**
     * 新增
     */
    public void insert(String book_name,String book_author,Float book_price,String book_publisher,Integer book_state,String add_time){
        tbBookDao.insert(book_name,book_author,book_price,book_publisher,book_state,add_time);
    }

    /**
     * 修改
     */
    public void update(String book_state,Integer book_id){
        tbBookDao.update(book_state,book_id);
    }
}
