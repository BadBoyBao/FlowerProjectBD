package com.xpxp.mapper;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file OrderMapper
 * @author thexpxp233
 * @date 2025/12/9
 * My name is lixiaopei
 **/

import com.github.pagehelper.Page;
import com.xpxp.DTO.OrderQueryParmDTO;
import com.xpxp.DTO.OrderReviewDTO;
import com.xpxp.VO.OrderItemVO;
import com.xpxp.VO.OrderStatusCountVO;
import com.xpxp.VO.OrdersVO;
import com.xpxp.entity.OrderItems;
import com.xpxp.entity.Orders;
import com.xpxp.entity.Submit;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface OrderMapper {
	/**
	 * 提交订单
	 *
	 * @param order
	 * @return
	 */
	void submitOrder(Orders order);

	/**
	 * 添加订单项
	 *
	 * @param orderId
	 * @param submit
	 */
	void addOrderItems(@Param("orderId") Integer orderId, @Param("submit") Submit submit);

	/**
	 * 获取订单结果
	 *
	 * @param userId
	 * @return
	 */
	List<Orders> listResult(Long userId);

	/**
	 * 获取用户订单
	 *
	 * @param userId
	 * @return
	 */
	Orders getOrderByUserId(Long userId);

	/**
	 * 获取订单项
	 *
	 * @param orderId
	 * @return
	 */
	List<OrderItems> getOrderItemsByOrderId(Integer orderId);

	/**
	 * 确认订单
	 *
	 * @param userId
	 * @param orders
	 */
	void confirmOrder(Long userId, Orders orders);


	/**
	 * 获取用户订单列表
	 *
	 * @param userId
	 * @return
	 */
	List<Orders> orderList(Long userId);

	/**
	 * 获取用户指定订单
	 *
	 * @param userId
	 * @param orderId
	 * @return
	 */
	Orders getOrderById(Long userId, Integer orderId);

	/**
	 * 更新订单状态
	 *
	 * @param orders
	 * @return
	 *
	 */
	void update(Orders orders);

	/**
	 * 删除用户指定订单
	 *
	 * @param userId
	 * @param orderId
	 */
	void deleteOrderById(Long userId, Integer orderId);

	/**
	 * 删除用户指定订单项
	 *
	 * @param orderId
	 *
	 */
	void deleteOrderItemsById(Integer orderId);

	/**
	 * 获取订单列表,分页查询
	 *
	 * @return
	 */
	Page<OrdersVO> page(OrderQueryParmDTO orderQueryParmDTO);

	/**
	 * 根据订单ID更新订单信息
	 *
	 * @param orders
	 */
	void updateByOrderId(Orders orders);

	/**
	 * 根据订单ID获取订单信息
	 *
	 * @param orderId
	 * @return
	 */
	Orders getOrderByOrderId(Integer orderId);

	/**
	 * 统计订单状态数量
	 *
	 * @return
	 *
	 */
	List<OrderStatusCountVO> CountStatus(Integer shopId);


	/**
	 * 获取订单详情
	 *
	 * @param orderId
	 * @return
	 */
	List<OrderItemVO> getOrderDetail(Integer orderId);

	@Update("update order_items set shop_status  = #{status} where order_id = #{orderId}")
	void updateItems(Integer orderId, Integer status);

	/**
	 * 获取订单详情
	 *
	 * @param orderId
	 * @param shopId
	 * @return
	 */
	List<OrderItemVO> getOrderItemsByOrderIdAndShopId(Integer orderId, Integer shopId);

	/**
	 * 批量更新订单项
	 *
	 * @param items
	 * @return
	 */
	@Update("update order_items set shop_status  = #{shopStatus} where order_id = #{orderId} AND shop_id = #{shopId}")
	int batchUpdateOrderItems(OrderItems items);


	/**
	 * 获取订单状态
	 *
	 * @param orderId
	 * @param shopId
	 * @return
	 */
	@Select("select * from order_items where order_id = #{orderId} AND shop_id = #{shopId}")
	List<OrderItems> getStatus(Integer orderId, Integer shopId);

	/**
	 * 获取订单项
	 *
	 * @param flowerId
	 * @param orderId
	 * @return
	 */
	@Select("select * from order_items where flower_id = #{flowerId} AND order_id = #{orderId}")
	OrderItems getByFlowerIdAndOrderId(Integer flowerId, Integer orderId);

	/**
	 * 更新订单项状态为已评价-7
	 *
	 * @param flowerId
	 * @param orderId
	 * @return
	 */
	@Update("update order_items set shop_status  = 7 where flower_id = #{flowerId} AND order_id = #{orderId}")
	void updateByFlowerIdAndOrderId(Integer flowerId, Integer orderId);

	/**
	 * 评价订单项
	 *
	 * @param orderReviewDTO
	 */
	void review(Long userId, @Param("orderReviewDTO") OrderReviewDTO orderReviewDTO);

	/**
	 * 更新订单项状态为取消 -6
	 *
	 * @param orderId
	 */
	@Update("update order_items set shop_status  = 6 where order_id = #{orderId}")
	void updateOrderItemsStatus(Integer orderId);
}