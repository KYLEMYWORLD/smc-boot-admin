package com.kyle.basic.domain.query;

import com.kyle.common.api.BaseQuery;
import com.kyle.query.annotation.Equals;
import com.kyle.query.annotation.Like;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author kyle
 * @date 2024/4/30
 */
@Getter
@Setter
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ToString
public class BasRoleQuery extends BaseQuery {
    /**
     * 角色名称
     */
    @Like
    @Schema(description = "角色名称")
    private String name;
    /**
     * 角色标识
     */
    @Equals
    @Schema(description = "角色标识")
    private String code;
    /**
     * 是否启用
     */
    @Schema(description = "是否启用")
    @Equals
    private Boolean enabled;
    /**
     * 商户识别码
     */
    @Equals
    @Schema(description = "商户识别码", hidden = true)
    private String sysCode;
}
