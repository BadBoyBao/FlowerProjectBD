package com.xpxp.Controller.User;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file UserInfoController
 * @author thexpxp233
 * @date 2025/12/19
 * My name is lixiaopei
 **/

import com.xpxp.Common.Result;
import com.xpxp.DTO.ResetPasswordDTO;
import com.xpxp.DTO.UserInfoUpdateDTO;
import com.xpxp.Service.InfoService;
import com.xpxp.VO.UserInfoVO;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user/info")
@Tag(name = "用户信息模块")
public class UserInfoController {

	@Autowired
	private InfoService infoService;


	/**
	 * 获取个人信息
	 *
	 * @return
	 */
	@GetMapping
	@Schema(description = "获取用户信息")
	public Result<UserInfoVO> getUserInfo() {
		UserInfoVO userInfoVO = infoService.getInfo();
		return Result.success(userInfoVO);
	}


	/**
	 * 更新用户信息
	 *
	 * @param userInfoUpdateDTO
	 * @return
	 */
	@PostMapping
	@Schema(description = "更新用户信息")
	public Result updateUserInfo(@RequestBody UserInfoUpdateDTO userInfoUpdateDTO) {
		log.info("userInfoUpdateDTO:{}", userInfoUpdateDTO);
		infoService.updateInfo(userInfoUpdateDTO);
		return Result.success();
	}

	@PostMapping("/resetpassword")
	@Schema(description = "重置密码")
	public Result resetPassword(@RequestBody ResetPasswordDTO resetPasswordDTO) {
		log.info("resetPasswordDTO:{}", resetPasswordDTO);
		infoService.resetPassword(resetPasswordDTO);
		return Result.success();
	}
}