package com.xpxp.exception;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file BusinessException
 * @author thexpxp233
 * @date 2025/11/27
 * My name is lixiaopei
 **/

// 业务异常
public class BusinessException extends RuntimeException {
    private final Integer code;

    public BusinessException(String message) {
        super(message);
        this.code = 0;
    }

    public BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}