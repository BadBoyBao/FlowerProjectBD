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
public class OrderItems implements Serializable {
	@Schema(description = "订单项ID")
	private Integer orderItemId;
	@Schema(description = "订单ID")
	private Integer orderId;
	@Schema(description = "鲜花ID")
	private Integer flowerId;
	@Schema(description = "鲜花名称(下单时)")
	private String flowerName;
	@Schema(description = "鲜花图片(下单时)")
	private String flowerImage;
	@Schema(description = "单价(下单时)")
	private BigDecimal unitPrice;
	@Schema(description = "数量")
	private Integer quantity;
	@Schema(description = "小计金额")
	private BigDecimal subtotal;
	@Schema(description = "创建时间")
	private Date createdAt;
	@Schema(description = "店铺ID")
	private Integer shopId;
	@Schema(description = "店铺订单状态: 0-待确认 1-待支付 2-待接单 3-待发货 4-已发货 5-已完成 6-已取消")
	private Integer shopStatus;
	@Schema(description = "店铺状态更新时间")
	private Date shopUpdatedAt;
}