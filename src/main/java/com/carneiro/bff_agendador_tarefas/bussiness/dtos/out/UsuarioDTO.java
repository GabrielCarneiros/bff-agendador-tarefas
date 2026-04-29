package com.carneiro.bff_agendador_tarefas.bussiness.dtos.out;


import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioDTO {
    private String nome;
    private String email;
    private String senha;
    private List <EnderecoDTO> enderecos;
    private List <TelefoneDTO> telefones;
}
