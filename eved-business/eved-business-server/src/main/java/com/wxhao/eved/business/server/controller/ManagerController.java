package com.wxhao.eved.business.server.controller;


import com.wxhao.boot.base.utils.ConvertUtils;
import com.wxhao.eved.business.common.bo.AdminUserVO;
import com.wxhao.eved.business.common.to.AdminUserForm;
import com.wxhao.eved.business.server.po.AdminUser;
import com.wxhao.eved.business.server.service.AdminUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/adminUser")
@Slf4j
public class ManagerController {

//    @Autowired
//    private String test;

    @Autowired
    private AdminUserService adminUserService;

//    @RequestMapping("/save")
//    public int save(@RequestBody AdminUserForm form) {
//        return adminUserService.save(ConvertUtils.convert(form, AdminUser.class));
//    }
//
    @RequestMapping("/findOne/{id}")
    public AdminUserVO findOne(@PathVariable("id") Long id) {
        AdminUser adminUser = adminUserService.getById(id);
        return ConvertUtils.convert(adminUser, AdminUserVO.class);
    }

    @RequestMapping("/randSelectOne")
    public AdminUserVO randSelectOne() {
        AdminUserVO adminUserVO = ConvertUtils.convert(adminUserService.randSelectOne(), AdminUserVO.class);
        return adminUserVO;
    }

}
