package com.kyle.sys.service.mapstruct;

import com.kyle.base.mapstruct.BaseMapstruct;
import com.kyle.sys.domain.dto.QuartzJobDto;
import com.kyle.sys.domain.entity.SysQuartzJob;

/**
 * @author kyle
 * @date 2024/4/30
 */
@org.mapstruct.Mapper(componentModel = "spring", uses = {}, unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface SysQuartzJobMapstruct extends BaseMapstruct<QuartzJobDto, SysQuartzJob> {
}
