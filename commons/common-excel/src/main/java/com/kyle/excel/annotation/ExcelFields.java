package com.kyle.excel.annotation;

import java.lang.annotation.RetentionPolicy;

/**
 * excel字段
 *
 * @author kyle
 * @date 2024/4/10
 */
@java.lang.annotation.Retention(RetentionPolicy.RUNTIME)
@java.lang.annotation.Target({java.lang.annotation.ElementType.TYPE})
public @interface ExcelFields {

    /**
     * 字段
     *
     * @return .
     */
    ExcelField[] value() default {};
}