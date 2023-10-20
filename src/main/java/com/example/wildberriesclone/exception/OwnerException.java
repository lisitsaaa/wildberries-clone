package com.example.wildberriesclone.exception;

public class OwnerException extends RuntimeException{

    public OwnerException() {
        super();
    }

    public OwnerException(String message) {
        super(message);
    }

    public OwnerException(String message, Throwable cause) {
        super(message, cause);
    }

    public OwnerException(Throwable cause) {
        super(cause);
    }

    protected OwnerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}