package com.xpxp.interceptor;

import com.xpxp.Utils.JwtUtils;
import com.xpxp.context.BaseContext;
import com.xpxp.exception.AuthenticationException;
import com.xpxp.exception.TokenExpiredException;
import com.xpxp.properties.JwtProperties;
import io.jsonwebtoken.*;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;


/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file TokenInterceptor
 * @author thexpxp233
 * @date 2025/11/20
 * My name is lixiaopei
 **/
@Slf4j
@Component
public class AuthenticationInterceptor implements HandlerInterceptor {

	@Autowired
	private JwtProperties jwtProperties;

	@Override
	public boolean preHandle(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response, Object handler) throws Exception {
		//判断当前拦截到的是Controller的方法还是其他资源
		if (!(handler instanceof HandlerMethod)) {
			//当前拦截到的不是动态方法，直接放行
			return true;
		}
		//1。获取请求路径
		String uri = request.getRequestURI();
		//2.获取请求头中的token
		String token = request.getHeader(jwtProperties.getUserTokenName());
		//3.判断token是否存在，如果不存在，说明没有登录，返回错误信息
		if (token == null || token.isEmpty()) {
			log.info("用户未登录，请先登录");
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return false;
		}
		//4.判断token是否正确，如果正确，说明已经登录，返回true
		try {
			log.info(" AuthenticationToken校验:{}", token);
			Claims claims = JwtUtils.parseJWT(jwtProperties.getUserSecretKey(), token);
			BaseContext.setCurrentId((long) Integer.parseInt(claims.get("userId")
			                                                       .toString()));
			log.info("用户已登录:{}", claims.get("userId"));
			return true;
		} catch (ExpiredJwtException e) {
			throw new TokenExpiredException("token过期");
		} catch (SignatureException e) {
			throw new AuthenticationException("token签名无效");
		} catch (MalformedJwtException e) {
			throw new AuthenticationException("token格式无效");
		} catch (UnsupportedJwtException e) {
			throw new AuthenticationException("不支持的token类型");
		} catch (IllegalArgumentException e) {
			throw new AuthenticationException("token参数无效");
		} catch (Exception e) {
			throw new AuthenticationException("token校验失败");
		}


	}


	@Override
	public void afterCompletion(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response, Object handler,
	                            Exception ex) throws Exception {
		/**
		 * 清理当前线程的变量，防止内存泄漏
		 */
		BaseContext.removeCurrentId();
	}
}