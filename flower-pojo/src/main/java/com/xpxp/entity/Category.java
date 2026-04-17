package com.xpxp.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category implements Serializable {
	@Schema(description = "分类ID")
	private Integer categoryId;
	@Schema(description = "分类名称")
	private String categoryName;
	@Schema(description = "分类描述")
	private String categoryDescription;

	@Schema(description = "分类图片")
	private String image;

	@Schema(description = "状态: 0-禁用 1-启用")
	private Integer status;
	@Schema(description = "创建时间")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@Schema(description = "更新时间")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

	@Schema(description = "店铺ID")
	private Integer shopId;


}