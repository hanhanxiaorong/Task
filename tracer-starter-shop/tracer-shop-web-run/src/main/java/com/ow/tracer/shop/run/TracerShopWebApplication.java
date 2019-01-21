package com.ow.tracer.shop.run;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@EnableOAuth2Sso
@SpringBootApplication
@EnableCaching
@ComponentScan(basePackages = {
        "com.ow.tracer.common.config", "com.ow.tracer.common.resolver","com.ow.tracer.shop"})
@MapperScan("com.ow.tracer.shop.*.mapper*")
public class TracerShopWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(TracerShopWebApplication.class, args);
    }
}
