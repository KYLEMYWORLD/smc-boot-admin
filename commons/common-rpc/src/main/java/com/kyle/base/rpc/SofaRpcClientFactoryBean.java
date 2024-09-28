package com.kyle.base.rpc;

import com.alipay.sofa.runtime.api.aware.ClientFactoryAware;
import com.alipay.sofa.runtime.api.client.ClientFactory;
import lombok.Getter;
import org.springframework.stereotype.Component;

/**
 * SofaRpcClientFactoryBean
 *
 * @author kyle
 * @date 2024/3/22
 */
@Getter
@Component
public class SofaRpcClientFactoryBean implements ClientFactoryAware {
    private ClientFactory clientFactory;

    @Override
    public void setClientFactory(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }
}