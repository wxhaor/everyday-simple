package com.wxhao.eved.business.server.pojo;

import com.wxhao.boot.api.pojo.BaseVO;
import com.wxhao.eved.business.server.po.BaseCreateTimePO;
import lombok.Data;

/**
 * $tableComment
 */
@Data
public class BlogImageVO extends BaseVO {

    /**
     * 文章id
     */
    private Long articleId;

    /**
     * 文章名称
     */
    private String articleName;

    /**
     * 图片(七牛)key
     */
    private String imageKey;

    /**
     * 图片(七牛)hash值
     */
    private String imageHash;

    /**
     * 图片名称
     */
    private String imageName;

    private String imageUrl;

}
