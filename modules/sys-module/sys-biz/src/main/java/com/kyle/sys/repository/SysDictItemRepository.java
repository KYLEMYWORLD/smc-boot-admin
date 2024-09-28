package com.kyle.sys.repository;

import com.kyle.data.core.repository.BaseJpaRepository;
import com.kyle.sys.domain.entity.SysDictItem;
import org.springframework.stereotype.Repository;

/**
 * @author kyle
 * @date 2024/5/5
 */
@Repository
public interface SysDictItemRepository extends BaseJpaRepository<SysDictItem, String> {
}
