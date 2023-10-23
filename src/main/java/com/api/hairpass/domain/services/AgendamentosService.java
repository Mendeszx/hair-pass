package com.api.hairpass.domain.services;

import com.api.hairpass.adapters.controllers.dtos.request.CancelarAgendamentoRequest;
import com.api.hairpass.adapters.controllers.dtos.request.CriarAgendamentoRequest;
import com.api.hairpass.adapters.controllers.dtos.request.DisponibilidadeAgendamentoRequest;
import com.api.hairpass.adapters.persistence.AgendamentosRepository;
import com.api.hairpass.domain.entities.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static com.api.hairpass.common.utils.FunctionsUtils.converterStringParaLocalDate;
import static com.api.hairpass.common.utils.FunctionsUtils.converterStringParaTime;

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

    @Transactional
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

    @Transactional
    public void cancelarAgendamento(CancelarAgendamentoRequest cancelarAgendamentoRequest) {

        Long agendamentoId = Long.valueOf(cancelarAgendamentoRequest.getAgendamentoId());

        Optional<AgendamentosEntity> agendamentosEntity = agendamentosRepository.findById(agendamentoId);

        try {
            if (agendamentosEntity.isPresent()){
                agendamentosEntity.get().setCancelado(true);
                agendamentosEntity.get().setDataDeAtualizacao(LocalDate.now());
                agendamentosRepository.save(agendamentosEntity.get());
            }
        } catch (Exception e) {
            throw new RuntimeException("Agendamento não existe!");
        }
    }

    public List<AgendamentosEntity> disponibilidadeAgendamento(DisponibilidadeAgendamentoRequest disponibilidadeAgendamentoRequest) {

        Long funcionarioId = Long.valueOf(disponibilidadeAgendamentoRequest.getFuncionarioId());

        FuncionariosEntity funcionariosEntity = funcionariosService.findFuncionariosById(funcionarioId);

        LocalDate localDate = converterStringParaLocalDate(disponibilidadeAgendamentoRequest.getData());

        List<AgendamentosEntity> agendamentosEntityList = agendamentosRepository.findByFuncionarioIdAndDia(funcionariosEntity, localDate);

        return agendamentosEntityList;
    }
}
