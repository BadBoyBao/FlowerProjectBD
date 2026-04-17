package com.xpxp.VO;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file UserInfoVO
 * @author thexpxp233
 * @date 2025/12/19
 * My name is lixiaopei
 **/

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.io.Serializable;

@Data
public class UserInfoVO implements Serializable {
	@Schema(description = "用户名")
	private String username;
	@Schema(description = "手机号")
	private String phone;
	@Schema(description = "昵称")
	private String nickname;
	@Schema(description = "性别: 0-未知 1-男 2-女")
	private Integer gender;
	@Schema(description = "头像")
	private String image;
}