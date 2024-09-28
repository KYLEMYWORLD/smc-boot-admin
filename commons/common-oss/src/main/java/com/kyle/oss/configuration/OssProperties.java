package com.kyle.oss.configuration;

import com.kyle.oss.core.aliyun.AliyunOssProperties;
import com.kyle.oss.core.s3.S3OssProperties;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author kyle
 * @date 2024/5/8
 */
@Data
@ConfigurationProperties(prefix = "boot.admin.oss")
public class OssProperties {
    /**
     * 是否启用
     */
    private boolean enabled;
    /**
     * 类型
     */
    private String type;
    /**
     * 阿里云oss
     */
    private AliyunOssProperties aliyun = new AliyunOssProperties();
    /**
     * s3
     */
    private S3OssProperties s3 = new S3OssProperties();
}
