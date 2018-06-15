package org.seckill.exception;

/**
 * 秒杀相关业务异常
 * @author MXN
 * @create 2018-05-18 13:04
 */

public class SeckillException extends RuntimeException{

    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
