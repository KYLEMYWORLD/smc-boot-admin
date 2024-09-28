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
 * @date 2024/4/29
 */
@Getter
@Setter
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class TenantQuery extends BaseQuery {
    /**
     * 厂商名称
     */
    @Like
    @Schema(description = "厂商名称")
    private String name;
    /**
     * 厂商代码
     */
    @Equals
    @Schema(description = "厂商代码")
    private String sysCode;

    /**
     * 机构类型
     * 1 厂商
     */
    @Schema(hidden = true)
    @Equals
    private Integer type = 1;

    /**
     * 是否启用
     */
    @Equals
    @Schema(description = "是否启用")
    public Boolean enabled;
}
