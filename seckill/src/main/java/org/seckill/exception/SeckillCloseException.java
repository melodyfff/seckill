package org.seckill.exception;

/**
 * Description:秒杀关闭异常
 *
 * @author xinchen (xinchenmelody@gmail.com)
 * @date 2017/1/14 14:04.
 * @see 2017/1/14 14:04 Created
 ****************************************/

public class SeckillCloseException extends SeckillException{
    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
