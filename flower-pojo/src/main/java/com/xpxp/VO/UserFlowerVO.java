package com.xpxp.VO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file UserFlowerVO
 * @author thexpxp233
 * @date 2025/12/5
 * My name is lixiaopei
 **/
@Data
public class UserFlowerVO implements Serializable {
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
    @Schema(description = "库存数量", required = false)
    private Integer stockQuantity;
    @Schema(description = "已售数量", required = false)
    private Integer soldQuantity;
    @Schema(description = "安全库存", required = false)
    private Integer safetyStock;
}