package com.wxhao.eved.manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.wxhao.eved.business.client")
@ComponentScan("com.wxhao")
public class EvedManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(EvedManageApplication.class, args);
    }
}
