package com.carneiro.bff_agendador_tarefas.bussiness;

import com.carneiro.bff_agendador_tarefas.bussiness.dtos.in.LoginRequestDTO;
import com.carneiro.bff_agendador_tarefas.bussiness.dtos.out.TarefasDTO;
import com.carneiro.bff_agendador_tarefas.infrastructure.enums.StatusNotificacaoEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CronService {

    private final TarefaService tarefaService;
    private final EmailService emailService;
    private final UsuarioService usuarioService;

    @Value("${usuario.email}")
    private String email;

    @Value("${usuario.senha}")
    private String senha;

    @Scheduled(cron = "${cron.horario}")
    public void buscaTarefaProximaHora(){
        String token = login(converterParaRequestDTO());
        LocalDateTime horaFutura = LocalDateTime.now().plusHours(1);
        LocalDateTime maisCincoMin = LocalDateTime.now().plusHours(1).plusMinutes(5);
        List<TarefasDTO> listaTarefas = tarefaService.buscaTarefasAgendadasPorPeriodo(horaFutura, maisCincoMin, token);

        listaTarefas.forEach(tarefa -> {emailService.enviaEmail(tarefa);
            tarefaService.alteraStatus(StatusNotificacaoEnum.NOTIFICADO, tarefa.getId(), token);});
    }

    public String login(LoginRequestDTO dto){
       return usuarioService.loginUsuario(dto);
    }

    public LoginRequestDTO converterParaRequestDTO(){
        return LoginRequestDTO.builder()
                .email(email)
                .senha(senha)
                .build();
    }
}
