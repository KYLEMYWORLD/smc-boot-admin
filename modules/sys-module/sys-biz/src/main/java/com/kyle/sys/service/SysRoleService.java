package com.kyle.sys.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.kyle.base.exception.ServiceException;
import com.kyle.base.utils.CollectionUtil;
import com.kyle.base.utils.StrUtil;
import com.kyle.common.api.JsfPage;
import com.kyle.data.core.service.BaseService;
import com.kyle.query.jpa.QueryHelper;
import com.kyle.sys.domain.dto.RoleDto;
import com.kyle.sys.domain.entity.SysPermission;
import com.kyle.sys.domain.entity.SysRole;
import com.kyle.sys.domain.query.RoleQuery;
import com.kyle.sys.repository.SysRoleRepository;
import com.kyle.sys.service.mapstruct.SysRoleMapstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author kyle
 * @date 2024/4/28
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class SysRoleService extends BaseService<SysRoleRepository, SysRole, String> {
    private final SysRoleMapstruct mapstruct;

    /**
     * 编码是否存在
     *
     * @param code 编码
     * @param id   需要排除的id
     * @return 是否存在
     */
    public Boolean existsCode(String code, String id) {
        if (StrUtil.isNotBlank(id)) {
            return baseRepository.existsByCodeAndIdNot(code, id);
        }
        return baseRepository.existsByCode(code);
    }

    /**
     * 根据用户id查询角色
     *
     * @param userId 用户id
     * @return 角色
     */
    public List<SysRole> listByUserId(String userId) {
        return baseRepository.findByUserId(userId);
    }

    /**
     * 查询
     *
     * @param query 查询条件
     * @return 角色列表
     */
    public List<RoleDto> list(RoleQuery query) {
        Specification<SysRole> specification = QueryHelper.ofBean(query);
        List<SysRole> list = findAll(specification);
        return mapstruct.toDtoList(list);
    }

    /**
     * 分页查询
     *
     * @param query 查询条件
     * @return 角色列表
     */
    public JsfPage<RoleDto> page(RoleQuery query) {
        Specification<SysRole> specification = QueryHelper.ofBean(query);
        Pageable page = QueryHelper.toPage(query);
        Page<SysRole> pageData = findAll(specification, page);
        List<RoleDto> res = mapstruct.toDtoList(pageData.getContent());
        return QueryHelper.toJsfPage(pageData, res);
    }

    /**
     * 保存
     *
     * @param dto dto
     */
    @Transactional(rollbackFor = Exception.class)
    public void save(RoleDto dto) {
        SysRole entity = mapstruct.toEntity(dto);
        Boolean res = existsCode(entity.getCode(), entity.getId());
        if (res) {
            throw new ServiceException("编码已存在");
        }
        save(entity);
    }

    /**
     * 更新
     *
     * @param dto dto
     */
    @Transactional(rollbackFor = Exception.class)
    public void updateById(RoleDto dto) {
        SysRole role = mapstruct.toEntity(dto);
        role.setCode(null);
        SysRole entity = getById(role.getId());
        if (entity == null) {
            throw new ServiceException("未找到对应实体");
        }
        BeanUtil.copyProperties(role, entity, CopyOptions.create().setIgnoreNullValue(true));
        updateById(entity);
    }

    /**
     * 删除
     *
     * @param id id
     */
    @Transactional(rollbackFor = Exception.class)
    public void deleteById(String id) {
        // 是否有用户关联
        boolean exists = baseRepository.existsUserByRoleId(id);
        if (exists) {
            throw new ServiceException("有用户关联，无法删除");
        }
        SysRole role = getById(id);
        if (role == null) {
            throw new ServiceException("未找到对应实体");
        }
        remove(role);
    }

    /**
     * 分配菜单
     *
     * @param roleId  角色id
     * @param menuIds 菜单id
     */
    @Transactional(rollbackFor = Exception.class)
    public void assign(String roleId, List<String> menuIds) {
        SysRole role = getById(roleId);
        if (role == null) {
            throw new ServiceException("未找到对应实体");
        }
        if (CollectionUtil.isEmpty(menuIds)) {
            role.setPermissions(null);
        } else {
            List<SysPermission> permissions = menuIds.stream().map(
                    menuId -> {
                        SysPermission permission = new SysPermission();
                        permission.setId(menuId);
                        return permission;
                    }
            ).collect(Collectors.toList());
            role.setPermissions(permissions);
        }
        updateById(role);
    }
}
