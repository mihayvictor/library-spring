package com.mihayvictor.library_spring.exception.serviceException;

public class DatabaseException extends RuntimeException{

    public DatabaseException(String msg){
        super(msg);
    }
}
