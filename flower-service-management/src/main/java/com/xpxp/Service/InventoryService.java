package com.xpxp.Service;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file InventoryService
 * @author thexpxp233
 * @date 2025/11/16
 * My name is lixiaopei
 **/

import com.xpxp.Common.PageResult;
import com.xpxp.DTO.InventoryQueryParmDTO;
import com.xpxp.DTO.InventoryUpdateDTO;
import com.xpxp.entity.FlowersInventory;

import java.util.List;

public interface InventoryService {
	/**
	 * 获取鲜花库存列表
	 *
	 * @return
	 */
	List<FlowersInventory> getFlowerInventory(Integer shopId);

	/**
	 * 分页查询
	 *
	 * @param inventoryQueryParmDTO
	 * @return
	 */
	PageResult page(InventoryQueryParmDTO inventoryQueryParmDTO);

	/**
	 * 根据鲜花ID查询库存信息
	 *
	 * @param flowerId
	 * @return
	 */
	FlowersInventory getByFlowerId(Integer flowerId);

	/**
	 * 更新鲜花库存
	 *
	 * @param inventoryUpdateDTO
	 */
	void updateInventory(InventoryUpdateDTO inventoryUpdateDTO);
}