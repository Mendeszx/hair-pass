package com.api.hairpass.domain.useCases.agendamento;

import com.api.hairpass.adapters.controllers.dtos.request.CriarAgendamentoRequest;
import org.springframework.http.ResponseEntity;

public interface AgendamentoUseCase {
    ResponseEntity<Object> criarAgendamento(CriarAgendamentoRequest criarAgendamentoRequest);
}
