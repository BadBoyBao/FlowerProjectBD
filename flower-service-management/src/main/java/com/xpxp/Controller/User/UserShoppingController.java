package com.xpxp.Controller.User;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file UserShoppingController
 * @author thexpxp233
 * @date 2025/12/5
 * My name is lixiaopei
 **/

import com.xpxp.Common.Result;
import com.xpxp.DTO.ShoppingCartAddDTO;
import com.xpxp.DTO.ShoppingCartSubmitDTO;
import com.xpxp.DTO.ShoppingCartUpdateDTO;
import com.xpxp.Service.OrderService;
import com.xpxp.Service.ShoppingService;
import com.xpxp.VO.ShoppingCartVO;
import com.xpxp.context.BaseContext;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/shopping")
@Tag(name = "用户购物车模块")
@Slf4j
public class UserShoppingController {

	@Autowired
	private ShoppingService shoppingService;
	@Autowired
	private OrderService orderService;

	/**
	 * 添加购物车
	 *
	 * @param shoppingCartAddDTO
	 * @return
	 */
	@PostMapping("/addCart")
	@Operation(summary = "添加购物车")
	public Result addCart(@RequestBody ShoppingCartAddDTO shoppingCartAddDTO) {
		log.info("添加购物车:{}", shoppingCartAddDTO);
		shoppingService.addCart(shoppingCartAddDTO);
		return Result.success();
	}


	/**
	 * 获取购物车列表
	 *
	 * @return
	 */
	@GetMapping("/list")
	@Operation(summary = "获取个人购物车列表")
	public Result<List<ShoppingCartVO>> listResult() {
		List<ShoppingCartVO> list = shoppingService.listResult();
		return Result.success(list);
	}

	@PutMapping
	@Operation(summary = "更新购物车")
	public Result updateCart(@RequestBody ShoppingCartUpdateDTO shoppingCartUpdateDTO) {
		log.info("更新购物车:{}", shoppingCartUpdateDTO);
		shoppingService.updateCart(shoppingCartUpdateDTO);
		return Result.success();
	}

	/**
	 * 批量更新购物车选中状态
	 *
	 * @param ids
	 * @param selected
	 * @return
	 */
	@PutMapping("/batchUpdate/{ids}/{selected}")
	@Operation(summary = "批量更新购物车选中状态")
	public Result batchUpdateCart(@PathVariable List<Integer> ids, @PathVariable Integer selected) {
		shoppingService.batchUpdateCart(ids, selected);
		return Result.success();
	}

	/**
	 * 删除购物车项
	 *
	 * @param cartItemId
	 * @return
	 */
	@DeleteMapping("/deleteCart/{cartItemId}")
	@Operation(summary = "删除购物车项")
	public Result deleteCart(@PathVariable List<Integer> cartItemId) {
		log.info("删除购物车项:{}", cartItemId);
		shoppingService.deleteByCartItemId(cartItemId);
		return Result.success();
	}

	@DeleteMapping("/deleteUserCart")
	@Operation(summary = "删除当前购物车")
	public Result deleteUserCart() {
		log.info("删除当前用户购物车：{}", BaseContext.getCurrentId());
		shoppingService.deleteCart();
		return Result.success();
	}

	@GetMapping("/getByFlowerId/{flowerId}")
	@Operation(summary = "根据鲜花ID查询购物车项")
	public Result getByFlowerId(@PathVariable Integer flowerId) {
		log.info("根据鲜花ID查询购物车项:{}", flowerId);
//		FlowersInventory inventory = shoppingService.getByFlowerId(flowerId);
		return Result.success();
	}

	/**
	 * 提交购物车
	 *
	 * @return
	 */
	@PostMapping("/submitOrder")
	@Operation(summary = "提交购物车")
	public Result submitCart(@RequestBody ShoppingCartSubmitDTO shoppingCartSubmitDTO) {
		log.info("提交购物车:{}", shoppingCartSubmitDTO.getSubmitList());

		Integer orderId = orderService.submitOrder(shoppingCartSubmitDTO);
		return Result.success(orderId);
	}
}