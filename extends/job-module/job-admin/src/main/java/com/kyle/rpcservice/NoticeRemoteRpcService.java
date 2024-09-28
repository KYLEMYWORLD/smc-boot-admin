package com.kyle.rpcservice;

import com.kyle.base.rpc.client.BaseRemoteRpcService;
import com.kyle.common.api.JR;
import com.kyle.rpc.sys.domain.NoticeDto;
import com.kyle.rpc.sys.domain.query.NoticeQuery;
import com.kyle.rpc.sys.service.NoticeRpcService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kyle
 * @date 2024/5/1
 */
@Slf4j
@Service
public class NoticeRemoteRpcService extends BaseRemoteRpcService<NoticeRpcService> implements NoticeRpcService {
    @Override
    protected String getAppName() {
        return "sys";
    }

    @Override
    public JR<List<NoticeDto>> list(NoticeQuery query) {
        return getRpcService().list(query);
    }

    @Override
    public JR<String> close(List<String> ids) {
        return getRpcService().close(ids);
    }
}
