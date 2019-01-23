package com.wxhao.eved.business.server.controller;

import com.wxhao.eved.business.server.common.ConvertUtils;
import com.wxhao.eved.business.server.common.PageResp;
import com.wxhao.eved.business.server.common.SimpleEventBO;
import com.wxhao.eved.business.server.common.SimpleEventPageBO;
import com.wxhao.eved.business.server.po.SimpleEvent;
import com.wxhao.eved.business.server.service.SimpleEventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/simpleEvent")
@Slf4j
public class SimpleEventController {

    @Autowired
    private SimpleEventService simpleEventService;


    @RequestMapping("/page")
    public PageResp<SimpleEvent> page(@RequestBody SimpleEventPageBO reqBO) {
        return simpleEventService.page(reqBO);
    }

    @RequestMapping("/save")
    public SimpleEvent save(@RequestBody SimpleEventBO reqBO) {
        SimpleEvent simpleEvent = ConvertUtils.convert(reqBO, SimpleEvent.class);
        if(simpleEvent.getEventDate() == null){
            simpleEvent.setEventDate(new Date());
        }
        int to = 1;
        return simpleEventService.saveAndFind(simpleEvent);
    }

}
