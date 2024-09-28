package com.kyle.security.domain.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @author kyle
 * @date 2024/4/28
 */
public interface TreeVO<T> extends Serializable {

    /**
     * 获取子类
     *
     * @return .
     */
    public List<T> getChildren();

    /**
     * 设置子类
     *
     * @param children .
     */
    void setChildren(List<T> children);
}