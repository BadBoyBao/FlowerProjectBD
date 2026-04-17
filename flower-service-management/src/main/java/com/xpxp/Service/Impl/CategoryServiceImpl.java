package com.xpxp.Service.Impl;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file CategoryServiceImpl
 * @author thexpxp233
 * @date 2025/11/11
 * My name is lixiaopei
 **/

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xpxp.Common.PageResult;
import com.xpxp.DTO.CategoryAddDTO;
import com.xpxp.DTO.CategoryQueryDTO;
import com.xpxp.DTO.CategoryUpdateDTO;
import com.xpxp.Service.CategoryService;
import com.xpxp.VO.CategoryCountVO;
import com.xpxp.VO.CategoryVO;
import com.xpxp.entity.Category;
import com.xpxp.exception.BusinessException;
import com.xpxp.mapper.CategoryMapper;
import com.xpxp.mapper.FlowerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {


	@Autowired
	private CategoryMapper categoryMapper;

	@Autowired
	private FlowerMapper flowerMapper;

	@Override
	public List<Category> list(Integer shopId) {
		return categoryMapper.getAll(shopId);
	}

	/**
	 * 根据分类ID查询分类详情
	 *
	 * @param categoryId
	 * @return
	 */
	@Override
	public Category getByCategoryId(Integer categoryId) {
		return categoryMapper.getByCategoryId(categoryId);
	}

	/**
	 * 新增分类
	 *
	 * @param categoryDTO
	 */
	@Override
	public void insert(CategoryAddDTO categoryDTO) {
		categoryMapper.insert(categoryDTO);
	}

	/**
	 * 根据分类ID删除分类
	 *
	 * @param categoryId
	 */
	@Override
	public void deleteByCategoryId(Integer categoryId) {
		//1.先查询鲜花表是否有该分类下的鲜花
		int result = flowerMapper.selectCountByCategoryId(categoryId);
		if (result > 0) {
			throw new BusinessException("该分类下有鲜花，请先删除该分类下的鲜花");
		}
		categoryMapper.deleteByCategoryId(categoryId);
	}

	/**
	 * 修改分类
	 *
	 * @param categoryUpdateDTO
	 */
	@Override
	public void updateCategory(CategoryUpdateDTO categoryUpdateDTO) {
		categoryMapper.updateCategory(categoryUpdateDTO);
	}

	/**
	 * 获取所有分类的鲜花数量
	 *
	 * @return
	 */
	@Override
	public List<CategoryCountVO> listCount() {
		return categoryMapper.listCount();
	}

	/**
	 * 分类分页查询
	 *
	 * @param categoryQueryDTO
	 * @return
	 */
	@Override
	public PageResult page(CategoryQueryDTO categoryQueryDTO) {
		PageHelper.startPage(categoryQueryDTO.getPage(), categoryQueryDTO.getPageSize());
		Page<Category> page = categoryMapper.page(categoryQueryDTO);
		return new PageResult(page.getTotal(), page.getResult());
	}

	@Override
	public List<CategoryVO> getByShopId(Integer shopId) {
		List<CategoryVO> list = categoryMapper.getByShopId(shopId);
		return list;
	}
}