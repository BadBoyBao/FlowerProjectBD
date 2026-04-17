package com.xpxp.Service.Impl;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file ShoppingServiceImpl
 * @author thexpxp233
 * @date 2025/12/5
 * My name is lixiaopei
 **/

import com.xpxp.DTO.ShoppingCartAddDTO;
import com.xpxp.DTO.ShoppingCartUpdateDTO;
import com.xpxp.Service.ShoppingService;
import com.xpxp.VO.ShoppingCartVO;
import com.xpxp.context.BaseContext;
import com.xpxp.entity.FlowersInventory;
import com.xpxp.entity.ShoppingCart;
import com.xpxp.exception.BusinessException;
import com.xpxp.mapper.InventoryMapper;
import com.xpxp.mapper.ShoppingMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class ShoppingServiceImpl implements ShoppingService {
	@Autowired
	private ShoppingMapper shoppingMapper;
	@Autowired
	private InventoryMapper inventoryMapper;

	@Transactional
	@Override
	public void addCart(ShoppingCartAddDTO shoppingCartAddDTO) {
		// 先查询库存
		FlowersInventory inventory = inventoryMapper.getByFlowerId(shoppingCartAddDTO.getFlowerId());
		if (shoppingCartAddDTO.getQuantity() > inventory.getStockQuantity()) {
			throw new BusinessException("库存不足");
		}
		// 购物车中是否已存在该商品
		ShoppingCart cart = shoppingMapper.getCart(BaseContext.getCurrentId(), shoppingCartAddDTO.getFlowerId());
		if (cart != null) {
			shoppingMapper.update(BaseContext.getCurrentId(), shoppingCartAddDTO.getFlowerId(), shoppingCartAddDTO.getQuantity());
		}
		if (cart == null) {
			// 构建一个购物车项
			ShoppingCart shoppingCart = ShoppingCart.builder()
			                                        .userId(BaseContext.getCurrentId())
			                                        .shopId(shoppingCartAddDTO.getShopId())
			                                        .shopName(shoppingCartAddDTO.getShopName())
			                                        .flowerId(shoppingCartAddDTO.getFlowerId())
			                                        .quantity(shoppingCartAddDTO.getQuantity())
			                                        .selected(1)
			                                        .addedPrice(shoppingCartAddDTO.getPrice())
			                                        .build();
			shoppingMapper.addCart(shoppingCart);
		}
		log.info("添加购物车成功");
		// 减去库存
		inventoryMapper.updateInventory(shoppingCartAddDTO.getFlowerId(), shoppingCartAddDTO.getQuantity());
	}

	/**
	 * 获取购物车列表
	 *
	 * @return
	 */
	@Override
	public List<ShoppingCartVO> listResult() {
		// 通过线程获取当前用户ID
		Long userId = BaseContext.getCurrentId();
		List<ShoppingCartVO> list = shoppingMapper.listResult(userId);
		return list;
	}

	/**
	 * 更新购物车
	 *
	 * @param shoppingCartUpdateDTO
	 * @return
	 */
	@Transactional
	@Override
	public void updateCart(ShoppingCartUpdateDTO shoppingCartUpdateDTO) {
		Long userId = BaseContext.getCurrentId();
		ShoppingCart cart = shoppingMapper.getCart(userId, shoppingCartUpdateDTO.getFlowerId());

		if (cart == null) {
			throw new BusinessException("购物车中没有此商品");
		}

		Integer oldQuantity = cart.getQuantity();
		Integer newQuantity = shoppingCartUpdateDTO.getQuantity();

		if (newQuantity.equals(oldQuantity)) {
			return; // 数量无变化，无需操作
		}

		if (newQuantity > oldQuantity) {
			// 增加商品数量
			FlowersInventory inventory = inventoryMapper.getByFlowerId(shoppingCartUpdateDTO.getFlowerId());
			int diff = newQuantity - oldQuantity;
			if (diff > inventory.getStockQuantity()) {
				throw new BusinessException("库存不足");
			}
			// 使用直接设置数量的方式替代累加
			shoppingMapper.updateSetQuantity(userId, shoppingCartUpdateDTO.getFlowerId(), newQuantity);
			inventoryMapper.updateInventory(shoppingCartUpdateDTO.getFlowerId(), diff);
		} else {
			// 减少商品数量
			int diff = oldQuantity - newQuantity;
			shoppingMapper.updateSetQuantity(userId, shoppingCartUpdateDTO.getFlowerId(), newQuantity);
			// 需要增加库存（因为是减少购物车数量）
			inventoryMapper.increaseInventory(shoppingCartUpdateDTO.getFlowerId(), diff);
		}
	}

	/**
	 * 批量更新购物车选中状态
	 *
	 * @param ids
	 * @param selected
	 */
	@Override
	public void batchUpdateCart(List<Integer> ids, Integer selected) {
		// 当前用户ID
		Long userId = BaseContext.getCurrentId();
		// 遍历ids，查询是否存在
		for (Integer id : ids) {
			ShoppingCart cart = shoppingMapper.getCart(userId, id);
			if (cart == null) {
				throw new BusinessException("购物车中没有此商品");
			}
		}
		//批量更新
		shoppingMapper.batchUpdateCart(userId, ids, selected);
	}

	/**
	 * 清空购物车
	 *
	 * @param
	 */
	@Transactional
	@Override
	public void deleteCart() {
		Long userId = BaseContext.getCurrentId();
		List<ShoppingCartVO> list = shoppingMapper.listResult(userId);
		if (list == null || list.size() == 0) {
			throw new BusinessException("购物车为空");
		}
		for (ShoppingCartVO cart : list) {
			inventoryMapper.increaseInventory(cart.getFlowerId(), cart.getQuantity());
		}
		shoppingMapper.deleteCartByUserId(userId);
	}

	/**
	 * 批量删除购物车项
	 *
	 * @param cartItemId
	 * @return
	 *
	 *
	 */
	@Transactional
	@Override
	public void deleteByCartItemId(List<Integer> cartItemId) {
		//通过线程获取当前用户ID
		Long userId = BaseContext.getCurrentId();
		//遍历cartItemId，查询是否存在
		for (Integer id : cartItemId) {
			ShoppingCart cart = shoppingMapper.getCartByCartItemId(userId, id);
			if (cart == null) {
				throw new BusinessException("购物车中没有此商品");
			}
			inventoryMapper.increaseInventory(cart.getFlowerId(), cart.getQuantity());
		}
		//批量删除
		shoppingMapper.deleteByCartItemId(userId, cartItemId);
	}


}