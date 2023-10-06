package com.api.hairpass.domain.useCases.agendamento;

import com.api.hairpass.adapters.controllers.dtos.request.CriarAgendamentoRequest;
import com.api.hairpass.adapters.controllers.dtos.response.CriarAgendamentoResponse;
import com.api.hairpass.domain.services.AgendamentosService;
import com.api.hairpass.domain.entities.AgendamentosEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AgendamentoUseCaseImpl implements AgendamentoUseCase {

    @Autowired
    AgendamentosService agendamentosService;

    @Override
    public ResponseEntity<CriarAgendamentoResponse> criarAgendamento(CriarAgendamentoRequest criarAgendamentoRequest) {
        CriarAgendamentoResponse criarAgendamentoResponse;

        try {
            agendamentosService.criarAgendamento(criarAgendamentoRequest);
            criarAgendamentoResponse = criarAgendamentoResponse(201, HttpStatus.CREATED, "Agendamento criado com sucesso.");

        } catch (Exception e) {
            criarAgendamentoResponse = criarAgendamentoResponse(400, HttpStatus.BAD_REQUEST, "Erro: " + e.getMessage());
        }

        return ResponseEntity.status(criarAgendamentoResponse.getHttpStatusCode()).body(criarAgendamentoResponse);
    }

    private CriarAgendamentoResponse criarAgendamentoResponse(int httpStatusCode, HttpStatus httpStatus, String mensagem) {
        CriarAgendamentoResponse criarAgendamentoResponse = new CriarAgendamentoResponse();

        criarAgendamentoResponse.setHttpStatusCode(httpStatusCode);
        criarAgendamentoResponse.setHttpStatus(httpStatus);
        criarAgendamentoResponse.setMensagem(mensagem);

        return criarAgendamentoResponse;
    }
}
