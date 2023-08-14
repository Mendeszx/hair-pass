package com.api.hairpass.domain.useCases.agendamento;

import com.api.hairpass.adapters.controllers.dtos.request.CriarAgendamentoRequest;
import com.api.hairpass.domain.services.AgendamentoService;
import com.api.hairpass.domain.entities.AgendamentoEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
public class AgendamentoUseCaseImpl implements AgendamentoUseCase {

    @Autowired
    AgendamentoService agendamentoService;

    private final static String DATE_FORMAT = "dd-MM-yyyy";

    @Override
    public ResponseEntity<Object> criarAgendamento(CriarAgendamentoRequest criarAgendamentoRequest) {
        AgendamentoEntity agendamentoEntity = new AgendamentoEntity();
        BeanUtils.copyProperties(criarAgendamentoRequest, agendamentoEntity);

        agendamentoEntity.setCancelado(false);
        LocalDate dataDeCadastro = LocalDate.now();
        agendamentoEntity.setDataDeCadastro(dataDeCadastro);

        agendamentoService.save(agendamentoEntity);

        return ResponseEntity.status(201).body("Sucesso agendar");
    }
}
