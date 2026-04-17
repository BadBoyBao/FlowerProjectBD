package com.xpxp.DTO;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file AddressAddDTO
 * @author thexpxp233
 * @date 2025/12/9
 * My name is lixiaopei
 **/

import lombok.Data;
import java.io.Serializable;

@Data
public class AddressAddDTO implements Serializable {
	private String name;
	private String phone;
	private String detail;
	private Integer isDefault;
}