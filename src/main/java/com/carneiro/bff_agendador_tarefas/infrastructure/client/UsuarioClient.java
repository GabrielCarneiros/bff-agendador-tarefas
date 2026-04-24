package com.carneiro.bff_agendador_tarefas.infrastructure.client;

import com.carneiro.bff_agendador_tarefas.bussiness.dtos.in.EnderecoDTORequest;
import com.carneiro.bff_agendador_tarefas.bussiness.dtos.in.LoginRequestDTO;
import com.carneiro.bff_agendador_tarefas.bussiness.dtos.in.TelefoneDTORequest;
import com.carneiro.bff_agendador_tarefas.bussiness.dtos.in.UsuarioDTORequest;
import com.carneiro.bff_agendador_tarefas.bussiness.dtos.out.EnderecoDTO;
import com.carneiro.bff_agendador_tarefas.bussiness.dtos.out.TelefoneDTO;
import com.carneiro.bff_agendador_tarefas.bussiness.dtos.out.UsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "usuario", url = "$(usuario.url")
public interface UsuarioClient {
    @GetMapping("/usuario")
    UsuarioDTO buscaUsuarioPorEmail(@RequestParam("email") String email, @RequestHeader("Authorization") String token);

    @PostMapping
    UsuarioDTO salvaUsuario(@RequestBody UsuarioDTORequest usuarioDTO);

    @PostMapping("/login")
    String login(@RequestBody LoginRequestDTO loginRequestDTO);


    @DeleteMapping("/{email}")
    void deletaUsuarioPorEmail(@PathVariable String email,
                               @RequestHeader("Authorization") String token);

    @PutMapping
    UsuarioDTO atualizaDadosUsuario(@RequestBody UsuarioDTORequest dto, @RequestHeader ("Authorization") String token);

    @PutMapping("/endereco")
    EnderecoDTO atualizaDadosEndereco(@RequestBody EnderecoDTORequest dto, @RequestParam("id") Long id,
                                      @RequestHeader("Authorization") String token);

    @PutMapping("/telefone")
    TelefoneDTO atualizaTelefone(@RequestBody TelefoneDTORequest dto, @RequestParam("id") Long id,
                                 @RequestHeader("Authorization") String token);

    @PostMapping("endereco")
    EnderecoDTO cadastraEndereco(@RequestBody EnderecoDTORequest dto, @RequestHeader("Authorization") String token);

    @PostMapping("/telefone")
    public TelefoneDTO cadastraTelefone(@RequestBody TelefoneDTORequest dto, @RequestHeader("Authorization") String token);

}
