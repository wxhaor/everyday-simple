package com.wxhao.eved.business.common.to;

import lombok.Data;


/**
 * @author wxhao
 * @date 2018/3/23
 */
@Data
public class AdminUserForm  {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 姓名
     */
    private String name;

    /**
     * 头像地址
     */
    private String headImgUrl;

    /**
     * 手机号
     */
    private String mobileNo;

}
