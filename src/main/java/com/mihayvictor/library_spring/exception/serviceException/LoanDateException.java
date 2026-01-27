package com.mihayvictor.library_spring.exception.serviceException;

public class LoanDateException extends RuntimeException{
    public LoanDateException(String msg){
        super(msg);
    }
}
