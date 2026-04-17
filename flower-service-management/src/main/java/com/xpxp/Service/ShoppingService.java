package com.xpxp.Service;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file ShoppingService
 * @author thexpxp233
 * @date 2025/12/5
 * My name is lixiaopei
 **/

import com.xpxp.DTO.ShoppingCartAddDTO;
import com.xpxp.DTO.ShoppingCartUpdateDTO;
import com.xpxp.VO.ShoppingCartVO;

import java.util.List;

public interface ShoppingService {

	/**
	 * 添加购物车
	 *
	 * @param shoppingCartAddDTO
	 */
	void addCart(ShoppingCartAddDTO shoppingCartAddDTO);


	/**
	 * 获取购物车列表
	 *
	 * @return
	 */
	List<ShoppingCartVO> listResult();

	/**
	 * 更新购物车
	 *
	 * @param shoppingCartUpdateDTO
	 */
	void updateCart(ShoppingCartUpdateDTO shoppingCartUpdateDTO);

	/**
	 * 批量更新购物车选中状态
	 *
	 * @param ids
	 * @param selected
	 */
	void batchUpdateCart(List<Integer> ids, Integer selected);

	/**
	 * 清空购物车
	 *
	 * @param
	 */
	void deleteCart();

	/**
	 * 批量删除购物车项
	 *
	 * @param cartItemId
	 * @return
	 *
	 *
	 */
	void deleteByCartItemId(List<Integer> cartItemId);


}