package com.kyle.sys.repository;

import com.kyle.data.core.repository.BaseJpaRepository;
import com.kyle.sys.domain.entity.SysTenant;
import org.springframework.stereotype.Repository;

/**
 * @author kyle
 * @date 2024/5/2
 */
@Repository
public interface SysTenantRepository extends BaseJpaRepository<SysTenant, String> {

    /**
     * 根据商户编码查询
     *
     * @param sysCode 商户编码
     * @return 是否存在
     */
    boolean existsBySysCode(String sysCode);

    /**
     * 根据商户编码和ID查询
     *
     * @param sysCode 商户编码
     * @param id      ID
     * @return 是否存在
     */
    boolean existsBySysCodeAndIdNot(String sysCode, String id);
}
