package com.kyle.basic.service;

import com.kyle.base.utils.CollectionUtil;
import com.kyle.basic.domain.dto.BasPermissionDto;
import com.kyle.basic.domain.entity.BasOrg;
import com.kyle.basic.domain.entity.BasPermission;
import com.kyle.basic.domain.entity.BasRole;
import com.kyle.basic.repository.BasPermissionRepository;
import com.kyle.basic.service.mapstruct.BasPermissionMapstruct;
import com.kyle.data.core.service.BaseService;
import com.kyle.sys.domain.dto.PermissionDto;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kyle
 * @date 2024/4/28
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class BasPermissionService extends BaseService<BasPermissionRepository, BasPermission, String> {
    @Lazy
    @Resource
    private BasRoleService basRoleService;
    @Lazy
    @Resource
    private BasOrgService basOrgService;
    private final BasPermissionMapstruct mapstruct;

    /**
     * 根据角色ID获取权限
     *
     * @param roleIds 角色ID
     * @return 权限
     */
    public List<BasPermission> findByRoleIds(List<String> roleIds) {
        return baseRepository.findAllByRoleIdIn(roleIds);
    }

    /**
     * 用户路由
     *
     * @param userId .
     * @return .
     */
    public List<PermissionDto> userRoutes(String userId) {
        List<BasRole> roles = basRoleService.findByUserId(userId);
        if (CollectionUtil.isEmpty(roles)) {
            return null;
        }
        List<String> roleIds = CollectionUtil.listToList(roles, BasRole::getId);
        List<BasPermission> basPermissions = findByRoleIds(roleIds);
        return mapstruct.toPermissionDtoList(basPermissions);
    }

    /**
     * 根据用户id查询权限
     *
     * @param userId 用户id
     * @return 权限
     */
    public List<BasPermission> listByUserId(String userId) {
        List<BasRole> roles = basRoleService.findByUserId(userId);
        if (CollectionUtil.isEmpty(roles)) {
            return null;
        }
        List<String> roleIds = CollectionUtil.listToList(roles, BasRole::getId);
        return findByRoleIds(roleIds);
    }

    /**
     * 根据产品ID获取权限
     *
     * @param productId 产品ID
     * @return 权限
     */
    public List<BasPermission> findByProductId(String productId) {
        return baseRepository.findByProductId(productId);
    }


    /**
     * 根据产品ID获取权限
     *
     * @param sysCode 产品ID
     * @return 权限
     */
    public List<BasPermissionDto> list(String sysCode) {
        BasOrg org = basOrgService.getTopOrg(sysCode);
        if (org == null) {
            return null;
        }
        if (org.getProduct() == null) {
            return null;
        }
        List<BasPermission> res = baseRepository.findByProductId(org.getProduct().getId());
        return mapstruct.toDtoList(res);
    }


}
