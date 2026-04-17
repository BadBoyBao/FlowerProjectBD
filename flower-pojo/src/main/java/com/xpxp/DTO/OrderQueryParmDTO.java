package com.xpxp.DTO;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file OrderQueryParmDTO
 * @author thexpxp233
 * @date 2025/12/11
 * My name is lixiaopei
 **/

import com.xpxp.Common.PageQueryParm;
import lombok.Data;
import java.io.Serializable;

@Data
public class OrderQueryParmDTO extends PageQueryParm implements Serializable {
	private Integer orderStatus;
	private Integer shopId;
}