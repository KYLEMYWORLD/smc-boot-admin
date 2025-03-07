package com.kyle.basic.repository;

import com.kyle.basic.domain.entity.BasPermission;
import com.kyle.data.core.repository.BaseJpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author kyle
 * @date 2024/5/2
 */
@Repository
public interface BasPermissionRepository extends BaseJpaRepository<BasPermission, String> {

    /**
     * 根据角色ID查询权限
     *
     * @param roleIds 角色ID
     * @return .
     */
    @Query("SELECT p FROM BasPermission p JOIN BasRolePermission rp ON p.id = rp.permissionId WHERE rp.roleId IN ?1 " +
            "AND p.enabled =true ORDER BY p.rank")
    List<BasPermission> findAllByRoleIdIn(List<String> roleIds);


    /**
     * 根据产品ID查询权限
     *
     * @param productId 产品ID
     * @return .
     */
    @Query("SELECT p FROM BasPermission p JOIN SysProductPermission pp ON p.id = pp.permissionId WHERE pp.productId = ?1")
    List<BasPermission> findByProductId(String productId);
}
