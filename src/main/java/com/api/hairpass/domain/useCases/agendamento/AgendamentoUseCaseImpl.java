package com.api.hairpass.domain.useCases.agendamento;

import com.api.hairpass.adapters.controllers.dtos.request.CriarAgendamentoRequest;
import com.api.hairpass.domain.services.AgendamentoService;
import com.api.hairpass.domain.entities.AgendamentoEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalDate;

@Service
public class AgendamentoUseCaseImpl implements AgendamentoUseCase {

    @Autowired
    AgendamentoService agendamentoService;

    @Override
    public ResponseEntity<Object> criarAgendamento(CriarAgendamentoRequest criarAgendamentoRequest) {
        var scheduleModel = new AgendamentoEntity();
        BeanUtils.copyProperties(criarAgendamentoRequest, scheduleModel);
        scheduleModel.setCanceledOrder(false);
        scheduleModel.setServiceOrderDay(LocalDate.now());
        scheduleModel.setScheduleDay(dateConvert(criarAgendamentoRequest.getScheduleDay()));
        scheduleModel.setScheduleHour(Time.valueOf(criarAgendamentoRequest.getScheduleHour()));
        agendamentoService.save(scheduleModel);
        return ResponseEntity.status(201).body("Sucesso agendar");
    }

    //TODO: Poderia estar em um utils
    private LocalDate dateConvert(String date) {
        int day = Integer.parseInt(date.substring(0,2));
        int month = Integer.parseInt(date.substring(2,4));
        int year = Integer.parseInt(date.substring(4,8));
        return LocalDate.of(year,month,day);
    }
}
