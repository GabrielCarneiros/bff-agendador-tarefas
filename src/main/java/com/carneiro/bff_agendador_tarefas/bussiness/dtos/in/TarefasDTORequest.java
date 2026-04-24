package com.carneiro.bff_agendador_tarefas.bussiness.dtos.in;

import com.carneiro.bff_agendador_tarefas.infrastructure.enums.StatusNotificacaoEnum;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TarefasDTORequest {

    private String nomeTarefa;
    private String descricao;
    private LocalDateTime dataEvento;

}
