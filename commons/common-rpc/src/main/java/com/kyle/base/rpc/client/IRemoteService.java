package com.kyle.base.rpc.client;

import org.springframework.beans.factory.BeanFactoryAware;

/**
 * 远程服务
 *
 * @author kyle
 * @date 2024/3/22
 */
public interface IRemoteService<T> extends BeanFactoryAware {


    /**
     * 根据接口类型取得RPC接口
     *
     * @param which 服务标识
     * @return RPC接口
     */
    T getRpcService(String which);
}