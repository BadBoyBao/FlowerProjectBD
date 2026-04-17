package com.xpxp.Service.Impl;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file InfoServiceImpl
 * @author thexpxp233
 * @date 2025/12/19
 * My name is lixiaopei
 **/

import com.xpxp.DTO.RegisterDTO;
import com.xpxp.DTO.ResetPasswordDTO;
import com.xpxp.DTO.UserInfoUpdateDTO;
import com.xpxp.Service.InfoService;
import com.xpxp.VO.UserInfoVO;
import com.xpxp.context.BaseContext;
import com.xpxp.entity.Users;
import com.xpxp.exception.BusinessException;
import com.xpxp.mapper.InfoMapper;
import com.xpxp.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;

@Service
public class InfoServiceImpl implements InfoService {
	@Autowired
	private InfoMapper infoMapper;
	@Autowired
	private LoginMapper loginMapper;

	/**
	 * 获取用户信息
	 *
	 * @return
	 */
	@Override
	public UserInfoVO getInfo() {
		Long userId = BaseContext.getCurrentId();
		UserInfoVO userInfoVO = infoMapper.getInfo(userId);
		return userInfoVO;
	}

	/**
	 * 更新用户信息
	 *
	 * @param userInfoUpdateDTO
	 */
	@Transactional
	@Override
	public void updateInfo(UserInfoUpdateDTO userInfoUpdateDTO) {
		Long userId = BaseContext.getCurrentId();
		infoMapper.updateInfo(userId, userInfoUpdateDTO);
	}

	/**
	 * 注册
	 *
	 * @param registerDTO
	 */
	@Transactional
	@Override
	public void register(RegisterDTO registerDTO) {
		if (registerDTO.getUsername() == null) {
			throw new BusinessException("用户名不能为空");
		}
		if (registerDTO.getNickname() == null) {
			throw new BusinessException("昵称不能为空");
		}
		if (registerDTO.getPhone() == null) {
			throw new BusinessException("手机号不能为空");
		}

		if (registerDTO.getPassword() == null) {
			throw new BusinessException("密码不能为空");
		}
		if (registerDTO.getConfirmPassword() == null) {
			throw new BusinessException("确认密码不能为空");
		}
		if (!registerDTO.getPassword()
		                .equals(registerDTO.getConfirmPassword())) {
			throw new BusinessException("密码不一致");
		}
		if (registerDTO.getUsername()
		               .length() < 6 || registerDTO.getUsername()
		                                           .length() > 20) {
			throw new BusinessException("用户名长度需在6到20之间");
		}
		if (registerDTO.getNickname()
		               .isEmpty() || registerDTO.getNickname()
		                                        .length() > 6) {
			throw new BusinessException("昵称长度需在1到6之间");
		}
		if (registerDTO.getPhone()
		               .length() != 11) {
			throw new BusinessException("手机号长度需为11位");
		}
		if (registerDTO.getPassword()
		               .length() < 6 || registerDTO.getPassword()
		                                           .length() > 12) {
			throw new BusinessException("密码长度需在6到12之间");
		}
		Users users = infoMapper.getUserName(registerDTO.getUsername());
		if (users != null) {
			throw new BusinessException("用户名已存在");
		}

		Users user = Users.builder()
		                  .username(registerDTO.getUsername())
		                  .nickname(registerDTO.getNickname())
		                  .phone(registerDTO.getPhone())
		                  .password(DigestUtils.md5DigestAsHex(registerDTO.getPassword()
		                                                                  .getBytes()))
		                  .role("USER")
		                  .image("http://118.178.18.207:9000/thexpxp233/flower/2025/12/20/6945931ee2e3b64eaf1abe32.png")
		                  .createdAt(new Date())
		                  .isShopOwner(0)
		                  .build();
		loginMapper.register(user);

	}

	@Transactional
	@Override
	public void resetPassword(ResetPasswordDTO resetPasswordDTO) {
		Long userId = BaseContext.getCurrentId();
		String username = resetPasswordDTO.getUsername();
		String password = resetPasswordDTO.getOldPassword();
		String newPassword = resetPasswordDTO.getNewPassword();
		String confirmPassword = resetPasswordDTO.getConfirmPassword();

		Users users = infoMapper.getByUserIdAndUserName(userId, username);
		if (users == null) {
			throw new BusinessException("用户不存在");
		}

		if (password.equals(newPassword)) {
			throw new BusinessException("新密码不能与旧密码相同");
		}
		if (!newPassword.equals(confirmPassword)) {
			throw new BusinessException("新密码不一致");
		}
		password = DigestUtils.md5DigestAsHex(password.getBytes());
		if (!users.getPassword()
		          .equals(password)) {
			throw new BusinessException("密码错误,请重新输入");
		}
		newPassword = DigestUtils.md5DigestAsHex(newPassword.getBytes());
		infoMapper.resetPassword(userId, username, newPassword);
	}
}