package com.xpxp.VO;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file ShopVO
 * @author thexpxp233
 * @date 2025/12/25
 * My name is lixiaopei
 **/

import lombok.Data;
import java.io.Serializable;

@Data
public class ShopVO implements Serializable {
	private Integer shopId;
	private String shopName;
	private String shopDescription;
	private String shopLogo;
	private String shopBanner;

}