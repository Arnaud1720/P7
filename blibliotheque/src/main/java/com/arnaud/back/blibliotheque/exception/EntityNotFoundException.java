package com.arnaud.back.blibliotheque.exception;

import lombok.Getter;

import java.util.List;

public class EntityNotFoundException extends RuntimeException{
    @Getter
    private ErrorCode errorCodes;
    @Getter
    private List<String> erros;


    public EntityNotFoundException(String message){
        super(message);
    }

    public EntityNotFoundException(String message, Throwable cause){
        super(message,cause);
    }

    public EntityNotFoundException(String message, Throwable cause, ErrorCode errorCode){
        super(message,cause);
        this.errorCodes= errorCode;
    }

    public EntityNotFoundException(String message, ErrorCode errorCode){
        super(message);
        this.errorCodes= errorCode;
    }

    public EntityNotFoundException(String message,ErrorCode errorCodes,List<String> erros){
        super(message);
        this.errorCodes=errorCodes;
        this.erros=erros;
    }

}
