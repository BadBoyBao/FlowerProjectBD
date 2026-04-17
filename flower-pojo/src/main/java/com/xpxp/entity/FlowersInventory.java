package com.xpxp.entity;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * 鲜花库存实体类
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlowersInventory implements Serializable {
	@Schema(description = "库存ID")
	private Integer inventoryId;

	@Schema(description = "鲜花ID")
	private Integer flowerId;

	@Schema(description = "库存数量")
	private Integer stockQuantity;

	@Schema(description = "已售数量")
	private Integer soldQuantity;

	@Schema(description = "安全库存")
	private Integer safetyStock;

	@Schema(description = "店铺ID")
	private Integer shopId;

	@Schema(description = "创建时间")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;

	@Schema(description = "更新时间")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
}