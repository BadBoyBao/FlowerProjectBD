package com.xpxp.Controller.User;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file LoginController
 * @author thexpxp233
 * @date 2025/11/20
 * My name is lixiaopei
 **/

import com.xpxp.Common.Result;
import com.xpxp.DTO.LoginDTO;
import com.xpxp.Service.LoginService;
import com.xpxp.Utils.JwtUtils;
import com.xpxp.VO.LoginVO;
import com.xpxp.entity.Users;
import com.xpxp.properties.JwtProperties;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/user/login")
@Tag(name = "用户登录接口")
public class UserLoginController {

	@Autowired
	private LoginService loginService;
	@Autowired
	private JwtProperties jwtProperties;

	@PostMapping
	@Operation(summary = "登录")
	public Result<LoginVO> login(@RequestBody LoginDTO loginDTO) {
		Users users = loginService.login(loginDTO);
		Map<String, Object> claims = new HashMap<>();
		claims.put("userId", users.getUserId());
		String token = JwtUtils.createJWT(jwtProperties.getUserSecretKey(), jwtProperties.getUserTtl(), claims);
		if (users != null) {
			LoginVO loginVO = LoginVO.builder()
			                         .userId(users.getUserId())
			                         .username(users.getUsername())
			                         .nickname(users.getNickname())
			                         .image(users.getImage())
			                         .role(users.getRole())
			                         .shopId(users.getShopId())
			                         .token(token)
			                         .build();
			return Result.success(loginVO);
		}
		return Result.error("错误信息");
	}
}