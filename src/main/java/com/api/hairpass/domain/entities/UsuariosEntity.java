package com.api.hairpass.domain.entities;

import com.api.hairpass.common.enums.RoleEnum;
import com.api.hairpass.common.enums.SexoEnum;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class UsuariosEntity implements UserDetails, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Long usuarioId;
    @Column(nullable = false, name = "nome")
    private String nome;
    @Column(name = "foto")
    private byte[] foto;
    @Column(nullable = false, unique = true, name = "cpf")
    private String cpf;
    @Column(nullable = false, unique = true, name = "numero_celular")
    private String numeroCelular;
    @Column(nullable = false, name = "data_de_nascimento")
    private LocalDate dataDeNascimento;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "sexo")
    private SexoEnum sexo;
    @Column(nullable = false, name = "endereco")
    private String endereco;
    @Column(nullable = false, unique = true, name = "email")
    private String email;
    @Column(nullable = false, name = "senha")
    private String senha;
    @Column(name = "empresa_id")
    private Long empresaId;
    @Column(name = "empresa_ativo")
    private boolean empresaAtivo;
    @Column(name = "funcionario_id")
    private Long funcionarioId;
    @Column(name = "funcionario_ativo")
    private boolean funcionarioAtivo;
    @Column(nullable = false, name = "data_de_cadastro")
    private LocalDate dataDeCadastro;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "role")
    private RoleEnum role;
    @Column(nullable = false, name = "usuario_ativo")
    private boolean usuarioAtivo;

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public SexoEnum getSexo() {
        return sexo;
    }

    public void setSexo(SexoEnum sexo) {
        this.sexo = sexo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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

    public Long getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(Long empresaId) {
        this.empresaId = empresaId;
    }

    public Long getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(Long funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public boolean isFuncionarioAtivo() {
        return funcionarioAtivo;
    }

    public void setFuncionarioAtivo(boolean funcionarioAtivo) {
        this.funcionarioAtivo = funcionarioAtivo;
    }

    public boolean isEmpresaAtivo() {
        return empresaAtivo;
    }

    public void setEmpresaAtivo(boolean empresaAtivo) {
        this.empresaAtivo = empresaAtivo;
    }

    public LocalDate getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setDataDeCadastro(LocalDate dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

    public boolean isUsuarioAtivo() {
        return usuarioAtivo;
    }

    public void setUsuarioAtivo(boolean usuarioAtivo) {
        this.usuarioAtivo = usuarioAtivo;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        GrantedAuthority authority = new SimpleGrantedAuthority(role.toString());
        return List.of(authority);
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
