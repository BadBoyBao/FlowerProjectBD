package com.xpxp.Service;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file ShopService
 * @author thexpxp233
 * @date 2025/12/22
 * My name is lixiaopei
 **/

import com.xpxp.Common.PageQueryParm;
import com.xpxp.Common.PageResult;
import com.xpxp.DTO.*;
import com.xpxp.VO.*;

import java.util.List;

public interface ShopService {

	/**
	 * 添加店主
	 *
	 * @param ownerDTO
	 */
	void addOwner(OwnerDTO ownerDTO);

	/**
	 * 获取所有店主
	 *
	 * @return
	 */
	List<OwnerVO> list();

	/**
	 * 分页查询
	 *
	 * @param pageQueryParm
	 * @return
	 */
	PageResult page(PageQueryParm pageQueryParm);

	/**
	 * 添加店铺
	 *
	 * @param shopDTO
	 */
	void addShop(ShopDTO shopDTO);


	/**
	 * 获取所有店铺
	 *
	 * @return
	 */
	PageResult getAllShop(PageQueryParm pageQueryParm);

	/**
	 * 获取首页店铺
	 *
	 * @return
	 */
	List<ShopVO> shopList();

	/**
	 * 获取店铺列表
	 *
	 * @return
	 */
	List<ShopViewVO> getList();

	/**
	 * 获取店铺详情
	 *
	 * @param shopId
	 * @return
	 */
	ShopDetailVO getShopDetail(Integer shopId);


	/**
	 * 获取店铺详情信息
	 *
	 * @param shopId
	 * @return
	 */
	ShopDetailInfoVO getShopInfo(Integer shopId);

	/**
	 * 修改店铺状态
	 *
	 * @param shopId
	 * @param status
	 */
	void changeStatus(Integer shopId, String status);

	/**
	 * 修改店铺信息
	 *
	 * @param shopUpdateDTO
	 */
	void updateShop(ShopUpdateDTO shopUpdateDTO);

	/**
	 * 封禁店铺
	 *
	 * @param banShopDTO
	 */
	void banShop(BanShopDTO banShopDTO);

	/**
	 * 解禁店铺
	 *
	 * @param shopId
	 */
	void unbanShop(Integer shopId);

	/**
	 * 修改店铺信息
	 *
	 * @param updateShopDTO
	 */
	void updateShopByShopId(UpdateShopDTO updateShopDTO);

	/**
	 * 删除店主
	 *
	 * @param ownerId
	 */
	void deleteOwner(Integer ownerId);
}