package com.kyle.base.exception;

/**
 * @author kyle
 * @date 2024/4/28
 */
public class QueryException extends RuntimeException {

    public QueryException() {
        super();
    }

    public QueryException(String message) {
        super(message);
    }

    public QueryException(String message, Throwable cause) {
        super(message, cause);
    }
}
