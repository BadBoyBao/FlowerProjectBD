package com.xpxp.DTO;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file FlowerListQueryParmDTO
 * @author thexpxp233
 * @date 2025/12/29
 * My name is lixiaopei
 **/

import com.xpxp.Common.PageQueryParm;
import lombok.Data;
import java.io.Serializable;

@Data
public class FlowerListQueryParmDTO extends PageQueryParm implements Serializable {
	private String flowerName;
	private String categoryName;
	private String tag;
	private String priceRange;       // 新增：价格范围，格式："0-50"
	private String sortBy;           // 新增：排序方式

	// 解析价格范围的方法
	public Double getMinPrice() {
		if (priceRange != null && priceRange.contains("-")) {
			String[] range = priceRange.split("-");
			try {
				return Double.parseDouble(range[0]);
			} catch (NumberFormatException e) {
				return null;
			}
		}
		return null;
	}

	public Double getMaxPrice() {
		if (priceRange != null && priceRange.contains("-")) {
			String[] range = priceRange.split("-");
			try {
				return Double.parseDouble(range[1]);
			} catch (NumberFormatException e) {
				return null;
			}
		}
		return null;
	}
}