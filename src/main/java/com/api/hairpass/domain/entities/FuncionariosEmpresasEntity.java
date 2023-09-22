package com.api.hairpass.domain.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "funcionarios_empresas")
public class FuncionariosEmpresasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "funcionarios_empresas_id")
    private Long funcionariosEmpresasId;
    @Column(nullable = false, name = "funcionario_id")
    private FuncionariosEntity funcionarioId;
    @Column(nullable = false, name = "empresa_id")
    private EmpresasEntity empresaId;
    @Column(nullable = false, name = "data_de_cadastro")
    private LocalDate dataDeCadastro;
    @Column(nullable = false, name = "funcionario_empresa_ativo")
    private boolean funcionarioEmpresaAtivo;

    public Long getFuncionariosEmpresasId() {
        return funcionariosEmpresasId;
    }

    public void setFuncionariosEmpresasId(Long funcionariosEmpresasId) {
        this.funcionariosEmpresasId = funcionariosEmpresasId;
    }

    public FuncionariosEntity getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(FuncionariosEntity funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public EmpresasEntity getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(EmpresasEntity empresaId) {
        this.empresaId = empresaId;
    }

    public LocalDate getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setDataDeCadastro(LocalDate dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

    public boolean isFuncionarioEmpresaAtivo() {
        return funcionarioEmpresaAtivo;
    }

    public void setFuncionarioEmpresaAtivo(boolean funcionarioEmpresaAtivo) {
        this.funcionarioEmpresaAtivo = funcionarioEmpresaAtivo;
    }
}
