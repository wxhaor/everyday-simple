package com.wxhao.eved.business.server.po;

import lombok.Data;

import java.util.Date;

/**
 * 实体基类注解
 *
 * @author wxhao
 * @date 2018/1/16
 */

@Data
public abstract class BaseUpdateTimePO extends BaseCreateTimePO{

    /**
     * 创建时间
     */
    private Date updateTime;

}

