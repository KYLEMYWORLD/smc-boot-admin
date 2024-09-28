package com.kyle.sys.domain.query;

import com.kyle.common.api.BaseQuery;
import com.kyle.query.annotation.Equals;
import com.kyle.query.annotation.Like;
import io.swagger.v3.oas.annotations.Parameter;
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
public class UserQuery extends BaseQuery {
    /**
     * 用户账号
     */
    @Equals
    @Parameter(description = "用户账号")
    private String username;
    /**
     * 用户昵称
     */
    @Like
    @Parameter(description = "用户昵称")
    private String nickname;

    /**
     * 是否启用
     */
    @Equals
    @Parameter(description = "是否启用")
    private Boolean enabled;
}
