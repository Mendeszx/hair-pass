package com.api.hairpass.domain.services;

import com.api.hairpass.adapters.controllers.dtos.request.CriarAgendamentoRequest;
import com.api.hairpass.adapters.persistence.AgendamentosRepository;
import com.api.hairpass.domain.entities.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

@Service
public class AgendamentosService {

    @Autowired
    AgendamentosRepository agendamentosRepository;
    @Autowired
    EmpresasService empresasService;
    @Autowired
    UsuariosService usuariosService;
    @Autowired
    ServicosService servicosService;
    @Autowired
    FuncionariosService funcionariosService;

    public void criarAgendamento(CriarAgendamentoRequest criarAgendamentoRequest) throws ParseException {
        AgendamentosEntity agendamentosEntity = new AgendamentosEntity();

        UsuariosEntity usuariosEntity = usuariosService.findUsuariosById(Long.valueOf(criarAgendamentoRequest.getUsuarioId()));
        agendamentosEntity.setUsuariosEntity(usuariosEntity);

        EmpresasEntity empresasEntity = empresasService.findEmpresaById(Long.valueOf(criarAgendamentoRequest.getEmpresaId()));
        agendamentosEntity.setEmpresaId(empresasEntity);

        ServicosEntity servicosEntity = servicosService.findServicosById(Long.valueOf(criarAgendamentoRequest.getServicoId()));
        agendamentosEntity.setServicoId(servicosEntity);

        FuncionariosEntity funcionariosEntity = funcionariosService.findFuncionariosById(Long.valueOf(criarAgendamentoRequest.getServicoId()));
        agendamentosEntity.setFuncionarioId(funcionariosEntity);

        LocalDate dataAgendamento = converterStringParaLocalDate(criarAgendamentoRequest.getDia());
        agendamentosEntity.setDia(dataAgendamento);

        Time inicio = converterStringParaTime(criarAgendamentoRequest.getInicio());
        agendamentosEntity.setInicio(inicio);

        Time fim = converterStringParaTime(criarAgendamentoRequest.getFim());
        agendamentosEntity.setFim(fim);

        LocalDate dataDeCadastro = LocalDate.now();
        agendamentosEntity.setDataDeCadastro(dataDeCadastro);

        agendamentosEntity.setCancelado(false);

        agendamentosRepository.save(agendamentosEntity);
    }

    public LocalDate converterStringParaLocalDate(String dataString) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate data = LocalDate.parse(dataString, formatter);

        return data;
    }

    public Time converterStringParaTime(String horaString) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        Date data = sdf.parse(horaString);

        Time horaTime = new Time(data.getTime());

        return horaTime;
    }
}
