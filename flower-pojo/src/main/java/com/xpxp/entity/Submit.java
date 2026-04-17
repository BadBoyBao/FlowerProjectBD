package com.xpxp.entity;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file Submit
 * @author thexpxp233
 * @date 2025/12/9
 * My name is lixiaopei
 **/

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Submit implements Serializable {
	private Integer flowerId;
	private Integer cartItemId;
	private String flowerName;
	private String flowerImage;
	private Double unitPrice;
	private Integer quantity;
	private Double subtotal;
	private Integer shopId;
}