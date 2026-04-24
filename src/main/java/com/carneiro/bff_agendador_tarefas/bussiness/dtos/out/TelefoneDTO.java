package com.carneiro.bff_agendador_tarefas.bussiness.dtos.out;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class TelefoneDTO {

    private Long id;
    private String numeroTelefone;
    private String ddd;
}

