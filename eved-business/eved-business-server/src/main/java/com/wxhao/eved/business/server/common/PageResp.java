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

    private PageResp() {
    }

    public static <T> PageResp<T> build(PageReq pageReq, List<T> items, Integer totalCount) {
        PageResp<T> pageResp = new PageResp<>();
        Integer pageSize = pageReq.getPageSize();
        pageResp.setPageReq(pageReq);
        pageResp.setTotalCount(totalCount);
        if (totalCount > 0) {
            pageResp.setTotalPage(totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1);
        }
        pageResp.setItems(items);
        return pageResp;
    }



}
