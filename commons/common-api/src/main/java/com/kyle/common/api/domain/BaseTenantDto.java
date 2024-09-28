package com.kyle.common.api.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author kyle
 * @date 2024/5/14
 */
@Getter
@Setter
@Accessors(chain = true)
public class BaseTenantDto extends BaseDto {

    /**
     * 租户ID
     */
    @Schema(description = "租户ID")
    private String sysCode;
}
