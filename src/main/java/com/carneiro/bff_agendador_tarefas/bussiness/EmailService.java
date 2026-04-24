package com.carneiro.bff_agendador_tarefas.bussiness;

import com.carneiro.bff_agendador_tarefas.bussiness.dtos.out.TarefasDTO;
import com.carneiro.bff_agendador_tarefas.infrastructure.client.EmailClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final EmailClient client;

    public void enviaEmail(TarefasDTO dto) {
        client.enviarEmail(dto);
    }

}