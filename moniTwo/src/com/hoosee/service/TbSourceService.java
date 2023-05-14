package com.hoosee.service;

import com.hoosee.dao.TbSourceDao;
import com.hoosee.model.TbSource;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class TbSourceService {
    TbSourceDao tbSourceDao=new TbSourceDao();

    /**
     * 查询全部，并按登记时间倒序
     */
        public List<TbSource> sellectAll() {
            return tbSourceDao.sellectAll();
        }

        /**
         * 新增
         *
         * @param name
         * @param sex
         * @param birthday
         * @param cardno
         * @param address
         * @param isLocal
         */
        public void insert(String name, String sex, String  birthday, String cardno, String address, Integer isLocal) {
            tbSourceDao.insert(name, sex, birthday, cardno, address, isLocal);
        }

        /**
         * 删除
         *
         * @param id
         */
        public void delete(Integer id) {
            tbSourceDao.delete(id);
        }

}
