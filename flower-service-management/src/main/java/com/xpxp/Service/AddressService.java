package com.xpxp.Service;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file AddressService
 * @author thexpxp233
 * @date 2025/12/9
 * My name is lixiaopei
 **/

import com.xpxp.DTO.AddressAddDTO;
import com.xpxp.DTO.AddressUpdateDTO;
import com.xpxp.VO.AddressVO;

import java.util.List;

public interface AddressService {
	/**
	 * 添加地址
	 *
	 * @param addressAddDTO
	 */
	void addAddress(AddressAddDTO addressAddDTO);


	/**
	 * 获取地址列表
	 *
	 * @return
	 */
	List<AddressVO> listResult();

	/**
	 * 更新 地址
	 *
	 */
	void updateAddress(AddressUpdateDTO addressUpdateDTO);

	/**
	 * 删除地址
	 *
	 */
	void deleteAddress(Integer id);
}