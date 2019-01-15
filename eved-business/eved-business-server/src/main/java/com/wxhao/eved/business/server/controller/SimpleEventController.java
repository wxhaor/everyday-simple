package com.wxhao.eved.business.server.controller;

import com.wxhao.eved.business.common.bo.AdminUserVO;
import com.wxhao.eved.business.server.service.SimpleEventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/adminUser")
@Slf4j
public class SimpleEventController {

    @Autowired
    private SimpleEventService simpleEventService;


    @RequestMapping("/randSelectOne")
    public AdminUserVO page() {

        return null;
    }

}
