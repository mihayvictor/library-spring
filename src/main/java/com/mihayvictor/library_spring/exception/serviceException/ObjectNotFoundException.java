package com.mihayvictor.library_spring.exception.serviceException;

public class ObjectNotFoundException extends RuntimeException {

    public ObjectNotFoundException(String msg){
        super(msg);
    }
}

