package com.api.hairpass.domain.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "funcionario_servico")
public class ServicoFuncionarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long funcionarioServicoId;
    @Column(nullable = false)
    private Long servicoId;
    @Column(nullable = false)
    private Long funcionarioId;
    @Column(nullable = false)
    private LocalDate dataDeCadastro;
    @Column(nullable = false)
    private boolean ativo;

    public Long getFuncionarioServicoId() {
        return funcionarioServicoId;
    }

    public void setFuncionarioServicoId(Long funcionarioServicoId) {
        this.funcionarioServicoId = funcionarioServicoId;
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

    public LocalDate getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setDataDeCadastro(LocalDate dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}