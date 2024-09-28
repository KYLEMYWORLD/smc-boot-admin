package com.kyle.opentelemetry.autoconfigure.rpc;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author kyle
 * @date 2024/5/1
 */
@ConfigurationProperties(prefix = "boot.admin.opentelemetry.rpc")
@Getter
@Setter
public class OpenTelemetrySofaRpcProperties {
    /**
     * Whether to enable RPC tracing.
     */
    private boolean enabled = true;
}
