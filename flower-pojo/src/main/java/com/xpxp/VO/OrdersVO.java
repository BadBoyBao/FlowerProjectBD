package com.xpxp.VO;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file OrdersVO
 * @author thexpxp233
 * @date 2025/12/11
 * My name is lixiaopei
 **/

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class OrdersVO implements Serializable {
	@Schema(description = "订单ID")
	private Integer orderId;
	@Schema(description = "用户ID")
	private Integer userId;
	@Schema(description = "订单编号")
	private String orderNo;
	@Schema(description = "支付状态")
	private Integer paymentStatus;
	@Schema(description = "订单状态")
	private Integer orderStatus;
	@Schema(description = "订单备注")
	private String orderNotes;
	@Schema(description = "创建时间")
	@JsonFormat(pattern = "yyyy-MM-dd-HH:mm")
	private Date createdAt;
	//收货人
	@Schema(description = "收货人")
	private String receiverName;
	//收货地址
	@Schema(description = "收货地址")
	private String shippingAddress;
	//收货电话
	@Schema(description = "收货电话")
	private String receiverPhone;
	//运费
	@Schema(description = "运费")
	private Double shippingFee;
	//订单总额
	@Schema(description = "订单总额")
	private Double totalAmount;
	//实付总额
	@Schema(description = "实付总额")
	private Double finalAmount;
	//订单项状态
	@Schema(description = "订单项状态")
	private Integer shopStatus;
}