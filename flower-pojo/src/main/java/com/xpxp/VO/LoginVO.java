package com.xpxp.VO;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file LoginVO
 * @author thexpxp233
 * @date 2025/11/20
 * My name is lixiaopei
 **/

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginVO implements Serializable {

	@Schema(description = "用户ID")
	private Integer userId;
	@Schema(description = "用户名")
	private String username;
	@Schema(description = "昵称")
	private String nickname;
	@Schema(description = "角色")
	private String role;
	@Schema(description = "店铺ID")
	private Integer shopId;
	@Schema(description = "头像")
	private String image;
	@Schema(description = "token令牌")
	private String token;
}