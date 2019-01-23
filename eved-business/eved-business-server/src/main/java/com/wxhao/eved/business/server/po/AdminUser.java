package com.wxhao.eved.business.server.po;

import lombok.Data;

/**
 * 管理员用户
 */
@Data
public class AdminUser extends BaseCreateTimePO {


    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

}
