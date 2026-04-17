package com.xpxp.DTO;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file FlowerQueryParmDTO
 * @author thexpxp233
 * @date 2025/11/17
 * My name is lixiaopei
 **/

import com.xpxp.Common.PageQueryParm;
import lombok.Data;
import java.io.Serializable;

/**
 * 鲜花分页查询参数
 */
@Data
public class FlowerQueryParmDTO extends PageQueryParm implements Serializable {
	//鲜花名称
	private String flowerName;

	private Integer shopId;

}