package com.xpxp.VO;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file FlowerRecommendVO
 * @author thexpxp233
 * @date 2025/11/22
 * My name is lixiaopei
 **/

import lombok.Data;
import java.io.Serializable;

@Data
public class FlowerRecommendVO implements Serializable {

	private Integer flowerId;
	private String flowerName;
	private String image;
	private double price;
	private Integer soldQuantity;
	private Integer shopId;
}