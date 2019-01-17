package com.wxhao.eved.business.server.service;

import com.wxhao.eved.business.server.common.PageResp;
import com.wxhao.eved.business.server.common.PageUtils;
import com.wxhao.eved.business.server.common.SimpleEventPageBO;
import com.wxhao.eved.business.server.mapper.SimpleEventMapper;
import com.wxhao.eved.business.server.po.SimpleEvent;
import org.springframework.stereotype.Service;

@Service
public class SimpleEventService extends HaoBaseService<SimpleEventMapper, SimpleEvent> {

    public PageResp<SimpleEvent> page(SimpleEventPageBO reqBO) {

        PageResp<SimpleEvent> pageResp = PageUtils.init(reqBO, baseMapper::pageCount, baseMapper::pageList).get();

        return pageResp;
    }


}
