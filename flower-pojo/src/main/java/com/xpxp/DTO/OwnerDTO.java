package com.xpxp.DTO;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file OwnerDTO
 * @author thexpxp233
 * @date 2025/12/22
 * My name is lixiaopei
 **/

import lombok.Data;
import java.io.Serializable;

@Data
public class OwnerDTO implements Serializable {
	private String username;
	private String password;
	private String phone;
	private String nickname;
	private Integer gender;
	private String image;
}