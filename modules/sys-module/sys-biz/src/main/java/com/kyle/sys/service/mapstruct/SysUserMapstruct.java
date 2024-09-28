package com.kyle.sys.service.mapstruct;

import com.kyle.base.mapstruct.BaseMapstruct;
import com.kyle.sys.domain.dto.UserDto;
import com.kyle.sys.domain.dto.UserSaveDto;
import com.kyle.sys.domain.entity.SysUser;

/**
 * @author kyle
 * @date 2024/4/30
 */
@org.mapstruct.Mapper(componentModel = "spring", uses = {}, unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface SysUserMapstruct extends BaseMapstruct<UserDto, SysUser> {

    /**
     * dto转entity
     *
     * @param dto dto
     * @return entity
     */
    SysUser saveDtoToEntity(UserSaveDto dto);
}
