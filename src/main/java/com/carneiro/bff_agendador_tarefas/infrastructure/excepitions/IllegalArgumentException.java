package com.carneiro.bff_agendador_tarefas.infrastructure.excepitions;

public class IllegalArgumentException extends RuntimeException {
    public IllegalArgumentException(String message) {
        super(message);
    }
}
