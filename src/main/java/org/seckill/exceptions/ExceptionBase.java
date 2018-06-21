package org.seckill.exceptions;

/**
 * @author 12084
 * @create 2018-06-21 9:23
 */

public class ExceptionBase extends RuntimeException {

    public ExceptionBase(String message) {
        super(message);
    }

    public ExceptionBase(String message, Throwable throwable) {
        super(message, throwable);
    }
}
