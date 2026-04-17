package com.xpxp.entity;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Users implements Serializable {
	@Schema(description = "用户ID")
	private Integer userId;
	@Schema(description = "用户名")
	private String username;
	@Schema(description = "密码")
	private String password;
	@Schema(description = "手机号")
	private String phone;
	@Schema(description = "昵称")
	private String nickname;
	@Schema(description = "性别: 0-未知 1-男 2-女")
	private Integer gender;
	@Schema(description = "状态: 0-禁用 1-正常")
	private Integer status;
	@Schema(description = "最后登录时间")
	private Date lastLoginTime;
	@Schema(description = "创建时间")
	private Date createdAt;
	@Schema(description = "更新时间")
	private Date updatedAt;
	@Schema(description = "用户角色: SUPER_ADMIN-超级管理员, SHOP_ADMIN-店铺管理员, CUSTOMER-普通用户")
	private String role;
	@Schema(description = "关联的店铺ID（如果是店铺管理员）")
	private Integer shopId;
	@Schema(description = "是否是店主: 0-否 1-是")
	private Integer isShopOwner;
	@Schema(description = "用户头像URL")
	private String image;
}