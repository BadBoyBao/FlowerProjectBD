package com.xpxp.Controller.Admin;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file FlowerController
 * @author thexpxp233
 * @date 2025/11/11
 * My name is lixiaopei
 **/

import com.xpxp.Common.PageResult;
import com.xpxp.Common.Result;
import com.xpxp.DTO.FlowerAddDTO;
import com.xpxp.DTO.FlowerQueryParmDTO;
import com.xpxp.DTO.FlowerUpdateDTO;
import com.xpxp.Service.FlowerService;
import com.xpxp.entity.Flowers;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/admin/flower")
@Tag(name = "鲜花接口")
@Slf4j
public class AdminFlowerController {
	@Autowired
	private FlowerService flowerService;


	/**
	 *
	 * 获取鲜花列表
	 *
	 * @return
	 */
	@GetMapping("/list/{shopId}")
	@Operation(summary = "获取鲜花列表")
	public Result<List<Flowers>> list(@PathVariable Integer shopId) {
		List<Flowers> flowers = flowerService.getAllFlowers(shopId);
		return Result.success(flowers);
	}

	/**
	 * 分页查询
	 *
	 * @param flowerQueryParmDTO
	 * @return
	 */
	@GetMapping("/page")
	@Operation(summary = "分页查询")
	public Result<PageResult> page(FlowerQueryParmDTO flowerQueryParmDTO) {
		PageResult pageResult = flowerService.page(flowerQueryParmDTO);
		return Result.success(pageResult);
	}


	/**
	 * 根据鲜花Id查询鲜花数据详情
	 *
	 * @param flowerId
	 * @return
	 */
	@GetMapping("/{flowerId}")
	@Operation(summary = "获取鲜花详情")
	public Result<Flowers> getResult(@PathVariable("flowerId") Integer flowerId) {
		Flowers flower = flowerService.getById(flowerId);
		return Result.success(flower);
	}

	/**
	 * 根据分类Id获取鲜花列表
	 *
	 * @param categoryId
	 * @return
	 */
	@GetMapping("/category/{categoryId}")
	@Operation(summary = "根据分类Id获取鲜花列表")
	public Result<List<Flowers>> listByCategoryId(@PathVariable("categoryId") Integer categoryId) {
		List<Flowers> list = flowerService.listByCategoryId(categoryId);
		return Result.success(list);
	}

	/**
	 * 新增鲜花数据
	 *
	 * @param flowerAddDTO
	 * @return
	 */

	@PostMapping
	@Operation(summary = "新增鲜花")
	public Result add(@RequestBody FlowerAddDTO flowerAddDTO) {
		flowerService.addFlower(flowerAddDTO);
		return Result.success();
	}

	/**
	 * 根据id删除鲜花数据
	 *
	 * @param flowerId
	 * @return
	 */

	@DeleteMapping("/{flowerId}")
	@Operation(summary = "根据Id删除鲜花")
	public Result delete(@PathVariable Integer flowerId) {
		flowerService.deleteById(flowerId);
		return Result.success();
	}

	/**
	 * 更新鲜花数据
	 *
	 * @param flowerUpdateDTO
	 * @return
	 */
	@PutMapping
	@Operation(summary = "更新鲜花")
	public Result update(@RequestBody FlowerUpdateDTO flowerUpdateDTO) {
		flowerService.updateFlower(flowerUpdateDTO);
		return Result.success();
	}

	/**
	 * 切换状态
	 *
	 * @param flowerId
	 * @param status   0下架 - 1上架
	 * @return
	 */
	@PutMapping("/status/{flowerId}/{status}")
	@Operation(summary = "状态切换")
	public Result updateStatus(@PathVariable("flowerId") Integer flowerId, @PathVariable("status") Integer status) {
		log.info("flowerId:{},status:{}", flowerId, status);
		flowerService.updateStatusByFlowerId(flowerId, status);
		return Result.success();
	}


}