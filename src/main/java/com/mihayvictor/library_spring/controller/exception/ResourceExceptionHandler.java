package com.mihayvictor.library_spring.controller.exception;

import com.mihayvictor.library_spring.service.exception.DatabaseException;
import com.mihayvictor.library_spring.service.exception.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;


@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError>objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        String error = "Não encontrado";
        StandardError err =
                new StandardError
                        (Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError>dataBase(DatabaseException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        String error = "Database error";
        StandardError err =
                new StandardError
                        (Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return  ResponseEntity.status(status).body(err);
    }
}
