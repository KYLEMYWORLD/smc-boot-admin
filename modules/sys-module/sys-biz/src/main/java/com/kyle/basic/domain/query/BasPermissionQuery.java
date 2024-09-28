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
 * @date 2024/4/29
 */
@Getter
@Setter
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ToString
public class BasPermissionQuery extends BaseQuery {
    /**
     * 菜单名称
     */
    @Schema(description = "菜单名称")
    @Like
    private String name;

    /**
     * 是否启用
     */
    @Schema(description = "是否启用")
    @Equals
    private Boolean enabled;
}
