package com.wxhao.eved.business.server.po;

import lombok.Data;
import java.util.Date;

/**
 * 简单的事件记录更新历史
 */
@Data
public class SimpleEventRecord {

    /**
     * 主键
     */
    private Long id;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * simple_event_id
     */
    private Long simpleEventId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 内容
     */
    private String content;

    /**
     * 事件时间
     */
    private Date eventDate;

}
