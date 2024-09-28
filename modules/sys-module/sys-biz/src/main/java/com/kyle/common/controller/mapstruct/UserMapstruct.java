package com.kyle.common.controller.mapstruct;

import com.kyle.basic.domain.entity.BasUser;
import com.kyle.common.domain.vo.UserVo;
import com.kyle.sys.domain.entity.SysUser;

/**
 * @author kyle
 * @date 2024/5/13
 */
@org.mapstruct.Mapper(componentModel = "spring", uses = {}, unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface UserMapstruct {

    /**
     * 转换
     *
     * @param entity 实体
     * @return vo
     */
    UserVo toVo(SysUser entity);

    /**
     * 转换
     *
     * @param entity 实体
     * @return vo
     */
    UserVo toVo(BasUser entity);
}
