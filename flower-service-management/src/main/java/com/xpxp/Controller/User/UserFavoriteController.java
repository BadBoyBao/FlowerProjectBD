package com.xpxp.Controller.User;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file UserFavoriteController
 * @author thexpxp233
 * @date 2025/12/29
 * My name is lixiaopei
 **/

import com.xpxp.Common.Result;
import com.xpxp.Service.FavoriteService;
import com.xpxp.VO.FavoritesVO;
import com.xpxp.entity.Favorites;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user/favorite")
@Tag(name = "用户收藏接口")
public class UserFavoriteController {
	@Autowired
	private FavoriteService favoriteService;

	/**
	 * 添加收藏
	 *
	 * @param flowerId
	 * @return
	 */
	@PostMapping("/add/{flowerId}")
	@Operation(summary = "添加收藏")
	//删除缓存
	@CacheEvict(value = "flowerDetailCache", key = "#flowerId")
	public Result addFavorite(@PathVariable Integer flowerId) {
		favoriteService.addFavorite(flowerId);
		return Result.success();
	}

	/**
	 * 删除收藏
	 *
	 * @param flowerId
	 * @return
	 */
	@PostMapping("/delete/{flowerId}")
	@Operation(summary = "删除收藏")
	public Result deleteFavorite(@PathVariable List<Integer> flowerId) {
		log.info("ids:{}", flowerId);
		favoriteService.deleteFavorite(flowerId);
		return Result.success();
	}

	/**
	 * 获取收藏列表
	 *
	 * @return
	 */
	@GetMapping("/list")
	@Operation(summary = "获取收藏列表")
	public Result<List<Favorites>> list() {
		List<Favorites> favorites = favoriteService.list();
		return Result.success(favorites);
	}

	/**
	 * 获取用户收藏列表
	 *
	 * @return
	 */
	@GetMapping("/allList")
	@Operation(summary = "获取用户收藏列表")
	public Result<List<FavoritesVO>> allList() {
		List<FavoritesVO> favorites = favoriteService.allList();
		return Result.success(favorites);
	}

	@GetMapping("/getByFlowerId/{flowerId}")
	@Operation(summary = "根据鲜花ID查询收藏项")
	public Result<FavoritesVO> getByFlowerId(@PathVariable Integer flowerId) {
		FavoritesVO favorites = favoriteService.getByFlowerId(flowerId);
		return Result.success(favorites);
	}
}