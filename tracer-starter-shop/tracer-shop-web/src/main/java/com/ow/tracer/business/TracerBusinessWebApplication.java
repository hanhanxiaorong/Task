package com.ow.tracer.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

/**
 * @auther: Easy
 * @date: 18-11-23 01:08
 * @description:
 */
@SpringBootApplication
@EnableCaching
@ComponentScan(basePackages = {
        "com.ow.tracer.common.config", "com.ow.tracer.common.resolver","com.ow.tracer.shop"})
public class TracerBusinessWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(TracerBusinessWebApplication.class, args);
    }
}
