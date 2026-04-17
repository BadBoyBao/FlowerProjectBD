package com.xpxp.DTO;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file AddressUpdateDTO
 * @author thexpxp233
 * @date 2025/12/9
 * My name is lixiaopei
 **/

import lombok.Data;
import java.io.Serializable;

@Data
public class AddressUpdateDTO implements Serializable {
	private Integer addressId;
	private String receiverName;
	private String receiverPhone;
	private String detailAddress;
	private Integer isDefault;
}