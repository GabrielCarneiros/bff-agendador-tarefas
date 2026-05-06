package com.carneiro.bff_agendador_tarefas.controller;

import com.carneiro.bff_agendador_tarefas.infrastructure.excepitions.ConfilctException;
import com.carneiro.bff_agendador_tarefas.infrastructure.excepitions.ResourceNotFoundException;
import com.carneiro.bff_agendador_tarefas.infrastructure.excepitions.UnauthorizedException;
import com.carneiro.bff_agendador_tarefas.infrastructure.excepitions.IllegalArgumentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(ConfilctException.class)
    public ResponseEntity<String> handleConflictException(ConfilctException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
    }
    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<String>UnauthorizedException(UnauthorizedException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.UNAUTHORIZED);
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handlerIllegalArgumentException(IllegalArgumentException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
