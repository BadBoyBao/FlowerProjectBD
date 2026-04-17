package com.xpxp.mapper;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file FavoriteMapper
 * @author thexpxp233
 * @date 2025/12/29
 * My name is lixiaopei
 **/

import com.xpxp.VO.FavoritesVO;
import com.xpxp.entity.Favorites;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FavoriteMapper {

	/**
	 * 根据用户ID和鲜收藏ID查询收藏
	 *
	 * @param userId
	 * @param favoriteId
	 * @return
	 */
	@Select("select * from favorites where user_id = #{userId} and flower_id = #{favoriteId}")
	Favorites getByUserIdAndFlowerId(Long userId, Integer favoriteId);

	/**
	 * 添加收藏
	 *
	 * @param userId
	 * @param flowerId
	 */
	void addFavorite(Long userId, Integer flowerId);

	/**
	 * 删除收藏
	 *
	 * @param userId
	 * @param flowerId
	 */

	void deleteFavorite(Long userId, List<Integer> flowerId);

	/**
	 * 获取收藏列表
	 *
	 * @param userId
	 * @return
	 */
	@Select("select * from favorites where user_id = #{userId}")
	List<Favorites> list(Long userId);

	/**
	 * 获取所有收藏列表
	 *
	 * @param userId
	 * @return
	 */
	List<FavoritesVO> allList(Long userId);

	/**
	 * 根据鲜花ID删除收藏
	 *
	 * @param flowerId
	 */
	@Delete("delete from favorites where flower_id = #{flowerId}")
	void deleteByFlowerId(Integer flowerId);

	/**
	 * 根据鲜花ID查询收藏
	 *
	 * @param flowerId
	 * @return
	 */

	FavoritesVO getByFlowerId(Long userId, Integer flowerId);
}