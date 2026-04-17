package com.xpxp.entity;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Shops implements Serializable {
	@Schema(description = "店铺ID")
	private Integer shopId;
	@Schema(description = "店铺名称")
	private String shopName;
	@Schema(description = "店铺描述")
	private String shopDescription;
	@Schema(description = "店主ID（关联用户表）")
	private Integer ownerId;
	@Schema(description = "联系电话")
	private String contactPhone;
	@Schema(description = "联系地址")
	private String contactAddress;
	@Schema(description = "店铺Logo")
	private String shopLogo;
	@Schema(description = "店铺横幅")
	private String shopBanner;
	@Schema(description = "状态: 0-禁用 1-正常 2-封禁")
	private Integer status;
	@Schema(description = "营业时间")
	private String businessHours;
	@Schema(description = "店铺评分")
	private BigDecimal rating;
	@Schema(description = "总销量")
	private Integer totalSales;
	@Schema(description = "创建时间")
	private Date createdAt;
	@Schema(description = "更新时间")
	private Date updatedAt;
	@Schema(description = "封禁原因")
	private String banReason;
}