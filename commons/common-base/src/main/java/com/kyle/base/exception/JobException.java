package com.kyle.base.exception;


/**
 * @author kyle
 * @date 2024/4/14
 */
public class JobException extends RuntimeException {

    public JobException() {
        super();
    }

    public JobException(String message) {
        super(message);
    }

    public JobException(String message, Throwable cause) {
        super(message, cause);
    }
}