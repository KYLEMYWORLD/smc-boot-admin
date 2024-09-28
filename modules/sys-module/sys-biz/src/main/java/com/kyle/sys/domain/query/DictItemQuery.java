package com.kyle.sys.domain.query;

import com.kyle.common.api.BaseQuery;
import com.kyle.query.annotation.Equals;
import com.kyle.query.annotation.Like;
import com.kyle.query.jpa.annotation.Query;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author kyle
 * @date 2024/5/5
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString
public class DictItemQuery extends BaseQuery {

    /**
     * 字典id
     */
    @Query(value = "id", joinName = "dict")
    @Schema(description = "字典id")
    private String dictId;

    /**
     * 字典类型
     */
    @Equals
    @Schema(description = "字典类型")
    private String dictType;

    /**
     * 字典标签
     */
    @Like
    @Schema(description = "字典标签")
    private String label;

    /**
     * 状态
     */
    @Equals
    @Schema(description = "状态")
    private Boolean enabled;
}
