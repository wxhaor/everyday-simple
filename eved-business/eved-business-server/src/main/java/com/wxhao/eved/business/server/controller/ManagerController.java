package com.wxhao.eved.business.server.controller;


import com.wxhao.boot.base.utils.ConvertUtils;
import com.wxhao.eved.business.common.from.AdminUserForm;
import com.wxhao.eved.business.common.vo.AdminUserVO;
import com.wxhao.eved.business.server.po.AdminUser;
import com.wxhao.eved.business.server.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wxhao
 * @date 2018/3/22
 */
@RestController
@RequestMapping("/adminUser")
public class ManagerController {

    @Autowired
    private AdminUserService adminUserService;

    @RequestMapping("/save")
    public int save(@RequestBody AdminUserForm form) {
        return adminUserService.save(ConvertUtils.convert(form, AdminUser.class));
    }

    @RequestMapping("/randSelectOne")
    public AdminUserVO randSelectOne() {
        AdminUserVO adminUserVO = ConvertUtils.convert(adminUserService.randSelectOne(), AdminUserVO.class);
        return adminUserVO;
    }

}
