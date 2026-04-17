package com.xpxp.exception;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file DataIntegrityViolationException
 * @author thexpxp233
 * @date 2025/11/28
 * My name is lixiaopei
 **/

import java.sql.SQLException;

public class DataIntegrityViolationException extends SQLException {
    public DataIntegrityViolationException(String message) {
        super(message);
    }
}