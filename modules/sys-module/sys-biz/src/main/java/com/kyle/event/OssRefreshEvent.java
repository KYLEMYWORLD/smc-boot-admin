package com.kyle.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * @author kyle
 * @date 2024/5/8
 */
@Getter
public class OssRefreshEvent extends ApplicationEvent {
    private final String sysCode;

    public OssRefreshEvent(String sysCode, Object source) {
        super(source);
        this.sysCode = sysCode;
    }
}
