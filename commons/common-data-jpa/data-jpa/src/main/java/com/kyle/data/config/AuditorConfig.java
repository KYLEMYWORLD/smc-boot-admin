package com.kyle.data.config;

import com.kyle.base.context.UserContext;
import com.kyle.base.context.UserInfo;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

/**
 * @author kyle
 * @date 2024/5/2
 */
@Configuration
@EnableJpaAuditing
public class AuditorConfig implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        UserInfo userInfo = UserContext.get();
        if (null != userInfo) {
            return Optional.of(userInfo.getUsername());
        }
        return Optional.empty();
    }
}
