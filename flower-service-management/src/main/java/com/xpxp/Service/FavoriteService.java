package com.xpxp.Service;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file FavoriteService
 * @author thexpxp233
 * @date 2025/12/29
 * My name is lixiaopei
 **/

import com.xpxp.VO.FavoritesVO;
import com.xpxp.entity.Favorites;

import java.util.List;

public interface FavoriteService {
	/**
	 * 添加收藏
	 *
	 * @param flowerId
	 */
	void addFavorite(Integer flowerId);

	/**
	 * 删除收藏
	 *
	 * @param flowerId
	 */
	void deleteFavorite(List<Integer> flowerId);

	/**
	 * 获取收藏列表
	 *
	 * @return
	 */
	List<Favorites> list();

	/**
	 * 获取所有收藏列表
	 *
	 * @return
	 */
	List<FavoritesVO> allList();

	/**
	 * 根据鲜花ID查询收藏项
	 *
	 * @param flowerId
	 * @return
	 */
	FavoritesVO getByFlowerId(Integer flowerId);
}