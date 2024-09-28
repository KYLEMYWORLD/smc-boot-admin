package com.kyle.sys.service.mapstruct;

import com.kyle.base.mapstruct.BaseMapstruct;
import com.kyle.sys.domain.dto.AreaDto;
import com.kyle.sys.domain.entity.SysArea;
import com.kyle.sys.domain.vo.AreaTreeVo;

import java.util.List;

/**
 * @author kyle
 * @date 2024/5/10
 */
@org.mapstruct.Mapper(componentModel = "spring", uses = {}, unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface SysAreaMapstruct extends BaseMapstruct<AreaDto, SysArea> {

    /**
     * 转换
     *
     * @param list .
     * @return .
     */
    List<AreaTreeVo> toTreeVoList(List<SysArea> list);
}
