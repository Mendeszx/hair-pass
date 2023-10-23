package com.api.hairpass.domain.useCases.agendamento;

import com.api.hairpass.adapters.controllers.dtos.request.CancelarAgendamentoRequest;
import com.api.hairpass.adapters.controllers.dtos.request.CriarAgendamentoRequest;
import com.api.hairpass.adapters.controllers.dtos.response.CancelarAgendamentoResponse;
import com.api.hairpass.adapters.controllers.dtos.response.CriarAgendamentoResponse;
import com.api.hairpass.domain.services.AgendamentosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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

    @Override
    public ResponseEntity<CancelarAgendamentoResponse> cancelarAgendamento(CancelarAgendamentoRequest cancelarAgendamentoRequest) {
        CancelarAgendamentoResponse cancelarAgendamentoResponse;

        try {
            agendamentosService.cancelarAgendamento(cancelarAgendamentoRequest);
            cancelarAgendamentoResponse = cancelarAgendamentoResponse(204, HttpStatus.CREATED, "Agendamento cancelado com sucesso.");

        } catch (Exception e) {
            cancelarAgendamentoResponse = cancelarAgendamentoResponse(400, HttpStatus.BAD_REQUEST, "Erro: " + e.getMessage());
        }

        return ResponseEntity.status(cancelarAgendamentoResponse.getHttpStatusCode()).body(cancelarAgendamentoResponse);
    }

    private CriarAgendamentoResponse criarAgendamentoResponse(int httpStatusCode, HttpStatus httpStatus, String mensagem) {
        CriarAgendamentoResponse criarAgendamentoResponse = new CriarAgendamentoResponse();

        criarAgendamentoResponse.setHttpStatusCode(httpStatusCode);
        criarAgendamentoResponse.setHttpStatus(httpStatus);
        criarAgendamentoResponse.setMensagem(mensagem);

        return criarAgendamentoResponse;
    }

    private CancelarAgendamentoResponse cancelarAgendamentoResponse(int httpStatusCode, HttpStatus httpStatus, String mensagem) {
        CancelarAgendamentoResponse cancelarAgendamentoResponse = new CancelarAgendamentoResponse();

        cancelarAgendamentoResponse.setHttpStatusCode(httpStatusCode);
        cancelarAgendamentoResponse.setHttpStatus(httpStatus);
        cancelarAgendamentoResponse.setMensagem(mensagem);

        return cancelarAgendamentoResponse;
    }
}
