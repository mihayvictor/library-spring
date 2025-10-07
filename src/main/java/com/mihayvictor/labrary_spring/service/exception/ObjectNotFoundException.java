package com.mihayvictor.labrary_spring.service.exception;

public class ObjectNotFoundException extends RuntimeException {

    public ObjectNotFoundException(String msg){
        super(msg);
    }
}

