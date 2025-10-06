package com.mihayvictor.labrary_spring.service.exception;

public class ObjectNotFoundExeception extends RuntimeException {

    public ObjectNotFoundExeception(String msg){
        super(msg);
    }
}

