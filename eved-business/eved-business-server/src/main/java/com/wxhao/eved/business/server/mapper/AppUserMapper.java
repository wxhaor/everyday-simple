package com.wxhao.eved.business.server.mapper;

import com.wxhao.eved.business.server.po.AppUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author wxhao
 * @date 2018/12/12
 */
@Mapper
public interface AppUserMapper extends HaoBaseMapper<AppUser> {

    AppUser randSelectOne();

}
