package com.xpxp.DTO;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file ReviewsQueryParm
 * @author thexpxp233
 * @date 2025/12/29
 * My name is lixiaopei
 **/

import com.xpxp.Common.PageQueryParm;
import lombok.Data;
import java.io.Serializable;

@Data
public class ReviewsQueryParm extends PageQueryParm implements Serializable {
	private Integer flowerId;
}