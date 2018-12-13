package com.wxhao.eved.business.server.service;

import com.wxhao.eved.business.server.mapper.AppUserMapper;
import com.wxhao.eved.business.server.po.AppUser;
import org.springframework.stereotype.Service;

/**
 * @author wxhao
 * @date 2018/12/12
 */
@Service
public class AppUserService extends HaoBaseService<AppUserMapper, AppUser> {

    public AppUser randSelectOne() {
        return baseMapper.randSelectOne();
    }

}
