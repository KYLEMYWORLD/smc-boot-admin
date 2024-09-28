package com.kyle.code.generator.core.config.strategy;

import com.kyle.code.generator.core.handler.ConverterFileName;

/**
 * @author kyle
 * @date 2024/5/30
 */
public interface IStrategy {


    /**
     * 获取文件名转换器
     *
     * @return 文件名转换器
     */
    ConverterFileName getConverterFileName();

    /**
     * 获取模板
     *
     * @return 模板
     */
    String getJavaTemplate();

    /**
     * 是否覆盖已有文件
     *
     * @return 是否覆盖已有文件
     */
    default boolean isFileOverride() {
        return false;
    }

    /**
     * 是否生成
     *
     * @return 是否生成
     */
    default boolean isGenerate() {
        return true;
    }
}
