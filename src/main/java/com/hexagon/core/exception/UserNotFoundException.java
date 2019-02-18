package com.hexagon.core.exception;

/**
 * @author Eason
 * @createTime 2019-02-18 下午 10:19
 * @description
 */
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String msg) {
        super(msg);
    }

    public UserNotFoundException(Throwable cause) {
        super(cause);
    }

    public UserNotFoundException(String msg, Throwable cause){
        super(msg, cause);
    }
}
