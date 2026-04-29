package com.carneiro.bff_agendador_tarefas.bussiness;

import com.carneiro.bff_agendador_tarefas.bussiness.dtos.in.EnderecoDTORequest;
import com.carneiro.bff_agendador_tarefas.bussiness.dtos.in.LoginRequestDTO;
import com.carneiro.bff_agendador_tarefas.bussiness.dtos.in.TelefoneDTORequest;
import com.carneiro.bff_agendador_tarefas.bussiness.dtos.in.UsuarioDTORequest;
import com.carneiro.bff_agendador_tarefas.bussiness.dtos.out.EnderecoDTO;
import com.carneiro.bff_agendador_tarefas.bussiness.dtos.out.TelefoneDTO;
import com.carneiro.bff_agendador_tarefas.bussiness.dtos.out.UsuarioDTO;
import com.carneiro.bff_agendador_tarefas.infrastructure.client.UsuarioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioClient usuarioClient;

    public UsuarioDTO salvaUsuario(UsuarioDTORequest usuarioDTO) {

        return usuarioClient.salvaUsuario(usuarioDTO);
    }

    public String loginUsuario(LoginRequestDTO dto){
        return usuarioClient.login(dto);
    }


    public UsuarioDTO buscarUsuarioPorEmail(String email, String token){
        return usuarioClient.buscaUsuarioPorEmail(email, token);
    }

    public void deletaUsuarioPorEmail(String email, String token){
        usuarioClient.deletaUsuarioPorEmail(email, token);
    }

    public UsuarioDTO atualizarDadosUsuario(String token, UsuarioDTORequest dto){
       return usuarioClient.atualizaDadosUsuario(dto, token);
    }

    public EnderecoDTO atualizaEndereco(Long idEndereco, EnderecoDTORequest enderecoDTO, String token){
        return usuarioClient.atualizaDadosEndereco(enderecoDTO, idEndereco, token);

    }

    public TelefoneDTO atualizaTelefone(Long idTelefone, TelefoneDTORequest telefoneDTO, String token){
        return usuarioClient.atualizaTelefone(telefoneDTO, idTelefone, token);
    }

    public EnderecoDTO cadastroEndereco(String token, EnderecoDTORequest enderecoDTO){
        return usuarioClient.cadastraEndereco(enderecoDTO, token);
    }

    public TelefoneDTO cadastroTelefone(String token, TelefoneDTORequest telefoneDTO){
        return usuarioClient.cadastraTelefone(telefoneDTO, token);
    }
}
