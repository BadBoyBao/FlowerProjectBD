package com.xpxp.Service;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file CategoryService
 * @author thexpxp233
 * @date 2025/11/11
 * My name is lixiaopei
 **/

import com.xpxp.Common.PageResult;
import com.xpxp.DTO.CategoryAddDTO;
import com.xpxp.DTO.CategoryQueryDTO;
import com.xpxp.DTO.CategoryUpdateDTO;
import com.xpxp.VO.CategoryCountVO;
import com.xpxp.VO.CategoryVO;
import com.xpxp.entity.Category;

import java.util.List;

public interface CategoryService {
	List<Category> list(Integer shopId);


	/**
	 * 根据分类ID查询分类详情
	 *
	 * @param categoryId
	 * @return
	 */
	Category getByCategoryId(Integer categoryId);

	/**
	 * 新增分类
	 *
	 * @param categoryAddDTO
	 */
	void insert(CategoryAddDTO categoryAddDTO);


	/**
	 * 根据分类ID删除分类
	 *
	 * @param categoryId
	 */
	void deleteByCategoryId(Integer categoryId);

	/**
	 * 修改分类
	 *
	 * @param categoryUpdateDTO
	 */
	void updateCategory(CategoryUpdateDTO categoryUpdateDTO);

	/**
	 * 获取所有分类的鲜花数量
	 *
	 * @return
	 */
	List<CategoryCountVO> listCount();

	/**
	 * 分类分页查询
	 *
	 * @param categoryQueryDTO
	 * @return
	 */
	PageResult page(CategoryQueryDTO categoryQueryDTO);

	/**
	 * 根据店铺ID获取所有分类
	 *
	 * @param shopId
	 * @return
	 */
	List<CategoryVO> getByShopId(Integer shopId);
}