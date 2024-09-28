package com.kyle.basic.domain.entity;

import com.kyle.data.core.identifier.IdGenerator;
import com.kyle.sys.domain.entity.SysNotice;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author kyle
 * @date 2024/4/29
 */
@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "bas_notice_record")
public class BasNoticeRecord implements Serializable {
    @Id
    @IdGenerator
    private String id;

    /**
     * 公告ID
     */
    @OneToOne
    @JoinColumn(name = "notice_id")
    private SysNotice notice;
    /**
     * 用户ID
     */
    @OneToOne
    @JoinColumn(name = "user_id")
    private BasUser user;
    /**
     * 是否已读
     */
    @Column(name = "is_read", columnDefinition = "tinyint(1) default 0")
    private Boolean read;
    /**
     * 阅读时间
     */
    private Date readTime;
}
