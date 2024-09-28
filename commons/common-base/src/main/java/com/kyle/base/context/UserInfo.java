package com.kyle.base.context;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author kyle
 * @date 2024/4/28
 */
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserInfo implements Serializable {
    private String id;
    private String username;
    private String sysCode;
    /**
     * 数据权限
     */
    private List<String> dataScopes;
}
