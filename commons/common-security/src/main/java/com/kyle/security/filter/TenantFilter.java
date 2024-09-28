package com.kyle.security.filter;

import com.kyle.base.context.TenantContext;
import com.kyle.base.utils.StrUtil;
import com.kyle.security.service.UserLoginService;
import com.kyle.security.utils.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

/**
 * @author kyle
 * @date 2024/5/14
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class TenantFilter extends OncePerRequestFilter {
    private final UserLoginService userLoginService;
    private static final AntPathRequestMatcher DEFAULT_ANT_PATH_REQUEST_MATCHER = new AntPathRequestMatcher("/auth/login",
            "POST");

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        try {
            String tenant = JwtUtil.getTenant(request);
            if (StrUtil.isNotBlank(tenant)) {
                TenantContext.set(tenant);
                chain.doFilter(request, response);
                return;
            }
            String token = JwtUtil.getToken(request);
            if (StrUtil.isNotBlank(token)) {
                Optional<String> tenantOptional = JwtUtil.getTenant(token);
                tenantOptional.ifPresent(TenantContext::set);
                chain.doFilter(request, response);
                return;
            }
            if (DEFAULT_ANT_PATH_REQUEST_MATCHER.matches(request)) {
                String username = obtainUsername(request);
                userLoginService.getSysCodeByUsername(username).ifPresent(TenantContext::set);
            }
            chain.doFilter(request, response);
        } finally {
            TenantContext.remove();
        }
    }

    private String obtainUsername(HttpServletRequest request) {
        return request.getParameter("username");
    }
}
