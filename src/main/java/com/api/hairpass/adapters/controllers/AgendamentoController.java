package com.api.hairpass.adapters.controllers;

import com.api.hairpass.adapters.controllers.dtos.request.CriarAgendamentoRequest;
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
}
