package com.xpxp.VO;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file HomeReviewVO
 * @author thexpxp233
 * @date 2025/12/30
 * My name is lixiaopei
 **/

import lombok.Data;
import java.io.Serializable;

@Data
public class HomeReviewVO implements Serializable {
	private Integer reviewId;
	private String nickName;
	private String avatar;
	private String createdAt;
	private Integer flowerId;
	private String flowerName;
	private String rating;
}