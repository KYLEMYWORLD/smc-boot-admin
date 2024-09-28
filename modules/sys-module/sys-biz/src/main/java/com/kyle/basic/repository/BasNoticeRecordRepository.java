package com.kyle.basic.repository;

import com.kyle.basic.domain.entity.BasNoticeRecord;
import com.kyle.data.core.repository.BaseJpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author kyle
 * @date 2024/5/2
 */
@Repository
public interface BasNoticeRecordRepository extends BaseJpaRepository<BasNoticeRecord, String> {

    /**
     * 根据用户ID查询已读的公告ID
     *
     * @param userId .
     * @return .
     */
    @Query("SELECT notice.id FROM BasNoticeRecord WHERE user.id = ?1")
    List<String> findNoticeIdByUserId(String userId);
}