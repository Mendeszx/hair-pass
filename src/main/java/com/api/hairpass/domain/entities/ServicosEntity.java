package com.api.hairpass.domain.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Time;
import java.time.LocalDate;

@Entity
@Table(name = "servicos")
public class ServicosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "servicoId")
    private Long servicoId;
    @ManyToOne
    @JoinColumn(name = "empresa_id", referencedColumnName = "empresa_id", unique = true, nullable = false)
    private EmpresasEntity empresaId;
    @Column(nullable = false, name = "nome")
    private String nome;
    @Column(nullable = false, name = "valor")
    private BigDecimal valor;
    @Column(nullable = false, name = "duracao")
    private Time duracao;
    @Column(name = "descricao")
    private String descricao;
    @Column(nullable = false, name = "data_de_cadastro")
    private LocalDate dataDeCadastro;
    @Column(nullable = false, name = "servico_ativo")
    private boolean servicoAtivo;

    public Long getServicoId() {
        return servicoId;
    }

    public void setServicoId(Long servicoId) {
        this.servicoId = servicoId;
    }

    public EmpresasEntity getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(EmpresasEntity empresaId) {
        this.empresaId = empresaId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Time getDuracao() {
        return duracao;
    }

    public void setDuracao(Time duracao) {
        this.duracao = duracao;
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

    public boolean isServicoAtivo() {
        return servicoAtivo;
    }

    public void setServicoAtivo(boolean servicoAtivo) {
        this.servicoAtivo = servicoAtivo;
    }
}
