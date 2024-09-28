package com.kyle.sys.service.mapstruct;

import com.kyle.base.mapstruct.BaseMapstruct;
import com.kyle.sys.domain.dto.TenantDto;
import com.kyle.sys.domain.entity.SysTenant;

/**
 * @author kyle
 * @date 2024/5/3
 */
@org.mapstruct.Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface SysTenantMapstruct extends BaseMapstruct<TenantDto, SysTenant> {
}
