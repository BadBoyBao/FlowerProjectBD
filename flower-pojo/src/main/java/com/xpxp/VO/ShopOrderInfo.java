package com.xpxp.VO;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file ShopOrderInfo
 * @author thexpxp233
 * @date 2025/12/28
 * My name is lixiaopei
 **/

import lombok.Data;
import java.io.Serializable;

@Data
public class ShopOrderInfo implements Serializable {
	private Integer shopId;
	private String shopName;
	private Integer shopStatus;
	private Integer itemCount;
}