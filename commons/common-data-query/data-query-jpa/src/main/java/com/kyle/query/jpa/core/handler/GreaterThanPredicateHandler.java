package com.kyle.query.jpa.core.handler;

import com.kyle.query.annotation.GreaterThan;
import com.kyle.query.jpa.core.AbstractPredicateHandler;
import jakarta.annotation.Nonnull;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.From;
import jakarta.persistence.criteria.Predicate;

/**
 * 构建“大于条件”({@code field > 'xxx'})场景的 {@link Predicate} 处理器.
 *
 * @author kyle
 * @date 2024/4/27
 */
public class GreaterThanPredicateHandler extends AbstractPredicateHandler {

    @Override
    public Class<GreaterThan> getAnnotation() {
        return GreaterThan.class;
    }

    @Override
    public <Z, X> Predicate _buildPredicate(CriteriaBuilder criteriaBuilder, From<Z, X> from, String fieldName,
                                            @Nonnull Object value) {
        return criteriaBuilder.and(
                super.buildGreaterThanPredicate(criteriaBuilder, from, fieldName, value)
        );
    }

}