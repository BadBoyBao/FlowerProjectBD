package com.xpxp.Common;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file PageResult
 * @author thexpxp233
 * @date 2025/11/17
 * My name is lixiaopei
 **/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResult implements Serializable {
	private long total; //总记录数
	private List rows; //当前页数据集合
}