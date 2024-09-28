package com.kyle.sys.repository;

import com.kyle.data.core.repository.BaseJpaRepository;
import com.kyle.sys.domain.entity.SysOssConfig;
import org.springframework.stereotype.Repository;

/**
 * @author kyle
 * @date 2024/5/2
 */
@Repository
public interface SysTenantOssConfigRepository extends BaseJpaRepository<SysOssConfig, String> {

    /**
     * 根据商户编码查询
     *
     * @param sysCode 商户编码
     * @return SysOssConfig
     */
    SysOssConfig findBySysCode(String sysCode);
}
