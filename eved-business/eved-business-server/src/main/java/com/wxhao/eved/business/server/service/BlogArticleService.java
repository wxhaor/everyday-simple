package com.wxhao.eved.business.server.service;

import com.wxhao.eved.business.server.mapper.BlogArticleMapper;
import com.wxhao.eved.business.server.po.BlogArticle;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wxhao
 * @date 2019/3/24
 */
@Service
public class BlogArticleService extends HaoBaseService<BlogArticleMapper, BlogArticle> {


    public List<BlogArticle> findByName(String name) {
        return baseMapper.findByName(name);
    }

}
