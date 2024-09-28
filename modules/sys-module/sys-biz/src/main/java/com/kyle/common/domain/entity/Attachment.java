package com.kyle.common.domain.entity;

import com.kyle.data.core.domain.BaseEntity;
import com.kyle.data.core.identifier.IdGenerator;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 附件
 *
 * @author kyle
 * @date 2024/5/9
 */
@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "t_attachment")
public class Attachment extends BaseEntity {
    @Id
    @IdGenerator
    private String id;
    /**
     * 文件名
     */
    private String displayName;
    /**
     * 文件类型
     */
    private String mediaType;
    /**
     * 文件大小
     */
    private Long size;
    /**
     * 链接
     */
    private String permalink;
    /**
     * 归属商户
     */
    private String sysCode;
}
