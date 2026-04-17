package com.xpxp.entity;


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
public class Favorites implements Serializable {
	@Schema(description = "收藏ID")
	private Integer favoriteId;
	@Schema(description = "用户ID")
	private Integer userId;
	@Schema(description = "鲜花ID")
	private Integer flowerId;
	@Schema(description = "创建时间")
	private Date createdAt;
}