package com.kyle.base.rpc.filter;

import com.alipay.sofa.rpc.context.RpcInvokeContext;
import com.alipay.sofa.rpc.core.exception.SofaRpcException;
import com.alipay.sofa.rpc.core.request.SofaRequest;
import com.alipay.sofa.rpc.core.response.SofaResponse;
import com.alipay.sofa.rpc.ext.Extension;
import com.alipay.sofa.rpc.filter.AutoActive;
import com.alipay.sofa.rpc.filter.Filter;
import com.alipay.sofa.rpc.filter.FilterInvoker;
import com.kyle.base.context.TenantContext;
import com.kyle.base.context.UserContext;
import com.kyle.base.context.UserInfo;
import lombok.extern.slf4j.Slf4j;

/**
 * @author kyle
 * @date 2024/3/25
 */
@Slf4j
@AutoActive(providerSide = true, consumerSide = false)
@Extension("tenantServerFilter")
public class TenantServerFilter extends Filter {
    @Override
    public SofaResponse invoke(FilterInvoker invoker, SofaRequest request) throws SofaRpcException {
        try {
            String id = RpcInvokeContext.getContext().getRequestBaggage(
                    UserContext.INVOKE_CTX_USER_ID);
            String username = RpcInvokeContext.getContext().getRequestBaggage(
                    UserContext.INVOKE_CTX_USERNAME);
            String sysCode = RpcInvokeContext.getContext().getRequestBaggage(
                    UserContext.INVOKE_CTX_SYS_CODE);

            if (username != null && sysCode != null) {
                log.info("user context username: {}, sysCode: {}", username, sysCode);
//                UserInfo userInfo = new UserInfo(id, username, sysCode);
//                UserContext.set(userInfo);
                UserContext.set(
                        UserInfo.builder()
                                .id(id)
                                .username(username)
                                .sysCode(sysCode)
                                .build()
                );
            }
            return invoker.invoke(request);
        } catch (Exception e) {
            log.error("tenant server filter error", e);
            throw e;
        } finally {
            TenantContext.remove();
        }
    }
}