package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author MXN
 * @create 2018-05-18 9:57
 */

/**
 * 配置spring和junit整合，使junit启动加载springIOC容器
 * spring-test,junit 依赖
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //注入Dao实现类依赖
    @Resource
    private SeckillDao seckillDao;

    @Test
    public void saveSeckill() {
        try {
            //获得2010年9月13日22点36分01秒 的Date对象
            DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date startTime = dateFormat2.parse("2018-05-26 14:00:01");
            Date endTime = dateFormat2.parse("2018-05-27 14:00:01");

            Seckill seckill = new Seckill();
            seckill.setName("999秒杀宝马760");
            seckill.setNumber(999);
            seckill.setStartTime(startTime);
            seckill.setEndTime(endTime);
            int saveCount = seckillDao.saveSeckill(seckill);
            logger.info("saveCount={}", saveCount);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    @Test
    public void deleteSeckillById() {
        try {
            Long seckillId = 1015L;
            int deleteCount = seckillDao.deleteSeckillById(seckillId);
            logger.info("deleteCount={}", deleteCount);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Test
    public void queryById() {
        try {
            long id = 1015L;
            Seckill seckill = seckillDao.queryById(id);
            if (seckill != null) {
                logger.info(seckill.getName());
                logger.info(seckill.toString());
            } else {
                logger.warn("没有此秒杀单");
            }
        } catch (Exception e) {

            logger.error(e.getMessage(), e);
        }
    }

    @Test
    public void queryAll() {
        /**
         * Caused by: org.apache.ibatis.binding.BindingException:
         * Parameter 'offset' not found. Available parameters are [0, 1, param1, param2]
         * 参数绑定错误
         *  queryAll(int offset,int limit);
         *  参数为形参 java没有保存形式参数 queryAll(arg0,arg1); 对应的sql语句在提取参数 #{offset} 会找不到对应的只管
         *
         */
        List<Seckill> seckills = seckillDao.queryAll(0, 1000);
        for (Seckill seckill : seckills) {
            logger.info("seckill={}", seckill.toString());
        }
    }

    @Test
    public void reduceNumber() {
        Date killTime = new Date();
        int updateCount = seckillDao.reduceNumber(1005L, killTime);
        System.out.println(updateCount);
    }


}