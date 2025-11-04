package com.mihayvictor.library_spring.service.exception;

public class LoanDateException extends RuntimeException{
    public LoanDateException(String msg){
        super(msg);
    }
}
