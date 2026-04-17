package com.xpxp;

import org.dromara.x.file.storage.spring.EnableFileStorage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file FlowerApplication
 * @author thexpxp233
 * @date 2025/11/11
 * My name is lixiaopei
 **/
@SpringBootApplication
@EnableFileStorage
@EnableCaching
public class FlowerApplication {
	public static void main(String[] args) {
		SpringApplication.run(FlowerApplication.class, args);
	}
}