package com.api.hairpass.domain.entities;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "funcionarios")
public class FuncionariosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "funcionario_id")
    private Long funcionarioId;
    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id", unique = true)
    private UsuariosEntity usuarioId;
    @Column(name = "descricao")
    private String descricao;
    @Column(nullable = false, name = "data_de_cadastro")
    private LocalDate dataDeCadastro;
    @Column(nullable = false, name = "funcionario_ativo")
    private boolean funcionarioAtivo;

    public Long getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(Long funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public UsuariosEntity getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(UsuariosEntity usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setDataDeCadastro(LocalDate dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

    public boolean isFuncionarioAtivo() {
        return funcionarioAtivo;
    }

    public void setFuncionarioAtivo(boolean funcionarioAtivo) {
        this.funcionarioAtivo = funcionarioAtivo;
    }
}
