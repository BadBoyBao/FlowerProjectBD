package com.xpxp.DTO;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file ShopUpdateDTO
 * @author thexpxp233
 * @date 2025/12/28
 * My name is lixiaopei
 **/

import lombok.Data;
import java.io.Serializable;

@Data
public class ShopUpdateDTO implements Serializable {
	private Integer shopId;
	private String shopName;
	private String shopDescription;
	private String shopLogo;
	private String businessHours;
	private String shopPhone;
	private String shopAddress;
}