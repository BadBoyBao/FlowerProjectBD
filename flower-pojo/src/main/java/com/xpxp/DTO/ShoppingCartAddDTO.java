package com.xpxp.DTO;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file ShoppingCartAddDTO
 * @author thexpxp233
 * @date 2025/12/5
 * My name is lixiaopei
 **/

import lombok.Data;
import java.io.Serializable;

@Data
public class ShoppingCartAddDTO implements Serializable {
	private Integer shopId;
	private String shopName;
	private Integer flowerId;
	private Integer quantity;
	private Double price;
}