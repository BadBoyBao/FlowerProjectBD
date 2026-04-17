package com.xpxp.DTO;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file LoginDTO
 * @author thexpxp233
 * @date 2025/11/20
 * My name is lixiaopei
 **/

import lombok.Data;
import java.io.Serializable;

@Data
public class LoginDTO implements Serializable {
    private String username;
    private String password;
}