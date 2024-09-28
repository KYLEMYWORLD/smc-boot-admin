package com.kyle.basic.repository;

import com.kyle.basic.domain.entity.BasPost;
import com.kyle.data.core.repository.BaseJpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author kyle
 * @date 2024/5/7
 */
@Repository
public interface BasPostRepository extends BaseJpaRepository<BasPost, String> {

    /**
     * 根据编码和系统编码查询
     *
     * @param code    .
     * @param sysCode .
     * @return .
     */
    boolean existsByCodeAndSysCode(String code, String sysCode);

    /**
     * 根据编码和系统编码查询
     *
     * @param code    .
     * @param sysCode .
     * @param id      .
     * @return .
     */
    boolean existsByCodeAndSysCodeAndIdNot(String code, String sysCode, String id);

    /**
     * 根据岗位id查询是否存在用户岗位
     *
     * @param id .
     * @return .
     */
    default boolean existsUserPostByPostId(String id) {
        return countUserPostByPostId(id) > 0;
    }

    /**
     * 根据岗位id统计用户岗位
     *
     * @param id .
     * @return .
     */
    @Query("select count(1) from BasUserPost where postId = ?1")
    int countUserPostByPostId(String id);
}
