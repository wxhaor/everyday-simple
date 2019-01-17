package com.wxhao.eved.business.server.common;

import lombok.Getter;

@Getter
public abstract class PageReq {

    protected Integer pageNumber = 1;
    protected Integer pageSize = 20;


    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
        if(pageNumber == null){
            this.pageNumber = 1;
        }
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        if(pageSize == null){
            this.pageSize = 20;
        }
    }


    /**
     * 首页下标
     *
     * @return index
     */
    public int getIndex() {
        return (pageNumber - 1) * pageSize;
    }


}
