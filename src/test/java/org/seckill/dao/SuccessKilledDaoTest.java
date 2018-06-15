package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SuccessKilled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author MXN
 * @create 2018-05-18 11:05
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessKilledDaoTest {

    @Autowired
    private SuccessKilledDao successKilledDao;

    @Test
    public void insertSuccessKilled() {
        /**
         * 第一次：insertCount=1
         * 第二次：insertCount=0
         * 第三次：insertCount=0
         */
        long id = 1005;
        long phone = 15669910310L;
        int insertCount = successKilledDao.insertSuccessKilled(id, phone);
        System.out.println("insertCount=" + insertCount);
    }

    @Test
    public void queryByIdWithSeckill() {
        try {
            long id = 1006;
            long phone = 15669910310L;
            SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(id, phone);
            System.out.println(successKilled);
            System.out.println(successKilled.getSeckill().getName());
        } catch (Exception e) {
            return;
        }
    }
}