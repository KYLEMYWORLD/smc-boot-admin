package com.kyle.code.generator.core.config;

import com.kyle.code.generator.core.po.TableInfo;

import java.util.Map;

/**
 * @author kyle
 * @date 2024/5/28
 */
public interface ITemplate {

    /**
     * 渲染数据
     *
     * @param tableInfo 表信息
     * @return 渲染数据
     */
    Map<String, Object> renderData(TableInfo tableInfo);
}
