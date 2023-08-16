package com.api.hairpass.domain.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "servicos_funcionarios")
public class ServicosFuncionariosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "funcionario_servico_id")
    private Long funcionarioServicoId;
    @Column(nullable = false, name = "servico_id")
    private Long servicoId;
    @Column(nullable = false, name = "funcionario_id")
    private Long funcionarioId;
    @Column(nullable = false, name = "data_de_cadastro")
    private LocalDate dataDeCadastro;
    @Column(nullable = false, name = "funcionario_servico_ativo")
    private boolean funcionarioServicoAtivo;

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

    public boolean isFuncionarioServicoAtivo() {
        return funcionarioServicoAtivo;
    }

    public void setFuncionarioServicoAtivo(boolean funcionarioServicoAtivo) {
        this.funcionarioServicoAtivo = funcionarioServicoAtivo;
    }
}
