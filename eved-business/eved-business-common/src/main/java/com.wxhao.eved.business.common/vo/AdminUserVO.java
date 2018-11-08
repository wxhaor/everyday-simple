package com.wxhao.eved.business.common.vo;


import com.wxhao.boot.api.pojo.BaseVO;
import lombok.Data;

import java.io.Serializable;

/**
 * @author wxhao
 * @date 2018/3/23
 */
@Data
public class AdminUserVO extends BaseVO implements Serializable {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

}
