package com.xpxp.VO;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file FavoritesVO
 * @author thexpxp233
 * @date 2025/12/29
 * My name is lixiaopei
 **/

import lombok.Data;
import java.io.Serializable;

@Data
public class FavoritesVO implements Serializable {
	private Integer favoriteId;
	private String collectTime;
	private Integer flowerId;
	private String flowerName;
	private String mainImage;
	private Double price;
	private String tags;
	private String meaning;
	private String season;
	private String flowerStatus;
	private String categoryName;
	private Integer shopId;
	private String shopName;
	private String shopLogo;
	private Double shopRating;
	private Integer stockQuantity;
	private Integer soldQuantity;
	private String purchaseStatus;
	private String formattedCollectTime;
	private Integer daysSinceCollect;
}