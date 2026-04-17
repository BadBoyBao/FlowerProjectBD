package com.xpxp.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
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
public class Orders implements Serializable {
	@Schema(description = "订单ID")
	private Integer orderId;
	@Schema(description = "订单编号")
	private String orderNo;
	@Schema(description = "用户ID")
	private Long userId;
	@Schema(description = "订单总金额")
	private double totalAmount;
	@Schema(description = "运费")
	private double shippingFee;
	@Schema(description = "实付金额")
	private double finalAmount;
	@Schema(description = "支付方式: 1-支付宝 2-微信 3-银行卡")
	private Integer paymentMethod;
	private Integer paymentStatus;
	private Integer orderStatus;
	@Schema(description = "收货地址")
	private String shippingAddress;
	@Schema(description = "收货人姓名")
	private String receiverName;
	@Schema(description = "收货人电话")
	private String receiverPhone;
	@Schema(description = "订单备注")
	private String orderNotes;
	@Schema(description = "支付时间")
	@JsonFormat(pattern = "yyyy-MM-dd-HH:mm")
	private Date paidTime;
	@Schema(description = "发货时间")
	@JsonFormat(pattern = "yyyy-MM-dd-HH:mm")
	private Date shippedTime;
	@Schema(description = "完成时间")
	@JsonFormat(pattern = "yyyy-MM-dd-HH:mm")
	private Date completedTime;
	@Schema(description = "取消时间")
	@JsonFormat(pattern = "yyyy-MM-dd-HH:mm")
	private Date cancelledTime;
	@Schema(description = "创建时间")
	@JsonFormat(pattern = "yyyy-MM-dd-HH:mm")
	private Date createdAt;
	@Schema(description = "更新时间")
	@JsonFormat(pattern = "yyyy-MM-dd-HH:mm")
	private Date updatedAt;
	//	rejection_reason    varchar(255)                             null comment '拒单原因',
//	cancellation_reason varchar(255)                             null comment '取消原因',
	@Schema(description = "拒单原因")
	private String rejectionReason;
	@Schema(description = "取消原因")
	private String cancellationReason;

}