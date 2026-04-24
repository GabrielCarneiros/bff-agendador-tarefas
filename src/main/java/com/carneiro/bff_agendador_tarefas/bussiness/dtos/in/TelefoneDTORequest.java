package com.carneiro.bff_agendador_tarefas.bussiness.dtos.in;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class TelefoneDTORequest {

    private String numeroTelefone;
    private String ddd;
}

