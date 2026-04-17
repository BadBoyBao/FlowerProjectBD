package com.xpxp.exception;

import com.xpxp.Common.Result;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;


/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file GlobalExceptionHandler
 * @author thexpxp233
 * @date 2025/11/20
 * My name is lixiaopei
 **/
@RestControllerAdvice
@Slf4j
@Hidden
public class GlobalExceptionHandler {
	// Token 过期异常 - 401
	@ExceptionHandler(TokenExpiredException.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public Result handleTokenExpiredException(TokenExpiredException e) {
		return Result.error(HttpStatus.UNAUTHORIZED, e.getMessage());
	}


	// 业务异常 - 400
	@ExceptionHandler(BusinessException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Result handleBusinessException(BusinessException e) {
		log.warn("业务异常: {}", e.getMessage());
		return Result.error(HttpStatus.BAD_REQUEST, e.getMessage());
	}

	// 数据库操作异常 - 400
	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Result handleDataIntegrityViolationException(SQLIntegrityConstraintViolationException e) {
		log.warn("数据库操作异常: {}", e.getMessage());
		if (e.getMessage()
		     .contains("a foreign key")) {
			return Result.error(HttpStatus.INTERNAL_SERVER_ERROR, "数据被关联，无法删除");
		}
		return Result.error(HttpStatus.INTERNAL_SERVER_ERROR, "数据库操作异常");
	}

	// 认证异常 - 401
	@ExceptionHandler(AuthenticationException.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public Result handleAuthenticationException(AuthenticationException e) {
		log.warn("认证异常: {}", e.getMessage());
		return Result.error(HttpStatus.UNAUTHORIZED, e.getMessage());
	}

	// 数据完整性异常 - 400
	@ExceptionHandler(DataIntegrityViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Result handleDataIntegrityViolationException(DataIntegrityViolationException e) {
		log.warn("数据完整性异常: {}", e.getMessage());
		return Result.error(HttpStatus.BAD_REQUEST, "数据完整性异常: " + e.getMessage());

	}

	// 空指针异常 - 400
	@ExceptionHandler(NullPointerException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Result handleNullPointerException(NullPointerException e, HttpServletRequest request) {
		log.error("空指针异常: {}，请求路径: {}", e.getMessage(), request.getRequestURI(), e);
		return Result.error(HttpStatus.BAD_REQUEST, "服务器内部错误，请稍后重试");
	}

	// 非法参数异常 - 400
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Result handleIllegalArgumentException(IllegalArgumentException e) {
		log.warn("非法参数异常: {}", e.getMessage());
		return Result.error(HttpStatus.BAD_REQUEST, "参数错误: " + e.getMessage());
	}

	// 请求方法不支持异常 - 405
	@ExceptionHandler(org.springframework.web.HttpRequestMethodNotSupportedException.class)
	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	public Result handleHttpRequestMethodNotSupportedException(org.springframework.web.HttpRequestMethodNotSupportedException e) {
		log.warn("请求方法不支持: {}", e.getMessage());
		return Result.error(HttpStatus.METHOD_NOT_ALLOWED, "请求方法不支持");
	}

	// 路径不存在异常 - 404
	@ExceptionHandler(org.springframework.web.servlet.NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Result handleNoHandlerFoundException(org.springframework.web.servlet.NoHandlerFoundException e) {
		log.warn("路径不存在: {}", e.getRequestURL());
		return Result.error(HttpStatus.NOT_FOUND, "请求路径不存在");
	}

	// 通用异常处理 - 500
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Result handleGeneralException(Exception e, HttpServletRequest request) {
		log.error("未捕获的异常: {}，请求路径: {}", e.getMessage(), request.getRequestURI(), e);
		return Result.error(HttpStatus.INTERNAL_SERVER_ERROR, "服务器内部错误，请稍后重试");
	}
}