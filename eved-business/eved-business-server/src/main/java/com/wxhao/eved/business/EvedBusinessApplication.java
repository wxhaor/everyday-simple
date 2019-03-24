package com.wxhao.eved.business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
//@EnableDiscoveryClient
//@EnableFeignClients
@ComponentScan("com.wxhao")
//@MapperScan(basePackages = {"com.wxhao.eved.business.server.mapper"})
public class EvedBusinessApplication {

    public static void main(String[] args) {
        SpringApplication.run(EvedBusinessApplication.class, args);
    }
}
