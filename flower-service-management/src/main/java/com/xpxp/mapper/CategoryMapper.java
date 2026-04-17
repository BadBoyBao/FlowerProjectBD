package com.xpxp.mapper;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file CategoryMapper
 * @author thexpxp233
 * @date 2025/11/11
 * My name is lixiaopei
 **/

import com.github.pagehelper.Page;
import com.xpxp.DTO.CategoryAddDTO;
import com.xpxp.DTO.CategoryQueryDTO;
import com.xpxp.DTO.CategoryUpdateDTO;
import com.xpxp.VO.CategoryCountVO;
import com.xpxp.VO.CategoryVO;
import com.xpxp.entity.Category;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoryMapper {

	List<Category> getAll(Integer shopId);

	/**
	 * 根据分类ID查询分类详情
	 *
	 * @param categoryId
	 * @return
	 */
	@Select("select * from category where category_id = #{categoryId}")
	Category getByCategoryId(Integer categoryId);


	/**
	 * 新增分类
	 *
	 * @param categoryDTO
	 */
	void insert(CategoryAddDTO categoryDTO);

	/**
	 * 根据分类ID删除分类
	 *
	 * @param categoryId
	 */
	@Delete("delete from category where category_id = #{categoryId}")
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
	 * 分页查询分类
	 *
	 * @param categoryQueryDTO
	 * @return
	 */
	Page<Category> page(CategoryQueryDTO categoryQueryDTO);

	/**
	 * 根据店铺ID获取分类列表
	 *
	 * @param shopId
	 * @return
	 */
	List<CategoryVO> getByShopId(Integer shopId);
}