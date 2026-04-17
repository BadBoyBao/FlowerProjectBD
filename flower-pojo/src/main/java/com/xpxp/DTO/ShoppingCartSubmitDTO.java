package com.xpxp.DTO;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file ShoppingCartSubmitDTO
 * @author thexpxp233
 * @date 2025/12/9
 * My name is lixiaopei
 **/

import com.xpxp.entity.Submit;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ShoppingCartSubmitDTO implements Serializable {
	List<Submit> submitList;
}