package com.carneiro.bff_agendador_tarefas.infrastructure.client;

import com.carneiro.bff_agendador_tarefas.bussiness.dtos.in.EnderecoDTORequest;
import com.carneiro.bff_agendador_tarefas.bussiness.dtos.in.LoginRequestDTO;
import com.carneiro.bff_agendador_tarefas.bussiness.dtos.in.TelefoneDTORequest;
import com.carneiro.bff_agendador_tarefas.bussiness.dtos.in.UsuarioDTORequest;
import com.carneiro.bff_agendador_tarefas.bussiness.dtos.out.EnderecoDTO;
import com.carneiro.bff_agendador_tarefas.bussiness.dtos.out.TarefasDTO;
import com.carneiro.bff_agendador_tarefas.bussiness.dtos.out.TelefoneDTO;
import com.carneiro.bff_agendador_tarefas.bussiness.dtos.out.UsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "notificacao", url = "$(notificacao.url")
public interface EmailClient {
    void enviarEmail(@RequestBody TarefasDTO dto);
}
