package com.wxhao.eved.business.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wxhao.boot.base.component.SnowflakeIdWorker;
import com.wxhao.eved.business.server.mapper.HaoBaseMapper;
import com.wxhao.eved.business.server.po.BaseIdPO;
import com.wxhao.eved.business.server.po.BaseTimePO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @author wxhao
 * @date 2018/12/11
 */
public class HaoBaseService<M extends HaoBaseMapper<T>, T> extends ServiceImpl<M, T> implements IService<T> {

    @Autowired
    private SnowflakeIdWorker idWorker;

    @Override
    public boolean save(T entity) {
        if (entity instanceof BaseTimePO) {
            ((BaseTimePO) entity).setCreateTime(new Date());
            ((BaseTimePO) entity).setId(idWorker.nextId());
        } else if (entity instanceof BaseIdPO) {
            ((BaseIdPO) entity).setId(idWorker.nextId());
        }
        return super.save(entity);
    }
}
