package com.xpxp.exception;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file TokenExpiredException
 * @author thexpxp233
 * @date 2025/11/27
 * My name is lixiaopei
 **/
// Token 过期异常
public class TokenExpiredException extends AuthenticationException {
    public TokenExpiredException(String message) {
        super(message);
    }
}