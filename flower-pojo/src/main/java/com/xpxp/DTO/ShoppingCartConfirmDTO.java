package com.xpxp.DTO;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file ShoppingCartConfirmDTO
 * @author thexpxp233
 * @date 2025/12/9
 * My name is lixiaopei
 **/

import lombok.Data;
import java.io.Serializable;

@Data
public class ShoppingCartConfirmDTO implements Serializable {

	private Integer orderId;
	private Double totalAmount;
	private Double shippingFee;
	private Double finalAmount;
	private Integer paymentMethod;
	private String address;
	private String name;
	private String phone;
	private String remark;
}