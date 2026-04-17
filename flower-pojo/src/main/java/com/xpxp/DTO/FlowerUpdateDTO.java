package com.xpxp.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.io.Serializable;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file FlowerUpdateDTO
 * @author thexpxp233
 * @date 2025/11/12
 * My name is lixiaopei
 **/
@Data
public class FlowerUpdateDTO implements Serializable {
    @Schema(description = "鲜花ID")
    private Integer flowerId;

    @Schema(description = "分类ID")
    private Long categoryId;

    @Schema(description = "鲜花名称")
    private String flowerName;

    @Schema(description = "商品描述")
    private String description;

    @Schema(description = "标签(逗号分隔)")
    private String tags;

    @Schema(description = "价格")
    private Long price;
    @Schema(description = "主图", required = true)
    private String mainImage;

    @Schema(description = "花期")
    private String season;

    @Schema(description = "花语")
    private String meaning;

    @Schema(description = "养护提示")
    private String careTips;

    @Schema(description = "状态: 0-下架 1-上架")
    private Long status;
}