package com.arnaud.back.blibliotheque.exception;

import lombok.Getter;

import java.util.List;

public class BorrowingNotValidException extends  RuntimeException{

    @Getter
    private final ErrorCode errorCodes;


    public BorrowingNotValidException(String message,ErrorCode errorCode){
             super(message);
           this.errorCodes =errorCode;

    }
}
