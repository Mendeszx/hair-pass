package com.api.hairpass.domain.useCases.agendamento;

import com.api.hairpass.adapters.controllers.dtos.request.CriarAgendamentoRequest;
import com.api.hairpass.domain.services.AgendamentosService;
import com.api.hairpass.domain.entities.AgendamentosEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AgendamentoUseCaseImpl implements AgendamentoUseCase {

    @Autowired
    AgendamentosService agendamentosService;

    private final static String DATE_FORMAT = "dd-MM-yyyy";

    @Override
    public ResponseEntity<Object> criarAgendamento(CriarAgendamentoRequest criarAgendamentoRequest) {
        AgendamentosEntity agendamentosEntity = new AgendamentosEntity();
        BeanUtils.copyProperties(criarAgendamentoRequest, agendamentosEntity);

        agendamentosEntity.setCancelado(false);
        LocalDate dataDeCadastro = LocalDate.now();
        agendamentosEntity.setDataDeCadastro(dataDeCadastro);

        agendamentosService.save(agendamentosEntity);

        return ResponseEntity.status(201).body("Sucesso agendar");
    }
}
