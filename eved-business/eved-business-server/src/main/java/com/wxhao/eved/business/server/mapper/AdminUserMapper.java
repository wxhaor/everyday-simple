package com.wxhao.eved.business.server.mapper;

import com.wxhao.eved.business.server.po.AdminUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author wxhao
 * @date 2018/12/22
 */
@Mapper
public interface AdminUserMapper extends HaoBaseMapper<AdminUser> {

    AdminUser randSelectOne();

}
