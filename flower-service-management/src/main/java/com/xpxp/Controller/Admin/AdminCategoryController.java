package com.xpxp.Controller.Admin;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file CategoryController
 * @author thexpxp233
 * @date 2025/11/11
 * My name is lixiaopei
 **/

import com.xpxp.Common.PageResult;
import com.xpxp.Common.Result;
import com.xpxp.DTO.CategoryAddDTO;
import com.xpxp.DTO.CategoryQueryDTO;
import com.xpxp.DTO.CategoryUpdateDTO;
import com.xpxp.Service.CategoryService;
import com.xpxp.entity.Category;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/category")
@Tag(name = "分类接口")
@Slf4j
public class AdminCategoryController {
	@Autowired
	private CategoryService categoryService;

	/**
	 * 获取所有分类
	 *
	 * @return
	 */
	@GetMapping("/list/{shopId}")
	@Operation(summary = "获取所有分类")
	public Result<List<Category>> list(@PathVariable Integer shopId) {
		List<Category> list = categoryService.list(shopId);
		return Result.success(list);
	}


	/**
	 * 根据id查询分类详情
	 *
	 * @param categoryId
	 * @return
	 */
	@GetMapping("/{categoryId}")
	@Operation(summary = "获取分类详情")
	public Result<Category> get(@PathVariable("categoryId") Integer categoryId) {
		Category category = categoryService.getByCategoryId(categoryId);
		return Result.success(category);
	}

	/**
	 * 新增分类
	 *
	 * @param categoryAddDTO
	 * @return
	 */
	@PostMapping
	@Operation(summary = "新增分类")
	public Result insert(@RequestBody CategoryAddDTO categoryAddDTO) {
		log.info("新增分类：{}", categoryAddDTO);
		categoryService.insert(categoryAddDTO);
		return Result.success();
	}

	/**
	 * 根据id删除分类数据
	 *
	 * @param categoryId
	 * @return
	 */
	@DeleteMapping("/{categoryId}")
	@Operation(summary = "根据Id删除分类")
	public Result delete(@PathVariable("categoryId") Integer categoryId) {
		categoryService.deleteByCategoryId(categoryId);
		return Result.success();
	}

	/**
	 * 修改分类数据
	 *
	 * @param categoryUpdateDTO
	 * @return
	 */
	@PutMapping
	@Operation(summary = "修改分类")
	public Result update(@RequestBody CategoryUpdateDTO categoryUpdateDTO) {
		categoryService.updateCategory(categoryUpdateDTO);
		return Result.success();
	}

	/**
	 * 分页查询分类数据
	 *
	 * @param categoryQueryDTO
	 * @return
	 */
	@GetMapping("/page")
	@Operation(summary = "分页查询分类")
	public Result<PageResult> page(CategoryQueryDTO categoryQueryDTO) {
		PageResult pageResult = categoryService.page(categoryQueryDTO);
		return Result.success(pageResult);
	}
}