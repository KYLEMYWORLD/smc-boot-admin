package com.kyle.cache.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author kyle
 * @date 2024/3/22
 */
@ConfigurationProperties(prefix = "boot.admin.cache")
@Setter
@Getter
public class CacheProperties {
    /**
     * 是否启用缓存
     */
    private boolean enabled = true;
    /**
     * 缓存前缀
     */
    private String prefix = "boot_admin";
}