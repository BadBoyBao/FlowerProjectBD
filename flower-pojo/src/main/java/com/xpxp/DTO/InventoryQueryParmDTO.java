package com.xpxp.DTO;

import com.xpxp.Common.PageQueryParm;
import lombok.Data;
import java.io.Serializable;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file InventoryQueryParmDTO
 * @author thexpxp233
 * @date 2025/12/24
 * My name is lixiaopei
 **/
@Data
public class InventoryQueryParmDTO extends PageQueryParm implements Serializable {
	private Integer shopId;
}