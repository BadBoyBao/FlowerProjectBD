package com.xpxp.Service.Impl;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file ShopServiceImpl
 * @author thexpxp233
 * @date 2025/12/22
 * My name is lixiaopei
 **/

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xpxp.Common.PageQueryParm;
import com.xpxp.Common.PageResult;
import com.xpxp.DTO.*;
import com.xpxp.Service.ShopService;
import com.xpxp.VO.*;
import com.xpxp.entity.Shops;
import com.xpxp.entity.Users;
import com.xpxp.exception.BusinessException;
import com.xpxp.mapper.ShopMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class ShopServiceImpl implements ShopService {
	@Autowired
	private ShopMapper shopMapper;

	/**
	 * 添加店主
	 *
	 * @param ownerDTO
	 */
	@Override
	public void addOwner(OwnerDTO ownerDTO) {
		Users users = Users.builder()
		                   .username(ownerDTO.getUsername())
		                   .password(DigestUtils.md5DigestAsHex(ownerDTO.getPassword()
		                                                                .getBytes()))
		                   .phone(ownerDTO.getPhone())
		                   .nickname(ownerDTO.getNickname())
		                   .gender(ownerDTO.getGender())
		                   .image(ownerDTO.getImage())
		                   .role("SHOP_OWNER")
		                   .isShopOwner(1)
		                   .build();
		shopMapper.addOwner(users);
	}

	/**
	 * 获取所有店主
	 *
	 * @return
	 */
	@Override
	public List<OwnerVO> list() {
		return shopMapper.getAll();
	}

	/**
	 * 分页查询
	 *
	 * @param pageQueryParm
	 * @return
	 */
	@Override
	public PageResult page(PageQueryParm pageQueryParm) {
		PageHelper.startPage(pageQueryParm.getPage(), pageQueryParm.getPageSize());
		Page<OwnerVO> page = shopMapper.page(pageQueryParm);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 添加店铺
	 *
	 * @param shopDTO
	 */
	@Transactional
	@Override
	public void addShop(ShopDTO shopDTO) {
		if (shopDTO.getShopName() == null || shopDTO.getContactAddress() == null || shopDTO.getShopDescription() == null) {
			throw new RuntimeException("店铺信息不完整");
		}
		if (shopDTO.getOwnerId() == null || shopDTO.getContactPhone() == null) {
			throw new RuntimeException("店主信息不完整");
		}
		if (shopDTO.getBusinessHours() == null) {
			throw new RuntimeException("营业时间未填写");
		}
		Shops shops = Shops.builder()
		                   .shopName(shopDTO.getShopName())
		                   .shopDescription(shopDTO.getShopDescription())
		                   .ownerId(shopDTO.getOwnerId())
		                   .contactPhone(shopDTO.getContactPhone())
		                   .contactAddress(shopDTO.getContactAddress())
		                   .shopLogo(shopDTO.getShopLogo())
		                   .shopBanner(shopDTO.getShopBanner())
		                   .status(1)
		                   .businessHours(shopDTO.getBusinessHours())

		                   .createdAt(new Date())
		                   .build();
		/*添加商铺并返回商铺主键Id*/
		shopMapper.addShop(shops);
		Integer shopId = shops.getShopId();
		//修改店主信息，设置店主的店铺Id
		Integer userId = shopDTO.getOwnerId();
		shopMapper.updateUser(userId, shopId);

	}

	/**
	 * 获取所有店铺
	 *
	 * @param pageQueryParm
	 * @return
	 */
	@Override
	public PageResult getAllShop(PageQueryParm pageQueryParm) {
		PageHelper.startPage(pageQueryParm.getPage(), pageQueryParm.getPageSize());
		Page<Shops> page = shopMapper.getAllShop(pageQueryParm);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 首页店铺
	 *
	 * @return
	 */
	@Override
	public List<ShopVO> shopList() {
		return shopMapper.GetShopList();
	}

	/**
	 * 获取所有店铺信息和包含鲜花
	 *
	 * @return
	 */
	@Override
	public List<ShopViewVO> getList() {
		// 方案1：先查询店铺列表，再循环查询每个店铺的鲜花
		List<ShopViewVO> shopList = shopMapper.getList();

		for (ShopViewVO shop : shopList) {
			List<FlowerVO> flowerList = shopMapper.getFlowersByShopId(shop.getShopId());
			shop.setFlowerList(flowerList);
		}

		return shopList;
	}

	/**
	 * 获取店铺详情
	 *
	 * @param shopId
	 * @return
	 */
	@Override
	public ShopDetailVO getShopDetail(Integer shopId) {
		ShopDetailVO shopDetailVO = shopMapper.getShopDetail(shopId);
		if (shopDetailVO == null) {
			throw new RuntimeException("店铺不存在");
		}
		return shopDetailVO;
	}

	/**
	 * 获取店铺详情信息
	 *
	 * @param shopId
	 * @return
	 */
	@Override
	public ShopDetailInfoVO getShopInfo(Integer shopId) {
		ShopDetailInfoVO shopDetailInfoVO = shopMapper.getShopInfo(shopId);
		return shopDetailInfoVO;
	}

	/**
	 * 修改店铺状态
	 *
	 * @param shopId
	 * @param status
	 */
	@Override
	public void changeStatus(Integer shopId, String status) {
		if (shopId == null || status == null) {
			throw new RuntimeException("店铺Id或状态不能为空");
		}
		shopMapper.changeStatus(shopId, status);
	}

	/**
	 * 修改店铺信息
	 *
	 * @param shopUpdateDTO
	 */
	@Override
	public void updateShop(ShopUpdateDTO shopUpdateDTO) {
		if (shopUpdateDTO.getShopId() == null) {
			throw new RuntimeException("店铺Id不能为空");
		}
		shopMapper.updateShop(shopUpdateDTO);
	}

	@Override
	public void banShop(BanShopDTO banShopDTO) {
		shopMapper.banShop(banShopDTO);
	}

	@Override
	public void unbanShop(Integer shopId) {
		shopMapper.unbanShop(shopId);
	}

	@Override
	public void updateShopByShopId(UpdateShopDTO updateShopDTO) {
		shopMapper.updateShopByShopId(updateShopDTO);
	}

	/**
	 * 删除店主
	 *
	 * @param ownerId
	 */
	@Override
	public void deleteOwner(Integer ownerId) {
		if (ownerId == 1) {
			throw new BusinessException("无操作权限");
		}
		Users users = shopMapper.getByUserId(ownerId);
		if (users.getShopId() != null) {
			throw new BusinessException("该店主有关联店铺，无法删除");
		}
		shopMapper.deleteOwner(ownerId);
	}


}