package com.kyle.sys.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.kyle.base.R;
import com.kyle.base.exception.JobException;
import com.kyle.common.api.JR;
import com.kyle.common.api.JsfPage;
import com.kyle.common.api.ResponseUtil;
import com.kyle.data.core.service.BaseService;
import com.kyle.query.jpa.QueryHelper;
import com.kyle.sys.domain.dto.QuartzJobDto;
import com.kyle.sys.domain.entity.SysQuartzJob;
import com.kyle.sys.domain.query.QuartzJobQuery;
import com.kyle.sys.remoterpc.JobRemoteRpcService;
import com.kyle.sys.repository.SysQuartzJobRepository;
import com.kyle.sys.service.mapstruct.SysQuartzJobMapstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author kyle
 * @date 2024/4/30
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class SysQuartzJobService extends BaseService<SysQuartzJobRepository, SysQuartzJob, String> {
    private final SysQuartzJobMapstruct mapstruct;
    private final JobRemoteRpcService jobRemoteRpcService;

    /**
     * 验证cron表达式
     *
     * @param cronExpression cron表达式
     * @return 是否成功
     */
    public R<String> validateCron(String cronExpression) {
        JR<String> jr = jobRemoteRpcService.validateCronExpression(cronExpression);
        return ResponseUtil.converter(jr);
    }

    /**
     * 分页查询
     *
     * @param query 查询条件
     * @return 分页数据
     */
    public JsfPage<QuartzJobDto> page(QuartzJobQuery query) {
        Specification<SysQuartzJob> specification = QueryHelper.ofBean(query);
        Pageable page = QueryHelper.toPage(query);
        Page<SysQuartzJob> pageData = findAll(specification, page);
        List<QuartzJobDto> res = mapstruct.toDtoList(pageData.getContent());
        return QueryHelper.toJsfPage(pageData, res);
    }

    /**
     * 获取详情
     *
     * @param id .
     * @return .
     */
    public QuartzJobDto get(String id) {
        SysQuartzJob sysQuartzJob = getById(id);
        return mapstruct.toDto(sysQuartzJob);
    }

    /**
     * 保存
     *
     * @param dto 数据
     */
    @Transactional(rollbackFor = Exception.class)
    public void save(QuartzJobDto dto) {
        SysQuartzJob sysQuartzJob = mapstruct.toEntity(dto);
        save(sysQuartzJob);

        com.kyle.rpc.job.domain.QuartzJobDto res = BeanUtil.toBean(sysQuartzJob, com.kyle.rpc.job.domain.QuartzJobDto.class);
        JR<String> jr = jobRemoteRpcService.add(res);
        if (!jr.isSuccess()) {
            throw new JobException(jr.getMessage());
        }
    }

    /**
     * 更新
     *
     * @param dto 数据
     */
    @Transactional(rollbackFor = Exception.class)
    public void update(QuartzJobDto dto) {
        JR<String> jr = jobRemoteRpcService.edit(BeanUtil.toBean(dto, com.kyle.rpc.job.domain.QuartzJobDto.class));
        if (!jr.isSuccess()) {
            throw new JobException(jr.getMessage());
        }
        SysQuartzJob entity = getById(dto.getId());
        SysQuartzJob sysQuartzJob = mapstruct.toEntity(dto);
        BeanUtil.copyProperties(sysQuartzJob, entity, CopyOptions.create().setIgnoreNullValue(true));
        updateById(entity);
    }

    /**
     * 删除
     *
     * @param ids id
     */
    @Transactional(rollbackFor = Exception.class)
    public void deleteByIds(List<String> ids) {
        List<SysQuartzJob> sysQuartzJobs = findAllByIds(ids);
        sysQuartzJobs.forEach(sysQuartzJob -> {
            JR<String> jr = jobRemoteRpcService.delete(BeanUtil.toBean(sysQuartzJob, com.kyle.rpc.job.domain.QuartzJobDto.class));
            if (!jr.isSuccess()) {
                throw new JobException(jr.getMessage());
            }
        });
        removeByIds(ids);
    }

    /**
     * 暂停
     *
     * @param id id
     */
    @Transactional(rollbackFor = Exception.class)
    public void pause(String id) {
        SysQuartzJob sysQuartzJob = getById(id);
        if (sysQuartzJob == null) {
            throw new JobException("任务不存在");
        }
        sysQuartzJob.setEnabled(false);
        updateById(sysQuartzJob);
        JR<String> jr = jobRemoteRpcService.pauseJob(BeanUtil.toBean(sysQuartzJob, com.kyle.rpc.job.domain.QuartzJobDto.class));
        if (!jr.isSuccess()) {
            throw new JobException(jr.getMessage());
        }
    }

    /**
     * 恢复
     *
     * @param id id
     */
    @Transactional(rollbackFor = Exception.class)
    public void resume(String id) {
        SysQuartzJob sysQuartzJob = getById(id);
        if (sysQuartzJob == null) {
            throw new JobException("任务不存在");
        }
        sysQuartzJob.setEnabled(true);
        updateById(sysQuartzJob);
        JR<String> jr = jobRemoteRpcService.resumeJob(BeanUtil.toBean(sysQuartzJob, com.kyle.rpc.job.domain.QuartzJobDto.class));
        if (!jr.isSuccess()) {
            throw new JobException(jr.getMessage());
        }
    }

    /**
     * 立即执行
     *
     * @param id id
     */
    public void run(String id) {
        SysQuartzJob sysQuartzJob = getById(id);
        JR<String> jr = jobRemoteRpcService.run(BeanUtil.toBean(sysQuartzJob, com.kyle.rpc.job.domain.QuartzJobDto.class));
        if (!jr.isSuccess()) {
            throw new JobException(jr.getMessage());
        }
    }

}
