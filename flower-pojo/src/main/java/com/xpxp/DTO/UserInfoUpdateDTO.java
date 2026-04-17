package com.xpxp.DTO;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file UserInfoUpdateDTO
 * @author thexpxp233
 * @date 2025/12/20
 * My name is lixiaopei
 **/

import lombok.Data;
import java.io.Serializable;

@Data
public class UserInfoUpdateDTO implements Serializable {
	private String image;
	private String nickname;
	private Integer gender;
	private String phone;
}