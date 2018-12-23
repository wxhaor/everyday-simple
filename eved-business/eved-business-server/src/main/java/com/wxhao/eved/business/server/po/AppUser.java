package com.wxhao.eved.business.server.po;

import lombok.Data;

/**
 * @author wxhao
 * @date 2018/12/12
 */
@Data
public class AppUser extends BaseTimePO {

    private String username;

    private String password;

    private String mobile;

    private String email;

}
