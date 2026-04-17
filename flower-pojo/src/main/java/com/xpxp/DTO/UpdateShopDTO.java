package com.xpxp.DTO;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file UpdateShopDTO
 * @author thexpxp233
 * @date 2025/12/29
 * My name is lixiaopei
 **/

import lombok.Data;
import java.io.Serializable;

@Data
public class UpdateShopDTO implements Serializable {
	private Integer shopId;
	private String shopName;
	private String shopLogo;
	private String businessHours;
	private String contactPhone;
	private String contactAddress;
	private Double rating;

}