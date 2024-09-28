package com.kyle.base.enums;

import lombok.Getter;

/**
 * @author kyle
 * @date 2024/3/25
 */
@Getter
public enum GenderEnums implements ValueEnum<Integer> {
    UNKNOWN(0, "未知"),
    MALE(1, "男"),
    FEMALE(2, "女"),
    ;

    private final Integer value;
    private final String name;

    GenderEnums(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    @Override
    public Integer getValue() {
        return value;
    }
}