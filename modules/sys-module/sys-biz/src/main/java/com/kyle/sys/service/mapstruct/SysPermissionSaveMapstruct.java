package com.kyle.sys.service.mapstruct;

import com.kyle.base.mapstruct.BaseMapstruct;
import com.kyle.sys.domain.dto.PermissionSaveDto;
import com.kyle.sys.domain.entity.SysPermission;
import com.kyle.sys.domain.entity.SysTenantPermission;

/**
 * @author kyle
 * @date 2024/4/29
 */
@org.mapstruct.Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface SysPermissionSaveMapstruct extends BaseMapstruct<PermissionSaveDto, SysPermission> {

    /**
     * 转换
     *
     * @param dto .
     * @return .
     */
    SysTenantPermission toTenant(PermissionSaveDto dto);
}
