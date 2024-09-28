package com.kyle.security.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * 刷新用户信息事件
 *
 * @author kyle
 * @date 2024/5/13
 */
@Getter
public class RefreshUserEvent extends ApplicationEvent {
    private final String username;
    private final String sysCode;

    public RefreshUserEvent(Object source, String username, String sysCode) {
        super(source);
        this.username = username;
        this.sysCode = sysCode;
    }
}
