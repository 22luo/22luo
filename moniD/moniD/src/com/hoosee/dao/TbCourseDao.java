package com.hoosee.dao;

import com.hoosee.model.TbCourse;

import java.util.List;

public class TbCourseDao extends BaseDao{
    //查询
    public List<TbCourse> selectTbCourse(String name){
        String sql="select * from tb_course where name LIKE?";
        return getList(sql,TbCourse.class,"%"+name+"%");
    }
    //删除
    public int delTbCourse(String id){
        String sql="DELETE FROM `o2omgr_db`.`tb_course` WHERE `id` = ?";
        return update(sql,id);
    }
    //新增
    public int insertTbCourse(TbCourse tbCourse){
        String sql="INSERT INTO `o2omgr_db`.`tb_course`(`name`, `count`, `startDate`, `endDate`, `teacher`) VALUES (?, ?, ?, ?, ?)";
        return update(sql,tbCourse.getName(),tbCourse.getCount(),tbCourse.getStartDate(),tbCourse.getEndDate(),tbCourse.getTeacher());
    }
}
