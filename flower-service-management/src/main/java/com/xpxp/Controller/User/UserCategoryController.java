package com.xpxp.Controller.User;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file UserCategoryController
 * @author thexpxp233
 * @date 2025/11/22
 * My name is lixiaopei
 **/

import com.xpxp.Common.Result;
import com.xpxp.Service.CategoryService;
import com.xpxp.VO.CategoryCountVO;
import com.xpxp.VO.CategoryVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user/category")
@Tag(name = "用户分类接口")
public class UserCategoryController {

	@Autowired
	private CategoryService categoryService;
	@Autowired
	private RedisTemplate redisTemplate;

	/**
	 * 获取所有分类的鲜花数量
	 *
	 * @return
	 */
	@GetMapping("/list/count")
	@Operation(summary = "获取所有分类的鲜花数量")
	public Result<List<CategoryCountVO>> listCount() {
		List<CategoryCountVO> list = categoryService.listCount();
		return Result.success(list);
	}

	/**
	 * 获取该店铺所有分类
	 *
	 * @param shopId
	 * @return
	 */
	@GetMapping("/list/{shopId}")
	@Operation(summary = "获取该店铺所有分类")
	public Result<List<CategoryVO>> list(@PathVariable Integer shopId) {
		List<CategoryVO> list = categoryService.getByShopId(shopId);
		return Result.success(list);
	}

}