/*
package com.wxhao.eved.business.server.service;


import com.wxhao.boot.mybatis.service.BaseService;
import com.wxhao.eved.business.server.mapper.AdminUserMapper;
import com.wxhao.eved.business.server.po.AdminUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

*/
/**
 * @author wxhao
 * @date 2018/3/22
 *//*

@Service
@Slf4j
public class AdminUserService extends BaseService<AdminUser> {

    @Autowired
    private AdminUserMapper adminUserMapper;

    public AdminUser randSelectOne() {
        return adminUserMapper.randSelectOne();
    }

//    public void validate(AdminUser reqAdminUser) throws IOException, NoSuchAlgorithmException {
//        String username = reqAdminUser.getUsername();
//        String password = reqAdminUser.getPassword();
//
//        AdminUser example = new AdminUser();
//        example.setUsername(username);
//        JWTInfo jwtInfo = new JWTInfo();
//        Relaxed.ofNullable(adminUserMapper.selectOne(example))
//                .ifNotNull(adminUser -> {
//                    jwtInfo.setUserId(adminUser.getId().toString());
//                    jwtInfo.setUsername(adminUser.getUsername());
//                    jwtInfo.setName(adminUser.getName());
//                });
//        log.info("JWTInfo:{}", JsonUtils.toJson(jwtInfo));
//
//        Map<String, byte[]> keyMap = RsaKeyHelper.generateKey("xx1WET12^%3^(WE45");
//        byte[] pris = keyMap.get("pri");
//        byte[] pubs = keyMap.get("pub");
//
//        String token = null;
//        try {
//
//            token = JWTHelper.generateToken(jwtInfo, pris, 10);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            Thread.sleep(11000L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        IJWTInfo ijwtInfo = null;
//        try {
//            ijwtInfo = JWTHelper.getInfoFromToken(token, pubs);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        log.info("IJWTInfo:{}", JsonUtils.toJson(ijwtInfo));
//
//    }

}
*/
