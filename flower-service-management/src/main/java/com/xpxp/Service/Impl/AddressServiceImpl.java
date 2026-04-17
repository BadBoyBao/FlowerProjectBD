package com.xpxp.Service.Impl;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file AddressServiceImpl
 * @author thexpxp233
 * @date 2025/12/9
 * My name is lixiaopei
 **/

import cn.hutool.core.bean.BeanUtil;
import com.xpxp.DTO.AddressAddDTO;
import com.xpxp.DTO.AddressUpdateDTO;
import com.xpxp.Service.AddressService;
import com.xpxp.VO.AddressVO;
import com.xpxp.context.BaseContext;
import com.xpxp.entity.Addresses;
import com.xpxp.exception.BusinessException;
import com.xpxp.mapper.AddressMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressMapper addressMapper;

	/**
	 * 添加地址
	 *
	 * @param addressAddDTO
	 */
	@Override
	public void addAddress(AddressAddDTO addressAddDTO) {
		Long userId = BaseContext.getCurrentId();
		if (addressAddDTO.getIsDefault() == 1) {
			addressMapper.updateAllToNonDefault(userId);
		}
		addressMapper.addAddress(userId, addressAddDTO);
	}

	/**
	 * 获取地址列表
	 *
	 * @return
	 */
	@Override
	public List<AddressVO> listResult() {
		Long userId = BaseContext.getCurrentId();
		List<AddressVO> list = addressMapper.listResult(userId);
		return list;
	}

	@Transactional
	@Override
	public void updateAddress(AddressUpdateDTO addressUpdateDTO) {
		Long userId = BaseContext.getCurrentId();
		if (addressUpdateDTO.getIsDefault() == 1) {
			addressMapper.updateAllToNonDefault(userId);
		}
		Addresses addresses = new Addresses();
		BeanUtil.copyProperties(addressUpdateDTO, addresses);
		addressMapper.updateAddress(userId, addresses);
	}

	@Override
	public void deleteAddress(Integer id) {
		Long userId = BaseContext.getCurrentId();
		Addresses addresses = addressMapper.getByUserIdAndId(userId, id);
		if (addresses == null) {
			throw new BusinessException("没有地址");
		}
		if (addresses.getIsDefault() == 1) {
			throw new BusinessException("默认地址不能删除");
		}
		addressMapper.deleteAddress(userId, id);
	}

}