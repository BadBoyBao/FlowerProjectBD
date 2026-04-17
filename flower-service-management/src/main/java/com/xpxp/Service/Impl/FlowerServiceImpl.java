package com.xpxp.Service.Impl;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file FlowerServiceImpl
 * @author thexpxp233
 * @date 2025/11/11
 * My name is lixiaopei
 **/


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xpxp.Common.PageResult;
import com.xpxp.DTO.FlowerAddDTO;
import com.xpxp.DTO.FlowerQueryParmDTO;
import com.xpxp.DTO.FlowerUpdateDTO;
import com.xpxp.Service.FlowerService;
import com.xpxp.entity.Flowers;
import com.xpxp.entity.FlowersInventory;
import com.xpxp.exception.BusinessException;
import com.xpxp.mapper.FavoriteMapper;
import com.xpxp.mapper.FlowerMapper;
import com.xpxp.mapper.InventoryMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class FlowerServiceImpl implements FlowerService {
	@Autowired
	private FlowerMapper flowerMapper;
	@Autowired
	private InventoryMapper inventoryMapper;

	@Autowired
	private FavoriteMapper favoriteMapper;


	/**
	 * 获取所有鲜花
	 *
	 * @return
	 */
	@Override
	public List<Flowers> getAllFlowers(Integer shopId) {
		return flowerMapper.getAllFlowers(shopId);
	}

	@Override
	public Flowers getById(Integer flowerId) {
		return flowerMapper.selectById(flowerId);
	}


	/**
	 * 删除鲜花
	 *
	 * @param flowerId
	 */
	@Override
	public void deleteById(Integer flowerId) {
		/*判空操作*/
		if (flowerId == null) {
			throw new BusinessException("参数错误");
		}
		favoriteMapper.deleteByFlowerId(flowerId);
		inventoryMapper.deleteByFlowerId(flowerId);
		int result = flowerMapper.deleteById(flowerId);

		if (result != 1) {
			throw new BusinessException("该数据不存在");
		}

	}

	/**
	 * 新增鲜花
	 *
	 * @param flowerAddDTO
	 */
	@Transactional
	@Override
	public void addFlower(FlowerAddDTO flowerAddDTO) {
		flowerMapper.addFlower(flowerAddDTO);
		FlowersInventory flowersInventory = FlowersInventory.builder()
		                                                    .flowerId(flowerAddDTO.getFlowerId())
		                                                    .shopId(flowerAddDTO.getShopId())
		                                                    .stockQuantity(20)
		                                                    .soldQuantity(0)
		                                                    .safetyStock(10)
		                                                    .build();
		/**
		 * 初始化库存
		 */
		inventoryMapper.addInitInventory(flowersInventory);

	}

	/**
	 * 修改鲜花
	 *
	 * @param flowerUpdateDTO
	 */
	@Override
	public void updateFlower(FlowerUpdateDTO flowerUpdateDTO) {
		flowerMapper.updateFlower(flowerUpdateDTO);
	}

	/**
	 * 切换状态
	 *
	 * @param flowerId
	 * @param status
	 */
	@Override
	public void updateStatusByFlowerId(Integer flowerId, Integer status) {
		flowerMapper.updateStatusByFlowerId(flowerId, status);
	}

	/**
	 * 分页查询
	 *
	 * @param flowerQueryParmDTO
	 * @return
	 */
	@Override
	public PageResult page(FlowerQueryParmDTO flowerQueryParmDTO) {
		PageHelper.startPage(flowerQueryParmDTO.getPage(), flowerQueryParmDTO.getPageSize());
		Page<Flowers> page = flowerMapper.page(flowerQueryParmDTO);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 根据分类id查询鲜花
	 *
	 * @param categoryId
	 * @return
	 */
	@Override
	public List<Flowers> listByCategoryId(Integer categoryId) {
		return flowerMapper.listByCategoryId(categoryId);
	}
}