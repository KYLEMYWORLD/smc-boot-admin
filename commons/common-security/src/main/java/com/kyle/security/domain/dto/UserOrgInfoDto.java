package com.kyle.security.domain.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author kyle
 * @date 2024/4/3
 */
@Getter
@Setter
@Accessors(chain = true)
public class UserOrgInfoDto implements Serializable {
    /**
     * 机构ID
     */
    private String id;
    /**
     * 机构名称
     */
    private String name;
    /**
     * 机构path
     */
    private String path;
}