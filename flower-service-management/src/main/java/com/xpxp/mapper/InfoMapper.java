package com.xpxp.mapper;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file InfoMapper
 * @author thexpxp233
 * @date 2025/12/19
 * My name is lixiaopei
 **/

import com.xpxp.DTO.UserInfoUpdateDTO;
import com.xpxp.VO.UserInfoVO;
import com.xpxp.entity.Users;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InfoMapper {


	/**
	 * 获取用户信息
	 *
	 * @param userId
	 * @return
	 */
	UserInfoVO getInfo(Long userId);

	/**
	 * 更新用户信息
	 *
	 * @param userId
	 * @param userInfoUpdateDTO
	 */
	void updateInfo(Long userId, UserInfoUpdateDTO userInfoUpdateDTO);

	/**
	 * 获取用户名
	 *
	 * @param username
	 * @return
	 */
	Users getUserName(String username);


	/**
	 * 获取用户ID和用户名
	 *
	 * @param userId
	 * @param username
	 * @return
	 */

	Users getByUserIdAndUserName(Long userId, String username);


	/**
	 * 重置密码
	 *
	 * @param userId
	 * @param newPassword
	 */
	void resetPassword(Long userId, String username, String newPassword);

}