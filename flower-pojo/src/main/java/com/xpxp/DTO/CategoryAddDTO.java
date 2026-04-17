package com.xpxp.DTO;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file CategoryDTO
 * @author thexpxp233
 * @date 2025/11/12
 * My name is lixiaopei
 **/

import lombok.Data;
import java.io.Serializable;

@Data
public class CategoryAddDTO implements Serializable {
	private Integer shopId;
	private String categoryName;
	private String categoryDescription;
	private String image;


}