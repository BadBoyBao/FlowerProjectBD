package com.xpxp.Service.Impl;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file LoginServiceImpl
 * @author thexpxp233
 * @date 2025/11/20
 * My name is lixiaopei
 **/

import cn.hutool.core.date.DateTime;
import com.xpxp.DTO.LoginDTO;
import com.xpxp.Service.LoginService;
import com.xpxp.entity.Users;
import com.xpxp.exception.BusinessException;
import com.xpxp.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginMapper loginMapper;

	@Override
	public Users login(LoginDTO loginDTO) {
		String username = loginDTO.getUsername();
		String password = loginDTO.getPassword();
		password = DigestUtils.md5DigestAsHex(password.getBytes());
		Users users = loginMapper.getByUserName(username);
		if (users == null) {
			throw new BusinessException("用户不存在");
		}
		if (!users.getPassword()
		          .equals(password)) {
			throw new BusinessException("密码错误");
		}
		if (users.getIsShopOwner() == 1 && users.getShopId() == null) {
			throw new BusinessException("请先完善店铺信息");
		}
		DateTime dateTime = new DateTime();
		loginMapper.updateLoginTime(users.getUserId(), dateTime);
		return users;
	}
}