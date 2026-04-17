package com.xpxp.mapper;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file AddressMapper
 * @author thexpxp233
 * @date 2025/12/9
 * My name is lixiaopei
 **/

import com.xpxp.DTO.AddressAddDTO;
import com.xpxp.VO.AddressVO;
import com.xpxp.entity.Addresses;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AddressMapper {

	/**
	 * 添加地址
	 *
	 * @param addressAddDTO
	 */
	void addAddress(@Param("userId") Long userId, @Param("addressAddDTO") AddressAddDTO addressAddDTO);


	/**
	 * 获取地址列表
	 *
	 * @return
	 */
	@Select("select a.address_id,a.receiver_name,a.receiver_phone,a.detail_address as receiverDetail,a.is_default from addresses a where user_id = #{userId}")
	List<AddressVO> listResult(Long userId);

	/**
	 * 将所有地址设置为非默认地址
	 *
	 * @param userId
	 */
	void updateAllToNonDefault(Long userId);

	/**
	 * 更新 地址
	 *
	 * @param userId
	 * @param addresses
	 */
	void updateAddress(Long userId, Addresses addresses);

	/**
	 * 根据用户id和地址id获取地址
	 *
	 * @param userId
	 * @param id
	 * @return
	 */
	@Select("select a.is_default from addresses a where user_id = #{userId} and address_id = #{id}")
	Addresses getByUserIdAndId(Long userId, Integer id);

	/**
	 * 删除地址
	 *
	 * @param userId
	 * @param id
	 */
	@Delete("delete from addresses where user_id = #{userId} and address_id = #{id}")
	void deleteAddress(Long userId, Integer id);
}