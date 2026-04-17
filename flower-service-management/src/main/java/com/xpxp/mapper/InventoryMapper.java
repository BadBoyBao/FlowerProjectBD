package com.xpxp.mapper;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file InventoryMapper
 * @author thexpxp233
 * @date 2025/11/16
 * My name is lixiaopei
 **/

import com.github.pagehelper.Page;
import com.xpxp.DTO.InventoryQueryParmDTO;
import com.xpxp.DTO.InventoryUpdateDTO;
import com.xpxp.entity.FlowersInventory;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface InventoryMapper {

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
	Page<FlowersInventory> page(InventoryQueryParmDTO inventoryQueryParmDTO);

	/**
	 * 根据鲜花ID查询库存信息
	 *
	 * @param flowerId
	 * @return
	 */
	@Select("select * from flowers_inventory where flower_id = #{flowerId}")
	FlowersInventory getByFlowerId(Integer flowerId);

	/**
	 *
	 * 添加鲜花库存
	 *
	 * @param flowersInventory
	 */
	void addInitInventory(FlowersInventory flowersInventory);


	/**
	 *
	 * 减少鲜花库存
	 *
	 * @param flowerId
	 * @param quantity
	 */
	void updateInventory(Integer flowerId, Integer quantity);

	/**
	 * 返回库存
	 *
	 * @param flowerId
	 * @param quantity
	 */
	void increaseInventory(Integer flowerId, Integer quantity);

	/**
	 * 增加已售数量
	 *
	 * @param flowerId
	 * @param quantity
	 */
	void AddSold(Integer flowerId, Integer quantity);

	/**
	 * 更新库存信息
	 *
	 * @param inventoryUpdateDTO
	 */
	void updateByShopId(InventoryUpdateDTO inventoryUpdateDTO);

	/**
	 * 删除库存信息
	 *
	 * @param flowerId
	 */
	@Delete("delete from flowers_inventory where flower_id = #{flowerId}")
	void deleteByFlowerId(Integer flowerId);
}