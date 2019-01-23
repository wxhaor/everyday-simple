package com.wxhao.eved.business.server.po;

import lombok.Data;
import java.util.Date;

/**
 * 简单的事件记录
 */
@Data
public class SimpleEvent extends BaseUpdateTimePO{

    /**
     * 主键
     */
    private Long id;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

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
