package com.kyle.code.generator.core.handler;

import com.kyle.code.generator.core.handler.columntype.IColumnType;
import jakarta.validation.constraints.NotNull;

/**
 * 字段类型
 *
 * @author kyle
 * @date 2024/5/27
 */
public interface IColumnTypeConvertHandler {

    /**
     * 执行类型转换
     *
     * @param fieldType 字段类型
     * @return ignore
     */
    IColumnType processTypeConvert(@NotNull String fieldType);

}
