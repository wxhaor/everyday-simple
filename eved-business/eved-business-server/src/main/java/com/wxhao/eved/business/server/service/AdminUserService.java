
package com.wxhao.eved.business.server.service;


import com.wxhao.eved.business.server.mapper.AdminUserMapper;
import com.wxhao.eved.business.server.po.AdminUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author wxhao
 * @date 2018/3/22
 */

@Service
@Slf4j
public class AdminUserService extends HaoBaseService<AdminUserMapper, AdminUser> {

    @Autowired
    private AdminUserMapper adminUserMapper;

    public AdminUser randSelectOne() {
        return adminUserMapper.randSelectOne();
    }


}

