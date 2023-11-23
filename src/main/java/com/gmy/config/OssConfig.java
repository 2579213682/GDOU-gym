package com.gmy.config;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 阿里云Oss配置文件
 */
@Configuration
public class OssConfig {

    @Bean
    public OSS ossClient(){
        String endpoint = "oss-cn-shenzhen.aliyuncs.com";
        String accessKeyId = "LTAI5tEXVPbve6aPopB5qzwe";
        String accessKeySecret = "PSvsSq79XnQtdDN4ylboTm1gu8Bwsz";
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        return ossClient;
    }
}
