package com.api.hairpass.adapters.controllers.dtos.request;

import jakarta.persistence.Column;

import java.util.Date;
import java.sql.Time;

public class CriarAgendamentoRequest {
    
    private Long salaoId;
    private Long servicoId;
    private Long funcionarioId;
    private Date dia;
    private Time inicio;
    private Time fim;

    public Long getSalaoId() {
        return salaoId;
    }

    public void setSalaoId(Long salaoId) {
        this.salaoId = salaoId;
    }

    public Long getServicoId() {
        return servicoId;
    }

    public void setServicoId(Long servicoId) {
        this.servicoId = servicoId;
    }

    public Long getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(Long funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public Time getInicio() {
        return inicio;
    }

    public void setInicio(Time inicio) {
        this.inicio = inicio;
    }

    public Time getFim() {
        return fim;
    }

    public void setFim(Time fim) {
        this.fim = fim;
    }
}
