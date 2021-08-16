package com.arnaud.front.blibliothequeFront.exception;

import lombok.Getter;

public class BorrowingNotValidException extends  RuntimeException {
//
//    @Getter
//    private final ErrorCode errorCodes;


//    public BorrowingNotValidException(String message, ErrorCode errorCode) {
//        super(message);
//        this.errorCodes = errorCode;
//
//    }

    public BorrowingNotValidException(String message) {
        super(message);
    }
}
