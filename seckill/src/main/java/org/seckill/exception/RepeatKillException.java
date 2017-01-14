package org.seckill.exception;

/**
 * Description:重复秒杀异常(运行期异常)
 *
 * @author xinchen (xinchenmelody@gmail.com)
 * @date 2017/1/14 14:01.
 * @see 2017/1/14 14:01 Created
 ****************************************/

public class RepeatKillException extends SeckillException {
    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
