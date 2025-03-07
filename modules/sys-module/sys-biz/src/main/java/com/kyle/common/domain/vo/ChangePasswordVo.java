package com.kyle.common.domain.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author kyle
 * @date 2024/5/13
 */
@Data
@EqualsAndHashCode
@ToString
public class ChangePasswordVo implements Serializable {
    @Schema(description = "旧密码")
    private String oldPassword;
    @Schema(description = "新密码")
    private String newPassword;
}
