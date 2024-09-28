package com.kyle.base.rpc;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @author kyle
 * @date 2024/4/16
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "boot.admin.rpc")
public class RpcProperties {

    private Map<String, Server> services;

    /**
     * 服务
     */
    @Data
    public static class Server {
        /**
         * 服务名称
         */
        private String name;
        /**
         * 服务地址
         */
        private String address;
    }
}