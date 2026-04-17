package com.xpxp.Utils;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file OrderNoUtils
 * @author thexpxp233
 * @date 2025/12/9
 * My name is lixiaopei
 **/


import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 订单号生成工具类
 */
@Slf4j
public class OrderNoUtils {
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
	private static final AtomicLong SEQUENCE = new AtomicLong(0);
	private static final int MAX_SEQUENCE = 9999; // 4位序列号

	/**
	 * 生成唯一订单号
	 * 格式: yyyyMMddHHmmss + 4位序列号
	 * 示例: 2025120915570001
	 */
	public static String generateOrderNo() {
		String timestamp = LocalDateTime.now()
		                                .format(FORMATTER);
		long sequence = SEQUENCE.incrementAndGet() % MAX_SEQUENCE;
		return timestamp + String.format("%04d", sequence);
	}
}