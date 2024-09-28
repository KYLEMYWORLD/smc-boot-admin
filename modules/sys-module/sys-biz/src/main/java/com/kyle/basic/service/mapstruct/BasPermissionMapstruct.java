package com.kyle.basic.service.mapstruct;

import com.kyle.base.mapstruct.BaseMapstruct;
import com.kyle.basic.domain.dto.BasPermissionDto;
import com.kyle.basic.domain.entity.BasPermission;
import com.kyle.sys.domain.dto.PermissionDto;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author kyle
 * @date 2024/4/29
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface BasPermissionMapstruct extends BaseMapstruct<BasPermissionDto, BasPermission> {
    /**
     * 转换
     *
     * @param permissions .
     * @return .
     */
    List<PermissionDto> toPermissionDtoList(List<BasPermission> permissions);
}
