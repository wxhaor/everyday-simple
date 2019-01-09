package com.wxhao.eved.business.server.plugin.qiniu;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class QiniuConfigProperties {

    String accessKey = "ae3GNnCaMIdcdDcf2PGthTEWSQw4O5eSX3CUkgnt";
    String secretKey = "EJUyk3em0gEPIWlNFqJ0KrqJcUf8PXY2SKTqHQoh";
    String bucket = "everyday";
    String zoneName = "z2";
}
