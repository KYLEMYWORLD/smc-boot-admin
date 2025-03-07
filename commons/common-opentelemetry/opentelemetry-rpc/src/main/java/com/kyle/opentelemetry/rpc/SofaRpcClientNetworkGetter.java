package com.kyle.opentelemetry.rpc;

import com.alipay.sofa.rpc.client.ProviderInfo;
import com.alipay.sofa.rpc.context.RpcInternalContext;
import com.alipay.sofa.rpc.core.request.SofaRequest;
import com.alipay.sofa.rpc.core.response.SofaResponse;
import io.opentelemetry.instrumentation.api.semconv.network.NetworkAttributesGetter;
import io.opentelemetry.instrumentation.api.semconv.network.ServerAttributesGetter;

/**
 * @author kyle
 * @date 2024/5/1
 */
public class SofaRpcClientNetworkGetter implements ServerAttributesGetter<SofaRequest>,
        NetworkAttributesGetter<SofaRequest,
                SofaResponse> {


    @Override
    public String getServerAddress(SofaRequest request) {
        RpcInternalContext context = RpcInternalContext.getContext();
        if (null != context) {
            ProviderInfo providerInfo = context.getProviderInfo();
            if (null != providerInfo) {
                return providerInfo.getHost();
            }
        }
        return null;
    }

    @Override
    public Integer getServerPort(SofaRequest request) {

        RpcInternalContext context = RpcInternalContext.getContext();
        if (null != context) {
            ProviderInfo providerInfo = context.getProviderInfo();
            if (null != providerInfo) {
                return providerInfo.getPort();
            }
        }
        return null;
    }

}