package com.kyle.sys.service.mapstruct;

import com.kyle.base.mapstruct.BaseMapstruct;
import com.kyle.common.domain.vo.SelectOptionVo;
import com.kyle.sys.domain.dto.DictItemDto;
import com.kyle.sys.domain.entity.SysDictItem;

import java.util.List;

/**
 * @author kyle
 * @date 2024/5/5
 */
@org.mapstruct.Mapper(componentModel = "spring", uses = {}, unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface SysDictItemMapstruct extends BaseMapstruct<DictItemDto, SysDictItem> {


    /**
     * 转换为SelectOption
     *
     * @param dtoList .
     * @return .
     */
    List<SelectOptionVo> toSelectOption(List<DictItemDto> dtoList);
}
