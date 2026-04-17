//package com.xpxp;
//
/// *
// * 😊😊😊😊😊😊😊😊😊😊😊😊
// * @file testRedis
// * @author thexpxp233
// * @date 2025/12/30
// * My name is lixiaopei
// **/
//
//import com.xpxp.entity.Users;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.redis.core.RedisTemplate;
//
//@SpringBootTest
//public class testRedis {
//
//	@Autowired
//	private RedisTemplate redisTemplate;
//
//
//	@Test
//	public void test() {
//		Users users = Users.builder()
//		                   .username("测试")
//		                   .build();
//
//		redisTemplate.opsForValue()
//		             .set("测试", users);
//
//
//	}
//
//	@Test
//	public void testRedis() {
//		Users retrievedUser = (Users) redisTemplate.opsForValue()
//		                                           .get("测试");
//		System.out.println(retrievedUser);
//	}
//
//
//}