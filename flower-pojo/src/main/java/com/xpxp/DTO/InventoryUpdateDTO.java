package com.xpxp.DTO;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file InventoryUpdateDTO
 * @author thexpxp233
 * @date 2025/12/29
 * My name is lixiaopei
 **/

import lombok.Data;
import java.io.Serializable;

@Data
public class InventoryUpdateDTO implements Serializable {
	private Integer flowerId;
	private Integer shopId;
	private Integer stockQuantity;
	private Integer safetyStock;
}