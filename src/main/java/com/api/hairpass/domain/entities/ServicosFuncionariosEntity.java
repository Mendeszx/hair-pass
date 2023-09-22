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
    @ManyToOne
    @JoinColumn(name = "servico_id", referencedColumnName = "servico_id")
    private ServicosEntity servicoId;
    @ManyToOne
    @JoinColumn(name = "funcionario_id", referencedColumnName = "funcionario_id")
    private FuncionariosEntity funcionarioId;
    @Column(nullable = false, name = "data_de_cadastro")
    private LocalDate dataDeCadastro;
    @Column(nullable = false, name = "servico_funcionario_ativo")
    private boolean servicoFuncionarioAtivo;

    public Long getFuncionarioServicoId() {
        return funcionarioServicoId;
    }

    public void setFuncionarioServicoId(Long funcionarioServicoId) {
        this.funcionarioServicoId = funcionarioServicoId;
    }

    public ServicosEntity getServicoId() {
        return servicoId;
    }

    public void setServicoId(ServicosEntity servicoId) {
        this.servicoId = servicoId;
    }

    public FuncionariosEntity getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(FuncionariosEntity funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public LocalDate getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setDataDeCadastro(LocalDate dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

    public boolean isServicoFuncionarioAtivo() {
        return servicoFuncionarioAtivo;
    }

    public void setServicoFuncionarioAtivo(boolean servicoFuncionarioAtivo) {
        this.servicoFuncionarioAtivo = servicoFuncionarioAtivo;
    }
}
