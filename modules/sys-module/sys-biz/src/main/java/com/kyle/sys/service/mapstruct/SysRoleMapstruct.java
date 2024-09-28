package com.kyle.sys.service.mapstruct;

import com.kyle.base.mapstruct.BaseMapstruct;
import com.kyle.sys.domain.dto.RoleDto;
import com.kyle.sys.domain.entity.SysRole;

/**
 * @author kyle
 * @date 2024/4/29
 */
@org.mapstruct.Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface SysRoleMapstruct extends BaseMapstruct<RoleDto, SysRole> {
}
