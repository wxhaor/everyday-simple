package com.wxhao.eved.business;

import com.wxhao.eved.business.server.mapper.UserMapper;
import com.wxhao.eved.business.server.po.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author wxhao
 * @date 2018/12/9
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class SampleTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        User user = new User();
        user.setId(1L);
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
        User user1 = userMapper.randSelectOne();
        log.info("---------------------->{}", user1.getName());
    }

}