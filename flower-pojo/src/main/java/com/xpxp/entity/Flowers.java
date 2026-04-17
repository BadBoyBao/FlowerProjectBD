package com.xpxp.entity;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Flowers implements Serializable {
	@Schema(description = "鲜花ID", required = false)
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
	@Schema(description = "状态: 0-下架 1-上架", required = false)
	private Integer status;
	@Schema(description = "创建时间", required = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDateTime createdAt;
	@Schema(description = "更新时间", required = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDateTime updatedAt;
}