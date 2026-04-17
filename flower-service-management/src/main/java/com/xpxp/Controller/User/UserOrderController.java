package com.xpxp.Controller.User;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file UserOrderController
 * @author thexpxp233
 * @date 2025/12/9
 * My name is lixiaopei
 **/

import com.xpxp.Common.Result;
import com.xpxp.DTO.OrderReviewDTO;
import com.xpxp.DTO.ShoppingCartConfirmDTO;
import com.xpxp.Service.OrderService;
import com.xpxp.VO.OrderItemVO;
import com.xpxp.entity.OrderItems;
import com.xpxp.entity.Orders;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user/order")
@Slf4j
@Tag(name = "用户订单接口")
public class UserOrderController {
	@Autowired
	private OrderService orderService;

	/**
	 * 获取用户所有订单
	 *
	 * @return
	 */

	@GetMapping("/orderList")
	@Operation(summary = "获取用户订单列表")
	public Result<List<Orders>> orderList() {
		List<Orders> list = orderService.orderList();
		return Result.success(list);
	}

	/**
	 * 获取用户订单项
	 *
	 * @param orderId
	 * @return
	 */
	@GetMapping("/orderList/{orderId}")
	@Operation(summary = "获取用户订单项")
	public Result<List<OrderItemVO>> getOrderItemsByOrderId(@PathVariable Integer orderId) {
		List<OrderItemVO> list = orderService.getOrderItemsByOrderId(orderId);
		return Result.success(list);
	}

	/**
	 * 获取用户指定ID订单
	 *
	 * @param orderId
	 * @return
	 */
	@GetMapping("{orderId}")
	@Operation(summary = "获取用户指定ID订单")
	public Result<Orders> getOrderById(@PathVariable Integer orderId) {
		log.info("获取用户指定ID订单：{}", orderId);
		Orders order = orderService.getOrderById(orderId);
		return Result.success(order);
	}

	/**
	 * 获取用户未确认订单列表
	 *
	 * @return
	 */
	@GetMapping("/list")
	@Operation(summary = "获取用户未确认订单列表")
	public Result<List<Orders>> listResult() {
		List<Orders> list = orderService.listResult();
		return Result.success(list);
	}

	/**
	 * 获取用户订单项列表
	 *
	 * @return
	 */
	@GetMapping("/OrderItemList")
	@Operation(summary = "获取用户订单项列表")
	public Result<List<OrderItems>> OrderItemList() {
		List<OrderItems> list = orderService.OrderItemList();
		return Result.success(list);
	}


	/**
	 * 删除订单
	 *
	 * @param orderId
	 * @return
	 */
	@DeleteMapping("/{orderId}")
	@Operation(summary = "删除订单")
	public Result deleteOrder(@PathVariable Integer orderId) {
		log.info("删除订单：{}", orderId);
		orderService.deleteOrder(orderId);
		return Result.success();
	}

	/**
	 * 确认订单
	 *
	 * @param shoppingCartConfirmDTO
	 * @return
	 */
	@PostMapping("/confirm")
	@Operation(summary = "确认订单")
	public Result confirm(@RequestBody ShoppingCartConfirmDTO shoppingCartConfirmDTO) {
		log.info("用户确认订单：{}", shoppingCartConfirmDTO);
		orderService.submitOrder(shoppingCartConfirmDTO);
		return Result.success();
	}

	/**
	 *
	 * 支付订单
	 */
	@PostMapping("/payOrder/{orderId}")
	@Operation(summary = "支付订单")
	public Result payOrder(@PathVariable Integer orderId) {
		log.info("用户支付订单：{}", orderId);
		orderService.payOrder(orderId);
		return Result.success();
	}

	/**
	 * 取消订单
	 *
	 * @param orderId
	 * @param cancelReason
	 * @return
	 */
	@PostMapping("/cancelOrder/{orderId}")
	@Operation(summary = "取消订单")
	public Result cancelOrder(@PathVariable Integer orderId, @RequestBody String cancelReason) {
		log.info("用户取消订单：{},取消原因：{}", orderId, cancelReason);
		orderService.cancelOrder(orderId, cancelReason);
		return Result.success();
	}


	/**
	 * 评价订单
	 *
	 * @param orderReviewDTO
	 * @return
	 */
	@PostMapping("/evaluate")
	@Operation(summary = "评价订单")
	@CacheEvict(value = "flowerReviewCache", key = "#orderReviewDTO.flowerId")
	public Result review(@RequestBody OrderReviewDTO orderReviewDTO) {
		log.info("用户评价订单：{}", orderReviewDTO);
		orderService.review(orderReviewDTO);
		return Result.success();
	}
}