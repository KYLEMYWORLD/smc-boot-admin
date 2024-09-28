package com.kyle.sys.repository;

import com.kyle.data.core.repository.BaseJpaRepository;
import com.kyle.sys.domain.entity.SysQuartzJob;
import org.springframework.stereotype.Repository;

/**
 * @author kyle
 * @date 2024/5/2
 */
@Repository
public interface SysQuartzJobRepository extends BaseJpaRepository<SysQuartzJob, String> {
}
