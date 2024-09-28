package com.kyle.security.controller.mapstruct;

import com.kyle.base.mapstruct.BaseMapstruct;
import com.kyle.security.domain.dto.UserInfoDto;
import com.kyle.security.domain.vo.LoginInfoVo;
import org.mapstruct.Mapper;

/**
 * @author kyle
 * @date 2024/3/25
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface LoginInfoMapstruct extends BaseMapstruct<LoginInfoVo, UserInfoDto> {

}