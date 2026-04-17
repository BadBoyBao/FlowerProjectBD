package com.xpxp.DTO;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file RegisterDTO
 * @author thexpxp233
 * @date 2025/12/20
 * My name is lixiaopei
 **/

import lombok.Data;
import java.io.Serializable;

@Data
public class RegisterDTO implements Serializable {

	private String username;

	private String nickname;

	private String phone;

	private String password;

	private String confirmPassword;
}