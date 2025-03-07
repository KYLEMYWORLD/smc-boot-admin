package com.kyle.security.service;

import com.kyle.base.context.TenantContext;
import com.kyle.base.context.UserContext;
import com.kyle.base.context.UserInfo;
import com.kyle.security.cache.UserProvider;
import com.kyle.security.domain.dto.UserInfoDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author kyle
 * @date 2024/4/2
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {
    private final UserProvider userProvider;
    private final UserLoginService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String tenantId = TenantContext.get();
        Optional<String> sysCode = Optional.ofNullable(tenantId);
        boolean isAdminLogin = sysCode.isEmpty();

        String cacheKey = UserProvider.getCacheKey(username, sysCode.orElse(null));
        UserInfoDto user = userProvider.getUser(cacheKey);
        if (null == user) {
            if (Boolean.TRUE.equals(isAdminLogin)) {
                user = userService.findByUsername(username);
            } else {
                user = userService.findByUsername(username, sysCode.orElse(null));
            }
            userProvider.putUser(cacheKey, user);
        }

        // user 上下文
        UserContext.set(
                UserInfo.builder()
                        .id(user.getId())
                        .username(user.getUsername())
                        .sysCode(user.getSysCode())
                        .dataScopes(user.getDataScopes())
                        .build()
        );


        return user;
    }
}