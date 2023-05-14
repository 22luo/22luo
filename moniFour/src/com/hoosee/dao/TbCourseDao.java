package com.hoosee.dao;

import com.hoosee.model.TbCourse;

import java.util.List;

public class TbCourseDao extends BaseDao{

    /**
     * 查询全部
     * @return
     */
    public List<TbCourse> selectAll(){
        String sql="SELECT * FROM `tb_source`";
        return getList(sql,TbCourse.class);
    }

    /**
     * 模糊查询
     * @return
     */
    public List<TbCourse> selectLike(String name){
        String sql="SELECT * FROM `tb_source` WHERE `name` LIKE concat('%',?,'%') ";
        return getList(sql,TbCourse.class,name);
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
        String sql="INSERT INTO `source_db`.`tb_source`(`name`, `count`, `startDate`, `endDate`, `teacher`) VALUES (?,?,?,?,?)";
        update(sql,name,count,startDate,endDate,teacher);
    }

    public void delete(Integer id){
        String sql="DELETE FROM `source_db`.`tb_source` WHERE `id` = ?";
        update(sql,id);
    }
}
