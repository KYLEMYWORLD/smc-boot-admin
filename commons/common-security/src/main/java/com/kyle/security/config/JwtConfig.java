package com.kyle.security.config;

import com.kyle.security.utils.JwtUtil;
import org.springframework.context.annotation.Configuration;

/**
 * @author kyle
 * @date 2024/3/23
 */
@Configuration
public class JwtConfig {
    public JwtConfig(SecurityProperties securityProperties) {
        JwtUtil.setSecurityProperties(securityProperties);
    }
}