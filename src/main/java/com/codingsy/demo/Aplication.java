package com.codingsy.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.context.annotation.ImportResource;

/**
 * @program: ShardingJdbcDemo
 * @description:
 * @author: sy
 * @create: 2019-07-01 00:41
 */
@SpringBootApplication(
        scanBasePackages = {"com.codingsy.demo"},
        exclude = {DruidDataSourceAutoConfigure.class})
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ImportResource({"classpath:/spring/dubbo-provider.xml","classpath:/spring/dubbo-consumer.xml"})
public class Aplication {

    public static void main(String[] args) {
        SpringApplication.run(Aplication.class, args);
    }

}