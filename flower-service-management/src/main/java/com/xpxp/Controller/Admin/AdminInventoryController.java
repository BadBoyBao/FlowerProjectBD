package com.xpxp.Controller.Admin;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file InventoryController
 * @author thexpxp233
 * @date 2025/11/16
 * My name is lixiaopei
 **/


import com.xpxp.Common.PageResult;
import com.xpxp.Common.Result;
import com.xpxp.DTO.InventoryQueryParmDTO;
import com.xpxp.DTO.InventoryUpdateDTO;
import com.xpxp.Service.InventoryService;
import com.xpxp.entity.FlowersInventory;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/inventory")
@Slf4j
@Tag(name = "库存接口")
public class AdminInventoryController {
	@Autowired
	private InventoryService inventoryService;

	/**
	 * 获取鲜花库存列表
	 *
	 * @return
	 */
	@GetMapping("/list/{shopId}")
	@Operation(summary = "获取鲜花库存列表")
	public Result<List<FlowersInventory>> list(@PathVariable Integer shopId) {
		List<FlowersInventory> list = inventoryService.getFlowerInventory(shopId);
		return Result.success(list);
	}

	/**
	 * 分页查询
	 *
	 * @param inventoryQueryParmDTO
	 * @return
	 */
	@GetMapping("/page")
	@Operation(summary = "库存分页查询")
	public Result<PageResult> page(InventoryQueryParmDTO inventoryQueryParmDTO) {
		PageResult pageResult = inventoryService.page(inventoryQueryParmDTO);
		return Result.success(pageResult);
	}


	/**
	 * 根据鲜花Id获取鲜花库存详情
	 *
	 * @param flowerId
	 * @return
	 */
	@GetMapping("/{flowerId}")
	@Operation(summary = "根据鲜花Id获取鲜花库存详情")
	public Result<FlowersInventory> getById(@PathVariable Integer flowerId) {
		FlowersInventory inventory = inventoryService.getByFlowerId(flowerId);
		return Result.success(inventory);
	}

	@PostMapping("/updateInventory")
	@Operation(summary = "更新鲜花库存")
	public Result updateInventory(@RequestBody InventoryUpdateDTO inventoryUpdateDTO) {
		log.info("inventoryUpdateDTO:{}", inventoryUpdateDTO);
		inventoryService.updateInventory(inventoryUpdateDTO);
		return Result.success();
	}

}