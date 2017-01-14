package org.seckill.service;

import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExcution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;

import java.util.List;

/**
 * Description:业务接口‘站在使用者’角度设计接口
 *  三个方面：方法定义粒度，参数，返回类型（return 类型/异常）
 *
 * @author xinchen (xinchenmelody@gmail.com)
 * @date 2017/1/14 13:46.
 * @see 2017/1/14 13:46 Created
 ****************************************/

public interface SeckillService {
    /**
     * 查询所有描述记录
     * @return
     */
    List<Seckill> getSeckillList();

    /**
     * 查询单个描述接口
     * @param seckillId
     * @return
     */
    Seckill getById(long seckillId);

    /**
     * 秒杀开启时数据秒杀接口地址，否则输出系统时间和秒杀时间
     * @param seckillId
     */
    Exposer exportSeckillUrl(long seckillId);

    /**
     * 执行秒杀操作
     * @param seckillId
     * @param userPhone
     * @param md5
     */
    SeckillExcution excuteSeckill(long seckillId, long userPhone, String md5)
            throws SeckillException,RepeatKillException,SeckillCloseException;
}
