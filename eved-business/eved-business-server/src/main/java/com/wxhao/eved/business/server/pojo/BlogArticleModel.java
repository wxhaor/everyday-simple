package com.wxhao.eved.business.server.pojo;

import com.wxhao.boot.api.pojo.BaseVO;
import com.wxhao.eved.business.server.po.BaseUpdateTimePO;
import lombok.Data;


@Data
public class BlogArticleModel extends BaseVO {


    /**
     * 文章名称
     */
    private String articleName;

}
