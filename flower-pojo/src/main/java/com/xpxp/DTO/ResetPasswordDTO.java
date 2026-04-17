package com.xpxp.DTO;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file ResetPasswordDTO
 * @author thexpxp233
 * @date 2025/12/20
 * My name is lixiaopei
 **/

import lombok.Data;
import java.io.Serializable;

@Data
public class ResetPasswordDTO implements Serializable {
	private String username;
	private String oldPassword;
	private String newPassword;
	private String confirmPassword;
}