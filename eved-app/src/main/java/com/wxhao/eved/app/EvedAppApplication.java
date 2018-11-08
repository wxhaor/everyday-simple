package com.wxhao.eved.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.wxhao.eved.business.client")
@ComponentScan("com.wxhao")
@SpringBootApplication
public class EvedAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(EvedAppApplication.class, args);
    }
}
