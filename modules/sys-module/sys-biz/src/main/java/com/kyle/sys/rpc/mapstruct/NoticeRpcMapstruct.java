package com.kyle.sys.rpc.mapstruct;

import com.kyle.base.mapstruct.BaseMapstruct;
import com.kyle.rpc.sys.domain.NoticeDto;

/**
 * @author kyle
 * @date 2024/5/1
 */
@org.mapstruct.Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface NoticeRpcMapstruct extends BaseMapstruct<NoticeDto, com.kyle.sys.domain.dto.NoticeDto> {
}
