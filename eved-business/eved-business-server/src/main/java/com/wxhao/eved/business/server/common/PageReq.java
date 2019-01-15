package com.wxhao.eved.business.server.common;

import lombok.Data;

@Data
public abstract class PageReq {

    protected int pageNumber = 1;
    protected int pageSize = 20;

    /**
     * 首页下标
     * @return
     */
    public int getIndex() {
        return (pageNumber - 1) * pageSize;
    }


}
