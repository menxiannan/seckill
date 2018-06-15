package org.seckill.dao.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dao.SeckillDao;
import org.seckill.entity.RedisTestEntity;
import org.seckill.entity.Seckill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author MXN
 * @create 2018-05-24 15:00
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class RedisDaoTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private long id = 1004;

    @Autowired
    private RedisDao redisDao;

    @Autowired
    private SeckillDao seckillDao;



    @Test
    public void testSeckill() {
        //get and put

        Seckill seckill = redisDao.getSeckill(id);
        if (seckill == null) {
            seckill = seckillDao.queryById(id);
            if (seckill != null) {
                String result = redisDao.putSeckill(seckill);
                logger.info("result={}", result);
                seckill = redisDao.getSeckill(seckill.getSeckillId());
                logger.info("seckill={}", seckill);
            }
        }
    }



    @Test
    public void testPut() {
        RedisTestEntity entity = new RedisTestEntity(3000, "mxn");
        String put = redisDao.put(entity);
        System.out.println(put);

    }
}