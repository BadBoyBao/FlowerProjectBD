package com.xpxp.mapper;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file ShopMapper
 * @author thexpxp233
 * @date 2025/12/22
 * My name is lixiaopei
 **/

import com.github.pagehelper.Page;
import com.xpxp.Common.PageQueryParm;
import com.xpxp.DTO.BanShopDTO;
import com.xpxp.DTO.ShopUpdateDTO;
import com.xpxp.DTO.UpdateShopDTO;
import com.xpxp.VO.*;
import com.xpxp.entity.Shops;
import com.xpxp.entity.Users;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ShopMapper {
	/**
	 * 添加店主
	 *
	 * @param users
	 */
	void addOwner(Users users);

	/**
	 * 获取所有店主
	 *
	 * @return
	 */
	List<OwnerVO> getAll();

	/**
	 * 分页查询
	 *
	 * @param pageQueryParm
	 * @return
	 */
	Page<OwnerVO> page(PageQueryParm pageQueryParm);

	/**
	 * 添加店铺
	 *
	 * @param shops
	 * @return
	 */
	void addShop(Shops shops);


	/**
	 * 更新用户
	 *
	 * @param userId
	 * @param shopId
	 */
	void updateUser(Integer userId, Integer shopId);


	/**
	 * 分页获取所有店铺
	 *
	 * @return
	 */
	Page<Shops> getAllShop(PageQueryParm pageQueryParm);

	/**
	 * 获取所有店铺
	 *
	 * @return
	 */
	List<ShopVO> GetShopList();

	/**
	 * 获取所有店铺信息和鲜花信息
	 *
	 * @return
	 */
	List<ShopViewVO> getList();

	/**
	 * 根据店铺ID获取鲜花列表
	 *
	 * @param shopId
	 * @return
	 */
	List<FlowerVO> getFlowersByShopId(Integer shopId);

	/**
	 * 获取店铺列表及其鲜花信息
	 *
	 * @return
	 */
	List<ShopViewVO> getListWithFlowers();

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
	@Update("update shops set status=#{status} where shop_id=#{shopId}")
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
	 * 根据店铺ID更新店铺信息
	 *
	 * @param updateShopDTO
	 */
	void updateShopByShopId(UpdateShopDTO updateShopDTO);

	/**
	 * 根据用户ID获取用户信息
	 *
	 * @param ownerId
	 * @return
	 */
	@Select("select * from users where user_id=#{ownerId}")
	Users getByUserId(Integer ownerId);

	/**
	 * 删除店主
	 *
	 * @param ownerId
	 */
	@Delete("delete from users where user_id=#{ownerId}")
	void deleteOwner(Integer ownerId);
}