package com.wxhao.eved.business.server.controller;


import com.wxhao.boot.base.utils.ConvertUtils;
import com.wxhao.eved.business.common.bo.AdminUserVO;
import com.wxhao.eved.business.server.service.AppUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/appUser")
@Slf4j
public class AppUserController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private AppUserService appUserService;


    @RequestMapping("/redisTest")
    public void redisTest() {
        redisTemplate.opsForValue().set("key1","value1");
    }



}
