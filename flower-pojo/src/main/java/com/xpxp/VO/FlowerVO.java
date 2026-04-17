package com.xpxp.VO;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file FlowerVO
 * @author thexpxp233
 * @date 2025/12/26
 * My name is lixiaopei
 **/

import lombok.Data;
import java.io.Serializable;

@Data
public class FlowerVO implements Serializable {
	private Integer shopId;
	private Integer flowerId;
	private String flowerName;
	private Double price;
	private String mainImage;
	private Integer stock;
	private Integer sold;
	private Integer status;
}