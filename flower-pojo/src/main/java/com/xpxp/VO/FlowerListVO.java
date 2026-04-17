package com.xpxp.VO;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file FlowerListVO
 * @author thexpxp233
 * @date 2025/12/28
 * My name is lixiaopei
 **/

import lombok.Data;
import java.io.Serializable;

@Data
public class FlowerListVO implements Serializable {
	private Integer flowerId;
	private String flowerName;
	private String mainImage;
	private double price;
	private String tags;
	private String meaning;
	private String season;
	private String categoryName;
	private Integer shopId;
	private String shopName;
	private Double rating;
	private Integer stockQuantity;
	private Integer soldQuantity;
	private String status;
	private String createAt;
	//收藏数
	private Integer collectCount;

}