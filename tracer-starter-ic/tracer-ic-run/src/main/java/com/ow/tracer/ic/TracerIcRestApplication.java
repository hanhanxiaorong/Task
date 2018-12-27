package com.ow.tracer.ic;

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
        "com.ow.tracer.common.config", "com.ow.tracer.admin.config.resolver","com.ow.tracer.ic"})
@MapperScan("com.ow.tracer.ic.group.mapper*")
public class TracerIcRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TracerIcRestApplication.class, args);
    }
}
