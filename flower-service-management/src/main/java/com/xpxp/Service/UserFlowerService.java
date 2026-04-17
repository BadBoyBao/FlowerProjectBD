package com.xpxp.Service;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file UserFlowerService
 * @author thexpxp233
 * @date 2025/11/20
 * My name is lixiaopei
 **/

import com.xpxp.Common.PageResult;
import com.xpxp.DTO.FlowerListQueryParmDTO;
import com.xpxp.DTO.ReviewsQueryParm;
import com.xpxp.VO.FlowerDetailVO;
import com.xpxp.VO.FlowerRecommendVO;
import com.xpxp.VO.FlowerVO;
import com.xpxp.VO.HomeReviewVO;

import java.util.List;

public interface UserFlowerService {


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
	 * @return
	 */
	PageResult listResult(FlowerListQueryParmDTO flowerListQueryParmDTO);


	/**
	 * 获取鲜花评价
	 *
	 * @param reviewsQueryParm
	 * @return
	 */
	PageResult flowerReviews(ReviewsQueryParm reviewsQueryParm);

	/**
	 * 获取首页的鲜花评价
	 *
	 * @return
	 */
	List<HomeReviewVO> homeReview();
}