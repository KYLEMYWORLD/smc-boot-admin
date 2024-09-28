package com.kyle.basic.service.mapstruct;

import com.kyle.base.mapstruct.BaseMapstruct;
import com.kyle.basic.domain.dto.BasOrgDto;
import com.kyle.basic.domain.entity.BasOrg;

/**
 * @author kyle
 * @date 2024/4/30
 */
@org.mapstruct.Mapper(componentModel = "spring", uses = {}, unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface BasOrgMapstruct extends BaseMapstruct<BasOrgDto, BasOrg> {
}
