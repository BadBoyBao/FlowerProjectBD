package com.xpxp.VO;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file ShopDetailVO
 * @author thexpxp233
 * @date 2025/12/26
 * My name is lixiaopei
 **/

import lombok.Data;
import java.io.Serializable;

@Data
public class ShopDetailVO implements Serializable {
	private String shopName;
	private String shopDescription;
	private String shopLogo;
	private String businessHours;
	private Double rating;
	private Integer totalSales;
	private Integer status;

}