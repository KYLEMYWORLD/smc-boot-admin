package com.kyle.rpcservice;

import com.kyle.base.rpc.server.BaseServerRpcService;
import com.kyle.common.api.JR;
import com.kyle.rpc.job.domain.QuartzJobDto;
import com.kyle.rpc.job.service.QuartzJobServerRpcService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author kyle
 * @date 2024/4/14
 */
@Service
@Slf4j
public class QuartzJobServerRpcServiceImpl extends BaseServerRpcService<QuartzJobServerRpcService> implements QuartzJobServerRpcService {
    @Qualifier("quartzJobService")
    @Resource
    private QuartzJobServerRpcService quartzJobService;

    @Override
    public JR<String> validateCronExpression(String cronExpression) {
        return quartzJobService.validateCronExpression(cronExpression);
    }

    @Override
    public JR<String> add(QuartzJobDto quartzJobDto) {
        return quartzJobService.add(quartzJobDto);
    }

    @Override
    public JR<String> edit(QuartzJobDto quartzJobDto) {
        return quartzJobService.edit(quartzJobDto);
    }

    @Override
    public JR<String> delete(QuartzJobDto quartzJobDto) {
        return quartzJobService.delete(quartzJobDto);
    }

    @Override
    public JR<String> pauseJob(QuartzJobDto quartzJobDto) {
        return quartzJobService.pauseJob(quartzJobDto);
    }

    @Override
    public JR<String> resumeJob(QuartzJobDto quartzJobDto) {
        return quartzJobService.resumeJob(quartzJobDto);
    }

    @Override
    public JR<String> run(QuartzJobDto quartzJobDto) {
        return quartzJobService.run(quartzJobDto);
    }
}