package com.kyle.sys.service.mapstruct;

import com.kyle.base.mapstruct.BaseMapstruct;
import com.kyle.sys.domain.dto.DictDto;
import com.kyle.sys.domain.entity.SysDict;

/**
 * @author kyle
 * @date 2024/5/5
 */
@org.mapstruct.Mapper(componentModel = "spring", uses = {}, unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface SysDictMapstruct extends BaseMapstruct<DictDto, SysDict> {
}
