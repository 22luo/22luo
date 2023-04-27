package com.mhys.mapper;

import com.mhys.model.TbCategory;
import com.mhys.model.TbGoods;
import org.apache.ibatis.annotations.Lang;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TbCategoryMapper {
////6
//    @Select("SELECT * FROM tb_category WHERE id=#{id}")
//     TbCategory selectByid1(@Param("id")Integer id);















    @Select("select * from tb_category WHERE id=#{id}")
    TbCategory SelectByid(@Param("id")Integer id);











}
