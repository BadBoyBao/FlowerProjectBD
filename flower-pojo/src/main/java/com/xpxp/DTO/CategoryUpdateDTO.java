package com.xpxp.DTO;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file CategoryUpdateDTO
 * @author thexpxp233
 * @date 2025/11/12
 * My name is lixiaopei
 **/

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.io.Serializable;

@Data
public class CategoryUpdateDTO implements Serializable {
    @Schema(description="分类ID")
    private Integer categoryId;
    @Schema(description="分类名称")
    private String categoryName;
    @Schema(description="分类描述")
    private String categoryDescription;
    @Schema(description="分类图片")
    private String image;

}