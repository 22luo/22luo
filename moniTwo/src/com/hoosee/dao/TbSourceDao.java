package com.hoosee.dao;

import com.hoosee.model.TbSource;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * 查询全部，并按登记时间倒序
 */
public class TbSourceDao extends BaseDao{
    public List<TbSource> sellectAll(){
        String sql="SELECT * FROM tb_source ORDER BY writeTime DESC";
        return getList(sql,TbSource.class);
    }

    /**
     * 新增
     * @param name
     * @param sex
     * @param birthday
     * @param cardno
     * @param address
     * @param isLocal
     * @param
     */
    public void insert(String name, String sex, String birthday, String cardno, String address, Integer isLocal){
        String sql="INSERT INTO `source_db`.`tb_source`(`name`, `sex`, `birthday`, `cardno`, `address`, `isLocal`, `writeTime`) VALUES (?, ?, ?, ?,?,?,SYSDATE())";
        update(sql,name,sex,birthday,cardno,address,isLocal);
    }

    /**
     * 删除
     * @param id
     */
    public void delete(Integer id){
        String sql="DELETE FROM `source_db`.`tb_source` WHERE `id` = ?";
        update(sql,id);
    }


}
