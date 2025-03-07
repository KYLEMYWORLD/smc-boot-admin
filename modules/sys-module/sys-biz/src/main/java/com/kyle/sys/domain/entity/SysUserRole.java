package com.kyle.sys.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author kyle
 * @date 2024/4/28
 */
@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "sys_user_role")
public class SysUserRole implements Serializable {
    @Id
    @Column(name = "user_id")
    private String userId;
    @Id
    @Column(name = "role_id")
    private String roleId;
}
