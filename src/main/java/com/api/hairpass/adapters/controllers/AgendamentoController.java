package com.api.hairpass.adapters.controllers;

import com.api.hairpass.adapters.controllers.dtos.request.CancelarAgendamentoRequest;
import com.api.hairpass.adapters.controllers.dtos.request.CriarAgendamentoRequest;
import com.api.hairpass.adapters.controllers.dtos.response.CancelarAgendamentoResponse;
import com.api.hairpass.adapters.controllers.dtos.response.CriarAgendamentoResponse;
import com.api.hairpass.domain.useCases.agendamento.AgendamentoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/agendamento")
public class AgendamentoController {

    @Autowired
    AgendamentoUseCase agendamentoUseCase;

    @PostMapping("/criar-agendamento")
    public ResponseEntity<CriarAgendamentoResponse> criarAgendamento(@RequestBody CriarAgendamentoRequest criarAgendamentoRequest){
        return agendamentoUseCase.criarAgendamento(criarAgendamentoRequest);
    }

    @PostMapping("/cancelar-agendamento")
    public ResponseEntity<CancelarAgendamentoResponse> cancelarAgendamento(@RequestBody CancelarAgendamentoRequest cancelarAgendamentoRequest){
        return agendamentoUseCase.cancelarAgendamento(cancelarAgendamentoRequest);
    }
}
