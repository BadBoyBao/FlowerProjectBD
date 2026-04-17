package com.xpxp.Common;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file PageQueryParm
 * @author thexpxp233
 * @date 2025/11/18
 * My name is lixiaopei
 **/

import lombok.Data;
import java.io.Serializable;

@Data
public class PageQueryParm implements Serializable {
    //页码
    private Integer page;

    //每页记录数
    private Integer pageSize;
}