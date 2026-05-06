package com.carneiro.bff_agendador_tarefas.infrastructure.client.config;

import com.carneiro.bff_agendador_tarefas.infrastructure.excepitions.BussinessException;
import com.carneiro.bff_agendador_tarefas.infrastructure.excepitions.ConfilctException;
import com.carneiro.bff_agendador_tarefas.infrastructure.excepitions.IllegalArgumentException;
import com.carneiro.bff_agendador_tarefas.infrastructure.excepitions.UnauthorizedException;
import feign.Response;
import feign.codec.ErrorDecoder;

import java.io.IOException;
import java.lang.module.ResolutionException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class FeignError implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {

        String messageErro = messagemErro(response);

        switch (response.status()){
            case 409:
                return new ConfilctException("Erro" + messageErro);
            case 403:
                return new ResolutionException("Erro" + messageErro);
            case 401:
                return new UnauthorizedException("Erro" + messageErro);
            case 400:
                return new IllegalArgumentException("");
            default:
                return new BussinessException("Erro de servidor");
        }
    }

    private String messagemErro(Response response){
        try {
            if (Objects.isNull(response.body())){
                return "";
            }
            return new String(response.body().asInputStream().readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
