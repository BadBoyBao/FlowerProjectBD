package com.xpxp.VO;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file ShopViewVO
 * @author thexpxp233
 * @date 2025/12/26
 * My name is lixiaopei
 **/

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ShopViewVO implements Serializable {
	List<FlowerVO> flowerList;
	private Integer shopId;
	private String shopName;
	private String shopDescription;
	private String shopLogo;
	private Integer status;
	private String businessHours;
	private Double rating;
	private Integer totalSales;
	private String banReason;
}