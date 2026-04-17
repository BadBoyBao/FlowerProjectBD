package com.xpxp.Controller.Admin;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file AdminInfoController
 * @author thexpxp233
 * @date 2025/12/21
 * My name is lixiaopei
 **/

import com.xpxp.Common.Result;
import com.xpxp.Service.InfoService;
import com.xpxp.entity.Users;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/info")
@Tag(name = "管理员信息模块")
@Slf4j
public class AdminInfoController {

	@Autowired
	private InfoService infoService;

	@GetMapping("/infoList")
	@Operation(summary = "获取所有用户信息")
	public Result<List<Users>> getInfoList() {
		return null;
	}
}