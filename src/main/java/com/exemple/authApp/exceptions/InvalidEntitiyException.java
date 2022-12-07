package com.exemple.authApp.exceptions;

import java.util.List;

public class InvalidEntitiyException extends RuntimeException{
    private ErrorCodes errorCode;
    private List<String> errors;

    public InvalidEntitiyException(String message, ErrorCodes errorCode, List<String> errors) {
        super(message);
        this.errorCode = errorCode;
        this.errors = errors;
    }

    public InvalidEntitiyException(String message, List<String> errors) {
        super(message);
        this.errors = errors;
    }

    public InvalidEntitiyException(String message, ErrorCodes errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
    public InvalidEntitiyException(String message) {
        super(message);
    }

    public ErrorCodes getErrorCode() {
        return errorCode;
    }

    public List<String> getErrors() {
        return errors;
    }
}
