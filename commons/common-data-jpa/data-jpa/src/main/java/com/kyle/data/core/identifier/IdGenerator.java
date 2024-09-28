package com.kyle.data.core.identifier;

import org.hibernate.annotations.IdGeneratorType;
import org.hibernate.annotations.ValueGenerationType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author kyle
 * @date 2024/3/23
 */
@IdGeneratorType(DefaultIdentifierGenerator.class)
@ValueGenerationType(generatedBy = DefaultIdentifierGenerator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface IdGenerator {
}