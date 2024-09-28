package com.kyle.basic.service.mapstruct;

import com.kyle.base.mapstruct.BaseMapstruct;
import com.kyle.basic.domain.dto.BasNoticeDto;
import com.kyle.sys.domain.entity.SysNotice;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author kyle
 * @date 2024/4/29
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BasNoticeMapstruct extends BaseMapstruct<BasNoticeDto, SysNotice> {
}
