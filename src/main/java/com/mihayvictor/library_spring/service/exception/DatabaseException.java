package com.mihayvictor.library_spring.service.exception;

public class DatabaseException extends RuntimeException{

    public DatabaseException(String msg){
        super(msg);
    }
}
