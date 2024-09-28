package com.kyle.basic.service.mapstruct;

import com.kyle.base.mapstruct.BaseMapstruct;
import com.kyle.basic.domain.dto.BasPostDto;
import com.kyle.basic.domain.entity.BasPost;

/**
 * @author kyle
 * @date 2024/5/7
 */
@org.mapstruct.Mapper(componentModel = "spring", uses = {}, unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface BasPostMapstruct extends BaseMapstruct<BasPostDto, BasPost> {
}
