package com.xpxp.Service.Impl;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file UserFlowerServiceImpl
 * @author thexpxp233
 * @date 2025/11/20
 * My name is lixiaopei
 **/

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xpxp.Common.PageResult;
import com.xpxp.DTO.FlowerListQueryParmDTO;
import com.xpxp.DTO.ReviewsQueryParm;
import com.xpxp.Service.UserFlowerService;
import com.xpxp.VO.*;
import com.xpxp.mapper.UserFlowerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserFlowerServiceImpl implements UserFlowerService {
	@Autowired
	private UserFlowerMapper userFlowerMapper;


	/**
	 * 获取销量前5的鲜花
	 *
	 * @return
	 */
	@Override
	public List<FlowerRecommendVO> getRecommendFlowers() {
		List<FlowerRecommendVO> flowerRecommendVOList = userFlowerMapper.getRecommendFlowers();
		return flowerRecommendVOList;
	}


	@Override
	public FlowerDetailVO getFlowerById(Integer flowerId) {
		FlowerDetailVO flowerDetailVO = userFlowerMapper.getFlowerById(flowerId);
		return flowerDetailVO;
	}

	/**
	 * 根据店铺id和分类id查询鲜花
	 *
	 * @param shopId
	 * @param categoryId
	 * @return
	 *
	 */
	@Override
	public List<FlowerVO> listByShopIdAndCategoryId(Integer shopId, Integer categoryId) {
		List<FlowerVO> flowerVOList = userFlowerMapper.listByShopIdAndCategoryId(shopId, categoryId);
		return flowerVOList;
	}

	/**
	 * 获取鲜花列表
	 *
	 * @return
	 */
	@Override
	public PageResult listResult(FlowerListQueryParmDTO flowerListQueryParmDTO) {
		PageHelper.startPage(flowerListQueryParmDTO.getPage(), flowerListQueryParmDTO.getPageSize());
		Page<FlowerListVO> page = userFlowerMapper.listResult(flowerListQueryParmDTO);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 获取鲜花评价
	 *
	 * @param reviewsQueryParm
	 * @return
	 */
	@Override
	public PageResult flowerReviews(ReviewsQueryParm reviewsQueryParm) {
		PageHelper.startPage(reviewsQueryParm.getPage(), reviewsQueryParm.getPageSize());
		Page<ReviewListVO> page = userFlowerMapper.flowerReviews(reviewsQueryParm.getFlowerId());
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 获取首页评价
	 *
	 * @return
	 */
	@Override
	public List<HomeReviewVO> homeReview() {
		List<HomeReviewVO> homeReviewVOList = userFlowerMapper.homeReview();
		return homeReviewVOList;
	}


}