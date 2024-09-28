package com.kyle.basic.service.mapstruct;

import com.kyle.base.mapstruct.BaseMapstruct;
import com.kyle.basic.domain.dto.BasRoleDto;
import com.kyle.basic.domain.entity.BasRole;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author kyle
 * @date 2024/4/30
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BasRoleMapstruct extends BaseMapstruct<BasRoleDto, BasRole> {
}
