package com.mhys.mapper;

import com.mhys.model.TbGoods;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TbGoodsMapper {
//    //1
//    @Select("SELECT * FROM tb_goods")
//    List<TbGoods> selectAll();
//
//    //2
//    @Select("SELECT count(*) FROM tb_goods")
//    int countGoods();
//
//    //3
//    @Select("SELECT * FROM tb_goods where cateid=#{cateid}")
//    List<TbGoods> selectCateId(@Param("cateid") int cateid);
//
//    //4
//    @Select("SELECT * FROM tb_goods where id=#{id}")
//    TbGoods selectByid(@Param("id") int id);
//
//    //5
//    @Select("SELECT * FROM tb_goods where title like concat('%',#{title},'%')")
//    List<TbGoods> selectByTitle(@Param("title") String title);
//
//    //7
//    List<TbGoods> selectByCateIdandTitle(@Param("tbGoods") TbGoods tbGoods);
//
////8
//    List<TbGoods>selectByIdList(@Param("idList")List<Integer>idList);
//
//    //10
//    @Select("SELECT * FROM tb_goods where cateid=#{cateid}")
//    List<TbGoods> selectCateId1(@Param("cateid") int cateid);

//1
//    @Select("select * from tb_goods")
//    List<TbGoods> selectAll();
//2
//    @Select("select count(*) from tb_goods")
//    int selectBycont();
//3
//    @Select("select * from tb_goods WHERE cateid=#{cateid}")
//    List<TbGoods> selectBycateid(@Param("cateid") Integer cateid);
//
//4
//    @Select("select * from tb_goods WHERE id=#{id}")
//    TbGoods selectBycId(@Param("id") int id);
//5
//    @Select("select * from tb_goods WHERE title LIKE concat('%',#{title},'%')")
//    List<TbGoods> selectByTitle(@Param("title") String title);


    @Select("select * from tb_goods")
    List<TbGoods> SelectAll();

    @Select("select count(*) from tb_goods")
    int selectByCount();

    @Select("select * from tb_goods WHERE cateid=#{cateid}")
    List<TbGoods> SelectByCateid(@Param("cateid")Integer cateid);

    @Select("select * from tb_goods WHERE id=#{id}")
    TbGoods SelectByid(@Param("id")Integer id);

    @Select("select * from tb_goods WHERE title like concat('%',#{title},'%')")
    List<TbGoods> SelectBytitle(@Param("title")String title);
}
