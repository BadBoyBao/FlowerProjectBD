package com.xpxp.Controller.Super;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file SuperShopController
 * @author thexpxp233
 * @date 2025/12/22
 * My name is lixiaopei
 **/

import com.xpxp.Common.PageQueryParm;
import com.xpxp.Common.PageResult;
import com.xpxp.Common.Result;
import com.xpxp.DTO.BanShopDTO;
import com.xpxp.DTO.OwnerDTO;
import com.xpxp.DTO.ShopDTO;
import com.xpxp.DTO.UpdateShopDTO;
import com.xpxp.Service.ShopService;
import com.xpxp.VO.OwnerVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/super/shop")
@Tag(name = "超级管理员店铺接口")
@Slf4j
public class SuperShopController {
	@Autowired
	private ShopService shopService;

	/**
	 * 添加店主
	 *
	 * @param ownerDTO
	 */
	@PostMapping("/addOwner")
	public Result addOwner(@RequestBody OwnerDTO ownerDTO) {
		shopService.addOwner(ownerDTO);
		return Result.success();
	}

	/**
	 * 删除店主
	 */
	@DeleteMapping("/deleteOwner/{ownerId}")
	public Result deleteOwner(@PathVariable Integer ownerId) {
		shopService.deleteOwner(ownerId);
		return Result.success();
	}

	/**
	 * 获取所有店主
	 */
	@GetMapping("/list")
	@Operation(summary = "获取所有店主")
	public Result<List<OwnerVO>> list() {
		List<OwnerVO> list = shopService.list();
		return Result.success(list);
	}

	/**
	 * 分页查询
	 */
	@GetMapping("/page")
	@Operation(summary = "分页查询")
	public Result<PageResult> pageResultResult(PageQueryParm pageQueryParm) {
		PageResult pageResult = shopService.page(pageQueryParm);
		return Result.success(pageResult);
	}

	/**
	 * 添加店铺
	 *
	 * @param shopDTO
	 * @return
	 */
	@PostMapping("/addShop")
	@Operation(summary = "添加店铺")
	public Result addShop(@RequestBody ShopDTO shopDTO) {
		shopService.addShop(shopDTO);
		return Result.success();
	}


	/**
	 * 获取所有店铺,分页查询
	 *
	 * @return
	 */
	@GetMapping("/getAllShop")
	@Operation(summary = "获取所有店铺")
	public Result<PageResult> getAllShop(PageQueryParm pageQueryParm) {
		PageResult pageResult = shopService.getAllShop(pageQueryParm);
		return Result.success(pageResult);
	}


	/**
	 * 封禁店铺
	 *
	 * @param banShopDTO
	 * @return
	 */
	@PostMapping("/banShop")
	@Operation(summary = "封禁店铺")
	public Result banShop(@RequestBody BanShopDTO banShopDTO) {
		shopService.banShop(banShopDTO);
		return Result.success();
	}

	/**
	 * 解禁
	 *
	 * @param shopId
	 */
	@PostMapping("/unbanShop/{shopId}")
	@Operation(summary = "解禁")
	public Result unbanShop(@PathVariable Integer shopId) {
		shopService.unbanShop(shopId);
		return Result.success();
	}

	@PostMapping("/updateShop")
	@Operation(summary = "更新店铺信息")
	public Result updateShop(@RequestBody UpdateShopDTO updateShopDTO) {
		shopService.updateShopByShopId(updateShopDTO);
		return Result.success();
	}


}