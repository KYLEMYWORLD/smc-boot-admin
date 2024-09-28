package com.kyle.basic.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author kyle
 * @date 2024/5/7
 */
@Data
@EqualsAndHashCode
@ToString
public class PostSmallDto implements java.io.Serializable {
    @Schema(description = "岗位id")
    private String id;
    @Schema(description = "岗位编码")
    private String code;
    @Schema(description = "岗位名称")
    private String name;
}
