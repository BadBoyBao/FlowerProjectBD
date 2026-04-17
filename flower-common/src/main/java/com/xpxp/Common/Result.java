package com.xpxp.Common;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file Result
 * @author thexpxp233
 * @date 2025/11/11
 * My name is lixiaopei
 **/
@Data
public class Result<T> implements Serializable {

	private Integer code; //编码：1成功，0和其它数字为失败
	private String msg; //错误信息
	private T data; //数据
	private Integer status; // HTTP 状态码

	public static <T> Result<T> success() {
		Result<T> result = new Result<T>();
		result.code = 1;
		result.status = HttpStatus.OK.value();
		return result;
	}

	public static <T> Result<T> success(T object) {
		Result<T> result = new Result<T>();
		result.data = object;
		result.code = 1;
		result.status = HttpStatus.OK.value();
		return result;
	}

	public static <T> Result<T> error(String msg) {
		Result result = new Result();
		result.msg = msg;
		result.code = 0;
		result.status = HttpStatus.INTERNAL_SERVER_ERROR.value();
		return result;
	}


	public static <T> Result<T> error(Integer status, String msg) {
		Result result = new Result();
		result.msg = msg;
		result.code = 0;
		result.status = status;
		return result;
	}


	public static <T> Result<T> error(HttpStatus status, String msg) {
		return error(status.value(), msg);
	}
}