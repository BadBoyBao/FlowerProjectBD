package com.xpxp.DTO;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file CategoryQueryDTO
 * @author thexpxp233
 * @date 2025/11/22
 * My name is lixiaopei
 **/

import com.xpxp.Common.PageQueryParm;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.io.Serializable;

@Data
public class CategoryQueryDTO extends PageQueryParm implements Serializable {

	@Schema(description = "分类ID")
	private Integer categoryId;

	@Schema(description = "分类名称")
	private String categoryName;

	@Schema(description = "店铺ID")
	private Integer shopId;

}