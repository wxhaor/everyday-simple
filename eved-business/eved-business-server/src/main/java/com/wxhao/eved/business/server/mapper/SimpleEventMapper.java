package com.wxhao.eved.business.server.mapper;

import com.wxhao.eved.business.server.po.SimpleEvent;

import java.util.List;

/**
 * 简单的事件记录
 */
public interface SimpleEventMapper extends HaoBaseMapper<SimpleEvent> {

    Integer pageCount();

    List<SimpleEvent> pageList();
}