package com.kyle.sys.domain.query;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kyle.common.api.BaseQuery;
import com.kyle.query.annotation.Equals;
import com.kyle.query.annotation.GreaterThanEqual;
import com.kyle.query.annotation.LessThanEqual;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author kyle
 * @date 2024/4/29
 */
@Getter
@Setter
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class NoticeQuery extends BaseQuery {
    /**
     * 是否启用
     */
    @Equals
    private Boolean enabled;

    /**
     * 公告开始时间
     */
    @GreaterThanEqual
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date noticeTimeStart;

    /**
     * 公告结束时间
     */
    @LessThanEqual
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date noticeTimeEnd;
}
