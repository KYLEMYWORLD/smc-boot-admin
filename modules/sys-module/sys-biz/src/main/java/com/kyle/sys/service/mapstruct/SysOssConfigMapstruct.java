package com.kyle.sys.service.mapstruct;

import com.kyle.base.mapstruct.BaseMapstruct;
import com.kyle.sys.domain.dto.OssConfigDto;
import com.kyle.sys.domain.entity.SysOssConfig;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author kyle
 * @date 2024/4/30
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SysOssConfigMapstruct extends BaseMapstruct<OssConfigDto, SysOssConfig> {
}
