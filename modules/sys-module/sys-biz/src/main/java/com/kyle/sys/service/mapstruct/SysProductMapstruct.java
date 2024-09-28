package com.kyle.sys.service.mapstruct;

import com.kyle.base.mapstruct.BaseMapstruct;
import com.kyle.sys.domain.dto.ProductDto;
import com.kyle.sys.domain.entity.SysProduct;

/**
 * @author kyle
 * @date 2024/4/29
 */
@org.mapstruct.Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface SysProductMapstruct extends BaseMapstruct<ProductDto, SysProduct> {
}
