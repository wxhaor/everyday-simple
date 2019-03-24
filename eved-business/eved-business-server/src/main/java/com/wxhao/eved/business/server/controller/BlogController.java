package com.wxhao.eved.business.server.controller;

import com.qiniu.storage.model.DefaultPutRet;
import com.wxhao.boot.base.utils.JsonUtils;
import com.wxhao.eved.business.server.common.ConvertUtils;
import com.wxhao.eved.business.server.plugin.qiniu.QiniuConfigProperties;
import com.wxhao.eved.business.server.plugin.qiniu.QiniuUploadManageHelper;
import com.wxhao.eved.business.server.po.BlogArticle;
import com.wxhao.eved.business.server.po.BlogImage;
import com.wxhao.eved.business.server.pojo.BlogArticleModel;
import com.wxhao.eved.business.server.pojo.BlogImageVO;
import com.wxhao.eved.business.server.service.BlogArticleService;
import com.wxhao.eved.business.server.service.BlogImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author wxhao
 * @date 2019/3/24
 */
@Slf4j
@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogArticleService blogArticleService;

    @Autowired
    private BlogImageService blogImageService;

    @Autowired
    private QiniuConfigProperties qiniuConfigProperties;


    @PostMapping("/findArticle")
    public List<BlogArticle> findArticle(@RequestBody BlogArticleModel model) {

        return blogArticleService.findByName(model.getArticleName());

    }

    @PostMapping("/findImageByArticleId")
    public List<BlogImageVO> findImageByArticleId(@RequestBody BlogArticleModel model) {
        List<BlogImage> images = blogImageService.findImageByArticleId(model.getId());
        return ConvertUtils.convertAfter(images, BlogImageVO.class, (blogImage, blogImageVO) -> {
            StringBuilder url = new StringBuilder();
            url = url.append(qiniuConfigProperties.getUrlPrefix())
                    .append(blogImage.getImageKey());
            blogImageVO.setImageUrl(url.toString());
        });
    }

    @PostMapping("/addArticle")
    public BlogArticle addArticle(@RequestBody BlogArticleModel model) {
        BlogArticle blogArticle = new BlogArticle();
        blogArticle.setArticleName(model.getArticleName());
        return blogArticleService.saveGet(blogArticle);

    }

    /**
     * 表单上传文件
     *
     * @param file
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file, String articleName, Long id) {
        InputStream inputStream = null;
        StringBuilder url = new StringBuilder();
        try {
            inputStream = file.getInputStream();
            file.getName();
            //上传图片
            DefaultPutRet ret = QiniuUploadManageHelper.simpleUpload(inputStream);
            log.info("上传成功-DefaultPutRet:{}", JsonUtils.toJson(ret));
            //拼装url
            url.append(qiniuConfigProperties.getUrlPrefix()).append(ret.key);

            BlogImage blogImage = new BlogImage();
            blogImage.setArticleId(id);
            blogImage.setArticleName(articleName);
            blogImage.setImageHash(ret.hash);
            blogImage.setImageKey(ret.key);
            blogImage.setImageName(file.getOriginalFilename());
            blogImageService.save(blogImage);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return url.toString();
    }

}
