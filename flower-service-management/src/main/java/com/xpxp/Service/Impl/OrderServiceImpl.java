package com.xpxp.Service.Impl;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file OrderServiceImpl
 * @author thexpxp233
 * @date 2025/12/9
 * My name is lixiaopei
 **/

import cn.hutool.core.date.DateTime;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xpxp.Common.PageResult;
import com.xpxp.DTO.OrderQueryParmDTO;
import com.xpxp.DTO.OrderReviewDTO;
import com.xpxp.DTO.ShoppingCartConfirmDTO;
import com.xpxp.DTO.ShoppingCartSubmitDTO;
import com.xpxp.Service.OrderService;
import com.xpxp.Utils.OrderNoUtils;
import com.xpxp.VO.OrderItemVO;
import com.xpxp.VO.OrderStatusCountVO;
import com.xpxp.VO.OrdersVO;
import com.xpxp.context.BaseContext;
import com.xpxp.entity.OrderItems;
import com.xpxp.entity.Orders;
import com.xpxp.entity.Submit;
import com.xpxp.exception.BusinessException;
import com.xpxp.mapper.InventoryMapper;
import com.xpxp.mapper.OrderMapper;
import com.xpxp.mapper.ShoppingMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private ShoppingMapper shoppingMapper;
	@Autowired
	private InventoryMapper inventoryMapper;

	@Transactional
	@Override
	public Integer submitOrder(ShoppingCartSubmitDTO shoppingCartSubmitDTO) {

		Long userId = BaseContext.getCurrentId();
		Orders order = Orders.builder()
		                     .orderNo(OrderNoUtils.generateOrderNo())
		                     .userId(userId)
		                     .totalAmount(0)
		                     .finalAmount(0)
		                     .shippingAddress("")
		                     .receiverName("")
		                     .receiverPhone("")
		                     .build();
		orderMapper.submitOrder(order);
		//购物车项id集合
		List<Integer> cartItemIdList = new ArrayList<>();
		for (Submit submit : shoppingCartSubmitDTO.getSubmitList()) {
			orderMapper.addOrderItems(order.getOrderId(), submit);
			cartItemIdList.add(submit.getCartItemId());
		}

		//批量删除购物车项
		shoppingMapper.deleteByCartItemId(userId, cartItemIdList);
		return order.getOrderId();
	}

	/**
	 * 获取订单列表
	 *
	 * @return
	 */
	@Override
	public List<Orders> listResult() {
		Long userId = BaseContext.getCurrentId();
		List<Orders> ordersList = orderMapper.listResult(userId);
		log.info("获取订单列表成功：{}", ordersList);
		return ordersList;
	}

	/**
	 * 获取订单项列表
	 *
	 * @return
	 */
	@Override
	public List<OrderItems> OrderItemList() {
		Long userId = BaseContext.getCurrentId();
		Orders orders = orderMapper.getOrderByUserId(userId);
		if (orders == null) {
			throw new BusinessException("没有订单");
		}
		List<OrderItems> orderItemsList = orderMapper.getOrderItemsByOrderId(orders.getOrderId());
		return orderItemsList;
	}

	/**
	 * 确认订单
	 *
	 * @param shoppingCartConfirmDTO
	 * @return
	 *
	 *
	 */
	@Transactional
	@Override
	public void submitOrder(ShoppingCartConfirmDTO shoppingCartConfirmDTO) {
		Long userId = BaseContext.getCurrentId();
		Orders orders = Orders.builder()
		                      .orderId(shoppingCartConfirmDTO.getOrderId())
		                      .totalAmount(shoppingCartConfirmDTO.getTotalAmount())
		                      .shippingFee(shoppingCartConfirmDTO.getShippingFee())
		                      .finalAmount(shoppingCartConfirmDTO.getFinalAmount())
		                      .paymentMethod(shoppingCartConfirmDTO.getPaymentMethod())
		                      .shippingAddress(shoppingCartConfirmDTO.getAddress())
		                      .receiverName(shoppingCartConfirmDTO.getName())
		                      .receiverPhone(shoppingCartConfirmDTO.getPhone())
		                      .orderNotes(shoppingCartConfirmDTO.getRemark())
		                      .paymentStatus(1)
		                      .orderStatus(1)
		                      .updatedAt(DateTime.now())
		                      .build();
		log.info("订单确认信息：{}，用户Id：{}", orders, userId);
		orderMapper.confirmOrder(userId, orders);
	}

	/**
	 * 获取用户订单列表
	 *
	 * @return
	 */
	@Override
	public List<Orders> orderList() {
		Long userId = BaseContext.getCurrentId();
		List<Orders> ordersList = orderMapper.orderList(userId);
		return ordersList;
	}


	/**
	 * 获取用户指定订单
	 *
	 * @param orderId
	 * @return
	 */
	@Override
	public Orders getOrderById(Integer orderId) {
		Long userId = BaseContext.getCurrentId();
		Orders order = orderMapper.getOrderById(userId, orderId);
		return order;
	}

	/**
	 * 支付订单
	 *
	 * @param orderId
	 */
	@Transactional
	@Override
	public void payOrder(Integer orderId) {
		//通过线程池获取当前用户Id
		Long userId = BaseContext.getCurrentId();
		Orders order = orderMapper.getOrderById(userId, orderId);
		if (order == null) {
			throw new BusinessException("订单不存在");
		}
		if (order.getOrderStatus() != 1) {
			throw new BusinessException("订单状态错误");
		}
		if (order.getPaymentStatus() != 1) {
			throw new BusinessException("订单支付状态");
		}
		Orders orders = Orders.builder()
		                      .orderId(orderId)
		                      .userId(userId)
		                      .paymentStatus(2)
		                      .orderStatus(2)
		                      .paidTime(DateTime.now())
		                      .updatedAt(DateTime.now())
		                      .build();
		//更新订单状态
		orderMapper.update(orders);
		//更新订单项状态
		orderMapper.updateItems(orderId, 2);

	}

	/**
	 * 删除订单
	 *
	 * @param orderId
	 */
	@Transactional
	@Override
	public void deleteOrder(Integer orderId) {
		Long userId = BaseContext.getCurrentId();
		Orders order = orderMapper.getOrderById(userId, orderId);
		if (order == null) {
			throw new BusinessException("订单不存在");
		}
		if (order.getOrderStatus() != 0) {
			throw new BusinessException("订单状态错误");
		}
		List<OrderItems> orderItemsList = orderMapper.getOrderItemsByOrderId(orderId);
		for (OrderItems orderItems : orderItemsList) {
			inventoryMapper.increaseInventory(orderItems.getFlowerId(), orderItems.getQuantity());
		}
		orderMapper.deleteOrderItemsById(orderId);
		orderMapper.deleteOrderById(userId, orderId);

	}

	/**
	 *
	 * 分页查询
	 *
	 * @param orderQueryParmDTO
	 * @return
	 */

	@Override
	public PageResult page(OrderQueryParmDTO orderQueryParmDTO) {
		PageHelper.startPage(orderQueryParmDTO.getPage(), orderQueryParmDTO.getPageSize());
		Page<OrdersVO> page = orderMapper.page(orderQueryParmDTO);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 取消订单
	 *
	 * @param orderId
	 * @param cancelReason
	 */
	@Transactional
	@Override
	public void cancelOrder(Integer orderId, String cancelReason) {
		Long userId = BaseContext.getCurrentId();
		Orders order = orderMapper.getOrderById(userId, orderId);
		if (order == null) {
			throw new BusinessException("订单不存在");
		}
		Orders orders = Orders.builder()
		                      .orderId(orderId)
		                      .userId(userId)
		                      .paymentStatus(4)
		                      .orderStatus(6)
		                      .cancelledTime(DateTime.now())
		                      .updatedAt(DateTime.now())
		                      .cancellationReason(cancelReason)
		                      .build();
		List<OrderItems> orderItemsList = orderMapper.getOrderItemsByOrderId(orderId);
		for (OrderItems orderItems : orderItemsList) {
			inventoryMapper.increaseInventory(orderItems.getFlowerId(), orderItems.getQuantity());
		}
		log.info("取消订单信息：{}", orders);
		orderMapper.updateByOrderId(orders);
		orderMapper.updateOrderItemsStatus(orderId);
	}

	/**
	 * 拒绝订单
	 *
	 * @param orderId
	 * @param rejectionReason
	 */
	@Transactional
	@Override
	public void rejection(Integer orderId, String rejectionReason) {
		Orders order = orderMapper.getOrderByOrderId(orderId);
		if (order == null) {
			throw new BusinessException("订单不存在");
		}
		Orders orders = Orders.builder()
		                      .orderId(orderId)
		                      .paymentStatus(4)
		                      .orderStatus(6)
		                      .rejectionReason(rejectionReason)
		                      .cancelledTime(DateTime.now())
		                      .updatedAt(DateTime.now())
		                      .build();
		List<OrderItems> orderItemsList = orderMapper.getOrderItemsByOrderId(orderId);
		for (OrderItems orderItems : orderItemsList) {
			inventoryMapper.increaseInventory(orderItems.getFlowerId(), orderItems.getQuantity());
		}
		orderMapper.updateByOrderId(orders);
	}

	/**
	 * 统计订单状态
	 */
	@Override
	public List<OrderStatusCountVO> CountStatus(Integer shopId) {
		List<OrderStatusCountVO> orderStatusCountVOList = orderMapper.CountStatus(shopId);
		return orderStatusCountVOList;
	}

	/**
	 * 接单
	 *
	 * @param orderId
	 */
	@Override
	public void accept(Integer orderId, Integer shopId) {
		Orders order = orderMapper.getOrderByOrderId(orderId);
		if (order == null) {
			throw new BusinessException("订单不存在");
		}
		if (order.getPaymentStatus() != 2) {
			throw new BusinessException("订单未支付");
		}
		if (order.getOrderStatus() != 2) {
			throw new BusinessException("订单状态错误");
		}
		if (order.getReceiverName() == null || order.getReceiverPhone() == null || order.getShippingAddress() == null) {
			throw new BusinessException("收货信息不完整");
		}
		OrderItems items = OrderItems.builder()
		                             .orderId(orderId)
		                             .shopId(shopId)
		                             .shopStatus(3)
		                             .shopUpdatedAt(DateTime.now())
		                             .build();
		orderMapper.batchUpdateOrderItems(items);
		/**
		 * 更新订单状态
		 */
		//检查订单项所有商家订单项状态是否都为3
		List<OrderItems> orderItemsList = orderMapper.getStatus(orderId, shopId);
		if (orderItemsList.size() == orderItemsList.stream()
		                                           .filter(item -> item.getShopStatus() == 3)
		                                           .count()) {
			Orders orders = Orders.builder()
			                      .orderId(orderId)
			                      .orderStatus(3)
			                      .updatedAt(DateTime.now())
			                      .build();
			orderMapper.updateByOrderId(orders);
		}


	}

	/**
	 * 发货
	 *
	 * @param orderId
	 */

	@Override
	public void deliver(Integer orderId, Integer shopId) {
		Orders order = orderMapper.getOrderByOrderId(orderId);
		if (order == null) {
			throw new BusinessException("订单不存在");
		}
		if (order.getOrderStatus() != 3) {
			throw new BusinessException("未接单，订单状态错误");
		}
		if (order.getReceiverName() == null || order.getReceiverPhone() == null || order.getShippingAddress() == null) {
			throw new BusinessException("收货信息不完整");
		}

		OrderItems items = OrderItems.builder()
		                             .orderId(orderId)
		                             .shopId(shopId)
		                             .shopStatus(4)
		                             .shopUpdatedAt(DateTime.now())
		                             .build();
		orderMapper.batchUpdateOrderItems(items);

		/**
		 * 更新订单状态
		 */
		//检查订单项所有商家订单项状态是否都为3
		List<OrderItems> orderItemsList = orderMapper.getStatus(orderId, shopId);
		if (orderItemsList.size() == orderItemsList.stream()
		                                           .filter(item -> item.getShopStatus() == 4)
		                                           .count()) {
			Orders orders = Orders.builder()
			                      .orderId(orderId)
			                      .orderStatus(4)
			                      .updatedAt(DateTime.now())
			                      .build();
			orderMapper.updateByOrderId(orders);
		}


	}

	/**
	 * 完成订单
	 *
	 * @param orderId
	 */
	@Transactional
	@Override
	public void complete(Integer orderId, Integer shopId) {
		Orders order = orderMapper.getOrderByOrderId(orderId);
		if (order == null) {
			throw new BusinessException("订单不存在");
		}
		if (order.getOrderStatus() != 4) {
			throw new BusinessException("订单不处于配送状态");
		}
		Integer id = order.getOrderId();
		List<OrderItems> orderItemsList = orderMapper.getOrderItemsByOrderId(id);
		//增加库存表中对应鲜花销售量
		for (OrderItems orderItems : orderItemsList) {
			inventoryMapper.AddSold(orderItems.getFlowerId(), orderItems.getQuantity());
		}
		//更新订单项状态为完成
		OrderItems items = OrderItems.builder()
		                             .orderId(orderId)
		                             .shopId(shopId)
		                             .shopStatus(5)
		                             .shopUpdatedAt(DateTime.now())
		                             .build();
		orderMapper.batchUpdateOrderItems(items);

		/**
		 * 订单项所有商家订单项状态都为5时，更新订单状态为完成
		 */
		List<OrderItems> orderItemsList1 = orderMapper.getStatus(orderId, shopId);
		if (orderItemsList1.size() == orderItemsList1.stream()
		                                             .filter(item -> item.getShopStatus() == 5)
		                                             .count()) {
			Orders orders = Orders.builder()
			                      .orderId(orderId)
			                      .orderStatus(5)
			                      .updatedAt(DateTime.now())
			                      .build();
			orderMapper.updateByOrderId(orders);
		}

	}

	/**
	 * 获取订单项
	 *
	 * @param orderId
	 * @return
	 */
	@Override
	public List<OrderItemVO> getOrderItemsByOrderId(Integer orderId) {
		List<OrderItemVO> list = orderMapper.getOrderDetail(orderId);
		return list;
	}

	/**
	 * 获取订单项
	 *
	 * @param orderId
	 * @param shopId
	 * @return
	 */
	@Override
	public List<OrderItemVO> getOrderItemsByOrderIdAndShopId(Integer orderId, Integer shopId) {
		List<OrderItemVO> list = orderMapper.getOrderItemsByOrderIdAndShopId(orderId, shopId);
		return list;
	}

	/**
	 * 评价订单
	 *
	 * @param orderReviewDTO
	 */
	@Transactional
	@Override
	public void review(OrderReviewDTO orderReviewDTO) {
		Long userId = BaseContext.getCurrentId();
		OrderItems items = orderMapper.getByFlowerIdAndOrderId(orderReviewDTO.getFlowerId(), orderReviewDTO.getOrderId());
		if (items.getShopStatus() != 5) {
			throw new BusinessException("订单未完成，不能评价");
		}
		orderMapper.updateByFlowerIdAndOrderId(orderReviewDTO.getFlowerId(), orderReviewDTO.getOrderId());

		orderMapper.review(userId, orderReviewDTO);
	}


}