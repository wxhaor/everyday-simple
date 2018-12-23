package com.wxhao.eved.business.server.service;

import com.wxhao.eved.business.server.mapper.AdminUserMapper;
import com.wxhao.eved.business.server.po.AdminUser;
import org.springframework.stereotype.Service;

/**
 * @author wxhao
 * @date 2018/12/22
 */
@Service
public class AdminUserService extends HaoBaseService<AdminUserMapper, AdminUser> {

    public AdminUser randSelectOne() {
        return baseMapper.randSelectOne();
    }

}
