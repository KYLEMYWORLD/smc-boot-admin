package com.kyle.sys.domain.query;

import com.kyle.common.api.BaseQuery;
import com.kyle.query.annotation.Equals;
import com.kyle.query.annotation.Like;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author kyle
 * @date 2024/4/28
 */
@Getter
@Setter
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class PermissionQuery extends BaseQuery {
    /**
     * 菜单名称
     */
    @Like
    @Schema(description = "菜单名称")
    private String title;

    /**
     * 父级id
     */
    @Equals(allowNull = true)
    @Schema(description = "父级id")
    private String parentId;
}
