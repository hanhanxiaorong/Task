package com.ow.tracer.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableOAuth2Sso
@SpringBootApplication
@ComponentScan(basePackages = {
        "com.ow.tracer.core.config","com.ow.tracer.core.resolver","com.ow.tracer.admin"})
@MapperScan("com.ow.tracer.admin.account.mapper*")
public class TracerAdminRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TracerAdminRestApplication.class, args);
    }
}
