package com.xpxp.mapper;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file UserFlowerMapper
 * @author thexpxp233
 * @date 2025/11/20
 * My name is lixiaopei
 **/

import com.github.pagehelper.Page;
import com.xpxp.DTO.FlowerListQueryParmDTO;
import com.xpxp.VO.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserFlowerMapper {


	/**
	 * 获取销量前5的鲜花
	 *
	 * @return
	 */
	List<FlowerRecommendVO> getRecommendFlowers();

	/**
	 * 根据鲜花ID查询鲜花详情
	 *
	 * @param flowerId
	 * @return
	 */
	FlowerDetailVO getFlowerById(Integer flowerId);

	/**
	 * 根据店铺ID和分类ID查询鲜花列表
	 *
	 * @param shopId
	 * @param categoryId
	 * @return
	 */
	List<FlowerVO> listByShopIdAndCategoryId(Integer shopId, Integer categoryId);

	/**
	 * 获取鲜花列表
	 *
	 * @param flowerListQueryParmDTO
	 * @return
	 */
	Page<FlowerListVO> listResult(FlowerListQueryParmDTO flowerListQueryParmDTO);

	/**
	 * 获取鲜花评价
	 *
	 * @param flowerId
	 * @return
	 */

	Page<ReviewListVO> flowerReviews(Integer flowerId);

	/**
	 * 获取鲜花评价用于首页展示
	 *
	 * @return
	 */
	List<HomeReviewVO> homeReview();
}