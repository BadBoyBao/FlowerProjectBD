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
public class Reviews implements Serializable {
	@Schema(description = "评论ID")
	private Integer reviewId;
	@Schema(description = "用户ID")
	private Integer userId;
	@Schema(description = "订单ID")
	private Integer orderId;
	@Schema(description = "鲜花ID")
	private Integer flowerId;
	@Schema(description = "评分: 1-5分")
	private Integer rating;
	@Schema(description = "评论内容")
	private String content;
	@Schema(description = "评论图片")
	private Object reviewImages;
	@Schema(description = "是否匿名: 0-否 1-是")
	private Integer isAnonymous;
	@Schema(description = "状态: 0-隐藏 1-显示")
	private Integer status;
	@Schema(description = "创建时间")
	private Date createdAt;
	@Schema(description = "更新时间")
	private Date updatedAt;
}