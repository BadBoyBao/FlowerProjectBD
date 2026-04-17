package com.xpxp.VO;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file OrderStatusCountVO
 * @author thexpxp233
 * @date 2025/12/13
 * My name is lixiaopei
 **/

import lombok.Data;
import java.io.Serializable;

@Data
public class OrderStatusCountVO implements Serializable {
	private Integer orderStatus;
	private Integer count;
}