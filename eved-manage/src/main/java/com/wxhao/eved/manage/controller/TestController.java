package com.wxhao.eved.manage.controller;

import com.wxhao.eved.business.client.manager.ManagerClient;
import com.wxhao.eved.business.common.bo.AdminUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wxhao
 * @date 2018/11/8
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private ManagerClient managerClient;

    @RequestMapping("/randSelectOne")
    public AdminUserVO randSelectOne() {
        AdminUserVO adminUserVO = managerClient.randSelectOne();
        return adminUserVO;
    }

}
