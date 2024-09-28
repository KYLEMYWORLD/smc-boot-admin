package com.kyle.oss.configuration;

import com.kyle.base.exception.ServiceException;
import com.kyle.oss.core.OssStorage;
import com.kyle.oss.core.aliyun.AliyunOssProperties;
import com.kyle.oss.core.aliyun.AliyunOssStorage;
import com.kyle.oss.core.s3.S3OssProperties;
import com.kyle.oss.core.s3.S3OssStorage;
import com.kyle.oss.factory.OssFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author kyle
 * @date 2024/5/8
 */
@Configuration
@ConditionalOnProperty(prefix = "boot.admin.oss", name = "enabled", havingValue = "true")
@EnableConfigurationProperties({OssProperties.class})
public class OssAutoConfiguration {

    @Bean
    @ConditionalOnProperty(prefix = "boot.admin.oss", name = "type", havingValue = "aliyun")
    @ConditionalOnMissingBean
    public OssStorage aliyunOssStorage(OssProperties properties) {
        AliyunOssProperties aliyun = properties.getAliyun();
        if (aliyun != null) {
            AliyunOssStorage aliyunOssStorage = new AliyunOssStorage(aliyun);
            OssFactory.registerStorage("DEFAULT", aliyunOssStorage);
            return aliyunOssStorage;
        }
        throw new ServiceException("Aliyun OSS properties cannot be null");
    }

    @Bean
    @ConditionalOnProperty(prefix = "boot.admin.oss", name = "type", havingValue = "s3")
    @ConditionalOnMissingBean
    public OssStorage s3OssStorage(OssProperties properties) {
        S3OssProperties s3 = properties.getS3();
        if (s3 != null) {
            S3OssStorage s3OssStorage = new S3OssStorage(s3);
            OssFactory.registerStorage("DEFAULT", s3OssStorage);
            return s3OssStorage;
        }
        throw new ServiceException("S3 OSS properties cannot be null");
    }
}
