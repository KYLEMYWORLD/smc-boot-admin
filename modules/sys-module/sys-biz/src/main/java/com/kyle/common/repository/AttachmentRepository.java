package com.kyle.common.repository;

import com.kyle.common.domain.entity.Attachment;
import com.kyle.data.core.repository.BaseJpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author kyle
 * @date 2024/5/9
 */
@Repository
public interface AttachmentRepository extends BaseJpaRepository<Attachment, String> {
}
