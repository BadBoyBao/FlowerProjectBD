package com.xpxp.Service;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file InfoService
 * @author thexpxp233
 * @date 2025/12/19
 * My name is lixiaopei
 **/

import com.xpxp.DTO.RegisterDTO;
import com.xpxp.DTO.ResetPasswordDTO;
import com.xpxp.DTO.UserInfoUpdateDTO;
import com.xpxp.VO.UserInfoVO;

public interface InfoService {

	/**
	 * 获取个人信息
	 *
	 * @return
	 */

	UserInfoVO getInfo();

	/**
	 * 修改个人信息
	 *
	 * @param userInfoUpdateDTO
	 */
	void updateInfo(UserInfoUpdateDTO userInfoUpdateDTO);

	/**
	 * 注册
	 *
	 * @param registerDTO
	 */
	void register(RegisterDTO registerDTO);

	/**
	 * 重置密码
	 *
	 * @param resetPasswordDTO
	 */
	void resetPassword(ResetPasswordDTO resetPasswordDTO);
}