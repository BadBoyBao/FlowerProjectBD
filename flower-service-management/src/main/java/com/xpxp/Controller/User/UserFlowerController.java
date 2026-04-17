package com.xpxp.Controller.User;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file UserFlowerController
 * @author thexpxp233
 * @date 2025/11/20
 * My name is lixiaopei
 **/

import com.xpxp.Common.PageResult;
import com.xpxp.Common.Result;
import com.xpxp.DTO.FlowerListQueryParmDTO;
import com.xpxp.DTO.ReviewsQueryParm;
import com.xpxp.DTO.ShopFlowerDTO;
import com.xpxp.Service.UserFlowerService;
import com.xpxp.VO.FlowerDetailVO;
import com.xpxp.VO.FlowerRecommendVO;
import com.xpxp.VO.FlowerVO;
import com.xpxp.VO.HomeReviewVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user/flower")
@Tag(name = "用户鲜花接口")
public class UserFlowerController {

	@Autowired
	private UserFlowerService userFlowerService;

	@Autowired
	private RedisTemplate redisTemplate;

	@GetMapping("/list")
	@Operation(summary = "获取花列表")
	public Result<PageResult> listResult(FlowerListQueryParmDTO flowerListQueryParmDTO) {

		PageResult pageResult = userFlowerService.listResult(flowerListQueryParmDTO);
		return Result.success(pageResult);
	}

	/**
	 * 获取销量前5的鲜花
	 *
	 * @return
	 */
	@GetMapping("/recommend")
	@Operation(summary = "获取推荐鲜花")
	public Result<List<FlowerRecommendVO>> recommend() {
		String key = "recommend_flower";
		List<FlowerRecommendVO> list = (List<FlowerRecommendVO>) redisTemplate.opsForValue()
		                                                                      .get(key);
		if (list != null) {
			return Result.success(list);
		}
		list = userFlowerService.getRecommendFlowers();
		redisTemplate.opsForValue()
		             .set(key, list);
		return Result.success(list);
	}


	/**
	 * 根据鲜花ID查询鲜花详情
	 *
	 * @param flowerId
	 * @return
	 */
	@GetMapping("/detail/{flowerId}")
	@Operation(summary = "根据鲜花ID查询鲜花详情")
	@Cacheable(cacheNames = "flowerDetailCache", key = "#flowerId")
	public Result<FlowerDetailVO> detailVOResult(@PathVariable Integer flowerId) {
		FlowerDetailVO flowerDetailVO = userFlowerService.getFlowerById(flowerId);
		return Result.success(flowerDetailVO);
	}

	/*通过店铺Id和分类ID获取鲜花*/
	@PostMapping("/listByShopIdAndCategoryId")
	@Operation(summary = "通过店铺Id和分类ID获取鲜花")
	public Result<List<FlowerVO>> listByShopIdAndCategoryId(@RequestBody ShopFlowerDTO shopFlowerDTO) {

		List<FlowerVO> flowerVOList = userFlowerService.listByShopIdAndCategoryId(shopFlowerDTO.getShopId(), shopFlowerDTO.getCategoryId());
		return Result.success(flowerVOList);
	}

	/**
	 * 获取鲜花评价
	 *
	 * @param reviewsQueryParm
	 * @return
	 */
	@GetMapping("/reviews")
	@Operation(summary = "获取鲜花评价")
	@Cacheable(cacheNames = "flowerReviewCache", key = "#reviewsQueryParm.flowerId")
	public Result<PageResult> flowerReviews(ReviewsQueryParm reviewsQueryParm) {
		PageResult pageResult = userFlowerService.flowerReviews(reviewsQueryParm);
		return Result.success(pageResult);

	}

	/**
	 * 获取首页鲜花评价
	 *
	 * @return
	 */
	@GetMapping("/homeReview")
	@Operation(summary = "获取首页鲜花评价")
	@Cacheable(cacheNames = "home_review")
	public Result<List<HomeReviewVO>> homeReview() {

		List<HomeReviewVO> homeReviewVOList = userFlowerService.homeReview();

		return Result.success(homeReviewVOList);
	}
}