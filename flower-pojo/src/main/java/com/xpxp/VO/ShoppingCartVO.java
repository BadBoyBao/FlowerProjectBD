package com.xpxp.VO;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file ShoppingCartVO
 * @author thexpxp233
 * @date 2025/12/5
 * My name is lixiaopei
 **/

import lombok.Data;
import java.io.Serializable;

@Data
public class ShoppingCartVO implements Serializable {
	private Integer cartItemId;
	private Integer flowerId;
	private String flowerName;
	private String mainImage;
	private Double price;
	private String meaning;
	private String tags;
	private Integer quantity;
	private Integer selected;
	private Integer shopId;
	private String shopName;
	private Integer status;
}