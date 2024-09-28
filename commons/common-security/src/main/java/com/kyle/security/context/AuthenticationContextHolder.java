package com.kyle.security.context;

/**
 * 认证上下文
 *
 * @author kyle
 * @date 2024/3/23
 */
public class AuthenticationContextHolder {
    private static final ThreadLocal<AuthenticationContext> CONTEXT = new ThreadLocal<>();

    public static void setContext(AuthenticationContext context) {
        CONTEXT.set(context);
    }

    public static AuthenticationContext getContext() {
        return CONTEXT.get();
    }

    public static void clear() {
        CONTEXT.remove();
    }
}