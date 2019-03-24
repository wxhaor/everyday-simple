package com.wxhao.eved.business.server.controller;

import com.qiniu.storage.model.DefaultPutRet;
import com.wxhao.boot.base.utils.JsonUtils;
import com.wxhao.eved.business.server.plugin.qiniu.QiniuConfigProperties;
import com.wxhao.eved.business.server.plugin.qiniu.QiniuUploadManageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@RestController
@Slf4j
public class QiniuObjectStorageController {

    @Autowired
    private QiniuConfigProperties qiniuConfigProperties;

    /**
     * 表单上传文件
     *
     * @param file
     */
//    @PostMapping("upload")
//    public String upload(@RequestParam("file") MultipartFile file , String name) {
//        InputStream inputStream = null;
//        StringBuilder url = new StringBuilder();
//        log.info("QiniuObjectStorageController#upload#name:{}", name);
//        log.info("QiniuObjectStorageController#upload#file.getName():{}", file.getName());
//        try {
//            inputStream = file.getInputStream();
//            file.getName();
//            DefaultPutRet defaultPutRet = QiniuUploadManageHelper.simpleUpload(inputStream);
//            log.info("上传成功-QiniuObjectStorageController#upload#defaultPutRet:{}", JsonUtils.toJson(defaultPutRet));
//            url.append(qiniuConfigProperties.getUrlPrefix());
//            url.append(defaultPutRet.key);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return url.toString();
//    }
}
