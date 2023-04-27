package com;


import com.mhys.mapper.TbCategoryMapper;
import com.mhys.mapper.TbGoodsMapper;
import com.mhys.model.TbCategory;
import com.mhys.model.TbGoods;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class TestTbGoodsMapper extends TestMapper {
//    //        1、查询所有商品列表（10分）
//    @Test
//    public void TestSelectAll() {
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        TbGoodsMapper tbGoodsMapper = sqlSession.getMapper(TbGoodsMapper.class);
//        List<TbGoods> list = tbGoodsMapper.selectAll();
//        for (TbGoods tg : list) {
//            System.out.println(tg);
//        }
//        sqlSession.close();
//    }
//
//    //        2、查询所有商品数量（10分）
//    @Test
//    public void TestCountGoods() {
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        TbGoodsMapper tbGoodsMapper = sqlSession.getMapper(TbGoodsMapper.class);
//        int countGoods = tbGoodsMapper.countGoods();
//        System.out.println("商品总数：" + countGoods);
//        sqlSession.close();
//    }
//
//    //        3、查询指定分类id（cateid）的商品列表（10分）
//    @Test
//    public void TestSelectCateId() {
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        TbGoodsMapper tbGoodsMapper = sqlSession.getMapper(TbGoodsMapper.class);
//        List<TbGoods> list = tbGoodsMapper.selectCateId(2);
//        for (TbGoods tg : list) {
//            System.out.println(tg);
//        }
//        sqlSession.close();
//    }
//
//    //    4、根据主键id查找商品（10分）
//    @Test
//    public void TestSelectByid() {
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        TbGoodsMapper tbGoodsMapper = sqlSession.getMapper(TbGoodsMapper.class);
//        TbGoods tbGoods = tbGoodsMapper.selectByid(6);
//        System.out.println(tbGoods);
//        sqlSession.close();
//    }
//
//    //    5、使用模糊查询，查询所有标题（title）包含指定关键字的商品（10分）
//    @Test
//    public void TestSelectByTitle() {
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        TbGoodsMapper tbGoodsMapper = sqlSession.getMapper(TbGoodsMapper.class);
//        List<TbGoods> list = tbGoodsMapper.selectByTitle("美");
//        for (TbGoods tg : list) {
//            System.out.println(tg);
//        }
//        sqlSession.close();
//    }
//
//    //    6、根据主键id查找商品，商品中要包含分类信息（tb_category）（10分）
//    @Test
//    public void TestSelectByid2() {
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        TbGoodsMapper tbGoodsMapper = sqlSession.getMapper(TbGoodsMapper.class);
//        TbCategoryMapper tbCategoryMapper = sqlSession.getMapper(TbCategoryMapper.class);
//        TbGoods tbGoods = tbGoodsMapper.selectByid(4);
//        TbCategory tbCategory = tbCategoryMapper.selectByid1(tbGoods.getCateid());
//        System.out.println(tbCategory);
//        System.out.println(tbGoods);
//        System.out.println("分类名称：" + tbCategory.getCname());
//        sqlSession.close();
//    }
//
//    //    7、使用<where>标签和<if>标签实现多条件查询，支持以下3种情况：（10分）
//    @Test
//    public void TestSelectByCateIdandTitle() {
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        TbGoodsMapper tbGoodsMapper = sqlSession.getMapper(TbGoodsMapper.class);
//        TbGoods tbGoods = new TbGoods();
//        tbGoods.setTitle("小");
//        tbGoods.setCateid(1);
//        List<TbGoods> list = tbGoodsMapper.selectByCateIdandTitle(tbGoods);
//        for (TbGoods tg : list) {
//            System.out.println(tg);
//        }
//        sqlSession.close();
//    }
//
////        8、使用<foreach>标签，批量查询多个主键id的商品信息（10分）
//@Test
//public void TestSelectByIdList() {
//    SqlSession sqlSession = sqlSessionFactory.openSession();
//    TbGoodsMapper tbGoodsMapper = sqlSession.getMapper(TbGoodsMapper.class);
//    List<Integer>idList =new ArrayList<Integer>();
//    idList.add(1);
//    idList.add(3);
//    idList.add(4);
//    List<TbGoods> list = tbGoodsMapper.selectByIdList(idList);
//    for (TbGoods tg : list) {
//        System.out.println(tg);
//    }
//    sqlSession.close();
//}
//
//    //    10、查找指定主键id的分类信息，分类中包含关联的所有商品列表（10分）
//    @Test
//    public void TestSelectByid1() {
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        TbCategoryMapper tbCategoryMapper = sqlSession.getMapper(TbCategoryMapper.class);
//        TbCategory tbCategory = tbCategoryMapper.selectByid1(4);
//        TbGoodsMapper tbGoodsMapper = sqlSession.getMapper(TbGoodsMapper.class);
//        List<TbGoods> list = tbGoodsMapper.selectCateId1(tbCategory.getId());
//        System.out.println("分类名称：" + tbCategory.getCname());
//        for (TbGoods tg : list) {
//            System.out.println(tg);
//        }
//        sqlSession.close();
//    }


//    @Test
//    public void TestSelectAll() {
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        TbGoodsMapper tbGoodsMapper = sqlSession.getMapper(TbGoodsMapper.class);
//        List<TbGoods> list = tbGoodsMapper.selectAll();
//        for (TbGoods tg : list) {
//            System.out.println(tg);
//        }
//        sqlSession.close();
//    }
//
//
//    @Test
//    public void TestSelectBycont() {
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        TbGoodsMapper tbGoodsMapper = sqlSession.getMapper(TbGoodsMapper.class);
//        int tbGoods = tbGoodsMapper.selectBycont();
//        System.out.println(tbGoods);
//        sqlSession.close();
//    }
//
//    @Test
//    public void TestSelectBycateid() {
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        TbGoodsMapper tbGoodsMapper = sqlSession.getMapper(TbGoodsMapper.class);
//        List<TbGoods> list = tbGoodsMapper.selectBycateid(2);
//        for (TbGoods tg : list) {
//            System.out.println(tg);
//        }
//        sqlSession.close();
//    }
//
//    @Test
//    public void TestSelectBycId() {
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        TbGoodsMapper tbGoodsMapper = sqlSession.getMapper(TbGoodsMapper.class);
//        TbGoods tbGoods = tbGoodsMapper.selectBycId(6);
//
//        System.out.println(tbGoods);
//        sqlSession.close();
//    }
//
//
//    @Test
//    public void TestSelectByTitle() {
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        TbGoodsMapper tbGoodsMapper = sqlSession.getMapper(TbGoodsMapper.class);
//        List<TbGoods> list = tbGoodsMapper.selectByTitle("美");
//        for (TbGoods tg : list) {
//            System.out.println(tg);
//        }
//        sqlSession.close();
//    }
//
//
//
//    @Test
//    public void TestSelectByid1() {
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        TbGoodsMapper tbGoodsMapper = sqlSession.getMapper(TbGoodsMapper.class);
//        TbCategoryMapper tbCategoryMapper = sqlSession.getMapper(TbCategoryMapper.class);
//        TbGoods tbGoods = tbGoodsMapper.selectBycId(4);
//        TbCategory tbCategory = tbCategoryMapper.selectByid1(tbGoods.getCateid());
//
//        System.out.println(tbGoods);
//        System.out.println("分类商品:"+tbCategory.getCname());
//        sqlSession.close();
//    }


    @Test
    public void TestSelectAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TbGoodsMapper tbGoodsMapper = sqlSession.getMapper(TbGoodsMapper.class);
        List<TbGoods> list = tbGoodsMapper.SelectAll();
        for (TbGoods tg : list) {
            System.out.println(tg);
        }
    }

    @Test
    public void TestSelectByCount() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TbGoodsMapper tbGoodsMapper = sqlSession.getMapper(TbGoodsMapper.class);
        int tbGoods = tbGoodsMapper.selectByCount();

        System.out.println("商品总数" + tbGoods);

    }

    @Test
    public void TestSelectByCateid() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TbGoodsMapper tbGoodsMapper = sqlSession.getMapper(TbGoodsMapper.class);
        List<TbGoods> list = tbGoodsMapper.SelectByCateid(2);
        for (TbGoods tg : list) {
            System.out.println(tg);
        }
    }


    @Test
    public void TestSelectByid() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TbGoodsMapper tbGoodsMapper = sqlSession.getMapper(TbGoodsMapper.class);
        TbGoods tbGoods = tbGoodsMapper.SelectByid(6);

        System.out.println(tbGoods);

    }
    @Test
    public void TestSelectBytitle() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TbGoodsMapper tbGoodsMapper = sqlSession.getMapper(TbGoodsMapper.class);
        List<TbGoods> list = tbGoodsMapper.SelectBytitle("美");
        for (TbGoods tg : list) {
            System.out.println(tg);
        }
    }

    @Test
    public void TestSelectByid1() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TbGoodsMapper tbGoodsMapper = sqlSession.getMapper(TbGoodsMapper.class);
        TbCategoryMapper tbCategoryMapper=sqlSession.getMapper(TbCategoryMapper.class);
        TbGoods tbGoods = tbGoodsMapper.SelectByid(4);
        TbCategory tbCategory=tbCategoryMapper.SelectByid(tbGoods.getCateid());


            System.out.println(tbGoods);
        System.out.println(tbCategory.getCname());
        ;

    }

}
