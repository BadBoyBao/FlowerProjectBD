package com.xpxp.VO;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file OwnerVO
 * @author thexpxp233
 * @date 2025/12/22
 * My name is lixiaopei
 **/

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class OwnerVO implements Serializable {
	private Long userId;
	private String username;
	private String nickname;
	private String phone;
	private String image;
	private Date createdAt;
	private Integer isShopOwner;
}