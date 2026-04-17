package com.xpxp.Service.Impl;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file InventoryServiceImpl
 * @author thexpxp233
 * @date 2025/11/16
 * My name is lixiaopei
 **/

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xpxp.Common.PageResult;
import com.xpxp.DTO.InventoryQueryParmDTO;
import com.xpxp.DTO.InventoryUpdateDTO;
import com.xpxp.Service.InventoryService;
import com.xpxp.entity.FlowersInventory;
import com.xpxp.exception.BusinessException;
import com.xpxp.mapper.InventoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private InventoryMapper inventoryMapper;

	/**
	 * 获取鲜花库存列表
	 *
	 * @return
	 */
	@Override
	public List<FlowersInventory> getFlowerInventory(Integer shopId) {
		List<FlowersInventory> flowerInventory = inventoryMapper.getFlowerInventory(shopId);
		return flowerInventory;
	}

	/**
	 * 分页查询
	 *
	 * @param inventoryQueryParmDTO
	 * @return
	 */
	@Override
	public PageResult page(InventoryQueryParmDTO inventoryQueryParmDTO) {
		PageHelper.startPage(inventoryQueryParmDTO.getPage(), inventoryQueryParmDTO.getPageSize());
		Page<FlowersInventory> page = inventoryMapper.page(inventoryQueryParmDTO);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 根据鲜花ID查询库存信息
	 *
	 * @param flowerId
	 * @return
	 */
	@Override
	public FlowersInventory getByFlowerId(Integer flowerId) {
		FlowersInventory inventory = inventoryMapper.getByFlowerId(flowerId);
		return inventory;
	}

	@Override
	public void updateInventory(InventoryUpdateDTO inventoryUpdateDTO) {
		FlowersInventory inventory = inventoryMapper.getByFlowerId(inventoryUpdateDTO.getFlowerId());
		if (inventory == null) {
			throw new BusinessException("库存不存在");
		}
		if (inventoryUpdateDTO.getStockQuantity() != null && inventoryUpdateDTO.getSafetyStock() != null) {
			if (inventoryUpdateDTO.getStockQuantity() < inventoryUpdateDTO.getSafetyStock()) {
				throw new BusinessException("库存数量不能小于安全库存");
			}
		}
		inventoryMapper.updateByShopId(inventoryUpdateDTO);
	}
}