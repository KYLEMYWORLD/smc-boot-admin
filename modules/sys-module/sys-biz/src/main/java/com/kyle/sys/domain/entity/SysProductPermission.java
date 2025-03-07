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
@Table(name = "sys_product_permission")
public class SysProductPermission implements Serializable {
    @Id
    @Column(name = "product_id")
    private String productId;
    @Id
    @Column(name = "permission_id")
    private String permissionId;
}
