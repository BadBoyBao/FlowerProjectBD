package com.xpxp.Controller.Admin;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file AdminOrderController
 * @author thexpxp233
 * @date 2025/12/11
 * My name is lixiaopei
 **/

import com.xpxp.Common.PageResult;
import com.xpxp.Common.Result;
import com.xpxp.DTO.OrderQueryParmDTO;
import com.xpxp.Service.OrderService;
import com.xpxp.VO.OrderItemVO;
import com.xpxp.VO.OrderStatusCountVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/order")
@Tag(name = "订单管理")
@Slf4j
public class AdminOrderController {

	@Autowired
	private OrderService orderService;

	/**
	 * 订单列表
	 *
	 * @param orderQueryParmDTO
	 * @return
	 */
	@GetMapping("/page")
	@Operation(summary = "订单列表")
	public Result<PageResult> listResult(OrderQueryParmDTO orderQueryParmDTO) {
		PageResult pageResult = orderService.page(orderQueryParmDTO);
		return Result.success(pageResult);
	}

	@GetMapping("/{orderId}/{shopId}")
	@Operation(summary = "订单详情")
	public Result<List<OrderItemVO>> getOrderItemsByOrderIdAndShopId(@PathVariable Integer orderId, @PathVariable Integer shopId) {
		List<OrderItemVO> list = orderService.getOrderItemsByOrderIdAndShopId(orderId, shopId);
		return Result.success(list);
	}


	/**
	 * 订单状态统计
	 *
	 * @return
	 */
	@GetMapping("/count/countStatus/{shopId}")
	@Operation(summary = "订单状态统计")
	public Result<List<OrderStatusCountVO>> CountStatus(@PathVariable Integer shopId) {
		List<OrderStatusCountVO> orderStatusCountVOList = orderService.CountStatus(shopId);
		return Result.success(orderStatusCountVOList);
	}

	/**
	 * 订单拒绝
	 *
	 * @param orderId
	 * @param rejectionReason
	 * @return
	 */
	@PostMapping("/rejection/{orderId}")
	@Operation(summary = "订单拒绝")
	public Result rejection(@PathVariable Integer orderId, @RequestBody String rejectionReason) {
		log.info("订单拒绝：{},拒绝原因：{}", orderId, rejectionReason);
		orderService.rejection(orderId, rejectionReason);
		return Result.success();
	}


	/**
	 * 接单
	 *
	 * @param orderId
	 * @return
	 *
	 */
	@PostMapping("/accept/{orderId}/{shopId}")
	@Operation(summary = "接单")
	public Result accept(@PathVariable Integer orderId, @PathVariable Integer shopId) {
		log.info("接单操作，订单ID：{}，商家ID：{}", orderId, shopId);
		orderService.accept(orderId, shopId);
		return Result.success();
	}

	/**
	 * 发货
	 *
	 * @param orderId
	 * @return
	 */
	@PostMapping("/deliver/{orderId}/{shopId}")
	@Operation(summary = "发货")
	public Result deliver(@PathVariable Integer orderId, @PathVariable Integer shopId) {
		log.info("发货：{}", orderId);
		orderService.deliver(orderId, shopId);
		return Result.success();
	}

	/**
	 * 完成订单
	 *
	 * @param orderId
	 * @return
	 */
	@PostMapping("/complete/{orderId}/{shopId}")
	@Operation(summary = "完成订单")
	public Result complete(@PathVariable Integer orderId, @PathVariable Integer shopId) {
		log.info("完成订单：{}", orderId);
		orderService.complete(orderId, shopId);
		return Result.success();
	}
}