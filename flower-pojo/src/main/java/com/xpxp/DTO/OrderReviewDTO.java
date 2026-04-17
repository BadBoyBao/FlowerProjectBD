package com.xpxp.DTO;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file OrderReviewDTO
 * @author thexpxp233
 * @date 2025/12/29
 * My name is lixiaopei
 **/

import lombok.Data;
import java.io.Serializable;

@Data
public class OrderReviewDTO implements Serializable {
	private Integer orderId;
	private Integer flowerId;
	private Integer rating;
	private String content;
}