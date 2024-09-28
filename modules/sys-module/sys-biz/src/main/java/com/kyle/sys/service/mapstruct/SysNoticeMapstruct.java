package com.kyle.sys.service.mapstruct;

import com.kyle.base.mapstruct.BaseMapstruct;
import com.kyle.sys.domain.dto.NoticeDto;
import com.kyle.sys.domain.entity.SysNotice;

/**
 * @author kyle
 * @date 2024/4/29
 */
@org.mapstruct.Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface SysNoticeMapstruct extends BaseMapstruct<NoticeDto, SysNotice> {
}
