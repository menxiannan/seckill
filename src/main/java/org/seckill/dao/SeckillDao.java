package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Seckill;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author MXN
 * @create 2018-05-17 15:50
 */

public interface SeckillDao {

    /**
     * 减库存
     * @param seckillId
     * @param killTime
     * @return 如果影响行数>1  ，表示更新记录行数
     */
    int reduceNumber(@Param("seckillId") long seckillId,@Param("killTime") Date killTime);

    /**
     *
     * 根据seckillId 查询秒杀对象
     * @param seckillId
     * @return
     */
    Seckill queryById(long seckillId);

    /**
     * 根据偏移量查询秒杀商品列表
     * @param offset 偏移量
     * @param limit 在偏移量之后查多少条
     * @return
     */
    List<Seckill> queryAll(@Param("offset") int offset,@Param("limit") int limit);


    /**
     * 添加
     * @param seckill
     * @return
     *
     */
    int saveSeckill(Seckill seckill);


    int deleteSeckillById(Long seckillId);

    /**
     * 使用存储过程执行秒杀
     * @param map
     */
    void killByProcedure(Map<String,Object> map);
}
