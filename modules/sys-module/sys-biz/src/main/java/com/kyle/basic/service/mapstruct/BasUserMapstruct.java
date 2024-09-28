package com.kyle.basic.service.mapstruct;

import com.kyle.base.mapstruct.BaseMapstruct;
import com.kyle.basic.domain.dto.BasUserDto;
import com.kyle.basic.domain.dto.BasUserSaveDto;
import com.kyle.basic.domain.entity.BasUser;

/**
 * @author kyle
 * @date 2024/4/30
 */
@org.mapstruct.Mapper(componentModel = "spring", uses = {}, unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface BasUserMapstruct extends BaseMapstruct<BasUserDto, BasUser> {

    BasUser toEntity(BasUserSaveDto dto);
}
