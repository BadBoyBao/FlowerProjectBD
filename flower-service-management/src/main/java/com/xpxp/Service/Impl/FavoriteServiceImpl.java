package com.xpxp.Service.Impl;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file FavoriteServiceImpl
 * @author thexpxp233
 * @date 2025/12/29
 * My name is lixiaopei
 **/

import com.xpxp.Service.FavoriteService;
import com.xpxp.VO.FavoritesVO;
import com.xpxp.context.BaseContext;
import com.xpxp.entity.Favorites;
import com.xpxp.exception.BusinessException;
import com.xpxp.mapper.FavoriteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteServiceImpl implements FavoriteService {

	@Autowired
	private FavoriteMapper favoriteMapper;


	@Override
	public void addFavorite(Integer flowerId) {
		//通过线程获取当前用户ID
		Long userId = BaseContext.getCurrentId();
		Favorites favorites = favoriteMapper.getByUserIdAndFlowerId(userId, flowerId);
		if (favorites != null) {
			throw new BusinessException("已收藏,收藏失败");
		}
		favoriteMapper.addFavorite(userId, flowerId);
	}

	@Override
	public void deleteFavorite(List<Integer> flowerId) {
		//通过线程获取当前用户ID
		Long userId = BaseContext.getCurrentId();

		for (Integer id : flowerId) {
			Favorites favorites = favoriteMapper.getByUserIdAndFlowerId(userId, id);
			if (favorites == null) {
				throw new BusinessException("未收藏");
			}
		}
		favoriteMapper.deleteFavorite(userId, flowerId);
	}

	/**
	 * 获取收藏列表
	 *
	 * @return
	 */
	@Override
	public List<Favorites> list() {
		Long userId = BaseContext.getCurrentId();
		List<Favorites> list = favoriteMapper.list(userId);
		return list;
	}

	/**
	 * 获取收藏列表
	 *
	 * @return
	 */
	@Override
	public List<FavoritesVO> allList() {
		Long userId = BaseContext.getCurrentId();
		List<FavoritesVO> allList = favoriteMapper.allList(userId);
		return allList;
	}

	/**
	 * 通过鲜花ID获取收藏信息
	 *
	 * @param flowerId
	 * @return
	 */
	@Override

	public FavoritesVO getByFlowerId(Integer flowerId) {
		Long userId = BaseContext.getCurrentId();
		FavoritesVO favoritesVO = favoriteMapper.getByFlowerId(userId, flowerId);
		return favoritesVO;
	}
}