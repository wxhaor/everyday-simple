package com.wxhao.eved.business.client.manager;


import com.wxhao.eved.business.common.vo.AdminUserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wxhao
 * @date 2018/3/23
 */
@FeignClient(name = "eved-business")
@RequestMapping("/adminUser")
public interface ManagerClient {


    @GetMapping("/randSelectOne")
    AdminUserVO randSelectOne();

}
