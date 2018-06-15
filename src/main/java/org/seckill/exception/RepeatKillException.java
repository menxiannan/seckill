package org.seckill.exception;

/**
 * 重复秒杀异常（运行期异常）
 * @author MXN
 * @create 2018-05-18 13:01
 */
public class RepeatKillException extends SeckillException{

    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
