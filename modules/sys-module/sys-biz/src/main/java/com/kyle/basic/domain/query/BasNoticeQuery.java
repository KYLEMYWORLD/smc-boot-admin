package com.kyle.basic.domain.query;

import com.kyle.common.api.BaseQuery;
import com.kyle.query.annotation.Equals;
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
public class BasNoticeQuery extends BaseQuery {
    @Schema(hidden = true)
    private String userId;
    /**
     * 商户ID
     */
    @Equals(allowNull = true)
    @Schema(hidden = true)
    private String orgId;


    @Equals
    @Schema(hidden = true)
    private Boolean enabled;
}
