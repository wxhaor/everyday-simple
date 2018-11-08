package com.wxhao.eved.business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;


@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@ComponentScan("com.wxhao")
@MapperScan(basePackages = {"com.wxhao.eved.business.server.mapper"})
public class EvedBusinessApplication {

    public static void main(String[] args) {
        SpringApplication.run(EvedBusinessApplication.class, args);
    }
}
