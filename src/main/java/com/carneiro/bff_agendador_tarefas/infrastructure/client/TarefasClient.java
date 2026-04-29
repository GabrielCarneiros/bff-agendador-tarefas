package com.carneiro.bff_agendador_tarefas.infrastructure.client;

import com.carneiro.bff_agendador_tarefas.bussiness.dtos.in.TarefasDTORequest;
import com.carneiro.bff_agendador_tarefas.bussiness.dtos.out.TarefasDTO;
import com.carneiro.bff_agendador_tarefas.infrastructure.enums.StatusNotificacaoEnum;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@FeignClient(name = "agendador-tarefas", url = "$(agendador-tarefas.url")
public interface TarefasClient {
    @PostMapping
    TarefasDTO salvarTarefas(@RequestBody TarefasDTORequest dto,
                             @RequestHeader("Authorization") String token);


    @GetMapping("/eventos")
    List<TarefasDTO> buscaListaDeTarefasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
            @RequestParam @DateTimeFormat(iso =DateTimeFormat.ISO.DATE_TIME ) LocalDateTime dataFinal,
            @RequestHeader("Authorization") String token);


    @GetMapping
    List<TarefasDTO> buscaTarefasPorEmail(@RequestHeader ("Authorization") String token);

    @DeleteMapping
    void deletaTarefaPorId(@RequestParam("id") String id, @RequestHeader("Authorization") String token);

    @PatchMapping
    TarefasDTO alteraStatusNotificacao(@RequestParam("status") StatusNotificacaoEnum statusNotificacaoEnum,
                                       @RequestParam("id") String id, @RequestHeader("Authorization") String token);

    @PutMapping
    public ResponseEntity<TarefasDTO> updateTarefas(@RequestBody TarefasDTORequest dto, @RequestParam("id") String id,
                                                    @RequestHeader("Authorization") String token);

}
