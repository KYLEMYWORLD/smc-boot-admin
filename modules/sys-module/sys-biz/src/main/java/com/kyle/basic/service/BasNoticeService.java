package com.kyle.basic.service;

import com.kyle.base.utils.CollectionUtil;
import com.kyle.basic.domain.dto.BasNoticeDto;
import com.kyle.basic.domain.entity.BasNoticeRecord;
import com.kyle.basic.domain.entity.BasUser;
import com.kyle.basic.domain.query.BasNoticeQuery;
import com.kyle.basic.repository.BasNoticeRecordRepository;
import com.kyle.basic.service.mapstruct.BasNoticeMapstruct;
import com.kyle.common.api.JsfPage;
import com.kyle.data.core.service.BaseService;
import com.kyle.query.jpa.QueryHelper;
import com.kyle.sys.domain.entity.SysNotice;
import com.kyle.sys.service.SysNoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author kyle
 * @date 2024/4/29
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class BasNoticeService extends BaseService<BasNoticeRecordRepository, BasNoticeRecord, String> {
    private final SysNoticeService sysNoticeService;
    private final BasNoticeMapstruct mapstruct;

    /**
     * 查询未读消息数量
     *
     * @param userId 用户id
     * @return 未读消息数量
     */
    public Integer countUnread(String userId) {
        List<String> noticeIds = baseRepository.findNoticeIdByUserId(userId);
        if (CollectionUtil.isEmpty(noticeIds)) {
            return sysNoticeService.countNotices();
        }
        return sysNoticeService.countNotInIds(noticeIds);
    }

    /**
     * 分页查询
     *
     * @param query 查询条件
     * @return 分页数据
     */
    public JsfPage<BasNoticeDto> page(BasNoticeQuery query) {
        List<String> noticeIds = baseRepository.findNoticeIdByUserId(query.getUserId());
        query.setSorts("created desc");
        query.setEnabled(true);
        Specification<SysNotice> specification = QueryHelper.ofBean(query);
        Pageable page = QueryHelper.toPage(query);
        Page<SysNotice> pageData = sysNoticeService.findAll(specification, page);
        List<BasNoticeDto> res = mapstruct.toDtoList(pageData.getContent());
        res.forEach(
                notice -> isRead(notice, noticeIds)
        );
        return QueryHelper.toJsfPage(pageData, res);
    }


    /**
     * 标记已读
     *
     * @param userId    用户ID
     * @param noticeIds 公告ID
     */
    @Transactional(rollbackFor = Exception.class)
    public void reads(String userId, List<String> noticeIds) {
        if (CollectionUtil.isEmpty(noticeIds)) {
            List<String> readNoticeIds = baseRepository.findNoticeIdByUserId(userId);
            if (CollectionUtil.isEmpty(readNoticeIds)) {
                noticeIds = sysNoticeService.getIds();
            } else {
                noticeIds = sysNoticeService.getIdsNotInIds(readNoticeIds);
            }
        }
        if (CollectionUtil.isEmpty(noticeIds)) {
            return;
        }
        List<BasNoticeRecord> notices = noticeIds.stream().map(e -> {
            BasNoticeRecord noticeRecord = new BasNoticeRecord();
            BasUser basUser = new BasUser();
            basUser.setId(userId);
//            noticeRecord.setUserId(userId);
            noticeRecord.setUser(basUser);
            SysNotice notice = new SysNotice();
            notice.setId(e);
//            noticeRecord.setNotice(e);
            noticeRecord.setNotice(notice);
            noticeRecord.setReadTime(new Date());
            noticeRecord.setRead(true);
            return noticeRecord;
        }).toList();

        saveBatch(notices);
    }

    private void isRead(BasNoticeDto notice, List<String> noticeIds) {
        if (noticeIds.contains(notice.getId())) {
            notice.setRead(true);
            return;
        }
        notice.setRead(false);
    }

}
