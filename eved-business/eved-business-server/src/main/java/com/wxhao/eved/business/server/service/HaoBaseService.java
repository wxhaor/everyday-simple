package com.wxhao.eved.business.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wxhao.boot.base.component.SnowflakeIdWorker;
import com.wxhao.boot.base.helper.ApplicationContextHelper;
import com.wxhao.eved.business.server.mapper.HaoBaseMapper;
import com.wxhao.eved.business.server.po.BaseIdPO;
import com.wxhao.eved.business.server.po.BaseCreateTimePO;
import com.wxhao.eved.business.server.po.BaseUpdateTimePO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author wxhao
 * @date 2018/12/11
 */
public class HaoBaseService<M extends HaoBaseMapper<T>, T> extends ServiceImpl<M, T> implements IService<T> {

    @Autowired
    private SnowflakeIdWorker idWorker;

    @Override
    @Transactional
    public boolean save(T entity) {
        initEntity(entity);
        return super.save(entity);
    }

    private T initEntity(T entity) {
        long id = idWorker.nextId();
        if (entity instanceof BaseUpdateTimePO) {
            ((BaseUpdateTimePO) entity).setCreateTime(new Date());
            ((BaseUpdateTimePO) entity).setUpdateTime(new Date());
            ((BaseUpdateTimePO) entity).setId(id);
        }else if (entity instanceof BaseCreateTimePO) {
            ((BaseCreateTimePO) entity).setCreateTime(new Date());
            ((BaseCreateTimePO) entity).setId(id);
        } else if (entity instanceof BaseIdPO) {
            ((BaseIdPO) entity).setId(id);
        }
        return entity;
    }

    @Transactional
    public T saveAndFind(T entity) {
        HaoBaseService<M, T> service = ApplicationContextHelper.getBean(this.getClass());
        T initEntity = initEntity(entity);
        boolean b = service.save(entity);
        if (b) {
            return initEntity;
        }
        return null;
    }
}
