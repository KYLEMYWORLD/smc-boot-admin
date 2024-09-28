package com.kyle.rpc.sys.service;

import com.kyle.common.api.JR;
import com.kyle.rpc.sys.domain.NoticeDto;
import com.kyle.rpc.sys.domain.query.NoticeQuery;

import java.util.List;

/**
 * @author kyle
 * @date 2024/5/1
 */
public interface NoticeRpcService {


    /**
     * 查询公告列表
     *
     * @param query 查询条件
     * @return 公告列表
     */
    default JR<List<NoticeDto>> list(NoticeQuery query) {
        return JR.fail("暂未实现");
    }

    /**
     * 关闭公告
     *
     * @param ids .
     * @return .
     */
    default JR<String> close(List<String> ids) {
        return JR.fail("暂未实现");
    }
}
