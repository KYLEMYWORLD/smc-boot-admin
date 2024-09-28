package com.kyle.security.event.listener;

import com.kyle.security.cache.UserProvider;
import com.kyle.security.event.RefreshUserEvent;
import jakarta.annotation.Nonnull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author kyle
 * @date 2024/5/13
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class RefreshUserListener implements ApplicationListener<RefreshUserEvent> {
    private final UserProvider userProvider;

    @Override
    @Async
    public void onApplicationEvent(@Nonnull RefreshUserEvent event) {
        String name = event.getUsername();
        String sysCode = event.getSysCode();

        log.info("刷新用户信息事件>>>>> 用户名:{}, 系统编码:{}", name, sysCode);
        userProvider.removeUser(UserProvider.getCacheKey(name, sysCode));
    }

}
