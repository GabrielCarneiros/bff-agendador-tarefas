package com.carneiro.bff_agendador_tarefas.bussiness;

import com.carneiro.bff_agendador_tarefas.bussiness.dtos.in.TarefasDTORequest;
import com.carneiro.bff_agendador_tarefas.bussiness.dtos.out.TarefasDTO;
import com.carneiro.bff_agendador_tarefas.infrastructure.client.TarefasClient;
import com.carneiro.bff_agendador_tarefas.infrastructure.enums.StatusNotificacaoEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefaService {
    private final TarefasClient client;

    public TarefasDTO salvarTarefa(String token, TarefasDTORequest dto) {
        return client.salvarTarefas(dto, token);
    }

    public List<TarefasDTO> buscaTarefasAgendadasPorPeriodo(LocalDateTime dataInicial, LocalDateTime dataFinal,
                                                            String token) {
        return client.buscaListaDeTarefasPorPeriodo(dataInicial, dataFinal, token);
    }

    public List<TarefasDTO> buscaTarefasPorEmail(String token) {
        return client.buscaTarefasPorEmail(token);
    }

    public void deletaTarefaPorId(String id, String token) {
        client.deletaTarefaPorId(id, token);
    }

    public TarefasDTO alteraStatus(StatusNotificacaoEnum status, String id, String token) {
       return client.alteraStatusNotificacao(status, id, token);
    }

    public TarefasDTO updateTarefas(TarefasDTORequest dto, String id, String token){
       return client.updateTarefas(dto, id, token).getBody();
    }
}