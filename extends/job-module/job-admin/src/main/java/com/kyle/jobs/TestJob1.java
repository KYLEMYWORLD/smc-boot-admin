package com.kyle.jobs;

import com.kyle.base.exception.JobException;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;

/**
 * 简单测试
 *
 * @author kyle
 * @date 2024/3/22
 */
@Slf4j
public class TestJob1 extends AbstractSkipableJob {
    @Override
    protected void doExecute(JobExecutionContext context) throws JobException {
        log.info("~~ demo simple job ~~~~,测试1");
    }
}