package com.kyle.jobs;

import com.kyle.base.exception.JobException;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Bean 测试
 *
 * @author kyle
 * @date 2024/3/22
 */
@Component
@Slf4j
public class TestJob3 extends AbstractSkipableJob {
    @Autowired
    private ApplicationContext applicationContext;

    @Override
    protected void doExecute(JobExecutionContext context) throws JobException {
        TestJob3 testJob3 = applicationContext.getBean("testJob3", TestJob3.class);
        log.info("~~ demo simple job ~~~~,测试3 spring bean name: {}", testJob3.getClass().getName());
    }
}