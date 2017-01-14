package org.seckill.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExcution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.List;

import static org.junit.Assert.*;

/**
 * Description:
 *
 * @author xinchen (xinchenmelody@gmail.com)
 * @date 2017/1/14 15:29.
 * @see 2017/1/14 15:29 Created
 ****************************************/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml",
                    "classpath:spring/spring-service.xml"})
public class SeckillServiceTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SeckillService seckillService;

    @Test
    public void getSeckillList() throws Exception {
        List<Seckill> list = seckillService.getSeckillList();
        logger.info("list={}", list);
    }

    @Test
    public void getById() throws Exception {
        long id = 1000L;
        Seckill seckill = seckillService.getById(id);
        logger.info("seckill={}", seckill);
    }

    /*
    * exposer=Exposer{
    * exposed=true,
    * md5='2acc4b7eb92bf8e9a022bcddfadf9dfc',
    * seckillId=1000,
    * now=0, start=0, end=0}
    * */
    @Test
    public void exportSeckillUrl() throws Exception {
        long id = 1000L;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        logger.info("exposer={}", exposer);
    }

    @Test
    public void excuteSeckill() throws Exception {
        long id = 1000L;
        long phone = 13322213442L;
//        String md5 = "md5='2acc4b7eb92bf8e9a022bcddfadf9dfc'";
        String md5 = "2acc4b7eb92bf8e9a022bcddfadf9dfc";

        //org.seckill.exception.SeckillException: seckill data rewrite
        try{
            SeckillExcution excution = seckillService.excuteSeckill(id, phone, md5);
            logger.info("result={}", excution);
        } catch (RepeatKillException e){
            logger.error(e.getMessage());
        }catch (SeckillCloseException e){
            logger.error(e.getMessage());
        }
    }
    //测试代码完整逻辑，注意可重复执行
//    @Test
//    public void  exportSeckillLogic() throws Exception{
//        long id =1000;
//        Exposer exposer = seckillService.exportSeckillUrl(id);
//        if (exposer.isExposed()){
//            logger.info("exposer={}", exposer);
//            long phone = 13322213442L;
//            String md5 = exposer.getMd5();
//            try{
//                SeckillExcution seckillExcution = seckillService.excuteSeckill(id, phone, md5);
//                logger.info("result={}", seckillExcution);
//            } catch (RepeatKillException e1){
//                logger.error(e1.getMessage());
//            }catch (SeckillCloseException e2){
//                logger.error(e2.getMessage());
//            }
//        }else {
//            //秒杀未开启
//            logger.warn("exposer={}",exposer);
//        }
//    }

}