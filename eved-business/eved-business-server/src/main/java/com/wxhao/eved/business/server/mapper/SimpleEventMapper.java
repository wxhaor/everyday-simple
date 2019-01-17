package com.wxhao.eved.business.server.mapper;

import com.wxhao.eved.business.server.common.SimpleEventPageBO;
import com.wxhao.eved.business.server.po.SimpleEvent;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 简单的事件记录
 */
@Mapper
public interface SimpleEventMapper extends HaoBaseMapper<SimpleEvent> {

    Integer pageCount(SimpleEventPageBO reqBO);

    List<SimpleEvent> pageList(SimpleEventPageBO reqBO);
}