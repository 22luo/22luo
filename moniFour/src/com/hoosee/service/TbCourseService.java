package com.hoosee.service;

import com.hoosee.dao.TbCourseDao;
import com.hoosee.model.TbCourse;

import java.util.List;

public class TbCourseService {
    TbCourseDao tbCourseDao=new TbCourseDao();


    /**
     * 查询全部
     * @return
     */
    public List<TbCourse> selectAll(){
        return tbCourseDao.selectAll();
    }

    /**
     * 模糊查询
     * @return
     */
    public List<TbCourse> selectLike(String name){
        return tbCourseDao.selectLike(name);
    }

    /**
     * 新增
     * @param name
     * @param count
     * @param startDate
     * @param endDate
     * @param teacher
     */
    public void insert(String name,Integer count,String startDate,String endDate,String teacher){
        tbCourseDao.insert(name,count,startDate,endDate,teacher);
    }

    public void delete(Integer id){
        tbCourseDao.delete(id);
    }
}
