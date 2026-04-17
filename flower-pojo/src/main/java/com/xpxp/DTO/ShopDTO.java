package com.xpxp.DTO;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file ShopDTO
 * @author thexpxp233
 * @date 2025/12/22
 * My name is lixiaopei
 **/

import lombok.Data;
import java.io.Serializable;

@Data
public class ShopDTO implements Serializable {
	
	private String shopName;
	private String shopDescription;
	private Integer ownerId;
	private String contactPhone;
	private String contactAddress;
	private String shopLogo;
	private String shopBanner;
	private String businessHours;

}