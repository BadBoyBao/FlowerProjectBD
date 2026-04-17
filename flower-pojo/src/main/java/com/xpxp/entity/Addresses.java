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
public class Addresses implements Serializable {
	@Schema(description = "地址ID")
	private Integer addressId;
	@Schema(description = "用户ID")
	private Integer userId;
	@Schema(description = "收货人姓名")
	private String receiverName;
	@Schema(description = "收货人电话")
	private String receiverPhone;
	@Schema(description = "详细地址")
	private String detailAddress;
	@Schema(description = "是否默认: 0-否 1-是")
	private Integer isDefault;
	@Schema(description = "创建时间")
	private Date createdAt;
	@Schema(description = "更新时间")
	private Date updatedAt;
}