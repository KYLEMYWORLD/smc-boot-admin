package com.kyle.sys.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.kyle.base.exception.ServiceException;
import com.kyle.base.utils.CollectionUtil;
import com.kyle.base.utils.StrUtil;
import com.kyle.basic.domain.entity.BasPermission;
import com.kyle.basic.service.BasOrgService;
import com.kyle.common.api.JsfPage;
import com.kyle.data.core.service.BaseService;
import com.kyle.query.jpa.QueryHelper;
import com.kyle.sys.domain.dto.ProductDto;
import com.kyle.sys.domain.entity.SysProduct;
import com.kyle.sys.domain.query.ProductQuery;
import com.kyle.sys.repository.SysProductRepository;
import com.kyle.sys.service.mapstruct.SysProductMapstruct;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author kyle
 * @date 2024/4/29
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class SysProductService extends BaseService<SysProductRepository, SysProduct, String> {
    private final SysProductMapstruct mapstruct;
    @Lazy
    @Resource
    private BasOrgService basOrgService;
    @Lazy
    @Resource
    private SysTenantPermissionService sysTenantPermissionService;

    /**
     * 编码是否存在
     *
     * @param code 编码
     * @param id   需要排除的ID
     * @return 是否存在
     */
    public Boolean existsCode(String code, String id) {
        if (StrUtil.isBlank(id)) {
            return baseRepository.existsByCode(code);
        }
        return baseRepository.existsByCodeAndIdNot(code, id);
    }

    /**
     * 查询
     *
     * @param query 查询条件
     * @return 结果
     */
    public List<ProductDto> list(ProductQuery query) {
        Specification<SysProduct> specification = QueryHelper.ofBean(query);
        List<SysProduct> sysProducts = this.findAll(specification);
        return mapstruct.toDtoList(sysProducts);
    }

    /**
     * 分页查询
     *
     * @param query 查询条件
     * @return 结果
     */
    public JsfPage<ProductDto> page(ProductQuery query) {
        Specification<SysProduct> specification = QueryHelper.ofBean(query);
        Pageable page = QueryHelper.toPage(query);
        Page<SysProduct> pageData = findAll(specification, page);
        List<ProductDto> dtoList = mapstruct.toDtoList(pageData.getContent());
        return QueryHelper.toJsfPage(pageData, dtoList);

    }


    /**
     * 保存
     *
     * @param dto dto
     */
    @Transactional(rollbackFor = Exception.class)
    public void save(ProductDto dto) {
        SysProduct sysProduct = mapstruct.toEntity(dto);
        save(sysProduct);
    }

    /**
     * 更新
     *
     * @param dto dto
     */
    @Transactional(rollbackFor = Exception.class)
    public void updateById(ProductDto dto) {
        String id = dto.getId();
        if (StrUtil.isBlank(id)) {
            throw new ServiceException("id不能为空");
        }
        SysProduct sysProduct = getById(id);
        if (null == sysProduct) {
            throw new ServiceException("数据不存在");
        }
        BeanUtil.copyProperties(
                dto,
                sysProduct,
                CopyOptions.create().ignoreNullValue()
        );
        updateById(sysProduct);
    }

    /**
     * 删除
     *
     * @param id id
     */
    @Transactional(rollbackFor = Exception.class)
    public void deleteById(String id) {
        // 已经分配的产品不能删除
        if (basOrgService.existsOrgByProduct(id)) {
            throw new ServiceException("机构已经关联该产品，无法删除");
        }
        SysProduct product = getById(id);
        if (null == product) {
            throw new ServiceException("数据不存在");
        }
        remove(product);
    }

    /**
     * 分配菜单
     *
     * @param id            id
     * @param permissionIds 权限ID
     */
    @Transactional(rollbackFor = Exception.class)
    public void grantMenus(String id, List<String> permissionIds) {
        SysProduct product = getById(id);
        if (null == product) {
            throw new ServiceException("数据不存在");
        }
        if (CollectionUtil.isEmpty(permissionIds)) {
            product.setPermissions(null);
        } else {
            List<BasPermission> permissions = permissionIds.stream().map(permissionId -> {
                BasPermission productPermission = new BasPermission();
                productPermission.setId(permissionId);
                return productPermission;
            }).collect(Collectors.toList());
            product.setPermissions(permissions);
        }
        // 更新& 分配菜单
        updateById(product);

        sysTenantPermissionService.grantMenus(id, permissionIds);
    }
}
