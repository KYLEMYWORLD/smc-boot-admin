package com.kyle.common.domain.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author kyle
 * @date 2024/5/7
 */
@Data
@EqualsAndHashCode
@ToString
public class SelectOptionVo implements Serializable {
    private String label;
    private String value;
}
