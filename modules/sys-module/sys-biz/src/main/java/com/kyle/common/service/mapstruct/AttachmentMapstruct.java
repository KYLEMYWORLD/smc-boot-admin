package com.kyle.common.service.mapstruct;

import com.kyle.base.mapstruct.BaseMapstruct;
import com.kyle.common.domain.dto.AttachmentDto;
import com.kyle.common.domain.entity.Attachment;

/**
 * @author kyle
 * @date 2024/5/9
 */
@org.mapstruct.Mapper(componentModel = "spring", uses = {}, unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface AttachmentMapstruct extends BaseMapstruct<AttachmentDto, Attachment> {
}
