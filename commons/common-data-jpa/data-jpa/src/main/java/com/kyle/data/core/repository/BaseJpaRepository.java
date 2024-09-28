package com.kyle.data.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author kyle
 * @date 2024/5/2
 */
@NoRepositoryBean
public interface BaseJpaRepository<E, ID> extends JpaRepository<E, ID>, JpaSpecificationExecutor<E> {
}
