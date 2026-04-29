package com.carneiro.bff_agendador_tarefas.bussiness.dtos.in;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EnderecoDTORequest {


    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;

}
