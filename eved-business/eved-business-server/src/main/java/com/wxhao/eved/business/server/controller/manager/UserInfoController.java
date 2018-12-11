package com.wxhao.eved.business.server.controller.manager;

import com.wxhao.eved.business.server.po.User;
import com.wxhao.eved.business.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wxhao
 * @date 2018/3/23
 */
@RestController
@RequestMapping("/user/userInfo")
public class UserInfoController {

//    @Autowired
//    private UserInfoClient userInfoClient;
//
//    @RequestMapping("/listAll")
//    public List<UserInfoVO> listAll() {
//        return userInfoClient.listAll();
//    }

    @Autowired
    private UserService userService;

    @RequestMapping("/randSelectOne")
    public User randSelectOne() {
        return userService.randSelectOne();
    }
}
