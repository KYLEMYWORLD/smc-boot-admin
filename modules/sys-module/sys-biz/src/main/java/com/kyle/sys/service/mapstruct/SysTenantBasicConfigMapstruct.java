package com.kyle.sys.service.mapstruct;

import com.kyle.base.mapstruct.BaseMapstruct;
import com.kyle.sys.domain.dto.TenantBasicConfigDto;
import com.kyle.sys.domain.entity.SysTenant;

/**
 * @author kyle
 * @date 2024/4/30
 */
@org.mapstruct.Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface SysTenantBasicConfigMapstruct extends BaseMapstruct<TenantBasicConfigDto, SysTenant> {
}
