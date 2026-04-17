package com.xpxp.Service;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file LoginService
 * @author thexpxp233
 * @date 2025/11/20
 * My name is lixiaopei
 **/

import com.xpxp.DTO.LoginDTO;
import com.xpxp.entity.Users;

public interface LoginService {
    Users login(LoginDTO loginDTO);
}