package com.kyle.sys.runner;

import com.kyle.base.ApplicationRunner;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * 系统启动完成后执行
 *
 * @author kyle
 * @date 2024/5/6
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class SystemApplicationRunner implements ApplicationRunner, InitializingBean {
    private final ApplicationContext applicationContext;
    private Collection<RefreshCache> refreshCaches;

    @Override
    public void refresh(@Nullable String code) {
        if (null != refreshCaches) {
            refreshCaches.forEach(refreshCache -> refreshCache.refreshCache(code));
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        refreshCaches = applicationContext.getBeansOfType(RefreshCache.class).values();
    }
}
