package com.kyle.cache.config;

import com.kyle.cache.core.BootAdminCache;
import com.kyle.cache.core.ICache;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author kyle
 * @date 2024/3/22
 */
@Configuration
@EnableConfigurationProperties(CacheProperties.class)
@ConditionalOnProperty(prefix = "boot.admin.cache", name = "enabled", havingValue = "true", matchIfMissing = true)
public class CacheAutoConfiguration {


    @Bean
    @ConditionalOnMissingBean
    public BootAdminCache cache(
            ICache redisCache,
            CacheProperties cacheProperties) {
        BootAdminCache bootAdminCache = new BootAdminCache();
        bootAdminCache.setCache(redisCache);
        bootAdminCache.setPrefix(cacheProperties.getPrefix());
        return bootAdminCache;
    }
}