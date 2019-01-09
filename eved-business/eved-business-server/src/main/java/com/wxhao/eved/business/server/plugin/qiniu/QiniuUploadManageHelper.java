package com.wxhao.eved.business.server.plugin.qiniu;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.StringMap;
import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;

@Slf4j
public class QiniuUploadManageHelper {

    public static DefaultPutRet simpleUpload(InputStream inputStream) {
        //构造一个带指定Zone对象的配置类
        UploadManager uploadManager = new UploadManager(QiniuConfig.getConfiguration());

        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = null;
        StringMap stringMap = null;
        String mimeType = null;
        String upToken = QiniuConfig.simpleToken();
        try {
            Response response = uploadManager.put(inputStream, key, upToken, stringMap, mimeType);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            return putRet;
        } catch (QiniuException ex) {
            Response r = ex.response;
            log.error(r.toString(), ex);
            try {
                log.error(r.bodyString());
            } catch (QiniuException exBodyString) {
                log.error("QiniuException-Error", exBodyString);
            }
        }
        throw new RuntimeException("上传失败");

    }
}
