package org.seckill.dao.cache;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import org.seckill.entity.RedisTestEntity;
import org.seckill.entity.Seckill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author MXN
 * @create 2018年5月24日14:35:27
 */
public class RedisDao {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private JedisPool jedisPool;

    public RedisDao(String ip, int port) {
        jedisPool = new JedisPool(ip, port);

    }

    private RuntimeSchema<Seckill> schema = RuntimeSchema.createFrom(Seckill.class);


    private RuntimeSchema<RedisTestEntity> schemaRedis = RuntimeSchema.createFrom(RedisTestEntity.class);

    /**
     * 测试方法，不关于seckill
     * @param redisTestEntity
     * @return
     */
    public String put(RedisTestEntity redisTestEntity) {
        try {
            Jedis jedis = jedisPool.getResource();
            try {
                String key = "redisTestEntity:" + redisTestEntity.getId();
                byte[] bytes = ProtostuffIOUtil.toByteArray(redisTestEntity, schemaRedis, LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
                //超时缓存
                int timeout = 60 * 60;
                String reslut = jedis.setex(key.getBytes(), timeout, bytes);
                return reslut;
            } finally {
                jedis.close();
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }


    public Seckill getSeckill(long seckillId) {
        //redis操作逻辑
        try {
            //拿到连接池
            Jedis jedis = jedisPool.getResource();
            try {
                String key = "seckill:" + seckillId;
                //并没有实现内部序列化操作
                //get->byte[] -> 反序列 -> Object(Seckill)
                //采用自定义序列化
                //protostuff：pojo
                byte[] bytes = jedis.get(key.getBytes());
                //缓存获取到
                if (bytes != null) {
                    /**
                     * 优点：速度快，压缩率高，节省cpu
                     */
                    //空对象
                    Seckill seckill = schema.newMessage();
                    ProtostuffIOUtil.mergeFrom(bytes, seckill, schema);
                    //seckill 被反序列化
                    return seckill;
                }
            } finally {
                //关闭连接池
                jedis.close();
            }
        } catch (Exception e) {
            logger.error("RedisDao.getSeckill error：", e);
            logger.error("RedisDao.getSeckill error：redis可能没有开启！！！");
        }
        return null;
    }

    public String putSeckill(Seckill seckill) {
        //set Object(seckill) -> 序列化 -> byte[]
        try {
            Jedis jedis = jedisPool.getResource();
            try {
                String key = "seckill:" + seckill.getSeckillId();
                byte[] bytes = ProtostuffIOUtil.toByteArray(seckill, schema, LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
                //超时缓存
                int timeout = 60 * 60;
                String reslut = jedis.setex(key.getBytes(), timeout, bytes);
                return reslut;
            } finally {
                jedis.close();
            }
        } catch (Exception e) {
            logger.error("RedisDao.getSeckill error：", e);
            logger.error("RedisDao.getSeckill error：redis可能没有开启！！！");
        }
        return null;
    }
}
