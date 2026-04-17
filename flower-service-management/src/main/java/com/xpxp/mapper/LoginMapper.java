package com.xpxp.mapper;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file LoginMapper
 * @author thexpxp233
 * @date 2025/11/20
 * My name is lixiaopei
 **/

import cn.hutool.core.date.DateTime;
import com.xpxp.DTO.LoginDTO;
import com.xpxp.entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginMapper {

	/**
	 * 登录
	 *
	 * @param loginDTO
	 * @return
	 */
	Users login(LoginDTO loginDTO);


	/**
	 * 更新登录时间
	 *
	 * @param userId
	 * @param dateTime
	 */
	void updateLoginTime(Integer userId, DateTime dateTime);

	/**
	 * 注册
	 *
	 * @param user
	 * @return
	 *
	 */
	void register(Users user);


	/**
	 * 根据用户名查询用户
	 *
	 * @param username
	 * @return
	 */
	@Select("select * from users where username = #{username}")
	Users getByUserName(String username);
}