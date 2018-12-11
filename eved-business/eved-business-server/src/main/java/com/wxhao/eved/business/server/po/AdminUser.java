package com.wxhao.eved.business.server.po;


import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.wxhao.boot.api.constant.TablePrefixConstant;
import com.wxhao.boot.api.enums.SexEnum;
import lombok.Data;

import java.util.Date;


@Data
@TableName(TablePrefixConstant.ADMIN + "admin_user")
public class AdminUser {

    private Long id;

    private Date createTime;

    private Date updateTime;

    private String username;


    private String password;


    private String name;


    private String headImgUrl;


    private String mobileNo;

    private Integer sex;

    @TableField(exist = false)
    @EnumValue
    private SexEnum sexEnum;

}
