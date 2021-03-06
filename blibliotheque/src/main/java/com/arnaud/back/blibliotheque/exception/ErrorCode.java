package com.arnaud.back.blibliotheque.exception;

public enum ErrorCode {

    USER_NOT_FOUND(1000),
         USER_NOT_VALID(1001),
         MAIL_OR_PASSWORD_INVALID(1002),
    BOOK_NOT_FOUND(2000),
    BORROWING_NOT_FOUND(3000),
    EXEMPLARY_NOT_FOUND(4000),
    IMPOSSIBLE_ADD_EXTENSION(5000);
    private final int code;

    ErrorCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
