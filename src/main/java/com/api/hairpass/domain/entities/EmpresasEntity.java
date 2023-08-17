package com.api.hairpass.domain.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "empresas")
public class EmpresasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empresa_id")
    private Long empresaId;
    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id", unique = true)
    private UsuariosEntity usuarioId;
    @Column(nullable = false, name = "nome")
    private String nome;
    @Column(unique = true, name = "cnpj")
    private String cnpj;
    @Column(unique = true, name = "cpf")
    private String cpf;
    @Column(unique = true, name = "categoria")
    private String categoria;
    @Column(name = "foto")
    private byte[] foto;
    @Column(name = "foto_de_capa")
    private byte[] fotoDeCapa;
    @Column(name = "descricao")
    private String descricao;
    @Column(nullable = false, unique = true, name = "telefone")
    private String telefone;
    @Column(nullable = false, name = "endereco")
    private String endereco;
    @Column(nullable = false, name = "data_de_cadastro")
    private LocalDate dataDeCadastro;
    @Column(nullable = false, name = "empresa_ativo")
    private boolean empresaAtivo;

    public Long getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(Long empresaId) {
        this.empresaId = empresaId;
    }

    public UsuariosEntity getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(UsuariosEntity usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
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

    public LocalDate getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setDataDeCadastro(LocalDate dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

    public boolean isEmpresaAtivo() {
        return empresaAtivo;
    }

    public void setEmpresaAtivo(boolean empresaAtivo) {
        this.empresaAtivo = empresaAtivo;
    }
}
