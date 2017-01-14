package org.seckill.exception;

/**
 * Description:秒杀相关业务异常
 *
 * @author xinchen (xinchenmelody@gmail.com)
 * @date 2017/1/14 14:05.
 * @see 2017/1/14 14:05 Created
 ****************************************/

public class SeckillException extends RuntimeException{
    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
