package com.kyle.sys.rpc;

import cn.hutool.core.bean.BeanUtil;
import com.kyle.base.rpc.server.BaseServerRpcService;
import com.kyle.common.api.JR;
import com.kyle.rpc.sys.domain.NoticeDto;
import com.kyle.rpc.sys.domain.query.NoticeQuery;
import com.kyle.rpc.sys.service.NoticeRpcService;
import com.kyle.sys.rpc.mapstruct.NoticeRpcMapstruct;
import com.kyle.sys.service.SysNoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kyle
 * @date 2024/5/1
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class NoticeRpcServiceImpl extends BaseServerRpcService<NoticeRpcService> implements NoticeRpcService {
    private final SysNoticeService noticeService;
    private final NoticeRpcMapstruct mapstruct;

    @Override
    public JR<List<NoticeDto>> list(NoticeQuery query) {
        com.kyle.sys.domain.query.NoticeQuery _query = BeanUtil.toBean(query, com.kyle.sys.domain.query.NoticeQuery.class);
        List<com.kyle.sys.domain.dto.NoticeDto> list = noticeService.list(_query);
        List<NoticeDto> res = mapstruct.toDtoList(list);
        return JR.okData(res);

    }

    @Override
    public JR<String> close(List<String> ids) {
        noticeService.closeByIds(ids);
        return JR.ok();
    }
}
