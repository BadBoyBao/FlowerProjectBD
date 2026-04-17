package com.xpxp.Controller.Common;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file RegisterController
 * @author thexpxp233
 * @date 2025/12/20
 * My name is lixiaopei
 **/

import com.xpxp.Common.Result;
import com.xpxp.DTO.RegisterDTO;
import com.xpxp.Service.InfoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/common/register")
@Tag(name = "注册接口")
@Slf4j
public class RegisterController {

	@Autowired
	private InfoService infoService;

	@PostMapping
	public Result register(@RequestBody RegisterDTO registerDTO) {

		log.info("用户注册：{}", registerDTO);
		infoService.register(registerDTO);
		return Result.success();
	}
}