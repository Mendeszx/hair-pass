package com.api.hairpass.domain.entities;

import jakarta.persistence.*;

import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.sql.Time;

@Entity
@Table(name = "servico")
public class ServicoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long servicoId;
    @Column(nullable = false)
    private Long salaoId;
    @Column(nullable = false)
    private Long nome;
    @Column(nullable = false)
    private BigDecimal valor;
    @Column(nullable = false)
    private Time duracao;
    @Column(nullable = false)
    private String descricao;
    @Column(nullable = false)
    private Data dataDeCadastro;
    @Column(nullable = false)
    private boolean ativo;

    public Long getServicoId() {
        return servicoId;
    }

    public void setServicoId(Long servicoId) {
        this.servicoId = servicoId;
    }

    public Long getSalaoId() {
        return salaoId;
    }

    public void setSalaoId(Long salaoId) {
        this.salaoId = salaoId;
    }

    public Long getNome() {
        return nome;
    }

    public void setNome(Long nome) {
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

    public Data getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setDataDeCadastro(Data dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
