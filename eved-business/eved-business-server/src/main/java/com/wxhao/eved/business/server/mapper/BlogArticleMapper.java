package com.wxhao.eved.business.server.mapper;

import com.wxhao.eved.business.server.po.BlogArticle;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BlogArticleMapper extends HaoBaseMapper<BlogArticle> {

    List<BlogArticle> findByName(String name);

}