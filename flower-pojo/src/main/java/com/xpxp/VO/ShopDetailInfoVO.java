package com.xpxp.VO;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file ShopDetailInfoVO
 * @author thexpxp233
 * @date 2025/12/28
 * My name is lixiaopei
 **/

import lombok.Data;
import java.io.Serializable;

@Data
public class ShopDetailInfoVO implements Serializable {
	//	店主名，店主手机号，店铺名，店铺描述，店铺logo，营业时间，店铺状态，店铺电话，店铺地址
	private String ownerName;
	private String ownerPhone;
	private Integer shopId;
	private String shopName;
	private String shopDescription;
	private String shopLogo;
	private String businessHours;
	private Integer status;
	private String shopPhone;
	private String shopAddress;
}