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
public class ShoppingCart implements Serializable {
	@Schema(description = "购物车项ID")
	private Integer cartItemId;
	@Schema(description = "用户ID")
	private Long userId;
	@Schema(description = "鲜花ID")
	private Integer flowerId;
	@Schema(description = "数量")
	private Integer quantity;
	@Schema(description = "是否选中: 0-否 1-是")
	private Integer selected;
	@Schema(description = "加入时的价格")
	private Double addedPrice;
	@Schema(description = "创建时间")
	private Date createdAt;
	@Schema(description = "更新时间")
	private Date updatedAt;
	@Schema(description = "店铺ID")
	private Integer shopId;
	@Schema(description = "店铺名称")
	private String shopName;
}