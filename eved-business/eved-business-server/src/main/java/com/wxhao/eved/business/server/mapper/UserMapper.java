package com.wxhao.eved.business.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wxhao.eved.business.server.po.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author wxhao
 * @date 2018/12/9
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {



    User randSelectOne();
}
