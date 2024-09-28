package com.kyle.sys.repository;

import com.kyle.data.core.repository.BaseJpaRepository;
import com.kyle.sys.domain.entity.SysNotice;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author kyle
 * @date 2024/5/2
 */
@Repository
public interface SysNoticeRepository extends BaseJpaRepository<SysNotice, String> {

    /**
     * 统计不在ids中的数量
     *
     * @param ids .
     * @return .
     */
    int countByIdNotInAndEnabledIsTrue(List<String> ids);

    /**
     * 查询不在ids中的数据
     *
     * @param ids .
     * @return .
     */
    List<SysNotice> findByIdNotInAndEnabledIsTrue(List<String> ids);

    /**
     * 统计启用的数量
     *
     * @return .
     */
    int countByEnabledIsTrue();

    /**
     * 查询启用的数据
     *
     * @return .
     */
    List<SysNotice> findByEnabledIsTrue();


    /**
     * 查询启用的数据
     *
     * @param ids .
     * @return .
     */
    List<SysNotice> findByEnabledIsTrueAndIdIn(List<String> ids);
}
