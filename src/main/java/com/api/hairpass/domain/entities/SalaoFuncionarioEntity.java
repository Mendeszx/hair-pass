package com.api.hairpass.domain.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "salao_funcionario")
public class SalaoFuncionarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long salaoFuncionarioId;
    @Column(nullable = false)
    private Long funcionarioId;
    @Column(nullable = false)
    private Date dataDeCadastro;
    @Column(nullable = false)
    private boolean ativo;

    public Long getSalaoFuncionarioId() {
        return salaoFuncionarioId;
    }

    public void setSalaoFuncionarioId(Long salaoFuncionarioId) {
        this.salaoFuncionarioId = salaoFuncionarioId;
    }

    public Long getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(Long funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public Date getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setDataDeCadastro(Date dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
