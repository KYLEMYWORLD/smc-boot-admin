package com.kyle.security.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 匿名访问
 *
 * @author kyle
 * @date 2024/5/7
 */
@Documented
@Inherited
@Target({java.lang.annotation.ElementType.METHOD})
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
public @interface AnonymousAccess {
}
