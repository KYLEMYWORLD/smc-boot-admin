package com.kyle.sys.service.mapstruct;

import com.kyle.base.mapstruct.BaseMapstruct;
import com.kyle.sys.domain.dto.PermissionDto;
import com.kyle.sys.domain.entity.SysPermission;
import com.kyle.sys.domain.entity.SysTenantPermission;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author kyle
 * @date 2024/4/29
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface SysPermissionMapstruct extends BaseMapstruct<PermissionDto, SysPermission> {

    List<PermissionDto> tenantToDtoList(List<SysTenantPermission> permissions);
}
