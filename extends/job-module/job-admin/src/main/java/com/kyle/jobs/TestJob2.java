package com.kyle.jobs;

import com.kyle.base.exception.JobException;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;

/**
 * 参数测试
 *
 * @author kyle
 * @date 2024/3/22
 */
@Slf4j
public class TestJob2 extends AbstractSkipableJob {
    @Override
    protected void doExecute(JobExecutionContext context) throws JobException {
        JobDataMap jobDataMap = context.getMergedJobDataMap();
        Object parameter = jobDataMap.get("parameter");
        log.info("~~ demo simple job ~~~~,测试2,参数：{}", parameter);
    }
}