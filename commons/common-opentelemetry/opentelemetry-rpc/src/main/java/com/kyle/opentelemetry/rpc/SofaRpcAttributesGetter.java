package com.kyle.opentelemetry.rpc;

import com.alipay.sofa.rpc.core.request.SofaRequest;
import io.opentelemetry.instrumentation.api.incubator.semconv.rpc.RpcAttributesGetter;

import java.util.List;

/**
 * @author kyle
 * @date 2024/5/1
 */
enum SofaRpcAttributesGetter implements RpcAttributesGetter<SofaRequest> {
    INSTANCE;


    @Override
    public String getSystem(SofaRequest request) {
        return "sofa-rpc";
    }

    @Override
    public String getService(SofaRequest request) {
        return request.getInterfaceName();
    }

    @Override
    public String getMethod(SofaRequest request) {
        return request.getMethodName();
    }

    List<String> metadataValue(SofaRequest request, String key) {
        return null;
    }
}