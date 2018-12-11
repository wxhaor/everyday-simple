package com.wxhao.eved.business.server.service;

import com.wxhao.eved.business.server.mapper.UserMapper;
import com.wxhao.eved.business.server.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wxhao
 * @date 2018/12/11
 */

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User randSelectOne(){
        return userMapper.randSelectOne();
    }

}
