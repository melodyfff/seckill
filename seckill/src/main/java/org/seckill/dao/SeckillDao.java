package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Seckill;

import java.util.Date;
import java.util.List;

/**
 * Description:
 *
 * @author xinchen (xinchenmelody@gmail.com)
 * @date 2017/1/13 23:22.
 * @see 2017/1/13 23:22 Created
 ****************************************/

public interface SeckillDao {
    /**
     * 减库存，
     * @param seckillId
     * @param killTime
     * @return 如果影响行数>1，表示更新记录行数
     */
    int reduceNumber(@Param("seckillId")long seckillId,@Param("killTime")Date killTime);

    /**
     * 根据ID查询秒杀对象
     * @param seckillId
     * @return
     */
    Seckill queryById(long seckillId);

    /**
     * 根据偏移量查询秒杀商品列表
     * @param offet
     * @param limit
     * @return
     */

    List<Seckill> queryAll(@Param("offset") int offet, @Param("limit") int limit);
}
