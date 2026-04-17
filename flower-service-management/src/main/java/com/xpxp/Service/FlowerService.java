package com.xpxp.Service;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file FlowerService
 * @author thexpxp233
 * @date 2025/11/11
 * My name is lixiaopei
 **/

import com.xpxp.Common.PageResult;
import com.xpxp.DTO.FlowerAddDTO;
import com.xpxp.DTO.FlowerQueryParmDTO;
import com.xpxp.DTO.FlowerUpdateDTO;
import com.xpxp.entity.Flowers;

import java.util.List;


public interface FlowerService {


	/**
	 * 获取所有鲜花
	 *
	 * @return
	 */
	List<Flowers> getAllFlowers(Integer shopId);

	/**
	 * 根据id查询鲜花
	 *
	 * @param flowerId
	 * @return
	 */
	Flowers getById(Integer flowerId);

	/**
	 * 删除鲜花
	 *
	 * @param flowerId
	 */
	void deleteById(Integer flowerId);

	/**
	 * 新增鲜花
	 *
	 * @param flowerAddDTO
	 */
	void addFlower(FlowerAddDTO flowerAddDTO);

	/**
	 * 修改鲜花
	 *
	 * @param flowerUpdateDTO
	 */
	void updateFlower(FlowerUpdateDTO flowerUpdateDTO);

	/**
	 * 切换状态
	 *
	 * @param flowerId
	 * @param status
	 */
	void updateStatusByFlowerId(Integer flowerId, Integer status);

	/**
	 * 分页查询
	 *
	 * @param flowerQueryParmDTO
	 * @return
	 */
	PageResult page(FlowerQueryParmDTO flowerQueryParmDTO);


	/**
	 * 根据分类id查询鲜花
	 *
	 * @param categoryId
	 * @return
	 */
	List<Flowers> listByCategoryId(Integer categoryId);
}