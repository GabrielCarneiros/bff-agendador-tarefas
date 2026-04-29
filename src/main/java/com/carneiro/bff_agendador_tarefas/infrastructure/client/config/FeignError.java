package com.carneiro.bff_agendador_tarefas.infrastructure.client.config;

import com.carneiro.bff_agendador_tarefas.infrastructure.excepitions.BussinessException;
import com.carneiro.bff_agendador_tarefas.infrastructure.excepitions.ConfilctException;
import com.carneiro.bff_agendador_tarefas.infrastructure.excepitions.UnauthorizedException;
import feign.Response;
import feign.codec.ErrorDecoder;

import java.lang.module.ResolutionException;

public class FeignError implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {

        switch (response.status()){
            case 409:
                return new ConfilctException("Erro atributo já existente ");
            case 403:
                return new ResolutionException("Erro atributo não encontrado ");
            case 401:
                return new UnauthorizedException("Erro usuario não autorizado");
            default:
                return new BussinessException("Erro de servidor");
        }
    }

}
