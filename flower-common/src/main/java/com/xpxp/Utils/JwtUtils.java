package com.xpxp.Utils;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file JwtUtils
 * @author thexpxp233
 * @date 2025/11/18
 * My name is lixiaopei
 **/
@Slf4j
public class JwtUtils {

	/**
	 * 秘钥最小长度
	 */
	private static final int MIN_SECRET_KEY_LENGTH = 32;

	/**
	 * 生成jwt
	 * 使用Hs256算法, 私匙使用固定秘钥
	 *
	 * @param secretKey jwt秘钥 ，长度至少32个字符
	 * @param ttlMillis jwt过期时间(毫秒)
	 * @param claims    设置的信息
	 * @return
	 */
	public static String createJWT(String secretKey, long ttlMillis, Map<String, Object> claims) {

		// 指定签名的时候使用的签名算法，也就是header那部分
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

		// 生成JWT的时间
		long expMillis = System.currentTimeMillis() + ttlMillis;
		Date exp = new Date(expMillis);

		// 设置jwt的body
		JwtBuilder builder = Jwts.builder()
		                         .setClaims(claims)
		                         // 设置签名使用的签名算法和签名使用的秘钥
		                         .signWith(Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8)), signatureAlgorithm)
		                         // 设置过期时间
		                         .setExpiration(exp)
		                         // 设置签发时间
		                         .setIssuedAt(new Date());

		return builder.compact();
	}

	/**
	 * Token解密
	 *
	 * @param secretKey jwt秘钥 此秘钥一定要保留好在服务端, 不能暴露出去, 否则sign就可以被伪造, 如果对接多个客户端建议改造成多个
	 * @param token     加密后的token
	 * @return
	 */
	public static Claims parseJWT(String secretKey, String token) {
		validateSecretKey(secretKey);
		SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));

		return Jwts.parser()
		           .verifyWith(key)
		           .build()
		           .parseSignedClaims(token)
		           .getPayload();
	}

	/**
	 * 校验token是否有效
	 *
	 * @param secretKey jwt秘钥
	 * @param token     加密后的token
	 * @return true-有效，false-无效
	 */
	public static boolean validateToken(String secretKey, String token) {
		try {
			parseJWT(secretKey, token);
			return true;
		} catch (SignatureException e) {
			log.error("Invalid JWT signature: {}", e.getMessage());
		} catch (MalformedJwtException e) {
			log.error("Invalid JWT token: {}", e.getMessage());
		} catch (ExpiredJwtException e) {
			log.error("JWT token is expired: {}", e.getMessage());
		} catch (UnsupportedJwtException e) {
			log.error("JWT token is unsupported: {}", e.getMessage());
		} catch (IllegalArgumentException e) {
			log.error("JWT claims string is empty: {}", e.getMessage());
		} catch (Exception e) {
			log.error("JWT validation error: {}", e.getMessage());
		}
		return false;
	}

	/**
	 * 刷新token
	 *
	 * @param secretKey jwt秘钥
	 * @param token     过期的token
	 * @param ttlMillis 新token的过期时间(毫秒)
	 * @return 新的token
	 */
	public static String refreshToken(String secretKey, String token, long ttlMillis) {
		try {
			// 解析旧token获取claims
			Claims claims = parseJWT(secretKey, token);
			// 移除过期时间
			claims.remove("exp");
			// 生成新token
			return createJWT(secretKey, ttlMillis, claims);
		} catch (ExpiredJwtException e) {
			// 如果是过期异常，仍然尝试获取claims
			Claims claims = e.getClaims();
			// 移除过期时间
			claims.remove("exp");
			// 生成新token
			return createJWT(secretKey, ttlMillis, claims);
		} catch (Exception e) {
			log.error("Failed to refresh token: {}", e.getMessage());
			throw e;
		}
	}

	/**
	 * 校验秘钥长度
	 *
	 * @param secretKey jwt秘钥
	 */
	private static void validateSecretKey(String secretKey) {
		if (secretKey == null || secretKey.length() < MIN_SECRET_KEY_LENGTH) {
			throw new IllegalArgumentException("JWT secret key must be at least " + MIN_SECRET_KEY_LENGTH + " characters long");
		}
	}
}