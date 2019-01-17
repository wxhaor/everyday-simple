package com.wxhao.eved.business.server.common;

import lombok.Data;

import java.util.Date;

@Data
public class SimpleEventBO extends PageReq {

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
