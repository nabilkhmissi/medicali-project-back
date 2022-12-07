package com.exemple.authApp.exceptions;

public enum ErrorCodes {
    USER_NOT_VALID(1000),
    USER_NOT_FOUND(1001),
    USER_EXISTS(1002),
    PRATICIENT_NOT_VALID(2000),
    PRATICIENT_NOT_FOUND(2001),
    PRATICIENT_ALREADY_EXISTS(2002),
    //dossier medical
    MALADIE_NOT_VALID(5000),
    MALADIE_NOT_FOUND(5001);

    private int code;

    ErrorCodes(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
