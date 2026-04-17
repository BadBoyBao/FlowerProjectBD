package com.xpxp.Config;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file DocConfig
 * @author thexpxp233
 * @date 2025/11/10
 * My name is lixiaopei
 **/

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DocConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("鲜花销售系统接口")
                        .description("鲜花销售系统接口文档")
                        .version("1.0"));
    }
}