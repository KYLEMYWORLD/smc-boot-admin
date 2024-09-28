package com.kyle.basic.domain.entity;

import com.kyle.base.utils.CollectionUtil;
import com.kyle.data.core.domain.BaseEntity;
import com.kyle.data.core.identifier.IdGenerator;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author kyle
 * @date 2024/4/28
 */
@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "bas_role")
public class BasRole extends BaseEntity {
    @Id
    @IdGenerator
    private String id;
    /**
     * 权限
     */
    @ManyToMany(fetch = jakarta.persistence.FetchType.EAGER)
    @JoinTable(name = "bas_role_permission",
            joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id", referencedColumnName = "id"))
    private List<BasPermission> permissions;
    /**
     * 用户
     */
    @ManyToMany(mappedBy = "roles")
    private List<BasUser> users;

    /**
     * 数据范围
     */
    @ManyToMany
    @JoinTable(name = "bas_role_data",
            joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "org_id", referencedColumnName = "id"))
    private List<BasOrg> orgs;
    /**
     * 角色名称
     */
    private String name;
    /**
     * 角色编码
     */
    private String code;
    /**
     * 描述
     */
    private String description;
    /**
     * 数据范围
     */
    private Integer dataScope;
    /**
     * 是否系统
     */
    @Column(name = "is_system", columnDefinition = "tinyint(1) default 0")
    private Boolean system = false;

    /**
     * 是否启用
     */
    @Column(name = "is_enabled", columnDefinition = "tinyint(1) default 1")
    private Boolean enabled = true;


    /**
     * 商户识别码
     */
    private String sysCode;

    /**
     * 获取权限id
     *
     * @return .
     */
    public List<String> getPermissionIds() {
        if (CollectionUtil.isNotEmpty(permissions)) {
            return this.permissions.stream().map(BasPermission::getId).toList();
        }
        return null;
    }

    /**
     * 获取数据范围
     *
     * @return .
     */
    public List<String> getOrgIds() {
        if (CollectionUtil.isNotEmpty(orgs)) {
            return this.orgs.stream().map(BasOrg::getId).toList();
        }
        return null;
    }
}
