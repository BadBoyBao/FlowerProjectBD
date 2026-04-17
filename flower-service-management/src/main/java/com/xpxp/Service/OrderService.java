package com.xpxp.Service;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file OrderService
 * @author thexpxp233
 * @date 2025/12/9
 * My name is lixiaopei
 **/


import com.xpxp.Common.PageResult;
import com.xpxp.DTO.OrderQueryParmDTO;
import com.xpxp.DTO.OrderReviewDTO;
import com.xpxp.DTO.ShoppingCartConfirmDTO;
import com.xpxp.DTO.ShoppingCartSubmitDTO;
import com.xpxp.VO.OrderItemVO;
import com.xpxp.VO.OrderStatusCountVO;
import com.xpxp.entity.OrderItems;
import com.xpxp.entity.Orders;

import java.util.List;

public interface OrderService {

	/**
	 * 提交订单
	 *
	 * @param shoppingCartSubmitDTO
	 * @return
	 */
	Integer submitOrder(ShoppingCartSubmitDTO shoppingCartSubmitDTO);

	/**
	 * 获取订单列表
	 *
	 * @return
	 */
	List<Orders> listResult();

	/**
	 * 获取订单项列表
	 *
	 * @return
	 */
	List<OrderItems> OrderItemList();

	/**
	 * 确认订单
	 *
	 * @param shoppingCartConfirmDTO
	 */
	void submitOrder(ShoppingCartConfirmDTO shoppingCartConfirmDTO);


	/**
	 * 获取用户订单列表
	 *
	 * @return
	 */
	List<Orders> orderList();


	/**
	 * 获取用户指定订单
	 *
	 * @param orderId
	 * @return
	 */
	Orders getOrderById(Integer orderId);

	/**
	 * 支付订单
	 *
	 * @param orderId
	 */
	void payOrder(Integer orderId);

	/**
	 * 删除订单
	 *
	 * @param orderId
	 */
	void deleteOrder(Integer orderId);

	/**
	 * 分页查询
	 *
	 * @param orderQueryParmDTO
	 * @return
	 */
	PageResult page(OrderQueryParmDTO orderQueryParmDTO);

	/**
	 * 取消订单
	 *
	 * @param orderId
	 * @param cancelReason
	 */
	void cancelOrder(Integer orderId, String cancelReason);

	/**
	 * 拒绝订单
	 *
	 * @param orderId
	 * @param rejectionReason
	 */
	void rejection(Integer orderId, String rejectionReason);


	/**
	 * 统计订单状态
	 *
	 * @return
	 */
	List<OrderStatusCountVO> CountStatus(Integer shopId);

	/**
	 * 接单
	 *
	 * @param orderId
	 */
	void accept(Integer orderId, Integer shopId);

	/**
	 * 发货
	 *
	 * @param orderId
	 */
	void deliver(Integer orderId, Integer shopId);

	/**
	 * 完成订单
	 *
	 * @param orderId
	 */
	void complete(Integer orderId, Integer shopId);


	/**
	 * 获取用户订单项
	 *
	 * @param orderId
	 * @return
	 */
	List<OrderItemVO> getOrderItemsByOrderId(Integer orderId);

	/**
	 * 获取店铺指定订单项
	 *
	 * @param orderId
	 * @param shopId
	 * @return
	 */
	List<OrderItemVO> getOrderItemsByOrderIdAndShopId(Integer orderId, Integer shopId);

	/**
	 * 评价订单
	 *
	 * @param orderReviewDTO
	 */
	void review(OrderReviewDTO orderReviewDTO);
}