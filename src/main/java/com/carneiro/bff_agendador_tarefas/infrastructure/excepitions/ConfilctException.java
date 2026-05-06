package com.carneiro.bff_agendador_tarefas.infrastructure.excepitions;

public class ConfilctException extends RuntimeException {
    public ConfilctException(String mensagem){
        super(mensagem);
    }
    public  ConfilctException(String mensagem, Throwable throwable){
        super(mensagem);
    }
}
