package com.xpxp.context;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file BaseContext
 * @author thexpxp233
 * @date 2025/11/20
 * My name is lixiaopei
 **/

public class BaseContext {
    public static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    public static void setCurrentId(Long id) {
        threadLocal.set(id);
    }

    public static Long getCurrentId() {
        return threadLocal.get();
    }

    public static void removeCurrentId() {
        threadLocal.remove();
    }
}