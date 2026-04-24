package com.carneiro.bff_agendador_tarefas.controller;

import com.carneiro.bff_agendador_tarefas.bussiness.UsuarioService;
import com.carneiro.bff_agendador_tarefas.bussiness.dtos.in.EnderecoDTORequest;
import com.carneiro.bff_agendador_tarefas.bussiness.dtos.in.LoginRequestDTO;
import com.carneiro.bff_agendador_tarefas.bussiness.dtos.in.TelefoneDTORequest;
import com.carneiro.bff_agendador_tarefas.bussiness.dtos.in.UsuarioDTORequest;
import com.carneiro.bff_agendador_tarefas.bussiness.dtos.out.EnderecoDTO;
import com.carneiro.bff_agendador_tarefas.bussiness.dtos.out.TelefoneDTO;
import com.carneiro.bff_agendador_tarefas.bussiness.dtos.out.UsuarioDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
@Tag(name = "Usuario", description = "cadastro e login de usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    @Operation(summary = "Salvar Usuarios", description = "Cria um novo usuario")
    @ApiResponse(responseCode = "200", description = "Usuario salvo com sucesso")
    @ApiResponse(responseCode = "400", description = "Usuario já cadastrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<UsuarioDTO> salvaUsuario(@RequestBody UsuarioDTORequest usuarioDTO){
        return ResponseEntity.ok(usuarioService.salvaUsuario(usuarioDTO));
    }

    @PostMapping("/login")
    @Operation(summary = "Login de Usuarios", description = "Entrada de um Usuario")
    @ApiResponse(responseCode = "200", description = "Usuario logado com sucesso")
    @ApiResponse(responseCode = "401", description = "Credenciais inválidas")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public String login(@RequestBody LoginRequestDTO loginRequestDTO){
       return usuarioService.loginUsuario(loginRequestDTO);
    }

    @GetMapping
    @Operation(summary = "Buscar dados de Usuario por email", description = "Procurar dados do Usuario")
    @ApiResponse(responseCode = "200", description = "Usuario encontrado")
    @ApiResponse(responseCode = "404", description = "Usuario não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<UsuarioDTO> buscaUsuarioPorEmail(@RequestParam("email") String email,
                                                           @RequestHeader(name = "Authorization", required = false) String token){
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorEmail(email, token));
    }

    @DeleteMapping("/{email}")
    @Operation(summary = "Deleta Usuarios", description = "Exclui o usuario")
    @ApiResponse(responseCode = "200", description = "Usuario excluido com suceso")
    @ApiResponse(responseCode = "404", description = "Usuario não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity <Void> deletaUsuarioPorEmail(@PathVariable String email,
                                                       @RequestHeader(name = "Authorization", required = false) String token){
        usuarioService.deletaUsuarioPorEmail(email, token);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @Operation(summary = "Atualiza Dados do Usuario", description = "Atualiza os dados de um usuario")
    @ApiResponse(responseCode = "200", description = "Dados atualizados")
    @ApiResponse(responseCode = "404", description = "Usuario não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<UsuarioDTO> atualizaDadosUsuario(@RequestBody UsuarioDTORequest dto, @RequestHeader (name = "Authorization", required = false) String token){
        return ResponseEntity.ok(usuarioService.atualizarDadosUsuario(token, dto));
    }

    @PutMapping("/endereco")
    @Operation(summary = "Atualizar Endereço", description = "Atualiza dados de endereço")
    @ApiResponse(responseCode = "200", description = "Endereço atualizado")
    @ApiResponse(responseCode = "404", description = "Usuario já cadastrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<EnderecoDTO> atualizaDadosEndereco(@RequestBody EnderecoDTORequest dto, @RequestParam("id") Long id,
                                                             @RequestHeader(name = "Authorization", required = false) String token){
        return ResponseEntity.ok(usuarioService.atualizaEndereco(id, dto, token));
    }

    @PutMapping("/telefone")
    @Operation(summary = "Atualizar Telefone", description = "Atualiza número de telefone")
    @ApiResponse(responseCode = "200", description = "Telefone atualizado")
    @ApiResponse(responseCode = "404", description = "Usuario não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<TelefoneDTO> atualizaTelefone(@RequestBody TelefoneDTORequest dto, @RequestParam("id") Long id,
                                                        @RequestHeader(name = "Authorization", required = false) String token){
        return ResponseEntity.ok(usuarioService.atualizaTelefone(id, dto, token));
    }

    @PostMapping("endereco")
    @Operation(summary = "Cadastrar Endereço", description = "Cadastra um endereço")
    @ApiResponse(responseCode = "200", description = "Endereço cadastrado")
    @ApiResponse(responseCode = "404", description = "Usuario não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<EnderecoDTO> cadastraEndereco(@RequestBody EnderecoDTORequest dto, @RequestHeader(name = "Authorization", required = false) String token){
        return ResponseEntity.ok(usuarioService.cadastroEndereco(token, dto));
    }

    @PostMapping("/telefone")
    @Operation(summary = "Cadastrar Telefone", description = "Cadastra um telefone")
    @ApiResponse(responseCode = "200", description = "Telefone cadastrado")
    @ApiResponse(responseCode = "404", description = "Usuario não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<TelefoneDTO> cadastraTelefone(@RequestBody TelefoneDTORequest dto, @RequestHeader(name = "Authorization", required = false) String token){
        return ResponseEntity.ok(usuarioService.cadastroTelefone(token, dto));
    }
}
