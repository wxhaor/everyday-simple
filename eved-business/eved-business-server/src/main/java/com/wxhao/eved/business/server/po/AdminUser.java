package com.wxhao.eved.business.server.po;


import com.wxhao.boot.api.constant.TablePrefixConstant;
import com.wxhao.boot.mybatis.po.BasePO;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author wxhao
 * @date 2018/3/22
 */
@Entity
@Data
@Table(name = TablePrefixConstant.ADMIN + "admin_user")
public class AdminUser extends BasePO {


    /**
     * 用户名
     */
    @Column(nullable = false)
    private String username;

    /**
     * 密码
     */
    @Column(nullable = false)
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
