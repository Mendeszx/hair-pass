package com.api.hairpass.domain.useCases.agendamento;

import com.api.hairpass.adapters.controllers.dtos.request.CriarAgendamentoRequest;
import com.api.hairpass.adapters.controllers.dtos.response.CriarAgendamentoResponse;
import org.springframework.http.ResponseEntity;

public interface AgendamentoUseCase {
    ResponseEntity<CriarAgendamentoResponse> criarAgendamento(CriarAgendamentoRequest criarAgendamentoRequest);
}
