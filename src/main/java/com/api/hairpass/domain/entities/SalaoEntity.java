package com.api.hairpass.domain.entities;

import com.api.hairpass.common.enums.RoleEnum;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "salao")
public class SalaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long salaoId;
    @Column(nullable = false)
    private String nome;
    @Column(unique = true)
    private String CNPJ;
    @Column()
    private byte[] foto;
    @Column()
    private byte[] fotoDeCapa;
    @Column()
    private String descricao;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String senha;
    @Column(nullable = false)
    private String telefone;
    @Column(nullable = false)
    private String endereco;
    @Column(nullable = false)
    private Date DataDeCadastro;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoleEnum role;
    @Column(nullable = false)
    private boolean ativo;

    public Long getSalaoId() {
        return salaoId;
    }

    public void setSalaoId(Long salaoId) {
        this.salaoId = salaoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public byte[] getFotoDeCapa() {
        return fotoDeCapa;
    }

    public void setFotoDeCapa(byte[] fotoDeCapa) {
        this.fotoDeCapa = fotoDeCapa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Date getDataDeCadastro() {
        return DataDeCadastro;
    }

    public void setDataDeCadastro(Date dataDeCadastro) {
        DataDeCadastro = dataDeCadastro;
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
