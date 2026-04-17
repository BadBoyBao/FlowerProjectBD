package com.xpxp.VO;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file OrderItemVO
 * @author thexpxp233
 * @date 2025/12/28
 * My name is lixiaopei
 **/

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class OrderItemVO implements Serializable {
	private Integer orderItemId;
	private Integer orderId;
	private Integer flowerId;
	private String flowerName;
	private String flowerImage;
	private Double unitPrice;
	private Integer quantity;
	private Double subtotal;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createdAt;
	private Integer shopId;
	private Integer shopStatus;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date shopUpdatedAt;
	private String shopName;
}