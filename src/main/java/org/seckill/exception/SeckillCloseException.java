package org.seckill.exception;

/**
 * 秒杀关闭异常
 * @author MXN
 * @create 2018-05-18 13:03
 */

public class SeckillCloseException extends SeckillException{

    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
