package com.xpxp.VO;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file FlowerDetailVO
 * @author thexpxp233
 * @date 2025/12/18
 * My name is lixiaopei
 **/

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class FlowerDetailVO implements Serializable {
	@Schema(description = "鲜花ID", required = true)
	private Integer flowerId;
	@Schema(description = "鲜花名称", required = true)
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
	@Schema(description = "库存数量", required = false)
	private Integer stockQuantity;
	@Schema(description = "已售数量", required = false)
	private Integer soldQuantity;
	//店铺ID
	@Schema(description = "店铺ID", required = true)
	private Integer shopId;
	//店铺名称
	@Schema(description = "店铺名称", required = true)
	private String shopName;
	//收藏数量
	@Schema(description = "收藏数量", required = true)
	private Integer favoriteCount;
}