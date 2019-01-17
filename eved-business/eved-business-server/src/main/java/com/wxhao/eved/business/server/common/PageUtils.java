package com.wxhao.eved.business.server.common;

import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;

public class PageUtils<E, C extends PageReq> {

    private C pageReq;
    private SelectCount<C> selectCount;
    private SelectList<E, C> selectList;
    Integer count = 0;
    private List<E> list = Collections.emptyList();

    public static <E, C extends PageReq> PageUtils<E, C> init(C condition, SelectCount<C> selectCount, SelectList<E, C> selectList) {
        PageUtils<E, C> pageUtils = new PageUtils<>();
        pageUtils.pageReq = condition;
        pageUtils.selectCount = selectCount;
        pageUtils.selectList = selectList;
        return pageUtils;
    }

    private PageUtils select() {
        count = selectCount.select(pageReq);
        if (count > pageReq.getIndex()) {
            list = selectList.select(pageReq);
        }
        return this;
    }

    public PageResp<E> get() {
        select();
        return PageResp.build(pageReq, list, count);
    }

    public <T> PageResp<T> get(Class<T> targetClass) {
        select();
        List<T> list = ConvertUtils.convert(this.list, targetClass);
        return PageResp.build(pageReq, list, count);
    }

    public <T> PageResp<T> get(Class<T> targetClass, BiConsumer<E, T> biConsumer) {
        select();
        List<T> list = ConvertUtils.convertAfter(this.list, targetClass, biConsumer);
        return PageResp.build(pageReq, list, count);
    }

    @FunctionalInterface
    public interface SelectCount<C extends PageReq> {
        Integer select(C pageReq);
    }

    @FunctionalInterface
    public interface SelectList<E, C extends PageReq> {
        List<E> select(C pageReq);
    }

}
