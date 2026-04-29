package com.carneiro.bff_agendador_tarefas.bussiness.dtos.in;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginRequestDTO {
    private String email;
    private String senha;
}
