package com.kyle.jobs.sys;

import com.kyle.base.exception.JobException;
import com.kyle.base.utils.CollectionUtil;
import com.kyle.common.api.JR;
import com.kyle.jobs.AbstractSkipableJob;
import com.kyle.rpc.sys.domain.NoticeDto;
import com.kyle.rpc.sys.domain.query.NoticeQuery;
import com.kyle.rpc.sys.service.NoticeRpcService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 系统通知 超时JOB
 *
 * @author kyle
 * @date 2024/4/25
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class NoticeTimeoutJob extends AbstractSkipableJob {
    private final NoticeRpcService noticeRpcService;

    @Override
    protected void doExecute(JobExecutionContext context) throws JobException {
        log.info("~~ 系统通过超时JOB~~~~");
        // 查询还未关闭已超时的系统通知
        NoticeQuery query = new NoticeQuery();
        query.setEnabled(true);
        query.setNoticeTimeEnd(new Date());
        JR<List<NoticeDto>> jr = noticeRpcService.list(query);
        if (!jr.isSuccess()) {
            log.error("查询系统通知超时失败:{}", jr.getMessage());
            throw new JobException("查询系统通知超时失败: message:" + jr.getMessage());
        }

        List<NoticeDto> res = jr.getResult();
        if (CollectionUtil.isEmpty(res)) {
            log.info("查询系统通知超时为空");
            return;
        }
        List<String> ids = res.stream().map(NoticeDto::getId).collect(Collectors.toList());
        log.info("关闭系统通知超时:{}", ids);
        JR<String> jrRes = noticeRpcService.close(ids);
        log.info("关闭系统通知超时结果:{}", jrRes);
        if (!jrRes.isSuccess()) {
            log.error("关闭系统通知超时失败:{}", jrRes.getMessage());
            throw new JobException("关闭系统通知超时失败: message:" + jrRes.getMessage());
        }
    }
}