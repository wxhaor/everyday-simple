package com.wxhao.eved.business.server.common;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class PageResp<T> implements Serializable {

    private PageReq pageReq;

    private int totalCount = 0;
    private int totalPage = 1;
    private List<T> items = new ArrayList<>();

    public void measureTotalPage(int totalCount, int pageSize) {
        this.totalCount = totalCount;
        if (totalCount < 1) {
            return;
        }
        this.totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
    }

}
