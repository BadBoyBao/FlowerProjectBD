package com.xpxp.Controller.User;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file UserShopController
 * @author thexpxp233
 * @date 2025/12/25
 * My name is lixiaopei
 **/

import com.xpxp.Common.Result;
import com.xpxp.Service.ShopService;
import com.xpxp.VO.ShopDetailVO;
import com.xpxp.VO.ShopVO;
import com.xpxp.VO.ShopViewVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user/shop")
@Tag(name = "用户商城接口")
public class UserShopController {

	@Autowired
	private ShopService shopService;


	@GetMapping("/list")
	@Operation(summary = "获取所有店铺")
	public Result<List<ShopVO>> list() {
		List<ShopVO> list = shopService.shopList();
		return Result.success(list);
	}

	@GetMapping("/shop")
	@Operation(summary = "获取所有店铺")
	public Result<List<ShopViewVO>> shop() {
		List<ShopViewVO> list = shopService.getList();
		return Result.success(list);
	}

	@GetMapping("/shopDetail/{shopId}")
	@Operation(summary = "获取店铺详情")
	public Result<ShopDetailVO> shopDetail(@PathVariable Integer shopId) {
		ShopDetailVO shopDetailVO = shopService.getShopDetail(shopId);
		return Result.success(shopDetailVO);
	}
}