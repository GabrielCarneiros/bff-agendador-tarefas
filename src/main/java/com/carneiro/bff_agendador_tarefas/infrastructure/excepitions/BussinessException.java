package com.carneiro.bff_agendador_tarefas.infrastructure.excepitions;

public class BussinessException extends RuntimeException{
    public BussinessException(String message){
        super(message);
    }
    public BussinessException(String message, Throwable throwable){
        super(message, throwable);
    }
}
