package com.wxhao.eved.business.server.service;

import com.wxhao.eved.business.server.mapper.BlogImageMapper;
import com.wxhao.eved.business.server.po.BlogImage;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wxhao
 * @date 2019/3/24
 */
@Service
public class BlogImageService extends HaoBaseService<BlogImageMapper, BlogImage> {


    public List<BlogImage> findImageByArticleId(Long articleId){

        return baseMapper.findImageByArticleId(articleId);
    }

}
