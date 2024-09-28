package com.kyle.base.exception;

/**
 * @author kyle
 * @date 2024/4/9
 */
public class ExcelException extends RuntimeException {
    public ExcelException(String message) {
        super(message);
    }

    public ExcelException(String message, Throwable cause) {
        super(message, cause);
    }
}