package com.xpxp.aop;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file LogginAspect
 * @author thexpxp233
 * @date 2025/12/30
 * My name is lixiaopei
 **/

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

	private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

	@Pointcut("execution(* com.xpxp.Controller..*(..))")
	public void controllerPointcut() {
	}

	@Around("controllerPointcut()")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		// 记录请求开始
		log.info("请求方法：{} ，请求参数：{}", joinPoint.getSignature()
		                                              .getName(), Arrays.toString(joinPoint.getArgs()));

		long startTime = System.currentTimeMillis();
		Object result = joinPoint.proceed();
		long endTime = System.currentTimeMillis();

		// 记录请求结束和执行时间
		log.info("响应: {} - 方法耗时： {}ms", joinPoint.getSignature()
		                                               .getName(), (endTime - startTime));

		return result;
	}
}