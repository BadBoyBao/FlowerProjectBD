package com.xpxp.Controller.User;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file UserAddressController
 * @author thexpxp233
 * @date 2025/12/9
 * My name is lixiaopei
 **/

import com.xpxp.Common.Result;
import com.xpxp.DTO.AddressAddDTO;
import com.xpxp.DTO.AddressUpdateDTO;
import com.xpxp.Service.AddressService;
import com.xpxp.VO.AddressVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/address")
@Slf4j
@Tag(name = "用户地址管理")
public class UserAddressController {

	@Autowired
	private AddressService addressService;


	@GetMapping("/list")
	@Operation(summary = "获取地址列表")
	public Result<List<AddressVO>> listResult() {
		List<AddressVO> list = addressService.listResult();
		return Result.success(list);
	}

	/**
	 * 添加地址
	 *
	 * @param addressAddDTO
	 * @return
	 */
	@PostMapping("/add")
	@Operation(summary = "添加地址")
	public Result addAddress(@RequestBody AddressAddDTO addressAddDTO) {
//		log.info("添加地址:{}", addressAddDTO);
		addressService.addAddress(addressAddDTO);
		return Result.success();
	}

	/**
	 * 更新 地址
	 *
	 * @param addressUpdateDTO
	 */
	@PostMapping("/update")
	@Operation(summary = "更新地址")
	public Result updateAddress(@RequestBody AddressUpdateDTO addressUpdateDTO) {
		log.info("更新地址:{}", addressUpdateDTO);
		addressService.updateAddress(addressUpdateDTO);
		return Result.success();
	}

	/**
	 * 删除 地址
	 *
	 * @param id
	 */
	@DeleteMapping("/delete/{id}")
	@Operation(summary = "删除地址")
	public Result deleteAddress(@PathVariable Integer id) {
		log.info("删除地址:{}", id);
		addressService.deleteAddress(id);
		return Result.success();
	}
}