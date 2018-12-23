package com.wxhao.eved.business.server.po;

import lombok.Data;
import java.util.Date;

/**
 * 管理员用户
 */
@Data
public class AdminUser extends BaseTimePO{

    /**
     * 主键
     */
    private Long id;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

}
