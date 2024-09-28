package com.kyle.basic.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author kyle
 * @date 2024/4/28
 */
@Getter
@Setter
@Entity
@Table(name = "bas_role_permission")
@AllArgsConstructor
@NoArgsConstructor
public class BasRolePermission implements Serializable {
    @Id
    @Column(name = "role_id")
    private String roleId;
    @Id
    @Column(name = "permission_id")
    private String permissionId;
}
