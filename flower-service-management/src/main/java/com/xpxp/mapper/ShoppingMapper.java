package com.xpxp.mapper;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file ShoppingMapper
 * @author thexpxp233
 * @date 2025/12/5
 * My name is lixiaopei
 **/

import com.xpxp.VO.ShoppingCartVO;
import com.xpxp.entity.ShoppingCart;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShoppingMapper {

	/**
	 * 添加购物车
	 *
	 * @param shoppingCart
	 * @return
	 */
	void addCart(ShoppingCart shoppingCart);

	/**
	 * 根据用户ID和鲜花ID查询购物车项
	 *
	 * @param userId
	 * @param flowerId
	 * @return
	 */
	ShoppingCart getCart(Long userId, Integer flowerId);


	/**
	 * 更新购物车项
	 *
	 * @param userId
	 * @param flowerId
	 * @param quantity
	 */
	void update(Long userId, Integer flowerId, Integer quantity);


	/**
	 * 获取购物车列表
	 *
	 * @param userId
	 * @return
	 */
	List<ShoppingCartVO> listResult(Long userId);

	/**
	 * 直接设置购物车项数量
	 *
	 * @param userId
	 * @param flowerId
	 * @param quantity
	 */
	void updateSetQuantity(Long userId, Integer flowerId, Integer quantity);


	/**
	 * 批量更新购物车项
	 *
	 * @param userId
	 * @param ids
	 * @param selected
	 */
	void batchUpdateCart(Long userId, List<Integer> ids, Integer selected);

	/**
	 * 清空购物车项
	 *
	 * @param userId
	 */
	@Delete("delete from shoppingcart where user_id = #{userId}")
	void deleteCartByUserId(Long userId);


	/**
	 * 批量删除购物车项
	 *
	 * @param userId
	 * @param cartItemId
	 */
	void deleteByCartItemId(Long userId, List<Integer> cartItemId);

	/**
	 * 根据购物车项ID查询购物车项
	 *
	 * @param userId
	 * @param id
	 * @return 购物车项
	 *
	 */
	ShoppingCart getCartByCartItemId(Long userId, Integer id);


}