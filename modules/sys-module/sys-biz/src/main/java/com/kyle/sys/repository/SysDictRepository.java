package com.kyle.sys.repository;

import com.kyle.data.core.repository.BaseJpaRepository;
import com.kyle.sys.domain.entity.SysDict;
import org.springframework.stereotype.Repository;

/**
 * @author kyle
 * @date 2024/5/5
 */
@Repository
public interface SysDictRepository extends BaseJpaRepository<SysDict, String> {

    /**
     * 根据类型查询
     *
     * @param type 类型
     * @return 是否存在
     */
    boolean existsByType(String type);

    /**
     * 根据类型和id查询
     *
     * @param type 类型
     * @param id   id
     * @return 是否存在
     */
    boolean existsByTypeAndIdNot(String type, String id);
}
