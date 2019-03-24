package com.wxhao.eved.business.server.mapper;

import com.wxhao.eved.business.server.po.BlogImage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BlogImageMapper extends HaoBaseMapper<BlogImage> {


    List<BlogImage> findImageByArticleId(Long articleId);

}