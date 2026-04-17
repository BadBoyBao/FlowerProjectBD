package com.xpxp.DTO;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file ShoppingCartUpdateDTO
 * @author thexpxp233
 * @date 2025/12/5
 * My name is lixiaopei
 **/

import lombok.Data;
import java.io.Serializable;

@Data
public class ShoppingCartUpdateDTO implements Serializable {
    private Integer flowerId;
    private Integer quantity;
    private Integer selected;
}