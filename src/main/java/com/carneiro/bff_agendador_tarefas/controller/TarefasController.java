package com.carneiro.bff_agendador_tarefas.controller;

import com.carneiro.bff_agendador_tarefas.bussiness.TarefaService;
import com.carneiro.bff_agendador_tarefas.bussiness.dtos.in.TarefasDTORequest;
import com.carneiro.bff_agendador_tarefas.bussiness.dtos.out.TarefasDTO;
import com.carneiro.bff_agendador_tarefas.infrastructure.enums.StatusNotificacaoEnum;
import com.carneiro.bff_agendador_tarefas.infrastructure.security.SecurityConfig;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
@SecurityRequirement(name = SecurityConfig.SECURITY_SCHEME)
@Tag(name = "Tarefas", description = "Cadastra tarefas de usuario")
public class TarefasController {
    private final TarefaService tarefaService;


    @PostMapping
    @Operation(summary = "Salvar Tarefas", description = "Cria uma nova tarefa")
    @ApiResponse(responseCode = "200", description = "Tarefa salva com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<TarefasDTO> salvarTarefas(@RequestBody TarefasDTORequest dto,
                                                    @RequestHeader(name = "Authorization", required = false) String token){
        return ResponseEntity.ok(tarefaService.salvarTarefa(token, dto));
    }

    @GetMapping("/eventos")
    @Operation(summary = "Busca de Tarefas por periodo", description = "Busca tarefas cadastrada por periodo")
    @ApiResponse(responseCode = "200", description = "Tarefa encontradas")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<List<TarefasDTO>> buscaListaDeTarefasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)LocalDateTime dataInicial,
            @RequestParam @DateTimeFormat(iso =DateTimeFormat.ISO.DATE_TIME ) LocalDateTime dataFinal,
            @RequestHeader(name = "Authorization", required = false) String token){

        return ResponseEntity.ok(tarefaService.buscaTarefasAgendadasPorPeriodo(dataInicial, dataFinal, token));

    }

    @GetMapping
    @Operation(summary = "Busca de Tarefas por email", description = "Busca tarefas cadastradas por email")
    @ApiResponse(responseCode = "200", description = "Tarefas encontradas")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<List<TarefasDTO>> buscaTarefasPorEmail(@RequestHeader (name = "Authorization", required = false) String token){
        return ResponseEntity.ok(tarefaService.buscaTarefasPorEmail(token));
    }

    @DeleteMapping
    @Operation(summary = "Deleta tarefas por id de usuario", description = "Deleta tarefas por id")
    @ApiResponse(responseCode = "200", description = "Tarefas deletadas")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<Void> deletaTarefaPorId(@RequestParam("id") String id, @RequestHeader(name = "Authorization", required = false) String token){

        tarefaService.deletaTarefaPorId(id, token);

        return ResponseEntity.ok().build();
    }

    @PatchMapping
    @Operation(summary = "Atualiza status das tarefas", description = "Atualiza status das tarefas")
    @ApiResponse(responseCode = "200", description = "Status de tarefa atualizadas")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<TarefasDTO> alteraStatusNotificacao(@RequestParam("status") StatusNotificacaoEnum statusNotificacaoEnum,
                                                              @RequestParam("id") String id, @RequestHeader(name = "Authorization", required = false) String token){
        return ResponseEntity.ok(tarefaService.alteraStatus(statusNotificacaoEnum, id, token));
    }

    @PutMapping
    @Operation(summary = "Altera dados de tarefas", description = "Altera dados de tarefas cadastradas")
    @ApiResponse(responseCode = "200", description = "Tarefas com dados atualizados")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<TarefasDTO> updateTarefas(@RequestBody TarefasDTO dto, @RequestParam("id") String id, @RequestHeader(name = "Authorization", required = false) String token){
        return ResponseEntity.ok(tarefaService.updateTarefas(dto, id, token));
    }
}
