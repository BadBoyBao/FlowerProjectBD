package com.xpxp.DTO;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file FlowerAddDTO
 * @author thexpxp233
 * @date 2025/11/12
 * My name is lixiaopei
 **/
@Data
@Builder
public class FlowerAddDTO implements Serializable {
	@Schema(description = "店铺ID", required = true)
	private Integer shopId;

	@Schema(description = "鲜花ID", required = false)
	private Integer flowerId;

	@Schema(description = "鲜花名称", required = true, example = "")
	private String flowerName;

	@Schema(description = "分类ID", required = true)

	private Integer categoryId;

	@Schema(description = "价格", required = true)

	private BigDecimal price;

	@Schema(description = "主图", required = true)
	private String mainImage;

	@Schema(description = "商品描述", required = true)
	private String description;

	@Schema(description = "标签(逗号分隔)", required = true)
	private String tags;

	@Schema(description = "花期", required = true)
	private String season;

	@Schema(description = "花语", required = true)
	private String meaning;

	@Schema(description = "养护提示", required = true)
	private String careTips;


}