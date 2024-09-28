package com.kyle.base.exception;

/**
 * oss异常
 *
 * @author kyle
 * @date 2024/4/10
 */
public class OssException extends RuntimeException {
    public OssException() {
        super();
    }

    public OssException(String message) {
        super(message);
    }

    public OssException(String message, Throwable cause) {
        super(message, cause);
    }
}