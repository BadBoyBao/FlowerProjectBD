package com.xpxp.VO;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file ReviewListVO
 * @author thexpxp233
 * @date 2025/12/29
 * My name is lixiaopei
 **/

import lombok.Data;
import java.io.Serializable;

@Data
public class ReviewListVO implements Serializable {
	private String nickName;
	private String avatar;
	private String reviewTime;
	private String content;
	private String rating;
	
}