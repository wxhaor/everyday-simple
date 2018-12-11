package com.wxhao.eved.business.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wxhao.boot.base.component.SnowflakeIdWorker;
import com.wxhao.eved.business.server.mapper.HaoBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author wxhao
 * @date 2018/12/11
 */
public class HaoBaseService<M extends HaoBaseMapper<T>, T> extends ServiceImpl<M, T> implements IService<T> {


    @Autowired
    private SnowflakeIdWorker idWorker;


}
