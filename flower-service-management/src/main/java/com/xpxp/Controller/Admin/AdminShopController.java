package com.xpxp.Controller.Admin;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file AdminShopController
 * @author thexpxp233
 * @date 2025/12/28
 * My name is lixiaopei
 **/

import com.xpxp.Common.Result;
import com.xpxp.DTO.ShopUpdateDTO;
import com.xpxp.Service.ShopService;
import com.xpxp.VO.ShopDetailInfoVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/admin/shop")
@Tag(name = "店铺管理")
public class AdminShopController {

	@Autowired
	private ShopService shopService;

	/**
	 * 获取店铺详情
	 *
	 * @param shopId
	 * @return
	 */
	@GetMapping("/shopDetail/{shopId}")
	@Operation(summary = "获取店铺详情")
	public Result<ShopDetailInfoVO> getShopDetail(@PathVariable Integer shopId) {
		ShopDetailInfoVO shopDetailInfoVO = shopService.getShopInfo(shopId);
		return Result.success(shopDetailInfoVO);
	}

	@PostMapping("/changeStatus/{shopId}/{status}")
	@Operation(summary = "修改店铺状态")
	public Result changeStatus(@PathVariable Integer shopId, @PathVariable String status) {
		log.info("修改的店铺Id为:{},修改的店铺状态为:{}", shopId, status);
		shopService.changeStatus(shopId, status);
		return Result.success();
	}

	@PutMapping("/updateShop")
	@Operation(summary = "修改店铺信息")
	public Result updateShop(@RequestBody ShopUpdateDTO shopUpdateDTO) {
		log.info("修改的店铺信息为:{}", shopUpdateDTO);
		shopService.updateShop(shopUpdateDTO);
		return Result.success();
	}


}